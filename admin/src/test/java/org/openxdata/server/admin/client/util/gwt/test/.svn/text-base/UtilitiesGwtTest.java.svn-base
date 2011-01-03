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

import java.util.List;
import java.util.Vector;

import org.openxdata.server.admin.client.gwt.test.OpenXDataGwtTestBase;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.images.OpenXDataImages;
import org.openxdata.server.admin.client.view.widget.CompositeTreeItem;
import org.openxdata.server.admin.client.view.widget.TreeItemWidget;
import org.openxdata.server.admin.model.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * Tests the {@link Utilities} class.
 * <p>
 * This <tt>Test Class</tt> is NO substitute for <tt>Selenium tests.</tt> It should be adequately beefed with UI tests using selenium.
 * </p>
 * 
 * @author Angel
 *
 */
public class UtilitiesGwtTest extends OpenXDataGwtTestBase {
	
	private List<User> dummyUserList;
	
	@Override
	public void gwtSetUp(){
		
		initializeUserList(false);

	}
	
	private Tree getTree(User user){
		
		Tree tree;
		TreeItem root;
		PopupPanel popup;
		
		final OpenXDataImages images = (OpenXDataImages) GWT.create(OpenXDataImages.class);
		
		tree = new Tree(images);
		popup = new PopupPanel(true,true);
		root = new CompositeTreeItem(new TreeItemWidget(images.lookup(), user.getName(), popup));
		root.setTitle(user.getFullName());
		root.setUserObject(user);
		tree.addItem(root);
		
		return tree;
	}

	/**
	 * Initializes a dummy <tt>User</tt> list.
	 */
	private void initializeUserList(boolean changePasswords) {
		if(changePasswords){
			
			User foo = new User(0, "Foo","Foo","XXX");
			foo.setClearTextPassword("Foo");
			
			User dummy = new User(0, "Dummy", "Dummy", "XXXX");
			dummy.setClearTextPassword("Dummy");
			
			User foo_dummy = new User(0, "Foo-Dummy", "Foo-D","XXXXX");
			foo_dummy.setClearTextPassword("Foo-D");
			
			dummyUserList = new Vector<User>();
			
			dummyUserList.add(foo);
			dummyUserList.add(dummy);
			dummyUserList.add(foo_dummy);
		}
		else{
			
			User foo = new User(0, "Foo","Foo","XXX");
			foo.setClearTextPassword("Foo-bar");
			
			User dummy = new User(0, "Dummy", "Dummy-Bummy", "XXXX");
			dummy.setClearTextPassword("Dummy-Bummy");
			
			User foo_dummy = new User(0, "Foo-Dummy", "Foo-D","XXXXX");
			foo_dummy.setClearTextPassword("Foo-Dummy-bar");
			
			dummyUserList = new Vector<User>();
			
			dummyUserList.add(foo);
			dummyUserList.add(dummy);
			dummyUserList.add(foo_dummy);
		}
		
	}
	
	public void testGetUserStatusTypes(){
		
		List<String> statusTypes = Utilities.getUserStatusTypes();//.toArray();
		
		assertNotNull(statusTypes);
		assertEquals("They should be 3 types", 3, statusTypes.size());
		String[] statusNames = getNames(statusTypes);
		
		assertNotNull(statusNames);
		assertEquals("They should be 3 types", 3, statusNames.length);
		
		assertTrue(statusNames[0].equals("Active"));
		assertTrue(statusNames[1].equals("Disabled"));
		assertTrue(statusNames[2].equals("Pending Approval"));
	}
	
	public void testGetUserStatusTypesX(){
		
		List<String> statusTypes = Utilities.getUserStatusTypes();//.toArray();
		
		assertNotNull(statusTypes);
		assertNotSame("They should be 3 types", 2, statusTypes.size());
		String[] statusNames = getNames(statusTypes);
		
		assertNotNull(statusNames);
		assertNotSame("They should be 3 types", 4, statusNames.length);
		
		assertFalse(statusNames[0].equals("ActiveX"));
		assertFalse(statusNames[1].equals("DisabledX"));
		assertFalse(statusNames[2].equals("Pending ApprovalX"));
	}
	
	public void testValidatedUserPassword(){
		for(User x : dummyUserList){
			assertNotNull(x);
			assertTrue(Utilities.validateUserPassword(x));
		}
	}
	
	public void testValidatedUserPasswordX(){
		initializeUserList(true);
		for(User x : dummyUserList){
			assertNotNull(x);
			assertFalse(Utilities.validateUserPassword(x));
		}
	}
	
	public void testSelectFirstItemOnTreeView(){
		User xUser = new User("Foo");
		
		xUser.setFirstName("Foo-B");
		xUser.setMiddleName("Bar");
		xUser.setLastName("Dummy");
		
		Tree tree = getTree(xUser);
		
		assertNotNull(xUser.getFirstName());
		assertNotNull(xUser.getMiddleName());
		assertNotNull(xUser.getFirstName());
		
		assertSame("Should equals the First Name we just set","Foo-B", xUser.getFirstName());
		assertSame("Should equals the Middle Name we just set","Bar", xUser.getMiddleName());
		assertSame("Should equals the Last Name we just set","Dummy", xUser.getLastName());
		
		//Returned tree should not be null
		assertNotNull(tree);
		assert(tree.getItemCount() > 0);
		assertFalse(tree.getItem(0).getState());
		assertFalse(tree.getItem(0).isSelected());
		assertEquals("Should have only one User object -- the User we added!", 1, tree.getItemCount());
		
		Utilities.selectFirstItemOnTreeView(tree);
		
		assertNotNull(tree);
		assert(tree.getItemCount() > 0);
		assertTrue(tree.getItem(0).isSelected());
		assertEquals("Should still have only one User object -- the User we added!", 1, tree.getItemCount());
		
		//assertTrue(tree.getItem(0).getState()); -- Use selenium for this.
	}
	
	public void testValidateEmail(){
		
		String fooEmail = "contact@openxdata.org";
		String foo2Email = "contact@openxdata.com";
		String foo3Email = "contact@cit.mak.ac.ug";
		String foo4Email = "contact@cell-life.org.za";
		
		assertTrue(Utilities.validateEmail(fooEmail));
		assertTrue(Utilities.validateEmail(foo2Email));
		assertTrue(Utilities.validateEmail(foo3Email));
		assertTrue(Utilities.validateEmail(foo4Email));
		
		// Testing multiple emails
		String emails = "contact@openxdata.org, contact@cell-life.org.za, contact@cit.mak.ac.ug";
		assertTrue(Utilities.validateEmail(emails.trim()));
	}
	
	public void testValidateEmailX(){
		
		String fooEmail = "contact[at]openxdata.org";
		String foo2Email = "contactXcit.mak.ac.ug";
		String foo3Email = "contact@.com";
		String foo4Email = "@cell-life.org.za";
		
		assertFalse(Utilities.validateEmail(fooEmail));
		assertFalse(Utilities.validateEmail(foo2Email));
		assertFalse(Utilities.validateEmail(foo3Email));
		assertFalse(Utilities.validateEmail(foo4Email));
		
		// Testing multiple emails
		String emails = "contact@cell-life.org.za, contact[at]openxdata.org, contactXcit.mak.ac.ug ";
		assertFalse(Utilities.validateEmail(emails.trim()));
	}

	/**
	 * Retrieves the names of a <tt>List</tt> and binds them to an <tt>array.</tt>
	 * @param statusTypes List of strings to disemble.
	 * @return <tt>Array of Strings</tt>
	 */
	private String[] getNames(List<String> statusTypes) {
		int index = 0;
		String[] arrNames = new String[statusTypes.size()];
		for(String x : statusTypes){
			for(; index < arrNames.length;){
				arrNames[index] = index < statusTypes.size() ? x : "";
				index++;
				break;
			}
		}
		return arrNames;
	}
}
