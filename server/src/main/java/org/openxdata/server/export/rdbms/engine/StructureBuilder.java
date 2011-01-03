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

import java.util.ArrayList;
import java.util.List;

import org.openxdata.server.admin.model.exception.UnexpectedException;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * Class that builds the table structures in which the exported data will be inserted
 * @author Tumwebaze Charles
 *
 */
public class StructureBuilder {

	private static StructureBuilder instance = new StructureBuilder();
	private int database = 0;
	
	/**
	 * default constructor made private
	 */
	public StructureBuilder(){}
	
	public static StructureBuilder getInstance(){
		return instance;
	}
	
	public List<TableQuery> createStructure(Document schemaDocument, int db) {
	    List<TableQuery> tables = new ArrayList<TableQuery>();
		if(schemaDocument == null)
			throw new UnexpectedException("schemaDocument cannot be null");
	
		database = db;
		
		NodeList instanceNodes = schemaDocument.getElementsByTagName("xf:instance");
		
		if(instanceNodes != null && instanceNodes.getLength() > 0){
			//get the first instance node for now we shall be processing only one instance
			for(int index = 0; index < instanceNodes.getLength(); index++){
				Node instanceNode = instanceNodes.item(index);
				if(instanceNode != null){					
					//clean the node
					Functions.cleanNode(instanceNode);
					
					NodeList tableElements = instanceNode.getChildNodes();
					if(tableElements != null && tableElements.getLength() > 0){
						for(int i = 0; i<tableElements.getLength(); i++){
							Node tableElement = tableElements.item(i);
							if (Functions.isValidNode(tableElement)){
								createTable(schemaDocument, tableElement,null,tables);
								
								//break out after processing one child of the instance node
								break;
							}
						}
					}
					//break out after processing the first instance node.
					break;
				}
			}
		}
		return tables;
	}
	
	private void createTable(Document schemaDocument,Node rootNode,String parentTable, List<TableQuery> tables){
		if(schemaDocument == null) return;
		if(rootNode == null) return;
		
		Functions.cleanNode(rootNode);
		StringBuilder builder = new StringBuilder();
		
		String tableName = rootNode.getNodeName();
		if(rootNode.hasChildNodes() && Functions.hasValidChildNodes(rootNode)){
		
			if(tableName !=null && tableName.trim().length() > 0){				
				//tableNames.add(tableName);
				builder.append(String.format(Constants.SQL_CREATE_TABLE ,tableName));
				builder.append(System.getProperty("line.separator"));
				builder.append(Constants.OPENING_BRACE);
				builder.append(System.getProperty("line.separator"));
				
				//create the Id column
				builder.append("\t"+"Id" +" "+Constants.TYPE_VARCHAR);
				builder.append(String.format(Constants.SIZE_OF_TYPE, 200));
				builder.append(" PRIMARY KEY");
				//builder.append(" CONSTRAINT pk_"+tableName+" PRIMARY KEY");
				builder.append(System.getProperty("line.separator"));
				
				
				/////////Added by Daniel Kayiwa as a request from the Tanzania water project.
				//create the form data id
				builder.append("\t"+",openxdata_form_data_id" +" "+Constants.TYPE_VARCHAR);
				builder.append(String.format(Constants.SIZE_OF_TYPE, 50));
				builder.append(System.getProperty("line.separator"));
				
				//create the user id
				builder.append("\t"+",openxdata_user_id" +" "+Constants.TYPE_VARCHAR);
				builder.append(String.format(Constants.SIZE_OF_TYPE, 50));
				builder.append(System.getProperty("line.separator"));
				
				//create the user name
				builder.append("\t"+",openxdata_user_name" +" "+Constants.TYPE_VARCHAR);
				builder.append(String.format(Constants.SIZE_OF_TYPE, 50));
				builder.append(System.getProperty("line.separator"));
				/////// End added by Daniel Kayiwa
				
				
				//creating other columns
				NodeList columnElements  = rootNode.getChildNodes();
				if(columnElements != null && columnElements.getLength() > 0){
					for(int index = 0; index < columnElements.getLength(); index++){
						Node columnElement = columnElements.item(index);
						if (Functions.isValidNode(columnElement)) {
							Functions.cleanNode(columnElement);
							
							//if the column element has children, recurse so that we create a table
							if(columnElement.hasChildNodes() && Functions.hasValidChildNodes(columnElement)){
								//if the column element is a repeat
								if(Functions.isRepeat(schemaDocument, columnElement)){
									createTable(schemaDocument,columnElement, tableName, tables);
									continue;
								}
								else{										
									NodeList children = columnElement.getChildNodes();
									if(children != null && children.getLength() > 0){
										for(int child = 0; child < children.getLength(); child++){
										    Node childElement = children.item(child);
										    if(Functions.isRepeat(schemaDocument, childElement)){
			                                    createTable(schemaDocument,childElement, tableName, tables);
			                                    continue;
			                                } else {
			                                    if(childElement != null && !(childElement instanceof Text || childElement instanceof Comment))
			                                        createColumnStructure(schemaDocument, builder, childElement);
			                                }
										}
									}										
									continue;
								}
							}								
							
							createColumnStructure(schemaDocument, builder, columnElement);
						}
					}
				}
				
				//create the parent column
				if(parentTable != null && parentTable.trim().length() > 0){
					//create the Id column
					builder.append("\t"+",ParentId" +" "+Constants.TYPE_VARCHAR);
					builder.append(String.format(Constants.SIZE_OF_TYPE, 200));
					builder.append(" REFERENCES "+parentTable+"(Id)");
					builder.append(System.getProperty("line.separator"));
				}
				
				if (this.database == Constants.DB_DERBY) {
					builder.append(Constants.CLOSING_BRACE);
				} else if (this.database == Constants.DB_MYSQL) {
				    builder.append(Constants.CLOSING_BRACE);
				    builder.append("TYPE = INNODB;");
				} else {
					builder.append(Constants.CLOSING_BRACE);
					builder.append(";");
				}
				
				tables.add(0, new TableQuery(tableName, builder.toString()));
				//System.out.println("TableName: ="+tableName +", sql: ="+builder.toString());
				//statements.add(builder.toString());
			}
		}
	}
	
	/**
	 * 
	 * @param schemaDocument
	 * @param builder
	 * @param columnNode
	 */
	private void createColumnStructure(Document schemaDocument,StringBuilder builder,Node columnNode){
		String columnName = columnNode.getNodeName();
		String columnType = Functions.resolveType(schemaDocument, columnNode);
		
		//create the column SQL statements.
		builder.append("\t ,"+columnName +" "+columnType);										
		if(columnType.equalsIgnoreCase(Constants.TYPE_INTEGER) || 
				columnType.equalsIgnoreCase(Constants.TYPE_DATE) || columnType.equalsIgnoreCase(Constants.TYPE_BOOLEAN) ||
				columnType.equalsIgnoreCase(Constants.TYPE_DATETIME) || columnType.equalsIgnoreCase(Constants.TYPE_TIME)) {
			//do nothing for these types
		}
		else
			builder.append(getTypeSizeResolver(columnType));
		
		builder.append(System.getProperty("line.separator"));
	}
	
	/**
	 * resolves returns RDBMS type size
	 */
	private String getTypeSizeResolver(String type){
		if (type.equalsIgnoreCase(Constants.TYPE_BOOLEAN)) {
			return String.format(Constants.SIZE_OF_TYPE, 1);
		} else if(type.equalsIgnoreCase(Constants.TYPE_CHAR)) {
			return String.format(Constants.SIZE_OF_TYPE, 1);
		} else if(type.equalsIgnoreCase(Constants.TYPE_DECIMAL)) {
			return String.format(Constants.SIZE_OF_DECIMAL_TYPE, 10, 8);
		} else if(type.equalsIgnoreCase(Constants.TYPE_VARCHAR)) {
			return String.format(Constants.SIZE_OF_TYPE, 255);
		} else {
			return String.format(Constants.SIZE_OF_TYPE, 4);
		}
	}
}
