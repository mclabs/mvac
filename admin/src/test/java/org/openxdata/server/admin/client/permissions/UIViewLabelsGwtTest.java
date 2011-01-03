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
package org.openxdata.server.admin.client.permissions;

import org.openxdata.server.admin.client.gwt.test.OpenXDataGwtTestBase;

/**
 * Tests the {@link UIViewLabels} class.
 * <p>
 * This <tt>Test Class</tt> is NO substitute for <tt>Selenium tests.</tt> It should be adequately beefed with UI tests using selenium.
 * </p>
 * 
 * @author Angel
 *
 */
public class UIViewLabelsGwtTest extends OpenXDataGwtTestBase {

	private UIViewLabels labels;
	
	@Override
	public void gwtSetUp(){
		
		labels = new UIViewLabels();
		
		labels.setLabel("Dummy");
		labels.setAddLabel("Add Dummy");

		labels.setDeleteLabel("Delete Dummy");
		
		labels.setMapButtonText("Map Dummy");
		labels.setUnMapButtonText("UnMap Dummy");
		
		labels.setAddButtonTitle("Add Dummy");
		labels.setRemoveButtonTitle("Remove Dummy");				

		labels.setLeftListBoxLabel("Dummy Objects");
		labels.setRightListBoxLabel("Mapped Dummy Objects");		

		labels.setAddChildItemLabel("Add child Dummy Object");
		labels.setDeleteChildItemLabel("Delete Bummy Object");
		
	}
	
	public void testGetLabel(){
		assertNotNull(labels.getLabel());
		assertEquals("Dummy", labels.getLabel());
	}
	
	public void testGetAddLabel(){
		assertNotNull(labels.getAddLabel());
		assertEquals("Add Dummy", labels.getAddLabel());
		
	}
	
	public void testGetAddButtonTitle(){
		assertNotNull(labels.getAddButtonTitle());
		assertEquals("Add Dummy", labels.getAddButtonTitle());
	}
	
	public void testGetRemoveButtonTitle(){
		assertNotNull(labels.getRemoveButtonTitle());
		assertEquals("Remove Dummy", labels.getRemoveButtonTitle());
	}
	
	public void testGetDeleteLabel(){
		assertNotNull(labels.getDeleteLabel());
		assertEquals("Delete Dummy", labels.getDeleteLabel());
	}
	
	public void testGetLeftListBoxLabel(){
		assertNotNull(labels.getLeftListBoxLabel());
		assertEquals("Dummy Objects", labels.getLeftListBoxLabel());
	}
	
	public void testGetRightListBoxLabel(){
		assertNotNull(labels.getRightListBoxLabel());
		assertEquals("Mapped Dummy Objects", labels.getRightListBoxLabel());
	}
	
	public void testGetMapButtonText(){
		assertNotNull(labels.getMapButtonText());
		assertEquals("Map Dummy", labels.getMapButtonText());
	}
	
	public void testGetUnMapButtonText(){
		assertNotNull(labels.getUnMapButtonText());
		assertEquals("UnMap Dummy", labels.getUnMapButtonText());
	}
	
	public void testGetAddChildItemLabel(){
		assertNotNull(labels.getAddChildItemLabel());
		assertEquals("Add child Dummy Object", labels.getAddChildItemLabel());
	}
	
	public void testGetDeleteChildItemLabel(){
		assertNotNull(labels.getDeleteChildItemLabel());
		assertEquals("Delete Bummy Object", labels.getDeleteChildItemLabel());
	}
}
