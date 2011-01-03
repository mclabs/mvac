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
 * This class enables us to have a lighter version of form data for display purposes
 * in form of a summary for data which has been collected. 
 * This class is not implementing the Editable interface because we do not expect 
 * to edit header objects.
 * 
 * @author daniel
 *
 */
public class FormDataHeader extends LightEntity{
	
	/**
	 * Serialisation ID
	 */
	private static final long serialVersionUID = 8542417235341285428L;

	/** The numeric unique identifier of the form data. */
	private int formDataId = 0;
	
	/** The numeric unique identifier for the version of the form that this data belongs to. */
	private Integer formDefVersionId;
	
	/** The user who first submitted this data. */
	private String creator;
	
	/** The date when this data was first submitted. */ 
	private Date dateCreated;
	
	/** The user who last changed or edited the object. */
	private String changedBy;
	
	/** The date when the object was last edited or changed. */
	private Date dateChanged;
	
	/** Description of the form data. */
	private String description;
	
	/** The name of the form whose data is contained in this object. */
	private String formName;
	
	/** The name of the form version whose data is contained in this object. */
	private String versionName;
	
	//TODO This is a temporary hack for deleted form data from a list and 
	//hence should eventually be removed from here. That is why i have made
	//it public such that it can be easily seen as violating the contract
	//of getters and setters as for the rest.
	public boolean deleted = false;
	
	/**
	 * Creates a new instance of the form data header object.
	 */
	public FormDataHeader(){
		
	}
	
	/**
	 * Creates a new instance of the form data object given the version id, date created and 
	 * user who submitted the data.
	 * 
	 * @param formDefVersionId the form version identifier.
	 * @param dateCreated the data when this form data was first submitted.
	 * @param creator the user whos first submitted this data.
	 */
	public FormDataHeader(Integer formDefVersionId, Date dateCreated, String creator){
		this.formDefVersionId =  formDefVersionId;
		this.dateCreated = dateCreated;
		this.creator = creator;
	}
	
	public String getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getDateChanged() {
		return dateChanged;
	}
	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public int getFormDataId() {
		return formDataId;
	}
	public void setFormDataId(int formDataId) {
		this.formDataId = formDataId;
	}
	public Integer getFormDefVersionId() {
		return formDefVersionId;
	}
	public void setFormDefVersionId(Integer formDefVersionId) {
		this.formDefVersionId = formDefVersionId;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
}
