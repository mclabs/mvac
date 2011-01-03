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
package org.openxdata.server.export.rdbms.engine;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang.Validate;

import org.apache.log4j.Logger;
import org.openxdata.server.admin.model.FormData;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Class responsible for building SQL insert statements for inserting data in the RDBMS tables
 * @author Tumwebaze Charles
 * @author dagmar@cell-life.org.za
 *
 */
public class DataBuilder {

    private Logger log = Logger.getLogger(this.getClass());
    private static final String SQL_INSERT_INTO = "INSERT INTO %s (%s) VALUES (%s);";

    public DataBuilder() {
    }

	public List<DataQuery> buildData(Document schemaDocument, Document dataDocument, FormData formData, List<String> tableNames, boolean update) {
        Validate.notNull(schemaDocument, "schemaDocument cannot be null");
		Validate.notNull(dataDocument, "dataDocument cannot be null");
		
		List<DataQuery> statements = new ArrayList<DataQuery>();
		NodeList nodes = dataDocument.getChildNodes();
		if (nodes != null) {
			for (int index = 0; index < nodes.getLength();) {
				Node tableElement = nodes.item(index);
				if(tableElement != null && !(tableElement instanceof org.w3c.dom.Text) || tableElement instanceof org.w3c.dom.Comment) {
			        Functions.cleanNode(tableElement);
			        createStatements(update, schemaDocument, tableElement, formData, statements, null, tableNames);
				}
				
				//for now we process the first child node in document
				break;
			}
		}
		return statements;
	}
	
   private void createStatements(boolean update,
            Document schemaDocument, Node tableElement, FormData formData,
            List<DataQuery> statements, String parentId, List<String> tableNames) {
        
        Map<String, Object> columnValues = new HashMap<String, Object>();
        String tableName = tableElement.getNodeName();

        if (tableElement.hasChildNodes() && Functions.hasValidChildNodes(tableElement)) {
            if (tableName != null && tableName.trim().length() > 0) {
                tableNames.add(tableName);

                // initialise generic columns
                String id = tableName;
                if (!update) {
                    id = UUID.randomUUID().toString();
                    columnValues.put("Id", id);
                    columnValues.put("openxdata_form_data_id", String.valueOf(formData.getFormDataId()));
                }
                columnValues.put("openxdata_user_name", formData.getCreator().getName());
                columnValues.put("openxdata_user_id", String.valueOf(formData.getCreator().getUserId()));               
                
                // initialise the columns specific to this form data (or form data child)
                NodeList columnElements  = tableElement.getChildNodes();
                if (columnElements != null && columnElements.getLength() > 0){
                    for (int index = 0; index < columnElements.getLength(); index++){
                        Node columnElement = columnElements.item(index);
                        if (Functions.isValidNode(columnElement)) {
                            Functions.cleanNode(columnElement);
                            if (Functions.isRepeat(schemaDocument, columnElement)) {
                                // if the column element is a repeat
                                log.debug(tableName+">column repeat '"+columnElement.getNodeName()+"'");
                                createStatements(update, schemaDocument, columnElement, formData, statements, id, tableNames);
                            } else if (columnElement.hasChildNodes() && Functions.hasValidChildNodes(columnElement)) {
                                // if there are child nodes, go through them
                                log.debug(tableName+">column with children "+columnElement.getNodeName());
                                NodeList children = columnElement.getChildNodes();
                                if (children != null && children.getLength() > 0) {                    
                                    for (int child = 0; child < children.getLength(); child++) {
                                        Node childElement = children.item(child);
                                        if (Functions.isRepeat(schemaDocument, childElement)) {
                                            // if the column child element is a repeat
                                            log.debug(tableName+">child repeat '"+childElement.getNodeName()+"'");
                                            createStatements(update, schemaDocument, childElement, formData, statements, id, tableNames);
                                        } else if (Functions.isValidNode(childElement)) {
                                            log.debug(tableName+">child ordinary "+childElement.getNodeName());
                                            Object columnValue = getColumnValue(schemaDocument, childElement);
                                            columnValues.put(childElement.getNodeName(), columnValue);
                                        }
                                    }          
                                }
                            } else {
                                // ordinary column with no child nodes
                                log.debug(tableName+">ordinary column "+columnElement.getNodeName());
                                Object columnValue = getColumnValue(schemaDocument, columnElement);
                                columnValues.put(columnElement.getNodeName(), columnValue);
                            }
                        }
                    }
                }

                // now create the statement (either update or insert) and insert into the list
                DataQuery stmt = null;
                if (update) {
                    stmt = createUpdateStatement(tableName, formData.getFormDataId(), parentId, columnValues);
                } else {
                    stmt = createInsertStatement(tableName, parentId, columnValues);
                }
                if (log.isDebugEnabled()) {
                    log.debug(tableName+">sql="+stmt.getSql()+" parameters="+stmt.getParameters());
                }
                statements.add(0, stmt);
            }
        }
    }
   
   private DataQuery createInsertStatement(String tableName, String parentId, Map<String, Object> columns) {
       StringBuilder structure = new StringBuilder();
       StringBuilder values = new StringBuilder();
       List<Object> columnValues = new ArrayList<Object>();
       for (String colName : columns.keySet()) {
           if (structure.length() > 0) {
               structure.append(",");
               values.append(",");
           }
           structure.append(colName);
           values.append("?");
           columnValues.add(columns.get(colName));
       }
       if (parentId != null && !parentId.trim().equals("")) {
           structure.append(",ParentId");
           values.append(",?");
           columnValues.add(parentId);
       }
       return new DataQuery(SQL_INSERT_INTO, tableName, structure.toString(), values.toString(), columnValues);
   }
   
   private DataQuery createUpdateStatement(String tableName, Integer id, String parentTableName, Map<String, Object> columns) {
       // generate set part of the sql statement
       List<Object> columnValues = new ArrayList<Object>();
       StringBuilder set = new StringBuilder();
       for (String colName : columns.keySet()) {
           if (set.length() > 0) {
               set.append(",");
           }
           set.append(colName);
           set.append("=?");
           columnValues.add(columns.get(colName));
       }
       
       // generate where part of the sql statement
       StringBuilder where = new StringBuilder();
       where.append("openxdata_form_data_id=?");
       columnValues.add(id.toString());
       
       if (parentTableName != null && !parentTableName.trim().equals("")) {
           where.append(" AND parentId = (select Id from "+parentTableName+" where openxdata_form_data_id=?)");
           columnValues.add(id.toString());
       }
       
       return new DataQuery(Constants.SQL_UPDATE, tableName, set.toString(), where.toString(), columnValues);
   }
   
   private Object getColumnValue(Document schemaDocument, Node node) {
       String x = node.getTextContent();
       if (x == null || x.trim().length() == 0) {
           return null;
       }
       String columnType = Functions.resolveType(schemaDocument, node.getNodeName());
       if (columnType.equalsIgnoreCase(Constants.TYPE_DATE)) {
           java.sql.Date date = java.sql.Date.valueOf(x); // must be yyyy-MM-dd format
           return date;
       }
       if (columnType.equalsIgnoreCase(Constants.TYPE_TIME)) {
    	   Time time = null;
    	   String xTime = x.toUpperCase();
    	   try {
	    	   if (xTime.contains("PM") || xTime.contains("AM")) {
	    		   time = new Time(new SimpleDateFormat("hh:mm:ss aaa").parse(xTime).getTime());
	    	   } else {
	    		   time = Time.valueOf(x); // must be HH:mm:ss format
	    	   }
    	   } catch (Exception e) {
    		   log.warn("Could not convert time '"+x+"' to sql Time", e);
    	   }
    	   return time;
       }
       if (columnType.equalsIgnoreCase(Constants.TYPE_DATETIME)) {
           Timestamp datetime = Timestamp.valueOf(x); // must be yyyy-MM-dd HH:mm:ss format
           return datetime;
       }
       if (columnType.equalsIgnoreCase(Constants.TYPE_BOOLEAN)) {
           Boolean bool = new Boolean(x); // note: see Functions.resolveType - boolean is actually VARCHAR
           return bool;
       }
       if (columnType.equalsIgnoreCase(Constants.TYPE_DECIMAL)) {
           Double dub = new Double(x);
           return dub;
       }
       if (columnType.equalsIgnoreCase(Constants.TYPE_INTEGER)) {
           Integer in = new Integer(x);
           return in;
       }
       // VARCHAR or CHAR
       return x;
   }
 
}