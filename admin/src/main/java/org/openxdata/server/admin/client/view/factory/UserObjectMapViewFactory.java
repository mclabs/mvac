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

import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.view.mapping.OpenXDataBaseObjectMapView;
import org.openxdata.server.admin.client.view.mapping.RolePermissionMapView;
import org.openxdata.server.admin.client.view.mapping.UserFormMapView;
import org.openxdata.server.admin.client.view.mapping.UserReportGroupMapView;
import org.openxdata.server.admin.client.view.mapping.UserReportMapView;
import org.openxdata.server.admin.client.view.mapping.UserRoleMapView;
import org.openxdata.server.admin.client.view.mapping.UserStudyMapView;


/**
 * Constructs <tt>Mapping views</tt> that can be bound to the <tt>Main View</tt> or other views.
 * <p>
 * This class should not be called directory but rather the <tt>OpenXDataViewFactory</tt> should delegate specific creation responsibilities to it.
 * </p>
 * @author Angel
 *
 */
public class UserObjectMapViewFactory {

	/** Widget for handling <tt>User Role Mapping.</tt>*/
	private static OpenXDataBaseObjectMapView userRoleMapView;
	
	/** Widget for handling <tt>User Form Mapping.</tt>*/
	private static OpenXDataBaseObjectMapView userFormMapView;	
	
	/** Widget for handling <tt>User Study Mapping.</tt>*/
	private static OpenXDataBaseObjectMapView userStudyMapView;
	
	/** Widget for handling <tt>User Report Mapping.</tt>*/
	private static OpenXDataBaseObjectMapView userReportMapView;
	
	/** WIdget for handling <tt>Role Permission Mapping.</tt>*/
	private static OpenXDataBaseObjectMapView rolePermissionMapView;
	
	/** Widget for handling <tt>User Report Group Mapping.</tt>*/
	private static OpenXDataBaseObjectMapView userReportGroupMapView;
	
	/**
	 * Creates or Returns an instance of <tt>RolePermissionMapView</tt>
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for the <tt>OpenXDataBaseObjectMapView.</tt>
	 * 
	 * @return <tt>RolePermissionMapView</tt>
	 */
	public static OpenXDataBaseObjectMapView createOrGetRolePermissionMapView(ItemChangeListener itemChangeListener) {
		if(rolePermissionMapView == null)
			rolePermissionMapView = new RolePermissionMapView(itemChangeListener);
		
		return rolePermissionMapView;
	}

	/**
	 * Creates or Returns an instance of <tt>UserFormMapView</tt>
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for the <tt>OpenXDataBaseObjectMapView.</tt>
	 * 
	 * @return <tt>UserFormMapView</tt>
	 */
	public static OpenXDataBaseObjectMapView createOrGetUserFormMapView(ItemChangeListener itemChangeListener) {
		if(userFormMapView == null)
			userFormMapView = new UserFormMapView(itemChangeListener);
		
		return userFormMapView;
	}

	/**
	 * Creates or Returns an instance of <tt>UserReportGroupMapView</tt>
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for the <tt>OpenXDataBaseObjectMapView.</tt>
	 * 
	 * @return <tt>UserReportGroupMapView</tt>
	 */
	public static OpenXDataBaseObjectMapView createOrGetUserReportGroupMapView(ItemChangeListener itemChangeListener) {
		if(userReportGroupMapView == null)
			userReportGroupMapView = new UserReportGroupMapView(itemChangeListener);
		
		return userReportGroupMapView;
	}

	/**
	 * Creates or Returns an instance of <tt>UserRoleMapView</tt>
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for the <tt>OpenXDataBaseObjectMapView.</tt>
	 * 
	 * @return <tt>UserRoleMapView</tt>
	 */
	public static OpenXDataBaseObjectMapView createOrGetUserRoleMapView(ItemChangeListener itemChangeListener) {
		if(userRoleMapView == null)
			userRoleMapView = new UserRoleMapView(itemChangeListener);
		
		return userRoleMapView;
	}

	/**
	 * Creates or Returns an instance of <tt>UserStudyMapView</tt>
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for the <tt>OpenXDataBaseObjectMapView.</tt>
	 * 
	 * @return <tt>UserStudyMapView</tt>
	 */
	public static OpenXDataBaseObjectMapView createOrGetUserStudyMapView(ItemChangeListener itemChangeListener) {
		if(userStudyMapView == null)
			userStudyMapView = new UserStudyMapView(itemChangeListener);
		
		return userStudyMapView;
	}

	/**
	 * Creates or Returns an instance of <tt>UserReportMapView</tt>
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for the <tt>OpenXDataBaseObjectMapView.</tt>
	 * 
	 * @return <tt>UserReportMapView</tt>
	 */
	public static OpenXDataBaseObjectMapView createOrGetUserReportMapView(ItemChangeListener itemChangeListener) {
		if(userReportMapView == null)
			userReportMapView = new UserReportMapView(itemChangeListener);
		
		return userReportMapView;
	}
}
