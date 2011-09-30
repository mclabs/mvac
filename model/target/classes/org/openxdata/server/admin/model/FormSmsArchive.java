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
 * 
 * @author daniel
 *
 */
public class FormSmsArchive  extends FormData{

	/**
	 * Serialisation ID
	 */
	private static final long serialVersionUID = 3969864109678496787L;

	private int formSmsArchiveId = 0;
	
	private User archiveCreator;
	private Date archiveDateCreated;
	
	private String sender;
	
	public FormSmsArchive(){
		
	}
	
	public FormSmsArchive(FormData formData){
		super(formData);
	}
	
	public int getFormSmsArchiveId() {
		return formSmsArchiveId;
	}
	
	public void setFormSmsArchiveId(int formSmsArchiveId) {
		this.formSmsArchiveId = formSmsArchiveId;
	}
	
	public User getArchiveCreator() {
		return archiveCreator;
	}
	
	public void setArchiveCreator(User archiveCreator) {
		this.archiveCreator = archiveCreator;
	}
	
	public Date getArchiveDateCreated() {
		return archiveDateCreated;
	}
	
	public void setArchiveDateCreated(Date archiveDateCreated) {
		this.archiveDateCreated = archiveDateCreated;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
}
