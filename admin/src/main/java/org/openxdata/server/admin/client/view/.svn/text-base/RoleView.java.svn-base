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
package org.openxdata.server.admin.client.view;

import java.util.List;

import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.controller.observe.RolesObserver;
import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.view.mapping.RolePermissionMapView;
import org.openxdata.server.admin.model.Permission;
import org.openxdata.server.admin.model.Role;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

/**
 * This widget displays properties of the selected role and lets you edit them.
 * 
 * @author Mark
 * @author daniel
 * @author Simon Peter Muwanga 
 */
public class RoleView extends OpenXDataBaseView implements RolesObserver {

	private Role role;
	private TextBox txtName;
	private TextBox txtDescription;

	/**
	 * Constructor that takes an argument (Item Change Listener)
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> sending objects that this <tt>Widget</tt> is interest in.
	 * @param openXDataViewFactory 
	 */
	public RoleView(ItemChangeListener itemChangeListener, OpenXDataViewFactory openXDataViewFactory){
		super(itemChangeListener, openXDataViewFactory);
	}

	
	@Override
	protected void setUp() {
		
		txtName = new TextBox();
		
		txtDescription = new TextBox();
		
		openxdataStackPanel = widgetFactory.getOpenXdataStackPanel();
		
		//Register this class with Event Dispatchers.
		super.registerWithEventDispatchers();
		
		if (RolesListUtil.getPermissionResolver().isPermission("Perm_View_Roles")) {
			loadView();
		} else {
			loadPermissionLessView();
		}
	}

	/**
	 * Load administrator view with full controls
	 */
	private void loadView() {
		
		table.setWidget(0, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_name()));
		
		table.setWidget(1, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_description()));

		table.setWidget(0, 1, txtName);
		table.setWidget(1, 1, txtDescription);

		txtName.setWidth("100%");
		txtDescription.setWidth("100%");

		FlexCellFormatter cellFormatter = table.getFlexCellFormatter();
		cellFormatter.setWidth(0, 0, "20%");

		table.getRowFormatter().removeStyleName(0, "FlexTable-Header");
		table.setStyleName("cw-FlexTable");
		Utilities.maximizeWidget(table);

		if(RolesListUtil.getPermissionResolver().isPermission("Role")){
			tabs.add(table, OpenXDataFacade.getOpenXDataConstants().label_properties());
		}
		if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Map_Permissions_to_Roles")||
				RolesListUtil.getPermissionResolver().isEditPermission("Perm_Edit_Role_Permissions")){
			
			tabs.add(widgetFactory.getRolePermissionMapView(), OpenXDataFacade.getOpenXDataConstants().label_rolesmanagement());
		}
		
		Utilities.maximizeWidget(tabs);

		initWidget(tabs);

		setWidth("100%");
		setupEventListeners();
		tabs.selectTab(0);

		setEnabled(false);
	}
	
	/**
	 * Loads a view for a user without permissions (No items to work with)
	 */
	private void loadPermissionLessView() {
		table.setWidget(0, 0, new Label(OpenXDataFacade.getOpenXDataConstants().ascertain_permissionLessView() + "Roles"));
		FlexCellFormatter cellFormatter = table.getFlexCellFormatter();
		cellFormatter.setWidth(0, 0, "20%");
		table.setStyleName("cw-FlexTable");
		
		Utilities.maximizeWidget(table);
		
		tabs.add(table, OpenXDataFacade.getOpenXDataConstants().ascertain_permissionTab());
		Utilities.maximizeWidget(tabs);
	    
		tabs.selectTab(0);
		
		initWidget(tabs);
		
		setWidth("100%");
		
	}

	/**
	 * Member that set ups the event listeners for the components on the widget
	 */
	private void setupEventListeners(){
		txtName.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				if(table.isVisible())
					updateName();
			}
		});
		txtName.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(table.isVisible())
					updateName();				
				if(event.getCharCode() == KeyCodes.KEY_ENTER){
					if(table.isVisible())
						txtDescription.setFocus(true);
				}					
			}
		});

		txtDescription.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				if(table.isVisible())
					updateDescription();
			}
		});
		txtDescription.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent arg0) {
				if(table.isVisible())
					updateDescription();				
			}
		});
	}

	/**
	 * Member that updates the name of the role on the display (tree view) as changes
	 * The changes are also captures and stored on the object
	 */
	private void updateName(){
		
		if(txtName.isVisible()){
			role.setName(txtName.getText());
			itemChangeListener.onItemChanged(role);
		}
	}

	/**
	 * Member that updates the description as it changes on the display
	 */
	private void updateDescription(){
				
		if(txtDescription.isVisible()){
			role.setDescription(txtDescription.getText());
			itemChangeListener.onItemChanged(role);
		}
	}

	/**
	 * Member that is fired when the selected item on the tree view changes
	 */
	@Override
	public void onItemSelected(Composite sender, Object item) {
		
		setEnabled(true);
		
		if(item == null)
			clear();
		else{
			role = (Role)item;

			if(table.isVisible()){
				
				txtName.setFocus(true);
				txtName.setText(role.getName());
				txtDescription.setText(role.getDescription());
			}
			
			txtName.setFocus(true);
			disableControlsOnDefaultAdministratorRole();			
			widgetFactory.getRolePermissionMapView().onItemSelected(sender, item);
		}
	}

	/**
	 * Disables controls if the selected <tt>Role</tt> is the default administrator <tt>Role</tt> that ships with the system.
	 */
	private void disableControlsOnDefaultAdministratorRole() {
		if(role.isDefaultAdminRole())
			setEnabled(false);
		else
			setEnabled(true);
	}	

	/**
	 * Member that enables/disables the controls on the widget
	 * @param enabled - parameter to enable the control. True for enabling, otherwise disable
	 */
	private void setEnabled(boolean enabled){
		if(txtName.isVisible() && txtDescription.isVisible()){
			txtName.setEnabled(enabled);
			txtDescription.setEnabled(enabled);
		}
	}

	/**
	 * Member that clears the name of the role on the display
	 */
	private void clear(){
		if(txtName.isVisible() && txtDescription.isVisible()){
			role = null;
			txtName.setText(null);
			txtDescription.setText(null);
		}
	}

	/**
	 * Member fired when the selected item on the tree view changes.
	 * 
	 * It also sets the currently selected member to the just selected member on the display
	 * @param item - currently selected item on the tree view
	 */
	public void onItemChanged(Object item) {
		
		setEnabled(true);
		role = (Role)item;

		if(table.isVisible()){
			txtName.setText(role.getName());
			txtDescription.setText(role.getDescription());
			txtName.setFocus(true);
		}
		txtName.selectAll();
		widgetFactory.getRolePermissionMapView().onItemSelected(null, item);
	}

	
	@Override
	public void updatePermissions(OpenXDataObservable observable, List<Permission> permissions) {
		((RolePermissionMapView)widgetFactory.getRolePermissionMapView()).setPermissions(permissions);
		
	}

	
	@Override
	public void updateRoles(OpenXDataObservable observable, List<Role> roles) {
		// do nothing
		
	}
	
	
	@Override
	public void update(OpenXDataObservable observable, Object observedModelObjects) {
		//do nothing
		
	}
}
