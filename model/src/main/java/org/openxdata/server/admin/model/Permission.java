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
 * This class encapsulates a permission 
 * which can be used to restrict the level of access in <code>openXData</code>. 
 * 
 * <P>
 * Examples of permissions could be<code> View Form Data, Edit Form Data,
 * Delete Form Data, Create New Studies, Export Data, Export Study </code>.
 * </P>
 * 
 * @author Mark
 * @author daniel
 *
 */
public class Permission extends AbstractEditable {
	
	/**
	 * Serialisation ID
	 */
	private static final long serialVersionUID = 4590744588070449021L;

	/** The database identifier of the permission. */
	private int permissionId = 0;
	
	/** The name of the permission. */
	private String name;
	
	/** The description of the permission. */
	private String description;
	
	
	/**
	 * Constructs a new permission object.
	 */
	public Permission(){
		
	}
	
	/**
	 * Constructs a new permission object with a given name.
	 * 
	 * @param name the name of the permission.
	 */
	public Permission(String name){
		this.name = name;
	}
	
	public int getPermissionId(){
		return permissionId;
	}
	
	@Override
	public int getId(){
		return permissionId;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}

	public void setPermissionId(int permissionId){
		this.permissionId = permissionId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	@Override
	public boolean isNew(){
		return permissionId == 0;
	}
}
