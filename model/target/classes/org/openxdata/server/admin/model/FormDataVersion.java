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


/**
 * This class holds a backup and audit trail for form data that has been updated.
 * 
 * @author dagmar@cell-life.org.za
 *
 */
public class FormDataVersion extends AbstractEditable{
	
    private static final long serialVersionUID = 8346348778133505205L;

    /** Unique identifier for this form data version */
    private int formDataVersionId = 0;

	/** Form Data object to which this is a backup */
	private FormData formData;
	
	/** The xml data. */
	private String data;
	
	
	/**
	 * Constructs a new form data object.
	 */
	public FormDataVersion(){
		
	}
	
	/**
	 * Creates a new copy of the form data version object from another instance.
	 * 
	 * @param formDataVersion the form data version instance to copy from.
	 */
	public FormDataVersion(FormDataVersion formDataVersion){
	    this.formDataVersionId = formDataVersion.formDataVersionId;
	    this.formData = formDataVersion.formData;
		this.data = formDataVersion.data;
		this.dateCreated = formDataVersion.dateCreated;
		this.creator = formDataVersion.creator;
		this.changedBy = formDataVersion.changedBy;
		this.dateChanged = formDataVersion.dateChanged;
	}
	
	/**
	 * Creates FormDataVersion backup from the FormData
	 * @param formData FormData that is being backed up
	 * @param data String containing old data
	 * @param dateCreated Date that the update was made
	 * @param creator User who made the update (that triggered the backup)
	 */
	public FormDataVersion(FormData formData, String data, Date dateCreated, User creator) {
        this.formData = formData;
        this.data = data;
        this.dateCreated = dateCreated;
        this.creator = creator;
    }

    public int getFormDataVersionId() {
        return formDataVersionId;
    }
    
    @Override
	public int getId() {
        return formDataVersionId;
    }    

    public void setFormDataVersionId(int formDataVersionId) {
        this.formDataVersionId = formDataVersionId;
    }

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}