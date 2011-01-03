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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.controller.observe.RolesObserver;
import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.listeners.RoleMappedListener;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.permissions.util.RolesMappingUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.constants.OpenXDataStackPanelConstants;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.view.listeners.OpenXDataViewApplicationEventListener;
import org.openxdata.server.admin.client.view.widget.CompositeTreeItem;
import org.openxdata.server.admin.client.view.widget.TreeItemWidget;
import org.openxdata.server.admin.model.Permission;
import org.openxdata.server.admin.model.Role;
import org.purc.purcforms.client.util.FormUtil;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 *Custom widget that binds a list of system roles to the tree view and renders them for display
 * 
 * Listens for actions on the widgets
 * Forwards some of the actions on the roles to relevant listeners
 *  
 * @author Angel
 *
 */
public class RolesTreeView extends OpenXDataBaseTreeView implements OpenXDataViewApplicationEventListener, RolesObserver {
	
	private List<Role> roles;
	private List<Role> deletedRoles;
	private List<Permission> deletedPermissions;
	
	/**
	 * Constructs an instance of this <tt>Class.</tt>
	 * @param openXDataViewFactory 
	 */
	public RolesTreeView(OpenXDataViewFactory openXDataViewFactory){
		super("Roles",openXDataViewFactory);		
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
		popup = initContextMenu(this);
		
		// Maximize this widget
		Utilities.maximizeWidget(this);
 }
	  
  /**
   * Member to initialize the roles that will be bound to the tree view
   * @param roles - list of roles that are in the system
   */
  public void loadRoles(List<Role> roles){
	this.roles = roles;
	deletedRoles = new Vector<Role>();
	
	if(isLoadData()){
		tree.clear();
		
		TreeItem root; Role role;
		for(int i=0; i<roles.size(); i++){
			role = roles.get(i);
			root = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), role.getName(),popup));
			root.setTitle(role.getDescription());
			root.setUserObject(role);
		    tree.addItem(root);
		}
	}
  }
  
	/**
	 * Member fired to create a new role on the tree view
	 */
	@Override
	public void addNewItem(){
		Role role = new Role(OpenXDataFacade.getOpenXDataConstants().label_newrole());
		TreeItem root = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), role.getName(),popup));
		root.setUserObject(role);
		tree.addItem(root);
		
		role.setDirty(true);
		
		roles.add(role);
		tree.setSelectedItem(root);
	}
	
	/**
	 * Deletes the selected role on the tree view
	 */
	@Override
	public void deleteSelectedItem() {

		Role roleToDelete = getSelectedRole();

		if (roleToDelete == null) {
			Window.alert(OpenXDataFacade.getOpenXDataConstants().label_nullrole());
			return;
		}

		if (roleToDelete.isDefaultAdminRole())
			return;

		// Do not delete roles mapped to userMappedStudies
		new RolesMappingUtil(new RoleMappedListener() {

			@Override
			public void isMappedToUser(boolean isMappedToUser) {
				if (isMappedToUser) {
					Window.alert("Cannot Delete A Role Mapped To User");
					return;
				} else {
					deleteSelectedRole();
				}
			}
		}).checkRoleMapping(roleToDelete);

	}
	
	private void deleteSelectedRole() {

		Role roleToDelete = (Role) getSelectedRole();

		if (roleToDelete == null) {
			Window.alert(OpenXDataFacade.getOpenXDataConstants().label_nullrole());
			return;
		}

		if (!Window.confirm(OpenXDataFacade.getOpenXDataConstants()
				.label_deleteroleconfirmation()))
			return;

		deletedRoles.add(roleToDelete);
		roles.remove(roleToDelete);
		Utilities.removeRootItem(tree, tree.getSelectedItem());

		if (tree.getItemCount() == 0)
			itemSelectionListener.onItemSelected(this, null);

	}

	
	@Override
	public void changeEditableProperties(Object item) {
		TreeItem treeItem = this.tree.getSelectedItem();
		
		if(item == null)
			return; //How can this happen?
		
		Role role = (Role)item;
		
		{
			treeItem = tree.getSelectedItem();
			treeItem.setWidget(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), role.getName(),popup));
			treeItem.setTitle(role.getDescription());
			role.setDirty(true);
		}
	}
	
	/**
	 * Member to get the deleted roles on the tree view
	 * @return - list of deleted roles
	 */
	public List<Role> getDeletedRoles(){
		return deletedRoles;
	}
	
	/**
	 * Checks if the list of roles is valid for saving.
	 * 
	 * @return true if valid, else flase.
	 */
	public boolean isValidRolesList(){
		try{
			Map <String,String> map = new HashMap<String,String>();
			int index = tree.getItemCount();
			
			for(int j=0;j<index;j++)
			{
				if(map.containsKey(tree.getItem(j).getText().toLowerCase())){
					
					tree.setSelectedItem(tree.getItem(j));
					
					Window.alert(OpenXDataFacade.getOpenXDataConstants().label_existingrole()+tree.getItem(j).getText());
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
	
	public List<Permission> getdeletedPermissions() {
		return deletedPermissions;
	}

	public void setPermissionToBeDeleted(Permission permission){
		this.deletedPermissions.add(permission);
	}

	@Override
	UIViewLabels getContextMenuLabels() {
        UIViewLabels labels = new UIViewLabels();
        labels.setAddLabel(OpenXDataFacade.getOpenXDataConstants().label_addnewrole());
        labels.setDeleteLabel(OpenXDataFacade.getOpenXDataConstants().label_deleterole());
        return labels;
	}
	
	/**
	 * Gets the currently selected <tt>Role</tt> on the {@link RolesTreeView}.
	 * @return Instance of {@link Role}.
	 */
	public Role getSelectedRole() {
		TreeItem item = tree.getSelectedItem();
		if (item == null)
			return null;

		return (Role) item.getUserObject();
	}

	
	@Override
	public void update(OpenXDataObservable observable, Object observedModelObjects) {
		//do nothing
	}

	
	@Override
	public void updatePermissions(OpenXDataObservable observable, List<Permission> permissions) {
		//do nothing
		
	}

	
	@Override
	public void updateRoles(OpenXDataObservable observable, List<Role> roles) {
		loadRoles(roles);
	}
	
	
	@Override
	public void onDeleteItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_ROLES){
			if(RolesListUtil.getPermissionResolver().isDeleteRoles()){
				deleteSelectedItem();
			}
			else{
				Window.alert("You do not have sufficient priviledges to delete Roles! Contact your system administrator");
			}
		}
	}
	
	
	@Override
	public void onNewChildItem() {
		// do nothing
		
	}
	
	
	@Override
	public void onNewItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_ROLES){
			if(RolesListUtil.getPermissionResolver().isAddRoles()){
				addNewItem();
			}
			else{
				Window.alert("You do not have sufficient priviledges to add Roles! Contact your system administrator");
			}
		}
	}
	
	
	@Override
	public void onRefresh() {
		MainViewControllerFacade.refreshData();
		
	}
	
	
	@Override
	public void onSave() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_ROLES){
			MainViewControllerFacade.saveRoles();
		}
		
	}
}
