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
import java.util.Set;
import java.util.Vector;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.model.Role;
import org.openxdata.server.admin.model.User;

/**
 * Encapsulates the <tt>User Role Mapping</tt> functionality.
 * 
 * @author Angel
 *
 */
public class UserRoleMapView extends OpenXDataBaseObjectMapView {
	
	/** List of all system roles */
	private List<Role> roles = new Vector<Role>();
	
	/**
	 * Creates an instance of this class.
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for this <tt>widget.</tt>
	 */
	public UserRoleMapView(ItemChangeListener itemChangeListener) {
		super(itemChangeListener);
	}

	
	@Override
	protected void mapItemTobject() {
		if(unMappedObjectsListBox.getSelectedIndex() > -1){		
			for(Role x : roles){
				if(x.getName().equals(unMappedObjectsListBox.getItemText(unMappedObjectsListBox.getSelectedIndex()))){
					if(user != null){
						if(!user.isDefaultAdministrator()){
							if(!user.hasRole(x)){
								
								if(!user.hasRole(x)){
									user.addRole(x);
									
									user.setDirty(true);
									
									//Moving the item to the right List boxes.
									mappedObjectsListBox.addItem(x.getName());			
									unMappedObjectsListBox.removeItem(unMappedObjectsListBox.getSelectedIndex());
								}
							}
							else{
								Utilities.displayMessage("The Role is already Mapped to the User. You cannot Map the same role to the User twice.");
							}
						}
						else{
							Utilities.displayMessage("This selected User is the default administrator, you cannot add/remove permissions from the administrator.");
						}
					}
				}
			}
		}
		else{
			if(unMappedObjectsListBox.getItemCount() < 0)
				Utilities.displayMessage("There are no Roles to map to the selected User. Either they have all been mapped to the selected User" +
						" or there are no Roles in the System. Create some Roles to Map to selected User.");
			else
				Utilities.displayMessage("Select a Role to Proceed!");
		}
		
	}

	/**
	 * Checks if the manipulated object has a specified property.
	 * 
	 * @param arg - property to check on object being manipulated.
	 * @param rolePermissions - List of available objects to check from.
	 * 
	 * @return <code> True only and only if(object.exists() == true)</code>
	 */
	private boolean hasProperty(Object arg, Set<Role> rolePermissions) {
		boolean ret = false;
		for(Role x : rolePermissions){
			if(x.getName().equals(((Role) arg).getName())){
				ret = true;
				break;
			}
		}
		
		return ret;
	}

	
	@Override
	protected void initializeObjectProperties() {
		
		// Clear boxes for new User Roles.
		mappedObjectsListBox.clear();
		unMappedObjectsListBox.clear();
		
		roles = Context.getRoles();		
		if(user != null){			
			
			Set<Role> userRoles = ((User) user).getRoles();			
			if(userRoles != null && roles != null){				
				for(Role role : roles){
					
					// If User has the Role, add it to the mapped
					// objects list box else add it to the unmapped objects list box.
					if(hasProperty(role, userRoles)){
						mappedObjectsListBox.addItem(role.getName());
					}
					else{
						unMappedObjectsListBox.addItem(role.getName());
					}
				}
			}
			else
				if(roles != null){
					for(Role role : roles){
						unMappedObjectsListBox.addItem(role.getName());
					}
				}
		}
	}

	
	@Override
	protected void unMapItemFromObject() {
		if(mappedObjectsListBox.getSelectedIndex() > -1){			
			for(Role x : roles){
				if(x.getName().equals(mappedObjectsListBox.getItemText(mappedObjectsListBox.getSelectedIndex()))){
					if(!user.isDefaultAdministrator()){
						user.removeRole(x);
						user.setDirty(true);						
						
						unMappedObjectsListBox.addItem(x.getName());			
						mappedObjectsListBox.removeItem(mappedObjectsListBox.getSelectedIndex());		
						
						break;
					}
					else{
						Utilities.displayMessage("This selected User is the default administrator, you cannot add/remove permissions from the administrator.");
					}
				}
			}
		}
		else{
			if(unMappedObjectsListBox.getItemCount() < 0)
				Utilities.displayMessage("There are no Roles mapped to the current User.");
			else
				Utilities.displayMessage("Select a Role to Proceed!");
		}
		
	}
	
	
	@Override
	UIViewLabels getMapViewLabels() {
		UIViewLabels labels = new UIViewLabels();
		labels.setLabel("User Roles");		
        
		labels.setRightListBoxLabel("Roles");    
        labels.setLeftListBoxLabel("User Roles");
        
        labels.setMapButtonText("Add Role");
        labels.setUnMapButtonText("Remove Role");
        
        labels.setAddButtonTitle("Adds the selected Role to the User.");
        labels.setRemoveButtonTitle("Removes the selected Role from the User.");
        
		return labels;
	}

	
	@Override
	protected void saveMap() {
		//We save all the User Mapped Roles by saving Users.
		MainViewControllerFacade.saveUsers();
	}
}
