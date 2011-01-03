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
package org.openxdata.server.admin.client.service;

import java.util.Date;
import java.util.List;

import org.openxdata.server.admin.model.Editable;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDataHeader;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.admin.model.mapping.UserFormMap;
import org.openxdata.server.admin.model.mapping.UserStudyMap;

import com.google.gwt.user.client.rpc.RemoteService;


/**
 * Defines the client side contract for the Study Manager Service.
 * 
 * @author daniel
 * @author Angel
 *
 */
public interface StudyManagerService extends RemoteService{
	
	/**
	 * Fetches all the <tt>Studies</tt> in the system.
	 * 
	 * @return <tt>List</tt> of <tt>Studies.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<StudyDef> getStudies() throws OpenXDataException;
	
	/**
	 * Saves a dirty or new <tt>Study.</tt>
	 * 
	 * @param studyDef <tt>Study</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveStudy(StudyDef studyDef) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>Study.</tt>
	 * 
	 * @param studyDef <tt>Study</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteStudy(StudyDef studyDef) throws OpenXDataException;
	
	/**
	 * Fetches all the <tt>Forms</tt> in the system.
	 * 
	 * @return <tt>List</tt> of <tt>Forms.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<FormDef> getForms() throws OpenXDataException;
	
	/**
	 * Saves a dirty or new <tt>Form.</tt>
	 * 
	 * @param formDef <tt>Form</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveForm(FormDef formDef) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>Form.</tt>
	 * 
	 * @param formDef <tt>Form</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteForm(FormDef formDef) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>Form's data.</tt>
	 * 
	 * @param formDataId ID of data to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteFormData(Integer formDataId) throws OpenXDataException;
	
	/**
	 * Fetches a given <tt>Form's data.</tt>
	 * 
	 * @param formDataId ID of the <tt>Form Data</tt> to fetch.
	 * @return <tt>Form's Form Data.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	FormData getFormData(Integer formDataId) throws OpenXDataException;
	
	/** 
	 * Checks if a given <tt>Editable</tt> has data. 
	 *  
	 * @param editable <tt>Editable</tt> to check data for. 
	 * @return <tt>True if has data else false.</tt> 
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt> 
	 */ 
	Boolean hasEditableData(Editable editable) throws OpenXDataException; 
	
	List<FormDataHeader> getFormData(Integer formDefId, Integer userId, Date fromDate,  Date toDate) throws OpenXDataException;
	
	/**
	 * Saves given <tt>Form Data.</tt>
	 * 
	 * @param formData <tt>Form Data</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveFormData(FormData formData) throws OpenXDataException;
	
	/**
	 * Fetches all the <tt>User Mapped Studies</tt> in the system.
	 * 
	 * @return <tt>List</tt> of <tt>User Mapped Studies.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<UserStudyMap> getUserMappedStudies() throws OpenXDataException;
	
	/**
	 * Saves a dirty or new <tt>User Mapped Study.</tt>
	 * 
	 * @param userMappedStudy <tt>User Mapped Study</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveUserMappedStudy(UserStudyMap userMappedStudy) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>User Mapped Study.</tt>
	 * 
	 * @param userMappedStudy <tt>User Mapped Study</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteUserMappedStudy(UserStudyMap userMappedStudy) throws OpenXDataException;
	
	/**
	 * Fetches all the <tt>User Mapped Forms</tt> in the system.
	 * 
	 * @return <tt>List</tt> of <tt>User Mapped Forms.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<UserFormMap> getUserMappedForms() throws OpenXDataException;
	
	/**
	 * Saves a dirty or new <tt>User Mapped Form.</tt>
	 * 
	 * @param userMappedForm <tt>User Mapped Form</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveUserMappedForm(UserFormMap userMappedForm) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>User Mapped Form.</tt>
	 * 
	 * @param userMappedForm <tt>User Mapped Form</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteUserMappedForm(UserFormMap userMappedForm) throws OpenXDataException;

}
