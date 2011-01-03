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
package org.openxdata.server.report.birt;

/**
 * This class represents a column which can be displayed in a report.
 * It could be a database column of calculated column.
 * 
 * @author daniel
 *
 */
public class ReportColumn {

	/** The database name of the column. */
	private String name;
	
	/** The display name of the column. */
	private String displayName;
	
	/** The BIRT data type for the column. */
	private String dataType;
	
	
	/**
	 * Creates a new instance of a column.
	 */
	public ReportColumn(){
		
	}

	/**
	 * Creates a new instance of a column from these parameters.
	 * 
	 * @param name the column database name.
	 * @param displayName the display name.
	 * @param dataType the BIRT data type of the column.
	 */
	public ReportColumn(String name, String displayName, String dataType) {
		super();
		this.name = name;
		this.displayName = displayName;
		this.dataType = dataType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
