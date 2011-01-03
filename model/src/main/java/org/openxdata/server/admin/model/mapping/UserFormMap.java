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
package org.openxdata.server.admin.model.mapping;

import org.openxdata.server.admin.model.AbstractEditable;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.User;

/**
 * Maps <code>Forms</code> to <code>User</code>.
 * 
 * @author Angel
 *
 */
public class UserFormMap extends AbstractEditable {

	private int userId;
	private int formId;
	private int userFormMapId;
	
	/**
	 * Generated serialization ID
	 */
	private static final long serialVersionUID = 4366549281586602840L;
	
	public UserFormMap(){}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param formId the formId to set
	 */
	public void setFormId(int formId) {
		this.formId = formId;
	}

	/**
	 * @return the formId
	 */
	public int getFormId() {
		return formId;
	}

	/**
	 * @param userFormId the userFormId to set
	 */
	public void setUserFormMapId(int userFormId) {
		this.userFormMapId = userFormId;
	}

	/**
	 * @return the userFormId
	 */
	public int getUserFormMapId() {
		return userFormMapId;
	}

	@Override
	public int getId() {
		return userFormMapId;
	}
	
	@Override
	public boolean isNew(){
		return this.userFormMapId == 0;
	}
	
	/**
	 * Adds the specified <code>User</code> to the Map.
	 * @param user <code>User</code> to remove.
	 */
	public void addUser(User user){
		setUserId(user.getUserId());
	}
	
	/**
	 * Removes the specified <code>User</code> from the Map.
	 * @param user <code>User</code> to remove.
	 */
	public void removeUser(User user){
		setUserId(user.getUserId());
	}
	
	/**
	 * Adds the specified <code>FormDef</code> to the Map.
	 * @param form <code>FormDef</code> to remove.
	 */
	public void addForm(FormDef form){
		setFormId(form.getFormId());
	}
	
	/**
	 * Removes the specified <code>FormDef</code> from the Map.
	 * @param form <code>FormDef</code> to remove.
	 */
	public void removeForm(FormDef form){
		setFormId(form.getFormId());
	}

}
