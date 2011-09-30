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
package org.openxdata.server.admin.model;

/**
 * This class represents a parameter for a schedulable task.
 * 
 * @author daniel
 *
 */
public class TaskParam  extends AbstractEditable{
	
	/**
	 * Serialization ID
	 */
	private static final long serialVersionUID = 5620957823593973227L;

	/** The database identifier for the parameter. */
	private int paramId = 0;
	
	/** The task definition to which this parameter belongs. */
	private TaskDef taskDef;
	
	/** The name of the parameter. */
	private String name;
	
	/** The value of the parameter. */
	private String value;
	
	/**
	 * Constructs a new task parameter object.
	 */
	public TaskParam(){
		
	}

	/**
	 * Constructs a new task parameter for a given a task definition, and with
	 * a given parameter name and value.
	 * 
	 * @param taskDef the task definition.
	 * @param name the parameter name.
	 * @param value the parameter value.
	 */
	public TaskParam(TaskDef taskDef,String name, String value){
		this.taskDef = taskDef;
		this.name= name;
		this.value= value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParamId() {
		return paramId;
	}

	@Override
	public int getId() {
		return paramId;
	}
	
	public void setParamId(int paramId) {
		this.paramId = paramId;
	}

	public TaskDef getTaskDef() {
		return taskDef;
	}

	public void setTaskDef(TaskDef taskDef) {
		this.taskDef = taskDef;
	}

	@Override
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public boolean isNew(){
		return paramId == 0;
	}
}
