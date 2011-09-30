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
package org.openxdata.server.admin.client.permissions.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.gwt.test.OpenXDataGwtTestBase;
import org.openxdata.server.admin.model.Permission;
import org.openxdata.server.admin.model.Role;
import org.openxdata.server.admin.model.User;

/**
 * Tests the {@link RolesListUtil} class.
 * <p>
 * This <tt>Test Class</tt> is NO substitute for <tt>Selenium tests.</tt> It should be adequately beefed with UI tests using selenium.
 * </p>
 * 
 * @author Angel
 *
 */
public class RolesListUtilGwtTest extends OpenXDataGwtTestBase {
	
	//Dummy User with no Roles.
	private User userWithoutRoles;
	
	//Dummy User with Admin Role
	private User userWithAdminRole;
	
	//Dummy User with normal Roles.
	private User userWithNormalRoles;
	
	//Dummy Role to work with
	private Role xRole;
	
	//Dummy Permission list to mimic all Permissions in the system.
	private List<Permission> permissions;
	
	@Override
	public void gwtSetUp(){		
		
		//Create dummy admin User to work with.
		userWithAdminRole = new User("Dummy");
		userWithAdminRole.addRole(new Role("Role_Administrator"));
		
		//Create dummy with normal Roles
		userWithNormalRoles = new User("Normal-User");		
		addRolesToUser();
		
		//Create a dummy User without Roles
		userWithoutRoles = new User("Dummy-No-Roles");
		
		permissions = initPermissions();
		
	}

	/**
	 * Initializes <tt>Permissions.</tt>
	 * @return List of Permissions
	 */
	private List<Permission> initPermissions() {
		
		permissions = new ArrayList<Permission>();
		
		permissions.add(new Permission("Perm_Add_Users"));
		permissions.add(new Permission("Perm_Edit_Users"));
		permissions.add(new Permission("Perm_View_Users"));
		permissions.add(new Permission("Perm_Add_Reports"));
		permissions.add(new Permission("Perm_Add_Studies"));
		permissions.add(new Permission("Perm_Edit_Studies"));
		permissions.add(new Permission("Perm_Edit_Reports"));
		permissions.add(new Permission("Perm_View_Reports"));
		permissions.add(new Permission("Perm_View_Studies"));
		permissions.add(new Permission("Perm_Delete_Users"));
		permissions.add(new Permission("Perm_Delete_Reports"));
		permissions.add(new Permission("Perm_Delete_Studies"));
		permissions.add(new Permission("Perm_Map_Studies_To_Users"));
		permissions.add(new Permission("Perm_Map_Roles_To_Users"));
		
		//These permissions are mandatory
		permissions.add(new Permission("Perm_View_Forms"));
		permissions.add(new Permission("Perm_View_Forms"));
		permissions.add(new Permission("Perm_Form_Design"));
		permissions.add(new Permission("Perm_View_Studies"));
		permissions.add(new Permission("Perm_View_Form_Data"));				
		permissions.add(new Permission("Perm_View_Mapped_Forms"));
		permissions.add(new Permission("Perm_View_Report_Groups"));
		permissions.add(new Permission("Perm_View_Mapped_Reports"));
		permissions.add(new Permission("Perm_View_Mapped_Studies"));
		permissions.add(new Permission("Perm_View_Mapped_Report_Groups"));
		
		Context.setPermissions(permissions);
		
		return permissions;
	}
	

	/**
	 * Adds some dummy Roles to the <tt>User.</tt>
	 */
	private void addRolesToUser() {
		//Studies Role
		Role sRole = createManageStudiesRole();
		
		//User Role
		Role uRole = createManageUsersRole();
				
		//Reports Role
		Role xRole = createManageReports();
		
		userWithNormalRoles.addRole(sRole);
		userWithNormalRoles.addRole(uRole);
		userWithNormalRoles.addRole(xRole);
	}

	/**
	 * Creates a dummy <tt>Role</tt> to mimic Report Management.
	 * @return <tt>Role with Report Permissions.</tt>
	 */
	private Role createManageReports() {
		xRole = new Role("Role_Manage_Reports");
		
		//Studies Role Permission
		xRole.addPermission(new Permission("Perm_Add_Reports"));
		xRole.addPermission(new Permission("Perm_Edit_Reports"));
		xRole.addPermission(new Permission("Perm_View_Reports"));
		xRole.addPermission(new Permission("Perm_Delete_Reports"));
		xRole.addPermission(new Permission("Perm_Map_Reports_To_Users"));
		
		return xRole;
	}

	/**
	 * Creates a dummy <tt>Role</tt> to mimic User Management.
	 * @return <tt>Role with User Permissions.</tt>
	 */
	private Role createManageUsersRole() {
		Role uRole = new Role("Role_Manage_Users");
		
		//User Role Permissions
		uRole.addPermission(new Permission("Perm_Add_Users"));
		uRole.addPermission(new Permission("Perm_Edit_Users"));
		uRole.addPermission(new Permission("Perm_View_Users"));
		uRole.addPermission(new Permission("Perm_Delete_Users"));
		uRole.addPermission(new Permission("Perm_Map_Roles_To_Users"));
		
		return uRole;
	}

	/**
	 * Creates a dummy <tt>Role</tt> to mimic Studies Management.
	 * @return <tt>Role with Studies Permissions.</tt>
	 */
	private Role createManageStudiesRole() {
		Role sRole = new Role("Role_Manage_Studies");
		
		//Studies Role Permission
		sRole.addPermission(new Permission("Perm_Add_Studies"));
		sRole.addPermission(new Permission("Perm_Edit_Studies"));
		sRole.addPermission(new Permission("Perm_View_Studies"));
		sRole.addPermission(new Permission("Perm_Delete_Studies"));
		sRole.addPermission(new Permission("Perm_Map_Studies_To_Users"));
		
		return sRole;
	}
	
	public void testIsAdmin(){
		
		initAdminUserProperties();
		assertTrue(RolesListUtil.getInstance().isAdmin());
	}
	
	public void testAdminPermissions(){
		
		initAdminUserProperties();
		
		assertNotNull(RolesListUtil.getInstance().getUserPermissions());
		assertEquals(0, RolesListUtil.getInstance().getUserPermissions().size());
	}
	
	public void testHasUserGotRolesForAdminUser(){
		
		initAdminUserProperties();
		
		assertTrue(RolesListUtil.getInstance().hasUserGotRoles());
		assertEquals(1, RolesListUtil.getInstance().getUserRoles().size());
		assertTrue(RolesListUtil.getInstance().hasUserGotAdminPrivileges());
		
		assertEquals(userWithAdminRole.getRoles().size(), RolesListUtil.getInstance().getUserRoles().size());
	}
	
	public void testClearRoles(){
		
		initAdminUserProperties();
		
		//Clear User Roles
		RolesListUtil.getInstance().clearRoles();
		
		assertNotNull(RolesListUtil.getInstance().getUserRoles());
		assertNotNull(RolesListUtil.getInstance().getUserPermissions());
		
		assertEquals(0, RolesListUtil.getInstance().getUserRoles().size());
		assertEquals(0, RolesListUtil.getInstance().getUserPermissions().size());
	}
	
	public void testIsAdminForNormalUser(){
		
		initNormalUserProperties();
		assertFalse(RolesListUtil.getInstance().isAdmin());
	}
	
	public void testPermissionsForNormalUser(){
		
		initNormalUserProperties();
		
		assertNotNull(RolesListUtil.getInstance().getUserPermissions());
		assertEquals(15, RolesListUtil.getInstance().getUserPermissions().size());
	}
	
	public void testHasUserGotRolesForNormalUser(){
		
		initNormalUserProperties();
		
		assertTrue(RolesListUtil.getInstance().hasUserGotRoles());
		assertEquals(3, RolesListUtil.getInstance().getUserRoles().size());
		assertFalse(RolesListUtil.getInstance().hasUserGotAdminPrivileges());
		
		assertEquals(userWithNormalRoles.getRoles().size(), RolesListUtil.getInstance().getUserRoles().size());
	}
	
	public void testIsAdminForUserWithoutRoles(){
		
		initPropertiesForUserWithoutRoles();
		assertFalse(RolesListUtil.getInstance().isAdmin());
	}
	
	public void testPermissionsForUserWithoutRoles(){
		
		initPropertiesForUserWithoutRoles();
		
		assertNotNull(RolesListUtil.getInstance().getUserPermissions());
		assertEquals(0, RolesListUtil.getInstance().getUserPermissions().size());
	}
	
	public void testHasUserGotRolesForForUserWithoutRoles(){
		
		initPropertiesForUserWithoutRoles();
		
		assertFalse(RolesListUtil.getInstance().hasUserGotRoles());
		assertEquals(0, RolesListUtil.getInstance().getUserRoles().size());
		assertFalse(RolesListUtil.getInstance().hasUserGotAdminPrivileges());
		
		assertEquals(userWithoutRoles.getRoles().size(), RolesListUtil.getInstance().getUserRoles().size());
	}
	
	public void testCheckAndBindAncillaryPermissions(){
		
		Permission perm = new Permission("Perm_Add_Forms");
		
		List<Permission> returnedPermissions = RolesListUtil.checkAndBindAncillaryPermissions(perm, permissions, xRole.getPermissions());
		
		
		assertNotNull(returnedPermissions);
		assertEquals(5, returnedPermissions.size());
		
		String[] returnedPermissionNames = getPermissionNames(returnedPermissions, false);
		
		//Check if ancillary Permissions were added successfully
		assertTrue(returnedPermissionNames[0].equals("Perm_Form_Design"));
		assertTrue(returnedPermissionNames[1].equals("Perm_Add_Forms"));
		assertTrue(returnedPermissionNames[2].equals("Perm_View_Forms"));
		assertTrue(returnedPermissionNames[3].equals("Perm_View_Studies"));
		assertTrue(returnedPermissionNames[4].equals("Perm_View_Form_Data"));
		
	}
	
	public void testCheckAndBindAncillaryPermissionsX(){
		
		Permission perm = new Permission("Perm_Create_Forms");
		
		List<Permission> returnedPermissions = RolesListUtil.checkAndBindAncillaryPermissions(perm, permissions, xRole.getPermissions());
		
		
		assertNotNull(returnedPermissions);
		assertEquals(1, returnedPermissions.size());
		
		String[] returnedPermissionNames = getPermissionNames(returnedPermissions, false);
		
		//Check if ancillary Permissions were added successfully
		assertTrue(returnedPermissionNames[0].equals("Perm_Create_Forms"));
		
		assertFalse(returnedPermissionNames[1].equals("Perm_Add_Forms"));
		assertFalse(returnedPermissionNames[2].equals("Perm_View_Forms"));
		assertFalse(returnedPermissionNames[3].equals("Perm_View_Studies"));
		assertFalse(returnedPermissionNames[4].equals("Perm_View_Form_Data"));
		
	}

	public void testAddViewStudiesRoleOnStudyMap(){
		
		User user = createUser();
		RolesListUtil.addViewStudiesRoleOnStudyMap(user);
		
		assertTrue(user.getRoles().size() > 0);
		assertEquals(2, user.getRoles().size());
		
		//Check if Roles we added successfully
		String [] roleNames = getRoleNames(user.getRoles());
		
		assertEquals(2, roleNames.length);
		assertTrue(roleNames[0].equals("Role_Foo"));
		assertTrue(roleNames[1].equals("Role_View_Studies_"));
		
		//Check if Permissions we added successfully
		String[] permissionNames = getPermissionNames(getPermissions(user), true);
		
		assertEquals(2, permissionNames.length);
		assertTrue(permissionNames[0].equals("Perm_View_Studies"));
		assertTrue(permissionNames[1].equals("Perm_View_Mapped_Studies"));
	}
	
	public void testAddViewReportGroupsRoleonReportGroupMap(){
		
		User user = createUser();
		RolesListUtil.addViewReportGroupsRoleOnReportGroupMap(user);
		
		assertTrue(user.getRoles().size() > 0);
		assertEquals(2, user.getRoles().size());
		
		//Check if Roles we added successfully
		String [] roleNames = getRoleNames(user.getRoles());
		
		assertEquals(2, roleNames.length);
		assertTrue(roleNames[0].equals("Role_Foo"));
		assertTrue(roleNames[1].equals("Role_View_ReportGroups_"));
		
		//Check if Permissions we added successfully
		String[] permissionNames = getPermissionNames(getPermissions(user), true);
		
		assertEquals(2, permissionNames.length);
		assertTrue(permissionNames[0].equals("Perm_View_Report_Groups"));
		assertTrue(permissionNames[1].equals("Perm_View_Mapped_Report_Groups"));
	}
	
	public void testAddViewFormsRoleOnFormMap(){
		
		User user = createUser();
		RolesListUtil.addViewFormsRoleOnFormMap(user);
		
		assertTrue(user.getRoles().size() > 0);
		assertEquals(2, user.getRoles().size());
		
		//Check if Roles we added successfully
		String [] roleNames = getRoleNames(user.getRoles());
		
		assertEquals(2, roleNames.length);
		assertTrue(roleNames[0].equals("Role_Foo"));
		assertTrue(roleNames[1].equals("Role_View_Forms_"));
		
		//Check if Permissions we added successfully
		String[] permissionNames = getPermissionNames(getPermissions(user), true);
		
		assertEquals(3, permissionNames.length);
		assertTrue(permissionNames[0].equals("Perm_View_Forms"));
		assertTrue(permissionNames[1].equals("Perm_View_Studies"));
		assertTrue(permissionNames[2].equals("Perm_View_Mapped_Forms"));
	}
	
	public void testAddViewReportsRoleOnReportMap(){
		
		User user = createUser();
		RolesListUtil.addViewReportsRoleOnReportMap(user);
		
		assertTrue(user.getRoles().size() > 0);
		assertEquals(2, user.getRoles().size());
		
		//Check if Roles we added successfully
		String [] roleNames = getRoleNames(user.getRoles());
		
		assertEquals(2, roleNames.length);
		assertTrue(roleNames[0].equals("Role_Foo"));
		assertTrue(roleNames[1].equals("Role_View_Reports_"));
		
		//Check if Permissions we added successfully
		String[] permissionNames = getPermissionNames(getPermissions(user), true);
		
		assertEquals(3, permissionNames.length);
		assertTrue(permissionNames[0].equals("Perm_View_Reports"));
		assertTrue(permissionNames[1].equals("Perm_View_Report_Groups"));
		assertTrue(permissionNames[2].equals("Perm_View_Mapped_Reports"));
		
	}
	
	public void testRemoveViewFormsRoleAddedOnMap(){
		
		User xUser = createUser();
		xUser.getRoles().add(new Role("Role_View_Forms_"));
		
		assertEquals(2, xUser.getRoles().size());
		RolesListUtil.removeViewFormsRoleAddedOnMap(xUser);
		
		assertEquals(1, xUser.getRoles().size());
		
		String[] roleName = getRoleNames(xUser.getRoles());
		
		assertEquals(1, roleName.length);
		assertTrue(roleName[0].equals("Role_Foo"));
		assertFalse(roleName[0].equals("Role_View_Forms_"));
	}
	
	public void testRemoveViewReportsRoleAddedOnMap(){
		
		User xUser = createUser();
		xUser.getRoles().add(new Role("Role_View_Reports_"));
		
		assertEquals(2, xUser.getRoles().size());
		RolesListUtil.removeViewReportsRoleAddedOnMap(xUser);
		
		assertEquals(1, xUser.getRoles().size());
		
		String[] roleName = getRoleNames(xUser.getRoles());
		
		assertEquals(1, roleName.length);
		assertTrue(roleName[0].equals("Role_Foo"));
		assertFalse(roleName[0].equals("Role_View_Reports_"));
	}
	
	public void testRemoveViewStudiesRoleAddedOnMap(){
		
		User xUser = createUser();
		xUser.getRoles().add(new Role("Role_View_Studies_"));
		
		assertEquals(2, xUser.getRoles().size());
		RolesListUtil.removeViewStudiesRoleAddedOnMap(xUser);
		
		assertEquals(1, xUser.getRoles().size());
		
		String[] roleName = getRoleNames(xUser.getRoles());
		
		assertEquals(1, roleName.length);
		assertTrue(roleName[0].equals("Role_Foo"));
		assertFalse(roleName[0].equals("Role_View_Studies_"));
	}
	
	public void testRemoveViewReportGroupsRoleOnReportGroupMap(){
		
		User xUser = createUser();
		xUser.getRoles().add(new Role("Role_View_ReportGroups_"));
		
		assertEquals(2, xUser.getRoles().size());
		RolesListUtil.removeViewReportGroupsRoleOnReportGroupMap(xUser);
		
		assertEquals(1, xUser.getRoles().size());
		
		String[] roleName = getRoleNames(xUser.getRoles());
		
		assertEquals(1, roleName.length);
		assertTrue(roleName[0].equals("Role_Foo"));
		assertFalse(roleName[0].equals("Perm_View_ReportGroups"));
		
	}

	/**
	 * Retrieves <tt>Role</tt> names.
	 * 
	 * @param roles <tt>Roles</tt> to retrieve names for.
	 * @return <tt>Collection</tt> of names.
	 */
	private String[] getRoleNames(Set<Role> roles) {
		
		int index = 0;
		String[] arrNames = new String[roles.size()];		
		for(Role x : roles){
			for(; index < arrNames.length;){
				if(x.getName().equals("Role_Foo")){
					arrNames[0] = index < roles.size() ? x.getName() : "" ;
					index++;
					break;
				}
				else
					if(x.getName().startsWith("Role_View_")){
						arrNames[1] = index < roles.size() ? x.getName() : "" ;
						index++;
						break;
				}
				else{
					arrNames[index] = index < roles.size() ? x.getName() : "" ;
					index++;
					break;
				}
			}
		}
		return arrNames;
	}

	/**
	 * Creates a <tt>User.</tt>
	 * @return Created <tt>User.</tt>
	 */
	private User createUser() {
		User user = new User("Foo");
		Role role = new Role("Role_Foo");
		role.setPermissions(new ArrayList<Permission>());
		
		user.addRole(role);
		return user;
	}
	
	/**
	 * Retrieves a given <tt>User's permissions</tt> and binds them to a list.
	 * @param user <tt>User</tt> to retrieve <tt>Permissions</tt> for.
	 * @return List of <tt>User Permissions.</tt>
	 */
	private List<Permission> getPermissions(User user) {
		List<Permission> permissions = new Vector<Permission>();
		for(Role x : user.getRoles()){
			for(Permission xPerm : x.getPermissions()){
				permissions.add(xPerm);
			}
		}
		return permissions;
	}

	/**
	 * Retrieves <tt>Permission</tt> names from given list of <tt>Permissions.</tt>
	 * @param permissions List of <tt>Permissions</tt> to retrieve names for.
	 * @return Array of names <tt>instanceof String. </tt>
	 */
	private String[] getPermissionNames(List<Permission> permissions, boolean useListLength) {	

		String[] arrNames = null;
		if(useListLength){
			
			int index = 0;
			arrNames = new String[permissions.size()];			
			for(Permission x : permissions){
				for(;index < permissions.size();){
					arrNames[index] = index < permissions.size() ? x.getName() : "" ;
					++index;
					break;
				}
			}
		}			
		else{
			arrNames = new String[5];
			for(int index = 0; index < arrNames.length; index++){
				arrNames[index] = index < permissions.size() ? permissions.get(index).getName() : "" ;
			}
		}
		return arrNames;
	}
	
	/**
	 * Initializes the Administrator's properties in the <tt>RolesListUtil.</tt>
	 */
	private void initAdminUserProperties() {
		
		//Clear Roles.
		RolesListUtil.getInstance().clearRoles();
		
		//Re Initialize lists.
		RolesListUtil.getInstance().setUserRoles(userWithAdminRole.getRoles());
	}
	
	/**
	 * Initializes the Normal User's properties in the <tt>RolesListUtil.</tt>
	 */
	private void initNormalUserProperties() {
		
		//Clear List.
		RolesListUtil.getInstance().clearRoles();
		RolesListUtil.getInstance().clearPermissions();
		
		//Re initialize lists.
		RolesListUtil.getInstance().setUserRoles(userWithNormalRoles.getRoles());
		
	}
	
	/**
	 * Initializes properties for <tt>User</tt> without <tt>Roles</tt> in the <tt>RolesListUtil.</tt>
	 */
	private void initPropertiesForUserWithoutRoles() {
		
		//Clear List.
		RolesListUtil.getInstance().clearRoles();
		RolesListUtil.getInstance().clearPermissions();
		
		//Re initialize lists.
		userWithoutRoles.setRoles(new HashSet<Role>());//No NPEs!!!
		RolesListUtil.getInstance().setUserRoles(userWithoutRoles.getRoles());
		
	}
	
	
}
