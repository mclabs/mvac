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
package org.openxdata.server.dao.hibernate;

import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.FormDataVersion;
import org.openxdata.server.dao.FormDataDAO;
import org.springframework.security.annotation.Secured;
import org.springframework.stereotype.Repository;

/**
 * @author Angel
 *
 */
@Repository("formDataDAO")
public class HibernateFormDataDAO extends BaseDAOImpl<FormData> implements FormDataDAO {

	@Override
	@Secured("Perm_Delete_Form_Data")
	public void deleteFormData(Integer formDataId){
		getSession().createSQLQuery("delete from form_data where form_data_id="+formDataId).executeUpdate();
	}

	@Override
	@Secured("Perm_View_Form_Data")
	public FormData getFormData(Integer formDataId) {
		return (FormData)getSession().get(FormData.class, formDataId);
	}

	@Override
	@Secured("Perm_Add_Form_Data")
	public void saveFormData(FormData formData){
		save(formData);
	}
	
	@Override
	@Secured("Perm_Add_Form_Data")
	public void saveFormDataVersion(FormData formData) {
	    String oldData = getFormData(formData.getFormDataId()).getData();
        FormDataVersion backup = new FormDataVersion(formData, oldData, formData.getDateChanged(), formData.getChangedBy());
        saveFormDataVersion(backup);
	}
	
	@Override
	@Secured("Perm_Add_Form_Data")
    public void saveFormDataVersion(FormDataVersion formDataVersion) {
	    _save(formDataVersion);
	}
}
