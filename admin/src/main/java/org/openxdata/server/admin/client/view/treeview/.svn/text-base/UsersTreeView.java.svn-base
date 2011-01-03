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
package org.openxdata.server.admin.client.view.treeview;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.controller.observe.UsersObserver;
import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.constants.OpenXDataStackPanelConstants;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.view.listeners.OpenXDataExportImportApplicationEventListener;
import org.openxdata.server.admin.client.view.widget.CompositeTreeItem;
import org.openxdata.server.admin.client.view.widget.TreeItemWidget;
import org.openxdata.server.admin.model.User;
import org.purc.purcforms.client.controller.OpenFileDialogEventListener;
import org.purc.purcforms.client.util.FormUtil;
import org.purc.purcforms.client.view.OpenFileDialog;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * Custom <code>widget</code> that binds the <code>list</code> of 
 * <code>system users</code> to the <code>tree view</code> and renders them for display.
 * 
 * Listens for actions on the <code>widgets</code>.
 * Forwards some of the actions on the roles to the relevant listeners
 * 
 * @author daniel
 * @author Angel
 */
public class UsersTreeView extends OpenXDataBaseTreeView implements UsersObserver, OpenFileDialogEventListener, OpenXDataExportImportApplicationEventListener {
	
	/** List of users. */
	private List<User> users;
	
	/** List of deleted users. */
	private List<User> deletedUsers;
	
	/**
	 * Constructor that initializes the widget
	 * @param openXDataViewFactory 
	 * 
	 * @param images - images to be bound to the tree view
	 * @param permissionResolver  - permissionLisUtil to manage user permissions
	 */
	public UsersTreeView(OpenXDataViewFactory openXDataViewFactory){
		super("Users",openXDataViewFactory);
	}

	
	@Override
	protected void setUp(){
		
		//Register this class with Event Dispatchers.
		super.registerWithEventDispatchers();
		
		openxdataStackPanel = widgetFactory.getOpenXdataStackPanel();
		
		// Initialize the Tree View
		tree = new Tree(widgetFactory.getOpenXDataImages());
		tree.ensureSelectedItemVisible();

		//Setting Scroll Panel properties.
		scrollPanel.setWidget(tree);
		scrollPanel.setWidth("100%");
		scrollPanel.setHeight("100");
		
		// Make this class the Listener
		tree.addSelectionHandler(this);

		// Initialize the ScrollPanel to be the main widget for the Tree View
		initWidget(scrollPanel);
		
		// Initialize the Context Menu.
		popup = initContextMenu();
		
		// Maximize this widget
		Utilities.maximizeWidget(this);
	}
	
	/**
	 * Adds more studiesTreeView specific items
	 */
	protected PopupPanel initContextMenu() {
		PopupPanel popup = super.initContextMenu(this);
		if(popup != null){
			MenuBar menuBar = (MenuBar)popup.getWidget();
			if(menuBar != null){
				addExtraContextMenuControls(menuBar);
			}
		}
		
		return popup;
	}

	/**
	 * @param menuBar
	 */
	private void addExtraContextMenuControls(MenuBar menuBar) {
		if(RolesListUtil.getPermissionResolver().isExtraPermission("Export Item")){
			menuBar.addSeparator();
			menuBar.addItem(Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().add(), "Export Item"),true, new Command(){
				@Override
				public void execute(){popup.hide();onExport();}
			});
		}
		
		if(RolesListUtil.getPermissionResolver().isExtraPermission("Import Item")){
			menuBar.addSeparator();
			menuBar.addItem(Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().add(), "Import Item"), true, new Command(){
				@Override
				public void execute(){popup.hide(); onImport();}
			});
		}
		
	}
	
	/**
	 * Member to initialize the users that will be bound to the tree view
	 * @param users - List of users that are in the system
	 */
	public void bindUsersToTreeView(List<User> users){
		this.users = users;
		deletedUsers = new Vector<User>();

		if (isLoadData()){
			tree.clear();

			User user;
			TreeItem root; 
			for(int i=0; i<users.size(); i++){
				user = (User) users.get(i);
				
				if(user.getUserId() == Context.getAuthenticatedUser().getUserId()){
					user = Context.getAuthenticatedUser();
					users.set(i, user);
				}
					
				root = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), user.getName(),popup));
				root.setTitle(user.getFullName());
				root.setUserObject(user);
				tree.addItem(root);
			}
			
			Utilities.selectFirstItemOnTreeView(tree);
		}
	}

	/**
	 * Member fired to create a new user on the tree view
	 */
	@Override
	public void addNewItem(){
		User user = new User(OpenXDataFacade.getOpenXDataConstants().label_new_user());
		user.setCreator(Context.getAuthenticatedUser());
		
		user.setDateCreated(new Date());
		TreeItem root = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), user.getName(),popup));
		root.setUserObject(user);
		tree.addItem(root);
		
		user.setDirty(true);		
		users.add(user);	
		
		tree.setSelectedItem(root);
	}

	/**
	 * Deletes the selected user on the tree view
	 */
	@Override
	public void deleteSelectedItem(){
		Utilities.displayMessage("You cannot delete Users because the System uses them for other system functions like logging. " +
				"Disabling a User is the recommended practice.");
	}

	
	@Override
	public void changeEditableProperties(Object item) {
		TreeItem treeItem = tree.getSelectedItem();
		
		if(item == null)
			return; //How can this happen?

		User user = (User)item;
		{
			
			treeItem = tree.getSelectedItem();
			treeItem.setWidget(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), user.getName(),popup));
			treeItem.setTitle(user.getFullName());
			user.setDirty(true);

		}
	}

	/**
	 * Member to get the deleted users on the tree view
	 * @return - list of deleted roles
	 */
	public List<User> getDeletedUsers(){
		return deletedUsers;
	}
		
	/**
	 * Checks if the users list is valid for saving to the database.
	 * 
	 * @return true if valid, else false.
	 */
	public boolean isValidUsersList(){
		try{

			Map <String,String> map = new HashMap<String,String>();
			int index = tree.getItemCount();
			
			for(int j=0;j<index;j++)
			{
				if(map.containsKey(tree.getItem(j).getText().toLowerCase())){
					
					tree.setSelectedItem(tree.getItem(j));
					Window.alert(OpenXDataFacade.getOpenXDataConstants().label_existinguser() + tree.getItem(j).getText());
				    return false;
				}
				else
					map.put(tree.getItem(j).getText().toLowerCase(),tree.getItem(j).getText());
			}
			return true;
		}
		catch(Exception ex){
			FormUtil.displayException(ex);
			return false;
		}
	}

    @Override
	UIViewLabels getContextMenuLabels() {
        UIViewLabels labels = new UIViewLabels();
        labels.setAddLabel(OpenXDataFacade.getOpenXDataConstants().label_addnewuser());
        labels.setDeleteLabel(OpenXDataFacade.getOpenXDataConstants().label_deleteuser());
        return labels;
    }

    
	@Override
	public void update(OpenXDataObservable observable, Object observedModelObjects) {
		//do nothing
	}

	@Override
	public void updateUsers(OpenXDataObservable observable, List<User> users) {
		this.users = users;
		bindUsersToTreeView(users);
		
	}
	
	public void importSelectedItem() {
		OpenFileDialog dlg = new OpenFileDialog(this, "import?type=user");
		dlg.center();
	}

	/**
	 * @see org.purc.purcforms.client.controller.OpenFileDialogEventListener#onSetFileContents(String)
	 */
	@Override
	public void onSetFileContents(String contents) {
		Window.alert("Import complete");
	}

	
	@Override
	public void exportAsPdf() {
		// do nothing
		
	}

	
	@Override
	public void onDeleteItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_USERS){
			if(RolesListUtil.getPermissionResolver().isDeleteUsers()){
				deleteSelectedItem();
			}
			else{
				Window.alert("You do not have sufficient priviledges to delete Users! Contact your system administrator");
			}
		}
		
	}

	
	@Override
	public void onExport() {
		// do nothing
		
	}

	
	@Override
	public void onImport() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_USERS){
			if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Import_Users")){
				importSelectedItem();
			}
			else{
				Window.alert("You do not have sufficient privileges to import Users!");
			}
		}
	}

	
	@Override
	public void onNewChildItem() {
		//do nothing
	}

	
	@Override
	public void onNewItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_USERS){
			if(RolesListUtil.getPermissionResolver().isAddUsers()){
				addNewItem();
			}
			else{
				Window.alert("You do not have sufficient priviledges to add Users! Contact your system administrator");
			}
		}
		
	}

	
	@Override
	public void onOpen() {
		// do nothing
		
	}

	
	@Override
	public void onRefresh() {
		MainViewControllerFacade.refreshData();
		
	}

	
	@Override
	public void onSave() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_USERS){
			MainViewControllerFacade.saveUsers();
		}		
	}
}
