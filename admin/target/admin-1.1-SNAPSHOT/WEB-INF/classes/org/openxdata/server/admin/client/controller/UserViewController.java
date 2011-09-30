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
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.treeview.UsersTreeView;
import org.openxdata.server.admin.model.Editable;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.purc.purcforms.client.util.FormUtil;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

/**
 * This controller deals with loading and saving of user related data
 * to and from the database for the various user related views.
 * 
 * @author Angel
 *
 */
public class UserViewController extends OpenXDataObservable implements SaveCompleteListener {

	private List<User> users;
	private UsersTreeView usersTreeView;
	
	/**
	 * Constructs an instance of this <tt>class</tt> given a <tt>View</tt> to update with <tt>Users.</tt>
	 * @param usersTreeView <tt>View</tt> that is observing this <tt>Class.</tt>
	 */
	public UserViewController(UsersTreeView usersTreeView) {
		this.usersTreeView = usersTreeView;
	}

	/**
	 * Loads users from the database. 
	 * 
	 * @param reload set to false if you want to use the cached users, if any, without
	 *        having to reload them from the database.
	 */
	public void loadUsers(boolean reload){
		if(users != null && !reload)
			return;
		
		FormUtil.dlg.setText(OpenXdataText.get(TextConstants.LOADING_USERS));
		FormUtil.dlg.center();

		DeferredCommand.addCommand(new Command(){
			@Override
			public void execute() {
				try{
					Context.getUserService().getUsers(new OpenXDataAsyncCallback<List<User>>() {
						@Override
						public void onOtherFailure(Throwable caught) {
							FormUtil.dlg.hide();
							AsyncCallBackUtil.handleGenericOpenXDataException(caught);
						}

						@Override
						public void onSuccess(List<User> result) {
							users = result;
							setChanged();
						    notifyObservers(users, User.class);
						    
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
	 * Saves modified and new users to the database.
	 * 
	 * @throws OpenXDataException If the <code>User</code> password length is less than
	 * the system specified password length.
	 */
	public void saveUsers() {
		if(users == null)
			return;

		if(!usersTreeView.isValidUsersList())
			return;

		List<User> deletedUsers = usersTreeView.getDeletedUsers();
		
		SaveAsyncCallback callback = new SaveAsyncCallback(MainViewControllerUtil.getDirtyCount(users) + (deletedUsers != null ? deletedUsers.size() : 0),
				OpenXdataText.get(TextConstants.USERS_SAVED_SUCCESSFULLY),OpenXdataText.get(TextConstants.PROBLEM_SAVING_USERS),users,deletedUsers,this);


		saveUser(callback);

		//Save deleted users.
		if(deletedUsers != null){
			for(User user: deletedUsers) {
				callback.setCurrentItem(user);
				Context.getUserService().deleteUser(user, callback);
			}
			deletedUsers.clear();
		}
	}

	/**
	 * Saves the individuals Users in the list.
	 * 
	 * @param callback
	 */
	private void saveUser(SaveAsyncCallback callback) {
		
		//Save new and modified users.
		for(User user : users) {
			if(!user.isDirty())
				continue;
			else{
				callback.setCurrentItem(user);
				MainViewControllerUtil.setEditableProperties(user);
			}

			if(Utilities.validateUserPassword(user)){
				Context.getUserService().saveUser(user, callback);
			}
			else{
				Utilities.displayMessage(
				 "The User password specified is less than the default length that is specified in the system. " +
				 "The Password should be equal or more than " + Context.getSetting("defaultUserPasswordLength", "6")
				 + " characters. The User will not be saved!");
			}
		}
	}

    @Override
	public void onSaveComplete(List<? extends Editable> modifiedList, List<? extends Editable> deletedList) {
    	MainViewControllerUtil.onSaveComplete(modifiedList, deletedList);
    	loadUsers(true);
	}
}
