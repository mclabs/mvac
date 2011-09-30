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
package org.openxdata.server.admin.server;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.openxdata.server.admin.model.Editable;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDataHeader;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.admin.model.mapping.UserFormMap;
import org.openxdata.server.admin.model.mapping.UserStudyMap;
import org.openxdata.server.rpc.OxdPersistentRemoteService;
import org.springframework.web.context.WebApplicationContext;

/**
 * Default Implementation for the StudyManagerService <code>Interface.</code>
 * 
 * @author daniel
 * @author Mark
 * 
 */
public class StudyManagerServiceImpl extends OxdPersistentRemoteService implements
		org.openxdata.server.admin.client.service.StudyManagerService {

	private static final long serialVersionUID = 579255315976404465L;
	private org.openxdata.server.service.StudyManagerService studyManager;

	public StudyManagerServiceImpl() {
	}

	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext ctx = getApplicationContext();
		studyManager = (org.openxdata.server.service.StudyManagerService) ctx
				.getBean("studyManagerService");
	}

	@Override
	public List<StudyDef> getStudies() throws OpenXDataException {
		return studyManager.getStudies();
	}

	@Override
	public void saveStudy(StudyDef studyDef) throws OpenXDataException {
		studyManager.saveStudy(studyDef);
	}

	@Override
	public void deleteStudy(StudyDef studyDef) throws OpenXDataException {
		studyManager.deleteStudy(studyDef);
	}

	@Override
	public List<FormDef> getForms() throws OpenXDataException {
		return studyManager.getForms();
	}

	@Override
	public void saveForm(FormDef formDef) throws OpenXDataException {
		studyManager.saveForm(formDef);
	}

	@Override
	public void deleteForm(FormDef formDef) throws OpenXDataException {
		studyManager.deleteForm(formDef);
	}

	@Override
	public void deleteFormData(Integer formDataId) throws OpenXDataException {
		studyManager.deleteFormData(formDataId);
	}

	@Override
	public List<FormDataHeader> getFormData(Integer formDefId, Integer userId, Date fromDate,
			Date toDate) throws OpenXDataException {
		return studyManager.getFormData(formDefId, userId, fromDate, toDate);
	}

	@Override
	public void saveFormData(FormData formData) throws OpenXDataException {
		studyManager.saveFormData(formData);
	}

	@Override
	public FormData getFormData(Integer formDataId) throws OpenXDataException {
		return studyManager.getFormData(formDataId);
	}

	@Override
	public Boolean hasEditableData(Editable item) throws OpenXDataException {
		return studyManager.hasEditableData(item);
	}
	
	@Override
	public void deleteUserMappedForm(UserFormMap map) throws OpenXDataException {
		studyManager.deleteUserMappedForm(map);
	}

	@Override
	public void deleteUserMappedStudy(UserStudyMap map) throws OpenXDataException {
		studyManager.deleteUserMappedStudy(map);
	}

	@Override
	public List<UserFormMap> getUserMappedForms() throws OpenXDataException {
		return studyManager.getUserMappedForms();
	}

	@Override
	public List<UserStudyMap> getUserMappedStudies() throws OpenXDataException {
		return studyManager.getUserMappedStudies();
	}

	@Override
	public void saveUserMappedForm(UserFormMap map) throws OpenXDataException {
		studyManager.saveUserMappedForm(map);
	}

	@Override
	public void saveUserMappedStudy(UserStudyMap map) throws OpenXDataException {
		studyManager.saveUserMappedStudy(map);
	}
}
