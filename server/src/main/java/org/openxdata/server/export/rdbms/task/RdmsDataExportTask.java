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
package org.openxdata.server.export.rdbms.task;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openxdata.server.Task;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDefVersion;
import org.openxdata.server.admin.model.TaskDef;
import org.openxdata.server.dao.RdmsExporterDAO;
import org.openxdata.server.dao.jdbc.JdbcRdmsExporterDAO;
import org.openxdata.server.export.rdbms.engine.Constants;
import org.openxdata.server.export.rdbms.engine.DataQuery;
import org.openxdata.server.export.rdbms.engine.RdmsEngine;
import org.openxdata.server.export.rdbms.engine.TableQuery;
import org.openxdata.server.service.DataExportService;
import org.openxdata.server.service.SchedulerService;
import org.openxdata.server.sms.OpenXDataAbstractJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class represents the task that handles the export of collected data from XML to RDBMS
 * @author Tumwebaze Charles
 * @author dagmar@cell-life.org.za
 */
@Component("rdmsDataExportTask")
public class RdmsDataExportTask extends OpenXDataAbstractJob implements Task {
    
	@Autowired
	private DataExportService dataExportService;
	
    private Logger log = Logger.getLogger(this.getClass());
    
    public static final Integer EXPORT_TASK_BIT = 1;

	private static final String DB_MYSQL="MYSQL";
	private static final String DB_ORACLE ="ORACLE";
	private static final String DB_SQLSERVER ="SQLSERVER";
	private static final String DB_POSTGRESQL= "POSTGRESQL";
	private static final String DB_DERBY= "DERBY";
	private static final String DB_ACCESS = "MSACCESS";
	private static final String DB_H2 = "H2";

	private TaskDef taskDef = null;

    private String serverName= "";
    private String portNumber = "";
    private String databaseName= "";
    private String dbUsername = "";
    private String dbPassword = "";
    private String DBMS = "";
    
    /** cache of form definitions */
    private Hashtable<Integer, FormDefVersion> formDefCache = new Hashtable<Integer, FormDefVersion>();
    /** cache of SQL to create tables */
    private Hashtable<FormDefVersion, List<TableQuery>> tableQueryCache = new Hashtable<FormDefVersion, List<TableQuery>>();
    /** dao used to create exported tables and insert/update exported data  */
    RdmsExporterDAO exporter;

    /** flag to indicate if the task is executing or not */
    private boolean running = false;
    
    /** thread pool to manage the direct invocation of the task (without quartz) */
    ThreadPoolExecutor tpe = new ThreadPoolExecutor(5,10, 3600, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    
    public RdmsDataExportTask() { }

    public RdmsDataExportTask(TaskDef taskDef) {
        this.taskDef = taskDef;
        init(taskDef);
    }
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException{
    	
		SchedulerService schedulerService = (SchedulerService) getBean("schedulerService",context);
		dataExportService = (DataExportService) getBean("dataExportService",context);
		
        if (taskDef == null) {
            taskDef = (TaskDef) context.getJobDetail().getJobDataMap().get("taskdef");
            schedulerService.registerTaskRunningInstance(this);
            init(taskDef);
        }

        List<FormData> dataList = dataExportService.getFormDataToExport(EXPORT_TASK_BIT);
        log.info("Running Data Export Service to export " + dataList.size() + " form data items");
        running = true;

        exporter = new JdbcRdmsExporterDAO(getDatabase(this.DBMS), getConnectionURL(this.DBMS));

        for (int index = 0; index < dataList.size(); index++) {
            FormData formData = dataList.get(index);
            exportFormData(formData, false);
        }
	}
	
	/**
	 * Exports the specified FormData
	 * @param formData FormData to exports
	 * @param threaded boolean true if the export must be run in a thread (only for outside of quartz execution)
	 */
	public void exportFormData(FormData formData, boolean threaded) {
	    if (formData == null) return;
        FormDefVersion formDefVersion =(FormDefVersion)formDefCache.get(new Integer(formData.getFormDefVersionId()));
        if (formDefVersion == null) {
            formDefVersion = dataExportService.getFormDefVersion(formData.getFormDefVersionId());
            formDefCache.put(new Integer(formDefVersion.getFormDefVersionId()), formDefVersion);
        }
        if (threaded) {
            tpe.execute(new ExportFormDataThread(formData, formDefVersion));
        } else {
            exportFormData(formData, formDefVersion);
        }
	}
	
	/**
	 * Runnable class to handle executing the Task outside of Quartz
	 * @author dagmar@cell-life.org.za
	 */
	class ExportFormDataThread implements Runnable {
	    FormData formData;
	    FormDefVersion formDefVersion;
	    public ExportFormDataThread(FormData formData, FormDefVersion formDefVersion) {
	        this.formData = formData;
	        this.formDefVersion = formDefVersion;
	    }
        @Override
		public void run() {
            exportFormData(formData, formDefVersion);
        }
	}
	
	// easy to test method
	protected void exportFormData(FormData formData, FormDefVersion formDefVersion) {
	    try {
    	    boolean newData = false;
            if (formDefVersion != null) {
                 //creating the structure
                List<TableQuery> tables = tableQueryCache.get(formDefVersion);
                if (tables == null) {
                    // if the tables weren't already cached
                    //long start0 = System.currentTimeMillis();
                    tables = RdmsEngine.getStructureSql(formDefVersion.getXform(), getDatabase(this.DBMS));
                    //System.out.println("creating tables sql took "+(System.currentTimeMillis()-start0)+"ms");
                    //long start1 = System.currentTimeMillis();
                    for (TableQuery table : tables) {
                        if (!exporter.tableExists(this.databaseName,table.getTableName())) {
                            String sqlStatement = table.getSql();
                            log.debug("Creating table '"+table+"'. SQL="+sqlStatement);
                            exporter.executeSql(sqlStatement);
                            newData = true; // if we just inserted the table, there is no data
                        }
                    }
                    //System.out.println("running tables sql took "+(System.currentTimeMillis()-start1)+"ms");
                    tableQueryCache.put(formDefVersion, tables);
                }
                
                
                // check if this an insert or update (only check the parent table)
                // note: only check if we didn't just create the table
                //long start2 = System.currentTimeMillis();
                if (!newData) {
                    for (TableQuery table : tables) {
                        newData = !exporter.dataExists(formData.getFormDataId(), table.getTableName());
                        log.debug("Is data with id "+formData.getFormDataId()+" in table '"+table.getTableName()+"' new? "+newData);
                    }
                }
                //System.out.println("new data check took "+(System.currentTimeMillis()-start2)+"ms");
                
                // inserting or updating the data
                List<String> tableNames = new ArrayList<String>();
                //long start3 = System.currentTimeMillis();
                List<DataQuery> dataSQL = RdmsEngine.getDataSql(formDefVersion.getXform(), formData, !newData, tableNames, getDatabase(this.DBMS));
                //System.out.println("creating data sql took "+(System.currentTimeMillis()-start3)+"ms");
                //long start4 = System.currentTimeMillis();
                exporter.executeSql(dataSQL);
                //System.out.println("running data sql"+(System.currentTimeMillis()-start4)+"ms");
            }
            
            // export successful if we are still here...
            dataExportService.setFormDataExported(formData, EXPORT_TASK_BIT);
        } catch(Exception ex) {
            log.error("Exception caught while attempting export of form data with id '"+formData.getFormDataId()+"'", ex);
        }
	}
	
	protected void setRdmsExporterDAO(RdmsExporterDAO exporter) {
	    this.exporter = exporter;
	}
	
	public void init(TaskDef taskDef) {
		if(taskDef != null){
			this.serverName = taskDef.getParamValue("server");
			this.portNumber = taskDef.getParamValue("port");
			this.databaseName = taskDef.getParamValue("database");
			this.dbUsername = taskDef.getParamValue("dbusername");
			this.dbPassword = taskDef.getParamValue("dbpassword");
			this.DBMS = taskDef.getParamValue("DBMS");
		}
		exporter = new JdbcRdmsExporterDAO(getDatabase(this.DBMS), getConnectionURL(this.DBMS));
	}
	
	public static int getDatabase(String dbms){
		if(dbms.equalsIgnoreCase(DB_MYSQL))
			return Constants.DB_MYSQL;
		else if(dbms.equalsIgnoreCase(DB_ORACLE))
			return Constants.DB_ORACLE;
		else if(dbms.equalsIgnoreCase(DB_POSTGRESQL))
			return Constants.DB_POSTGRESQL;
		else if(dbms.equalsIgnoreCase(DB_SQLSERVER))
			return Constants.DB_SQLSERVER;
		else if(dbms.equalsIgnoreCase(DB_DERBY))
			return Constants.DB_DERBY;
		else if(dbms.equalsIgnoreCase(DB_ACCESS))
		    return Constants.DB_MSACCESS;
		else if(dbms.equalsIgnoreCase(DB_H2))
			return Constants.DB_H2;
		else
			return Constants.DB_MYSQL;
	}
	
	@Override
	public void stop() {
		log.info("Stopping Data Export Service");		
		taskDef = null;		
		running  = false;
	}
		
	private String getConnectionURL(String dbms){
		if(dbms.equalsIgnoreCase(DB_SQLSERVER))
			return "jdbc:microsoft:sqlserver://"+this.serverName+":"+portNumber+";databaseName="+databaseName+";user="+dbUsername+";password="+dbPassword;
		else if(dbms.equalsIgnoreCase(DB_MYSQL))
			return "jdbc:mysql://"+this.serverName+":"+this.portNumber+"/"+this.databaseName+"?user="+
				this.dbUsername+"&password="+this.dbPassword+"&autoReconnect=true";
		else if(dbms.equalsIgnoreCase(DB_ORACLE))
			return "";
		else if(dbms.equalsIgnoreCase(DB_POSTGRESQL))
			return "jdbc:postgresql://"+this.serverName+":"+this.portNumber+"/"+this.databaseName+"?user="+this.dbUsername+"&password="+this.dbPassword;
		else if(dbms.equalsIgnoreCase(DB_DERBY))
			return "jdbc:derby:derby/"+this.databaseName+";create=true;password="+this.dbPassword+";user="+this.dbUsername;
		else if(dbms.equals(DB_ACCESS))
			return "jdbc:odbc:"+ this.databaseName;
		else if(dbms.equals(DB_H2))
			return "jdbc:h2:file:"+this.databaseName+";password="+this.dbPassword+";user="+this.dbUsername + ";AUTO_SERVER=TRUE";
		
		return null;
	}
	
	@Override
	public TaskDef getTaskDef(){
		return taskDef;
	}
	
	@Override
	public boolean isRunning(){
		return running;
	}
}
