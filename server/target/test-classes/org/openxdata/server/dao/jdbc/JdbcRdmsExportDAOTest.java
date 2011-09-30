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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openxdata.server.export.rdbms.engine.Constants;
import org.openxdata.server.export.rdbms.engine.DataQuery;

public class JdbcRdmsExportDAOTest {

    static String CONNECTION_URL = "jdbc:mysql://localhost:3306/openxdata?user=test&password=test&autoReconnect=true";
    static String DATABASE = "openxdata";
    //static String CONNECTION_URL = "jdbc:postgresql://nkosi.cell-life.org:5432/emittesting?user=emit&password=emit";
    static String TABLE_NAME = "bob";
    static Integer FORM_DATA_ID = 1;
    static String DATA_ID = "86106b50-e416-11de-b3c6-00216b5d6d6a";
    static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( Id VARCHAR(200) PRIMARY KEY, openxdata_form_data_id VARCHAR(50), openxdata_user_id VARCHAR(50), openxdata_user_name VARCHAR(50), kidname VARCHAR(255),kidsex VARCHAR(255),kidage INTEGER);";
    static String INSERT_DATA = "INSERT INTO " + TABLE_NAME + " (openxdata_user_id,openxdata_user_name,openxdata_form_data_id,kidage,Id,kidsex,kidname) VALUES (23,'dagmar'," + FORM_DATA_ID + ",1,'" + DATA_ID + "','female','clara');";
    static String INSERT_DATA_PS = "INSERT INTO " + TABLE_NAME + " (openxdata_user_id,openxdata_user_name,openxdata_form_data_id,kidage,Id,kidsex,kidname) VALUES (?,?,?,?,?,?,?);";
    static String DELETE_DATA = "DELETE " + TABLE_NAME + " where Id='" + DATA_ID + "'";
    static String UPDATE_DATA = "";
    static String DELETE_TABLE = "DROP TABLE " + TABLE_NAME + "";
    static String PROPERTY_FILE = "integration.properties";
    static String PROPERTY_MYSQL_URL = "mysql.integration.url";
    static String PROPERTY_MYSQL_DATABASE = "mysql.integration.database";
    JdbcRdmsExporterDAO dao;

    @BeforeClass
    public static void loadProperties() {
        //TODO make better after Ant support is not needed.
        InputStream input = ClassLoader.getSystemResourceAsStream(PROPERTY_FILE);
        if(input == null) {
            return;
        }
        
        Properties properties = new Properties();
        try {
            properties.load(input);

            String url = properties.getProperty(PROPERTY_MYSQL_URL);
            if (url.startsWith("jdbc:")) {
                CONNECTION_URL = url;
            } else {
                String msg = PROPERTY_MYSQL_URL + " is not set";
                Logger.getLogger(JdbcRdmsExportDAOTest.class.getName()).log(Level.WARNING, msg);
            }

            String database = properties.getProperty(PROPERTY_MYSQL_DATABASE);
            if (!database.startsWith("${")) {
                DATABASE = database;
            } else {
                String msg = PROPERTY_MYSQL_DATABASE + " is not set";
                Logger.getLogger(JdbcRdmsExportDAOTest.class.getName()).log(Level.WARNING, msg);
            }
        } catch (IOException ex) {
            Logger.getLogger(JdbcRdmsExportDAOTest.class.getName()).log(Level.WARNING, null, ex);
        }
    }

    @Before
    public void setup() throws Exception {
        dao = new JdbcRdmsExporterDAO(Constants.DB_MYSQL, CONNECTION_URL);
        dao.executeSql(CREATE_TABLE);
    }

    @After
    public void tearDown() throws Exception {
        dao.executeSql(DELETE_TABLE);
    }

    private static DataQuery insertDataQuery(String userName, int formDataId, String dataId, String kidSex, String kidName) {
        final int userId = 23;
        final int kidAge = 1;

        Object[] parameters = new Object[]{
            userId,
            userName,
            formDataId,
            kidAge,
            dataId,
            kidSex,
            kidName};

        return new DataQuery(INSERT_DATA_PS, parameters);
    }

    @Test
    public void testIntegrationNoDataExists() throws Exception {
        assertFalse("no data yet in table", dao.dataExists(FORM_DATA_ID, TABLE_NAME));
    }

    @Test
    public void testIntegrationDataExists() throws Exception {
        dao.executeSql(INSERT_DATA);
        assertTrue("data should have been inserted in the tables", dao.dataExists(FORM_DATA_ID, TABLE_NAME));
    }

    @Test
    public void testIntegrationTableExists() throws Exception {
        assertTrue("table " + TABLE_NAME + " already exists", dao.tableExists(DATABASE, TABLE_NAME));
    }

    @Test
    public void testIntegrationTableDoesNotExist() throws Exception {
        assertFalse("table bobby does not exist", dao.tableExists(DATABASE, "bobby"));
    }

    @Test
    public void testIntegrationExecuteListSQL() throws Exception {
        String userName = "dagmar'; DROP TABLE bob;";
        String kidSex = "fem;ale";
        String kidName = "clara";
        DataQuery dq = insertDataQuery(userName, FORM_DATA_ID, DATA_ID, kidSex, kidName);
        List<DataQuery> sqls = new ArrayList<DataQuery>();
        sqls.add(dq);
        dao.executeSql(sqls);
        assertTrue("Bob data was inserted ok (and bob table wasn't deleted by sql injection",
                dao.dataExists(FORM_DATA_ID, TABLE_NAME));
    }

    @Test
    @Ignore("Rollback does not work on Mysql unless you configure INNODB")
    // See: http://dev.mysql.com/doc/refman/5.0/en/innodb-configuration.html
    public void testIntegrationExecuteListSQLRollback() throws Exception {
        final String userName = "dagmar";
        final String kidSex = "female";
        final String kidName = "clara";

        List<DataQuery> sqls = new ArrayList<DataQuery>();
        sqls.add(insertDataQuery(userName, FORM_DATA_ID, DATA_ID, kidSex, kidName));
        sqls.add(insertDataQuery(userName, FORM_DATA_ID + 1, DATA_ID + 1, kidSex, kidName));
        sqls.add(new DataQuery("invalid sql statement", new Object[]{}));
        try {
            dao.executeSql(sqls);
            fail("expected to have an exception because last sql statement will fail");
        } catch (Exception e) {
            //TODO should use the correct exception class. Not the generic Exception..
            //should always happen, if not; there will be assertions that will report!!
        }

        assertTrue("All data should have been rolled back when last statement failed",
                dao.dataExists(FORM_DATA_ID, TABLE_NAME));
    }
}
