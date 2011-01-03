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
package org.openxdata.server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openxdata.server.admin.model.Editable;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDataHeader;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.FormDefVersion;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.TaskDef;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.mapping.UserFormMap;
import org.openxdata.server.admin.model.mapping.UserStudyMap;
import org.openxdata.server.dao.FormDAO;
import org.openxdata.server.dao.FormDataDAO;
import org.openxdata.server.dao.StudyDAO;
import org.openxdata.server.dao.EditableDAO;
import org.openxdata.server.dao.UserFormMapDAO;
import org.openxdata.server.dao.UserStudyMapDAO;
import org.openxdata.server.export.rdbms.task.RdmsDataExportTask;
import org.openxdata.server.service.StudyManagerService;
import org.openxdata.server.service.TaskService;
import org.openxdata.server.sms.WapPushSms;
import org.openxdata.server.util.XformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default implementation for study manager service.
 * 
 * @author daniel
 * @author Mark
 *
 */
@Service("studyManagerService")
@Transactional
public class StudyManagerServiceImpl implements StudyManagerService {

	@Autowired
	private FormDAO formDAO;
	
	@Autowired
	private StudyDAO studyDao;	
	
	@Autowired
	private FormDataDAO formDataDAO;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RdmsDataExportTask exportTask;
	
	@Autowired
	private UserFormMapDAO userFormMapDAO;
	
	@Autowired
	private UserStudyMapDAO userStudyMapDAO;

    @Autowired
    private EditableDAO editableDAO;
    
	@Override
	public void deleteForm(FormDef formDef) {
		formDAO.deleteForm(formDef);
	}

	@Override
	public void deleteFormData(Integer formDataId){
		formDataDAO.deleteFormData(formDataId);
	}

	@Override
	public void deleteStudy(StudyDef studyDef) {
		studyDao.deleteStudy(studyDef);
	}

	@Override
	@Transactional(readOnly=true)
	public List<FormDef> getForms() {
		return formDAO.getForms();
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudyDef> getStudies() {		
		return studyDao.getStudies();
	}

	@Override
	public void saveForm(FormDef formDef) {
		formDAO.saveForm(formDef);
	}

	@Override
	public void saveStudy(StudyDef studyDef) {
		List<FormDefVersion> newVersions = new ArrayList<FormDefVersion>();

		//Get a list of new form versions
		if(studyDef.getForms() != null){
			for(FormDef formDef : studyDef.getForms()){
				if(formDef.getVersions() == null)
					continue;

				for(FormDefVersion formDefVersion : formDef.getVersions()){
					if(formDefVersion.isNew())
						newVersions.add(formDefVersion);
				}
			}
		}

		studyDao.saveStudy(studyDef);

		//Now set the xforms id attribute to the value of the saved form version id.
        for (FormDefVersion formDefVersion : newVersions) {
            if (formDefVersion.getXform() != null) {
                formDefVersion.setXform(XformUtil.addFormId2Xform(formDefVersion.getFormDefVersionId(),
                        formDefVersion.getXform()));
            }
        }

		//Save the modified new form versions, if any
		//TODO This should only save the formDefVersion instead of the whole study.
		if(newVersions.size() > 0)
			studyDao.saveStudy(studyDef);
	}

	@Override
	@Transactional(readOnly=true)
	public List<FormDataHeader> getFormData(Integer formDefId, Integer userId, Date fromDate, Date toDate) {
		return editableDAO.getFormData(formDefId, userId, fromDate, toDate);
	}

	@Override
	public void saveFormData(FormData formData) {
        formData.setExported(0); // make sure the exported flag is reset
	    if (formData.getFormDataId() != 0) {
	        // save a backup/audit/history if this is not the first version
	    	formDataDAO.saveFormDataVersion(formData);
	    }
	    formDataDAO.saveFormData(formData);
		// trigger the export task
		TaskDef task = taskService.getTask("data export");
		if (task != null) {
            String continuous = task.getParamValue("continuous");
            if (continuous != null && continuous.equalsIgnoreCase("true")) {
                exportTask.init(task);
                exportTask.exportFormData(formData, true);
            }
		}
	}

	@Override
	@Transactional(readOnly=true)
	public FormData getFormData(Integer formDataId) {
		return formDataDAO.getFormData(formDataId);
	}

	@Override
	@Transactional(readOnly=true)
	public Boolean hasEditableData(Editable item) {
		return editableDAO.hasEditableData(item);
	}
	
	public Boolean installMobileApp(List<String> phonenos, String url, String modemComPort, int modemBaudRate, String promptText){
		return WapPushSms.sendMessages(phonenos, url, modemComPort, modemBaudRate, promptText);
	}
	
	@Override
	public List<UserStudyMap> getUserMappedStudies() {
		return userStudyMapDAO.getUserMappedStudies();
	}

	@Override
	public void saveUserMappedStudy(UserStudyMap map) {
		userStudyMapDAO.saveUserMappedStudy(map);
	}
	
	@Override
	public void deleteUserMappedStudy(UserStudyMap map) {
		userStudyMapDAO.deleteUserMappedStudy(map);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<FormDef> getFormsForUser(User user) {
		return userFormMapDAO.getFormsForUser(user);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<FormDef> getFormsForUser(User user, Integer studyDefId) {
		return userFormMapDAO.getFormsForUser(user, studyDefId);
	}

	@Override
	public void deleteUserMappedForm(UserFormMap map) {
		userFormMapDAO.deleteUserMappedForm(map);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<UserFormMap> getUserMappedForms() {
		return userFormMapDAO.getUserMappedForms();
	}

	@Override
	public void saveUserMappedForm(UserFormMap map) {
		userFormMapDAO.saveUserMappedForm(map);
	}
	
	@Override
	public String getStudyKey(int studyId) {
		String key = studyDao.getStudyKey(studyId);
		if (key == null)
			key = "";
		return key;
	}

	@Override
	public String getStudyName(int studyId) {
		String name = studyDao.getStudyName(studyId);
		if(name == null)
                name = "UNKNOWN STUDY";
        return name;
	}
}
