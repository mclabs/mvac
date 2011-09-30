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
package org.openxdata.server.admin.client.controller;

import java.util.List;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.callback.OpenXDataAsyncCallback;
import org.openxdata.server.admin.client.controller.callback.SaveAsyncCallback;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.listeners.SaveCompleteListener;
import org.openxdata.server.admin.client.locale.OpenXdataText;
import org.openxdata.server.admin.client.locale.TextConstants;
import org.openxdata.server.admin.client.util.AsyncCallBackUtil;
import org.openxdata.server.admin.client.util.MainViewControllerUtil;
import org.openxdata.server.admin.client.view.OpenXDataBaseView;
import org.openxdata.server.admin.client.view.treeview.OpenXDataBaseTreeView;
import org.openxdata.server.admin.client.view.treeview.RolesTreeView;
import org.openxdata.server.admin.model.Editable;
import org.openxdata.server.admin.model.Permission;
import org.openxdata.server.admin.model.Role;
import org.purc.purcforms.client.util.FormUtil;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

/**
 * This controller deals with loading and saving of Role and Permission related data
 * to and from the database for the various role and permission related views.
 * 
 * @author Angel
 *
 */
public class RolesViewController extends OpenXDataObservable implements SaveCompleteListener {
	
	private List<Role> roles;
	private RolesTreeView rolesTreeView;
	private List<Permission> permissions;

	/**
	 * Constructs an instance of this <tt>class</tt> given a <tt>View</tt> to update with <tt>Roles.</tt>
	 * 
	 * @param rolesTreeView <tt>Tree View</tt> that is observing this <tt>class.</tt>
	 * @param roleView <tt>RoleView</tt> to receive updates from this <tt>class.</tt>
	 */
	public RolesViewController(OpenXDataBaseTreeView rolesTreeView, OpenXDataBaseView roleView){
		this.rolesTreeView = (RolesTreeView) rolesTreeView;
	}

	/**
	 * Loads roles from the database.
	 * 
	 * @param reload set to false if you want to use the cached roles, if any, without
	 *        having to reload them from the database.
	 */
	public void loadRoles(boolean reload){
		if(roles != null && !reload)
			return;
		
		FormUtil.dlg.setText(OpenXdataText.get(TextConstants.LOADING_ROLES));
		FormUtil.dlg.center();

		DeferredCommand.addCommand(new Command(){
			@Override
			public void execute() {
				try{
					Context.getPermissionService().getRoles(new OpenXDataAsyncCallback<List<Role>>() {
						@Override
						public void onOtherFailure(Throwable caught) {
							FormUtil.dlg.hide();
							AsyncCallBackUtil.handleGenericOpenXDataException(caught);
						}

						@Override
						public void onSuccess(List<Role> result) {
							roles = result;
							
							setChanged();
						    notifyObservers(roles, Role.class);
						    
							FormUtil.dlg.hide();
						}
					});
				}
				catch(Exception ex){
					FormUtil.dlg.hide();
					FormUtil.displayException(ex);
				}	
			}
		});
	}
	
	/**
	 * Saves modified and new roles to the database.
	 */
	public void saveRoles(){
		if(roles == null)
			return;

		if(!rolesTreeView.isValidRolesList())
			return;

		List<Role> deletedRoles = rolesTreeView.getDeletedRoles();
		SaveAsyncCallback callback = new SaveAsyncCallback(MainViewControllerUtil.getDirtyCount(roles) + (deletedRoles != null ? deletedRoles.size() : 0),
				OpenXdataText.get(TextConstants.ROLES_SAVED_SUCCESSFULLY),OpenXdataText.get(TextConstants.PROBLEM_SAVING_ROLES),roles,deletedRoles,this);

		//Save new and modified roles.
		for(Role role : roles) {
			if(!role.isDirty())
				continue;
			else{
				callback.setCurrentItem(role);
				MainViewControllerUtil.setEditableProperties(role);
			}

			Context.getPermissionService().saveRole(role, callback);
		}

		//Save deleted roles.
		if(deletedRoles != null){
			for(Role role : deletedRoles) {
				callback.setCurrentItem(role);
				Context.getPermissionService().deleteRole(role, callback);
			}
			deletedRoles.clear();
		}
	}
	
    @Override
	public void onSaveComplete(List<? extends Editable> modifiedList, List<? extends Editable> deletedList) {
    	MainViewControllerUtil.onSaveComplete(modifiedList, deletedList);
    	loadRoles(true);
		
	}

	/**
	 * Loads the permissions from the database.
	 * 
	 * @param reload set to false if you want to use the cached permission list, if any, without
	 *        having to reload them from the database.
	 */
	public void loadPermissions(boolean reload){
		if(permissions != null && !reload)
			return;

		FormUtil.dlg.setText(OpenXdataText.get(TextConstants.LOADING_PERMISSIONS));
		FormUtil.dlg.center();

		DeferredCommand.addCommand(new Command(){
			@Override
			public void execute() {
				try{
					Context.getPermissionService().getPermissions(new OpenXDataAsyncCallback<List<Permission>>(){

						@Override
						public void onOtherFailure(Throwable caught) {
							FormUtil.dlg.hide();
							AsyncCallBackUtil.handleGenericOpenXDataException(caught);
						}

						@Override
						public void onSuccess(List<Permission> result) {
							permissions = result;
							
							setChanged();
						    notifyObservers(permissions, Permission.class);
							FormUtil.dlg.hide();
						}
					});
				}
				catch(Exception ex){
					FormUtil.displayException(ex);
					FormUtil.dlg.hide();
				}
			}
		});
	}
}
