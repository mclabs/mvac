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
package org.openxdata.server.admin.client.view.mapping;

import java.util.List;

import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.model.Permission;
import org.openxdata.server.admin.model.Role;

/** 
 * Custom <code>widget</code> that encapsulates 
 * operations that accomplish mapping of <code>Permissions to Roles.</code>
 * 
 * @author Angel
 *
 */
public class RolePermissionMapView extends OpenXDataBaseObjectMapView {
	
	/** Current <tt>Role</tt> we manipulating.*/
	private Role role;
	
	/** List of system <tt>Permissions.</tt>*/
	private List<Permission> permissions;
	
	/**
	 * Initializes the object with an event Listener.
	 * 
	 * @param itemChangeListener Event Listener.
	 */
	public RolePermissionMapView(ItemChangeListener itemChangeListener) {
		super(itemChangeListener);
	}

	
	@Override
	protected void initializeObjectProperties() {
		
		// Clear boxes for new Role permissions.
		mappedObjectsListBox.clear();
		unMappedObjectsListBox.clear();
		
		List<Permission> rolePermissions = role.getPermissions();
		
		if(rolePermissions.size() > 0 && permissions != null){
			for(Permission permission : permissions){
				
				// If Role has the Permission, add it to the mapped
				// objects list box else add it to the unmapped objects list box.
				if(hasProperty(permission, rolePermissions)){
					mappedObjectsListBox.addItem(permission.getName());
				}
				else{
					unMappedObjectsListBox.addItem(permission.getName());
				}
			}
		}
		else {
			if(permissions != null){
				for(Permission xPerm : permissions){
					unMappedObjectsListBox.addItem(xPerm.getName());
				}
			}
		}
	}
	
	
	@Override
	protected void mapItemTobject() {
		if(unMappedObjectsListBox.getSelectedIndex() > -1){			
			for(Permission x : permissions){	
				if(x.getName().equals(unMappedObjectsListBox.getItemText(unMappedObjectsListBox.getSelectedIndex()))){
					if(role != null){						
						if(!role.isDefaultAdminRole()){
							List<Permission> permissionsToAdd = RolesListUtil.checkAndBindAncillaryPermissions(x, permissions, role.getPermissions());
							
							if(permissionsToAdd != null &&
									permissionsToAdd.size() > 0){
								
								role.addPermissions(permissionsToAdd);
								role.setDirty(true);
								
								mappedObjectsListBox.addItem(x.getName());			
								unMappedObjectsListBox.removeItem(unMappedObjectsListBox.getSelectedIndex());
								
								break;
							}
						}
						else{
							Utilities.displayMessage("You cannot edit the Default Administrator Role!");
						}
					}
					else{
						if(unMappedObjectsListBox.getItemCount() < 0)
							Utilities.displayMessage("There are no Permissions to map to the selected Role. Either they have all been mapped to the Role " +
									"or there are no Permissions in the System.");
						else
							Utilities.displayMessage("Select a Permission to Proceed!");
					}
				}
			}
		}		
	}

	/**
	 * Checks if the manipulated object has a specified property.
	 * 
	 * @param arg - property to check on object being manipulated.
	 * @param permissions - List of available objects to check from.
	 * 
	 * @return <code> True only and only if(object.exists() == true)</code>
	 */
	private boolean hasProperty(Object arg, List<Permission> permissions) {
		
		boolean ret = false;		
		for(Permission x : permissions){
			if(x.getName().equals(((Permission) arg).getName())){
				ret = true;
				break;
			}
		}
		return ret;
	}

	
	@Override
	protected void unMapItemFromObject() {
		if(mappedObjectsListBox.getSelectedIndex() > -1){			
			for(Permission x : permissions){
				if(x.getName().equals(unMappedObjectsListBox.getItemText(unMappedObjectsListBox.getSelectedIndex()))){
					if(role != null){
						role.removePermission(x);
						role.setDirty(true);
						
						unMappedObjectsListBox.addItem(x.getName());				
						mappedObjectsListBox.removeItem(unMappedObjectsListBox.getSelectedIndex());
						break;
					}
					else{
						Utilities.displayMessage("Select a Role to Proceed");
						return;
					}
				}
			}
		}
		else{
			Utilities.displayMessage("The selected Role has no Permissions mapped to it!");
		}
		
	}
	
	/**
	 * Sets the list of system permissions retrieved from the server.
	 * 
	 * @param permissions - permissions to set.
	 * 
	 * @throws NullPointerException if(permissions == null)
	 */
	public void setPermissions(List<Permission> permissions) {		
		this.permissions = permissions;	
	}
	
	
	@Override
	UIViewLabels getMapViewLabels() {
		UIViewLabels labels = new UIViewLabels();
		labels.setLabel("Role Permissions");
		
		labels.setRightListBoxLabel("Permissions");    
        labels.setLeftListBoxLabel("Role Permissions");
        
        labels.setMapButtonText("Add Permission");
        labels.setUnMapButtonText("Remove Permission");
        
        labels.setAddButtonTitle("Adds the selected Permission to the Role.");
        labels.setRemoveButtonTitle("Removes the selected Permission from the Role.");
		
		return labels;
	}
	
	
	@Override
	protected void saveMap() {
		//We save all the roles that have been given permissions.
		MainViewControllerFacade.saveRoles();		
	}
}
