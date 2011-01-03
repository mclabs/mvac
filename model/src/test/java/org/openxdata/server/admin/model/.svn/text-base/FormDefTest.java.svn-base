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
 * Tests slightly complicated methods of the FormDef class.
 * 
 * @author daniel
 *
 */
public class FormDefTest {

	@Test
	public void isDirty_shouldReturnTrueForFormWithDirtyFormVersion() {

		FormDef formDef = new FormDef();
		FormDefVersion formDefVersion = new FormDefVersion();
		formDef.addVersion(formDefVersion);
		
		Assert.assertFalse(formDef.isDirty());
		formDefVersion.setDirty(true);
		
		Assert.assertTrue(formDef.isDirty());
	}
	
	
	@Test
	public void isDirty_shouldReturnTrueForFormWithDirtyFormVersionText() {

		FormDef formDef = new FormDef();
		FormDefVersion formDefVersion = new FormDefVersion();
		formDef.addVersion(formDefVersion);
		FormDefVersionText formDefVersionText = new FormDefVersionText();
		formDefVersion.addVersionText(formDefVersionText);
		
		Assert.assertFalse(formDef.isDirty());
		formDefVersionText.setDirty(true);
		
		Assert.assertTrue(formDef.isDirty());
	}
	
	
	@Test
	public void isNew_shouldReturnTrueForFormWithNewFormVersion() {

		FormDef formDef = new FormDef();
		formDef.setFormId(1);
		Assert.assertFalse(formDef.isNew());
		
		formDef.addVersion(new FormDefVersion());
		
		Assert.assertTrue(formDef.isNew());
	}
	
	
	@Test
	public void isNew_shouldReturnTrueForFormWithNewFormVersionText() {

		FormDef formDef = new FormDef();
		formDef.setFormId(1);
		FormDefVersion formDefVersion = new FormDefVersion();
		formDefVersion.setFormDefVersionId(1);
		formDef.addVersion(formDefVersion);
		Assert.assertFalse(formDef.isNew());
		
		formDefVersion.addVersionText(new FormDefVersionText());
		
		Assert.assertTrue(formDef.isNew());
	}
}
