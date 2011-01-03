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

import java.util.HashSet;
import java.util.Set;

import org.openxdata.server.admin.client.gwt.test.OpenXDataGwtTestBase;
import org.openxdata.server.admin.model.Permission;

/**
 * Tests the {@link PermissionResolver} class.
 * <p>
 * This <tt>Test Class</tt> is NO substitute for <tt>Selenium tests.</tt> It should be adequately beefed with UI tests using selenium.
 * </p>
 * 
 * @author Angel
 *
 */
public class PermissionResolverGwtTest extends OpenXDataGwtTestBase{
	
	private Set<Permission> permissions;
	
	//Object to test administrator permissions
	private PermissionResolver adminResolver;
	
	//Object to test normal User Permissions
	private PermissionResolver permissionResolver;
	
	//Object to test a User with NO Permissions
	private PermissionResolver lessResolver;
	
	@Override
	public void gwtSetUp(){
		
		//Object to test administrator permissions
		adminResolver = new PermissionResolver(true);
		
		//Dummy permission List
		permissions = new HashSet<Permission>();

		//Dummy permissions to deal with Studies
		permissions.add(new Permission("Perm_View_Studies"));
		permissions.add(new Permission("Perm_Edit_Studies"));
		permissions.add(new Permission("Perm_Delete_Studies"));
		permissions.add(new Permission("Perm_Add_Studies"));	
		
		permissions.add(new Permission("Perm_Map_Studies_To_Users"));
		
		//Dummy Permissions to deal with Users
		permissions.add(new Permission("Perm_View_Users"));
		permissions.add(new Permission("Perm_Edit_Users"));
		permissions.add(new Permission("Perm_Delete_Users"));
		permissions.add(new Permission("Perm_Add_Users"));	
		
		permissions.add(new Permission("Perm_Map_Roles_To_Users"));
		
		permissionResolver = new PermissionResolver(false, permissions);
		
		lessResolver = new PermissionResolver(false, null);
	}
	
	public void testIsAdmin_ShouldReturnTrue(){			
		assertTrue(adminResolver.isAdmin());
	}
	
	public void testIsAdmin_ShouldReturnFalse(){		
		assertFalse(permissionResolver.isAdmin());
	}
	
	public void testHasPermissions_ShouldReturnTrue(){
		
		//Test Add Permissions
		assertTrue(permissionResolver.isAddPermission());
		assertTrue(permissionResolver.isAddPermission("Perm_Add_Studies"));
		
		//Test Edit Permissions
		assertTrue(permissionResolver.isEditPermission());
		assertTrue(permissionResolver.isEditPermission("Perm_Edit_Studies"));
		
		//Test View Permissions
		assertTrue(permissionResolver.isViewPermission());
		assertTrue(permissionResolver.isViewPermission("Perm_View_Studies"));
		
		//Test Delete Permissions
		assertTrue(permissionResolver.isDeletePermission());
		assertTrue(permissionResolver.isDeletePermission("Perm_Delete_Studies"));
		
		//Test Extra Permissions
		assertTrue(permissionResolver.isExtraPermission());
		assertTrue(permissionResolver.isExtraPermission("Perm_Map_Roles_To_Users"));
	}
	
	public void testHasPermission_shouldReturnFalse(){
		
		//Testing if User CANNOT add Roles via Tool bar cause of no Permissions
		assertFalse(permissionResolver.isAddPermission("Perm_Add_Roles"));
		
		//Testing if User CANNOT edit Roles 
		assertFalse(permissionResolver.isEditPermission("Perm_Edit_Roles"));
		
		//Testing if User CANNOT view Roles
		assertFalse(permissionResolver.isViewPermission("Perm_View_Roles"));
		
		//Testing if User CANNOT delete Roles via Tool bar cause of no Permissions
		assertFalse(permissionResolver.isDeletePermission("Perm_Delete_Roles"));
		
		//Testing if User doesnot have unassigned extra permission
		assertFalse(permissionResolver.isExtraPermission("Perm_Map_Mark_To_Angel"));
	}
	
	public void testAddSimulateToolBarPermissions_ShouldReturnTrue(){
		
		//Test if User Can add Studies via Tool bar
		assertTrue(adminResolver.isAddStudies());
		assertTrue(permissionResolver.isAddStudies());
		
		//Test if User Can add User via Tool bar
		assertTrue(adminResolver.isAddUsers());
		assertTrue(permissionResolver.isAddUsers());
		
		
	}
	
	public void testDeleteSimulateToolBarPermissions_ShouldReturnTrue(){
		//Test if User Can Delete Studies via Tool bar
		assertTrue(adminResolver.isDeleteStudies());
		assertTrue(permissionResolver.isDeleteStudies());
		
		//Test if User Can Delete User via Tool bar
		assertTrue(adminResolver.isDeleteUsers());
		assertTrue(permissionResolver.isDeleteUsers());
	}
	
	public void testAddSimulateToolBarPermission_ShouldReturnFalse(){
		
		//Test if User CANNOT add Roles via Tool bar
		assertFalse(permissionResolver.isAddRoles());
		
		//Test if User CANNOT add Tasks via Tool bar
		assertFalse(permissionResolver.isAddTasks());
		
		//Test if User CANNOT add Settings via Tool bar
		assertFalse(permissionResolver.isAddSettings());
		
		//Test if User CANNOT add Report Groups via Tool bar
		assertFalse(permissionResolver.isAddReportGroups());
	}
	
	public void testDeleteSimulateToolBarPermission_ShouldReturnFalse(){
		
		//Test if User CANNOT delete Roles via Tool bar
		assertFalse(permissionResolver.isDeleteRoles());
		
		//Test if User CANNOT delete Tasks via Tool bar
		assertFalse(permissionResolver.isDeleteTasks());
		
		//Test if User CANNOT delete Settings via Tool bar
		assertFalse(permissionResolver.isDeleteSettings());
		
		//Test if User CANNOT delete Report Groups via Tool bar
		assertFalse(permissionResolver.isDeleteReportGroups());
	}
	
	public void testPermissionLists(){
		
		//Testing the Add Permission List for the current User.
		assertEquals(2, permissionResolver.getAddPermissions().size());
		
		//Testing the Edit Permission List for the current User.
		assertEquals(2, permissionResolver.getEditPermissions().size());
		
		//Testing the View Permission List for the current User.
		assertEquals(2, permissionResolver.getViewPermissions().size());
		
		//Testing the Delete Permission List for the current User.
		assertEquals(2, permissionResolver.getDeletePermissions().size());
		
		//Testing the Extra Permission List for the current User.
		assertEquals(2, permissionResolver.getExtraPermissions().size());
		
	}
	
	public void testPermissionLessUserLists(){
		
		//Although User has no permissions, we test if the Lists
		//are null. Also test if they have no Permissions.
		assertNotNull(lessResolver.getAddPermissions());
		assertEquals(0, lessResolver.getAddPermissions().size());
		
		assertNotNull(lessResolver.getEditPermissions());
		assertEquals(0, lessResolver.getEditPermissions().size());
		
		assertNotNull(lessResolver.getViewPermissions());
		assertEquals(0, lessResolver.getViewPermissions().size());
		
		assertNotNull(lessResolver.getDeletePermissions());
		assertEquals(0, lessResolver.getDeletePermissions().size());
		
		assertNotNull(lessResolver.getExtraPermissions());
		assertEquals(0, lessResolver.getExtraPermissions().size());
	}
	
	public void testAddAddPermission(){
		Permission dummyAddRolePermission = new Permission("Perm_Add_Roles");
		permissionResolver.addPermissionToAddPermissions(dummyAddRolePermission);
		
		assertTrue(permissionResolver.isPermission("Perm_Add_Roles"));
		assertTrue(permissionResolver.hasUserGotPermissions("Perm_Add_Roles"));
		assertEquals(true, permissionResolver.isAddPermission("Perm_Add_Roles"));		
	}
	
	public void testAddEditPermission(){
		Permission dummyEditPermission = new Permission("Perm_Edit_Roles");
		permissionResolver.addPermissionToEditPermissions(dummyEditPermission);
		
		assertTrue(permissionResolver.isPermission("Perm_Edit_Roles"));
		assertTrue(permissionResolver.hasUserGotPermissions("Perm_Edit_Roles"));
		assertEquals(true, permissionResolver.isEditPermission("Perm_Edit_Roles"));
	}
	
	public void testAddViewPermission(){
		Permission dummyViewPermission = new Permission("Perm_View_Roles");
		permissionResolver.addPermissionToViewPermissions(dummyViewPermission);
		
		assertTrue(permissionResolver.isPermission("Perm_View_Roles"));
		assertTrue(permissionResolver.hasUserGotPermissions("Perm_View_Roles"));
		assertEquals(true, permissionResolver.isViewPermission("Perm_View_Roles"));
	}
	
	public void testAddDeletePermission(){
		Permission dummyDeletePermission = new Permission("Perm_Delete_Roles");
		permissionResolver.addPermissionToDeletePermissions(dummyDeletePermission);
		
		assertTrue(permissionResolver.isPermission("Perm_Delete_Roles"));
		assertTrue(permissionResolver.hasUserGotPermissions("Perm_Delete_Roles"));
		assertEquals(true, permissionResolver.isDeletePermission("Perm_Delete_Roles"));
	}
	
	public void testGetLoggedOnUserPermission(){
		
		assertNotNull(permissionResolver.getLoggedOnUserPermissions());
		assertEquals(10, permissionResolver.getLoggedOnUserPermissions().size());
	}
}
