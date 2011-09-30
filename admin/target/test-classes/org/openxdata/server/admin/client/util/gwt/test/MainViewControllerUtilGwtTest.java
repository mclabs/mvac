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
package org.openxdata.server.admin.client.util.gwt.test;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.gwt.test.OpenXDataGwtTestBase;
import org.openxdata.server.admin.client.util.MainViewControllerUtil;
import org.openxdata.server.admin.model.Editable;
import org.openxdata.server.admin.model.Report;
import org.openxdata.server.admin.model.ReportGroup;
import org.openxdata.server.admin.model.Role;
import org.openxdata.server.admin.model.Setting;
import org.openxdata.server.admin.model.SettingGroup;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.TaskDef;
import org.openxdata.server.admin.model.User;

/**
 * Tests the {@link MainViewControllerUtil} class.
 * <p>
 * This <tt>Test Class</tt> is NO substitute for <tt>Selenium tests.</tt> It should be adequately beefed with UI tests using selenium.
 * </p>
 * 
 * @author Angel
 *
 */
public class MainViewControllerUtilGwtTest extends OpenXDataGwtTestBase {
	
	private User editable;
	private List<Editable> dummyEditableList;
	
	@Override
	public void gwtSetUp(){
		editable  = new User(1, "Foo");
		initializeEditableList(true);
	}

	/**
	 * Initializes a dummy <tt>Editable List</tt> to work with.
	 */
	private void initializeEditableList(boolean isNew) {
		Editable study = new StudyDef();
		Editable user = new User("Foo-U");
		Editable role = new Role("Foo-R");
		Editable task = new TaskDef("Foo-T");
		Editable report = new Report("Foo-R");
		Editable setting = new Setting("Foo-S");
		Editable settingGroup = new SettingGroup("Foo-SG");
		Editable reportGroup = new ReportGroup("Foo-RG");
		
		if(isNew){
			study.setDirty(isNew);
			user.setDirty(isNew);
			role.setDirty(isNew);
			task.setDirty(isNew);
			settingGroup.setDirty(isNew);
			setting.setDirty(isNew);
			reportGroup.setDirty(isNew);
			report.setDirty(isNew);
		}
		else{
			study.setDirty(isNew);
			user.setDirty(isNew);
			role.setDirty(isNew);
			task.setDirty(isNew);
			settingGroup.setDirty(isNew);
			setting.setDirty(isNew);
			reportGroup.setDirty(isNew);
			report.setDirty(isNew);
		}
		
		dummyEditableList = new Vector<Editable>();
		
		dummyEditableList.add(study);
		dummyEditableList.add(user);
		dummyEditableList.add(role);
		dummyEditableList.add(task);
		dummyEditableList.add(settingGroup);
		dummyEditableList.add(setting);
		dummyEditableList.add(reportGroup);
		dummyEditableList.add(report);
	}
	
	public void testGetDirtyCount(){
		
		assertEquals(8, dummyEditableList.size());
		assertEquals(8, MainViewControllerUtil.getDirtyCount(dummyEditableList));
	}
	
	public void testGetDirtyCountX(){
		
		initializeEditableList(false);
		
		assertEquals("Should still be the same", 8, dummyEditableList.size());
		assertEquals(0, MainViewControllerUtil.getDirtyCount(dummyEditableList));
		assertNotSame(8, MainViewControllerUtil.getDirtyCount(dummyEditableList));
	}
	
	@SuppressWarnings("deprecation")
	public void testSetEditableProperties(){

		Context.setAuthenticatedUser(new User("Foo"));
		
		assertNull(editable.getCreator());
		assertNull(editable.getVoidedBy());
		assertNull(editable.getChangedBy());
		assertNull(editable.getDateChanged());
		assertNull(editable.getDateCreated());
		
		MainViewControllerUtil.setEditableProperties(editable);
		
		assertNotNull(editable.getChangedBy());
		assertNotNull(editable.getDateChanged());
		
		assertSame("The changer should be the same as the one in the Context", "Foo", editable.getChangedBy().getName());
		assertSame("The created date should be the same as today", new Date().getDate(), editable.getDateChanged().getDate());
		
	}
	
}
