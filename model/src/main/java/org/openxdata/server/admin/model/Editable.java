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

import java.io.Serializable;
import java.util.Date;


/**
 * This interface is implemented by objects which can be edited.
 * 
 * @author daniel
 *
 */
public interface Editable extends Serializable{
	
	/**
	 * Checks if the object is new. New objects do not exist in the database.
	 * 
	 * @return true if the object is new, else false.
	 */
	public boolean isNew();
	
	/**
	 * Checks if the object has been changed and the changes have not yet been 
	 * persisted to the database.
	 * 
	 * @return true the object has unsaved changes, else false.
	 */
	public boolean isDirty();
	
	/**
	 * Flags the object as having been changed and which changes have not yet been
	 * persisted to the database.
	 * 
	 * @param dirty
	 */
	public void setDirty(boolean dirty);
	
	/**
	 * Sets the user who changed the object.
	 * 
	 * @param changedBy the user.
	 */
	public void setChangedBy(User changedBy);
	
	/** 
	 * Sets the date when the object was changed.
	 * 
	 * @param dateChanged the date.
	 */
	public void setDateChanged(Date dateChanged);
	
	/**
	 * Checks if the object has validation errors.
	 * 
	 * @return true if the object has, else false.
	 */
	public boolean hasErrors();
	
	/**
	 * Sets that the object has validation errors and hence should 
	 * not be persisted to the database.
	 * 
	 * @param hasErrors set this to true if the object has errors, else false.
	 */
	public void setHasErrors(boolean hasErrors);
	
	/**
	 * Returns the id of this editable item
	 * @return
	 */
	public int getId();
}
