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

import java.util.Date;

import net.sf.gilead.pojo.gwt.LightEntity;


/**
 * This serves as the base class for domain objects which can be edited.
 * 
 * @author daniel
 *
 */
public abstract class AbstractEditable extends LightEntity implements Editable{
	
	/**
	 * Generated <code>serialisation</code> ID.
	 */
	private static final long serialVersionUID = 7939951597182605859L;

	/** A flag to determine if the object has been changed and hence needs saving. */
	protected boolean dirty;
	
	/** A flag which tells that the objects has validation errors which need to be
	 * Corrected before it can be saved.
	 */
	protected boolean hasErrors;
	
	/** The user who last changed or edited the object. */
	protected User changedBy;
	
	/** The date when the object was last edited or changed. */
	protected Date dateChanged;
	
	/** The user who first submitted this data. */
	protected User creator;
	
	/** The date when this data was first submitted. */ 
	protected Date dateCreated;	
	
	@Override
	public boolean isNew(){
		return true;
	}
	
	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
	
	@Override
	public boolean hasErrors(){
		return hasErrors;
	}
	
	@Override
	public void setHasErrors(boolean hasErrors){
		this.hasErrors = hasErrors;
	}
	
	public User getChangedBy(){
		return changedBy;
	}
	
	@Override
	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}
	
	public Date getDateChanged(){
		return dateChanged;
	}
	
	@Override
	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}
	
	public User getCreator() {
		return creator;
	}
	
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
