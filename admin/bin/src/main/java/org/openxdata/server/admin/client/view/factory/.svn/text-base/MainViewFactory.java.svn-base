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
package org.openxdata.server.admin.client.view.factory;

import java.util.HashSet;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.listeners.LogoutListener;
import org.openxdata.server.admin.client.permissions.PermissionResolver;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.view.MainView;
import org.openxdata.server.admin.model.Permission;

/**
 * 
 * This <code>class</code> constructs a <code>Main View</code>
 * according to a given <code>User's</code> <code>Roles</code> and <code>Permissions.</code>
 *  
 * <p>
 * This class should not be called directory but rather the <tt>OpenXDataViewFactory</tt> should delegate specific creation responsibilities to it.
 * </p>
 * 
 * @author Angel
 */
public class MainViewFactory {

	/** Constructs a <tt>MainView</tt> for the application.*/
	public static MainView createMainView(LogoutListener logoutListener){
		
		//Setting the user roles in a globally accessible utility
		RolesListUtil.getInstance().setUserRoles(Context.getAuthenticatedUser().getRoles());
		
		//Ascertaining view to load according to roles
		if(RolesListUtil.getInstance().hasUserGotRoles()){
			
			if(RolesListUtil.getInstance().isAdmin()){
				
				// Construct a Permission Resolving object for this session for Administrative User
				RolesListUtil.setPermissionResolver(new PermissionResolver(true, new HashSet<Permission>()));
				
				// Main view for Administrative User
				return new MainView(logoutListener);
			}				
			else{
				
				// Construct a Permission Resolving object for this session according to User Roles.
				RolesListUtil.setPermissionResolver(new PermissionResolver(false, RolesListUtil.getInstance().getUserPermissions()));
				
				// Main view for User with Roles
				return new MainView(logoutListener);
			}
		}
		else{
			
			// Construct a Permission Resolving object for this session according to User Roles.
			RolesListUtil.setPermissionResolver(new PermissionResolver(false, RolesListUtil.getInstance().getUserPermissions()));
			
			// Main view for User without Roles
			return new MainView(logoutListener);
		}	
	}
}
