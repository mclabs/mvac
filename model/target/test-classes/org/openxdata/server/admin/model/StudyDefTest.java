/**
 *  Licensed to the OpenXdata Foundation (OXDF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The OXDF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at <p>
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  </p>
 *
 *  Unless required by applicable law or agreed to in writing, 
 *  software distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 *
 *  Copyright 2010 http://www.openxdata.org.
 */
package org.openxdata.server.admin.model;

import junit.framework.Assert;

import org.junit.Test;


/**
 * Tests slightly complicated methods of the StudyDef class.
 * 
 * @author daniel
 *
 */
public class StudyDefTest {

	@Test
	public void isDirty_shouldReturnTrueForStudyWithDirtyForm() {

		StudyDef studyDef = new StudyDef();
		FormDef formDef = new FormDef();
		studyDef.addForm(formDef);
		
		Assert.assertFalse(studyDef.isDirty());
		formDef.setDirty(true);
		
		Assert.assertTrue(studyDef.isDirty());
	}
	
	
	@Test
	public void isDirty_shouldReturnTrueForStudyWithDirtyFormVersion() {

		StudyDef studyDef = new StudyDef();
		FormDef formDef = new FormDef();
		studyDef.addForm(formDef);
		FormDefVersion formDefVersion = new FormDefVersion();
		formDef.addVersion(formDefVersion);
		
		Assert.assertFalse(studyDef.isDirty());
		formDefVersion.setDirty(true);
		
		Assert.assertTrue(studyDef.isDirty());
	}
	
	
	@Test
	public void isDirty_shouldReturnTrueForStudyWithDirtyFormVersionText() {

		StudyDef studyDef = new StudyDef();
		FormDef formDef = new FormDef();
		studyDef.addForm(formDef);
		FormDefVersion formDefVersion = new FormDefVersion();
		formDef.addVersion(formDefVersion);
		FormDefVersionText formDefVersionText = new FormDefVersionText();
		formDefVersion.addVersionText(formDefVersionText);
		
		Assert.assertFalse(studyDef.isDirty());
		formDefVersionText.setDirty(true);
		
		Assert.assertTrue(studyDef.isDirty());
	}
	
	
	@Test
	public void isNew_shouldReturnTrueForStudyWithNewForm() {

		StudyDef studyDef = new StudyDef();
		studyDef.setStudyId(1);
		Assert.assertFalse(studyDef.isNew());

		studyDef.addForm(new FormDef());
		
		Assert.assertTrue(studyDef.isNew());
	}
	
	
	@Test
	public void isNew_shouldReturnTrueForStudyWithNewFormVersion() {

		StudyDef studyDef = new StudyDef();
		studyDef.setStudyId(1);
		FormDef formDef = new FormDef();
		formDef.setFormId(1);
		studyDef.addForm(formDef);
		Assert.assertFalse(studyDef.isNew());
		
		formDef.addVersion(new FormDefVersion());
		
		Assert.assertTrue(studyDef.isNew());
	}
	
	
	@Test
	public void isNew_shouldReturnTrueForStudyWithNewFormVersionText() {

		StudyDef studyDef = new StudyDef();
		studyDef.setStudyId(1);
		FormDef formDef = new FormDef();
		formDef.setFormId(1);
		studyDef.addForm(formDef);
		FormDefVersion formDefVersion = new FormDefVersion();
		formDefVersion.setFormDefVersionId(1);
		formDef.addVersion(formDefVersion);
		Assert.assertFalse(studyDef.isNew());
		
		formDefVersion.addVersionText(new FormDefVersionText());
		
		Assert.assertTrue(studyDef.isNew());
	}
}
