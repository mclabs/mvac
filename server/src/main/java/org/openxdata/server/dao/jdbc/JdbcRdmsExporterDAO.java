/*
 *  Licensed to the OpenXdata Foundation (OXDF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The OXDF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, 
 *  software distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 *
 *  Copyright 2010 http://www.openxdata.org.
 */
package org.openxdata.server.dao.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;
import org.openxdata.server.admin.model.exception.OpenXdataDataAccessException;
import org.openxdata.server.dao.RdmsExporterDAO;
import org.openxdata.server.export.rdbms.engine.Constants;
import org.openxdata.server.export.rdbms.engine.DataQuery;

/**
 * Exporter providing all the functionality to the ServerTask responsible 
 * for exporting form data xml to relational database tables.
 * 
 * Note: Since the Exporter can export to a separate database (this is
 * configurable via the application), a direct connection is required (not
 * using the Spring data source). Also, since the tables are generated
 * from the xform, Hibernate cannot be used for data access - 
 * generating Hibernate mapping files at runtime is not recommended.
 * 
 * @author dagmar@cell-life.org.za
 */
public class JdbcRdmsExporterDAO implements RdmsExporterDAO {

    private Logger log = Logger.getLogger(this.getClass());
    protected int database = Constants.DB_MYSQL;
    protected String connectionUrl = "";
    
    //private static ComboPooledDataSource connectionPool = null;
    
    public JdbcRdmsExporterDAO() {
    }
	
	/**
     * prepares for data export (sets the database and connection url)
     * @param database database for which to export
     * @param connectionUrl connection url for the database to export data to
     * @see {Constants}
     */
	public JdbcRdmsExporterDAO(int database, String connectionUrl) {
        this.database = database;
        this.connectionUrl = connectionUrl;
	}

    @Override
	public boolean dataExists(Integer formDataId, String tableName) {
        
        String statement = "select count(*) from "+tableName+" where openxdata_form_data_id="+formDataId;
        Connection connection = null;
		try {
			connection = getConnection();
			
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(statement);
            if (rs.next()) {
                Integer count = rs.getInt(1);
                if (count >= 1) {
                    return true;
                }
            }
		} catch (SQLException e) {
			throw new OpenXdataDataAccessException(e);
		}
		finally {
            closeConnection(connection);
        }
        return false;
    }

	@Override
	public boolean tableExists(String database, String tableName) {
		String sql="";		
		boolean ret = false;
		Connection connection = getConnection();
		try {
			switch(this.database){
			case Constants.DB_DERBY:
				DatabaseMetaData metadata  = getConnection().getMetaData();
			    ResultSet tableNames = metadata.getTables( null, null, null, new String[]{"TABLE"});
			    while( tableNames.next()){
			          String tab = tableNames.getString("TABLE_NAME");
			          if(tableName.equalsIgnoreCase(tab)){
			        	  ret = true;
			        	  break;
			          }
			    }
				break;
			case Constants.DB_MYSQL:
				sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = '"+ database +"' AND table_name = '"+tableName+"';";
				ret = checkTableExistence(connection, sql);
				break;
			case Constants.DB_ORACLE:
				break;
			case Constants.DB_POSTGRESQL:
				sql = "select 1 from pg_tables where schemaname='public' and tablename='"+tableName+"'";
				ret = checkTableExistence(connection, sql);
				break;
			case Constants.DB_SQLSERVER:
				sql = "SELECT 1 FROM information_schema.tables where table_Name = '"+tableName+"'";
				ret = checkTableExistence(connection, sql);
				break;
			case Constants.DB_MSACCESS:
				ret = accessDBTableExists(connection, tableName);
				break;
			}
		} catch (SQLException e) {
			throw new OpenXdataDataAccessException(e);
		} finally {
			closeConnection(connection);
		}
	
		return ret;
	}
	
    @Override
	public void executeSql(String sql) {
        Connection connection = getConnection();
        try {
            if (sql.trim().length() > 0) {
                Statement st = connection.createStatement();
                log.debug("Executing SQL="+sql);
                st.execute(sql.trim());
            }
        } catch (SQLException e) {
        	throw new OpenXdataDataAccessException(e);
		} finally {
            closeConnection(connection);
        }
    }
    
    @Override
	public void executeSql(List<DataQuery> statements) {
        Connection con = getConnection();
        try {
            con.setAutoCommit(false);
            for (DataQuery query : statements) {
                PreparedStatement ps = con.prepareStatement(query.getSql());
                List<Object> parameters = query.getParameters();
                for (int i=0, j=parameters.size(); i<j; i++) {
                    Object obj = parameters.get(i);
                    ps.setObject(i+1, obj);
                }
                ps.execute();
            }
            con.commit();
        } catch (SQLException e) {
            try {
				con.rollback();
			} catch (SQLException ex) {
				// do nothing
			}
            throw new OpenXdataDataAccessException(e);
        } finally {
            closeConnection(con);
        }
    }

	private boolean accessDBTableExists(Connection connection, String tableName) throws SQLException {
		boolean ret = false;
		DatabaseMetaData metaData = connection.getMetaData();
		if(metaData != null){
			ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
			if(tables != null){
				while(tables.next()){
					String tb = tables.getString("TABLE_NAME");							
					if(tb != null && tb.equalsIgnoreCase(tableName)){
						ret = true;
						break;
					}							
				}
				
				tables.close();
			}
		}
		return ret;
	}

	private boolean checkTableExistence(Connection connection, String sql) throws SQLException {
		boolean ret = false;
		if(sql != null && sql.length() > 0){
			Statement st = connection.createStatement();
			ResultSet set = st.executeQuery(sql);
			if(set != null){
				if(set.next()){
					int value = set.getInt(1);
					if(value == 1)
						ret = true;
					else
						ret = false;		
				}
			}
		}
		return ret;
	}

    /**
     * sets the database for which the export is to be done
     * @param database
     */
    public void setDatabase(int database) {
    	this.database = database;
    }
    /**
     * sets the connection url for the database to export to
     * @param connectionUrl
     */
    public void setConnectionUrl(String connectionUrl) {
    	this.connectionUrl = connectionUrl;
    }
    
    private Connection getConnection() throws OpenXdataDataAccessException {
    	
    	Connection connection;
        if (this.connectionUrl == null || this.connectionUrl.trim().length() == 0) {
            throw new OpenXdataDataAccessException("Failure: connection url was not supplied");
        }

        try {
            switch (this.database) {
                case Constants.DB_DERBY:
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    break;
                case Constants.DB_MYSQL:
                    Class.forName("com.mysql.jdbc.Driver");
                    break;
                case Constants.DB_ORACLE:
                    break;
                case Constants.DB_POSTGRESQL:
                    Class.forName("org.postgresql.Driver");
                    break;
                case Constants.DB_SQLSERVER:
                    Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
                    break;
                case Constants.DB_MSACCESS:
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    break;
                case Constants.DB_H2:
                    Class.forName("org.h2.Driver");
                    break;
            }
            
            connection = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException e) {
            throw new OpenXdataDataAccessException("Missing class/jar for the database connector specified.");
        } catch (SQLException e) {
        	throw new OpenXdataDataAccessException(e);
		}
            
        return connection;
    }

    /**
     * Closes the connection if it is open
     * @param connection
     */
    private void closeConnection(Connection connection) {
		try {
			if(connection != null)
				connection.close();
		} catch (SQLException e) {
			throw new OpenXdataDataAccessException(e);
		}
	}
}