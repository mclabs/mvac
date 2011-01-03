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

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.service.StudyManagerService;
import org.openxdata.test.BaseContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 
 * @author daniel
 *
 */
public class FormDataServiceTest extends BaseContextSensitiveTest {

	@Autowired
	protected StudyManagerService studyManagerService;
	
	@Test
	public void getSetting_shouldReturnNullIfNoFormDataFoundWithGivenId() throws Exception {
		Assert.assertNull("formData with id=-1 exists", studyManagerService.getFormData(-1));
	}
	
	@Test
	public void getSetting_shouldNotReturnNullIfFormDataFoundWithGivenId() throws Exception {
		Assert.assertNotNull("formData with id=1 doesn't exist", studyManagerService.getFormData(1));
	}

	@Test
	public void deleteFormData_shouldDeleteFormDataWithGivenId() throws Exception {
		final int formDataId = 1;
		
		Assert.assertNotNull("form data does not exist", studyManagerService.getFormData(formDataId));
		studyManagerService.deleteFormData(formDataId);
		Assert.assertNull("formData still exists", studyManagerService.getFormData(formDataId));
	}
	
	@Test
	public void saveFormData() throws Exception {
		FormData fd = new FormData(1, "data", "description", new Date(), new User(1, "guyzb"));
		studyManagerService.saveFormData(fd);
		Assert.assertNotNull("Id has been set", fd.getId());
	}
}
