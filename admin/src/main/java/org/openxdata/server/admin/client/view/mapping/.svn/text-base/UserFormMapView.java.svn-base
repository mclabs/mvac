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

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.Role;
import org.openxdata.server.admin.model.mapping.UserFormMap;
import org.openxdata.server.admin.model.mapping.UserStudyMap;

/**
 * Encapsulates the <tt>User Form Mapping</tt> functionality.
 * 
 * @author Angel
 *
 */
public class UserFormMapView extends OpenXDataBaseObjectMapView {
	
	/** List of all system <tt>FormDefs.</tt>*/
	private List<FormDef> forms;
	
	/** List of all <tt>UserFormMaps.</tt>*/
	private List<UserFormMap> mappedForms;
	
	/** List of all User <tt>UserStudyMaps.</tt>*/
	private List<UserStudyMap> mappedStudies;
	
	/** List of all deleted <tt>UserFormMaps.</tt>*/
	private List<UserFormMap> deletedUserMappedForms;

	
	/**
	 * Creates an instance of this class.
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for this <tt>widget.</tt>
	 */
	public UserFormMapView(ItemChangeListener itemChangeListener) {
		super(itemChangeListener);
	}

	
	@Override
	public void initializeObjectProperties() {
		
		// Clear boxes for new User Roles.
		mappedObjectsListBox.clear();
		unMappedObjectsListBox.clear();
		
		forms = Context.getForms();
		
		// Retrieve currently mapped studies for the currently selected user
		List<UserFormMap> userMappedForms = RolesListUtil.getPermissionResolver().getUserMappedForms(user, mappedForms);
		
		RolesListUtil.getPermissionResolver().getUserMappedStudies(user, mappedStudies);
		
		// Bind only distinct Forms to the list boxes. 	
		if(forms != null && userMappedForms.size() > 0){
			for(FormDef def : forms){
				
				// If User has the Form, add it to the mapped
				// objects list box else add it to the unmapped objects list box.
				if(hasProperty(def, userMappedForms)){
					mappedObjectsListBox.addItem(def.getName());
				}
				else{
					unMappedObjectsListBox.addItem(def.getName());
				}
			}
		}
		else {
			if(forms != null){
				for(FormDef x : forms){
					unMappedObjectsListBox.addItem(x.getName());
				}
			}
		}
	}
	
	
	@Override
	protected void mapItemTobject() {
		if(unMappedObjectsListBox.getSelectedIndex() > -1){			
			for(FormDef x : forms){
				if(x.getName().equals(unMappedObjectsListBox.getItemText(unMappedObjectsListBox.getSelectedIndex()))){
					if(user != null){
						if(!user.hasAdministrativePrivileges()){
							UserFormMap map = new UserFormMap();
							
							map.addForm(x);
							map.addUser(user);
							map.setDirty(true);
							mappedForms.add(map);
							
							if(!user.hasRole(new Role("Role_View_Forms_")))
								RolesListUtil.addViewFormsRoleOnFormMap(user);
							
							user.setDirty(true);
							
							// Moving the item to the right List boxes.
							mappedObjectsListBox.addItem(x.getName());
							unMappedObjectsListBox.removeItem(unMappedObjectsListBox.getSelectedIndex());
							
							break;
						}
						else{
							Utilities.displayMessage("This selected User is an administrator, you cannot add/remove permissions from an administrator.");
						}
					}
					else{
						Utilities.displayMessage("Select a User on the Tree View to Proceed!");
					}
				}
			}
		}
		else{
			if(unMappedObjectsListBox.getItemCount() < 0)
				Utilities.displayMessage("There are no Forms to map to selected User. Either they have all been mapped to the selected User or " +
						"there are no Forms in the System. Create some Forms to Map to selected User.");
			else
				Utilities.displayMessage("Select a Form to Proceed!");
		}

	}

	
	@Override
	UIViewLabels getMapViewLabels() {
		UIViewLabels labels = new UIViewLabels();
		labels.setLabel("User Forms");		
        
		labels.setRightListBoxLabel("Forms");    
        labels.setLeftListBoxLabel("User Forms");
        
        labels.setMapButtonText("Add Form");
        labels.setUnMapButtonText("Remove Form");
        
        labels.setAddButtonTitle("Adds the selected Form to the User.");
        labels.setRemoveButtonTitle("Removes the selected Form from the User.");
        
		return labels;
	}

	/**
	 * Checks if the manipulated object has a specified property.
	 * 
	 * @param arg - property to check on object being manipulated.
	 * @param userMappedPermissions - List of available objects to check from.
	 * 
	 * @return <code> True only and only if(object.exists() == true)</code>
	 */
	private boolean hasProperty(Object arg, List<UserFormMap> userMappedPermissions) {
		
		boolean ret = false;		
		for(UserFormMap x : userMappedPermissions){
			if(x.getFormId() == ((FormDef) arg).getFormId()){
				ret = true;
				break;
			}
		}
		
		return ret;
	}

	
	@Override
	protected void unMapItemFromObject() {
		if(mappedObjectsListBox.getSelectedIndex() > -1){			
			/*Get the Form id and the current User id for constructing the User Form Object */
			for(FormDef x : forms){
				if(x.getName().equals(mappedObjectsListBox.getItemText(mappedObjectsListBox.getSelectedIndex()))){
					if(user != null & !user.hasAdministrativePrivileges()){
						UserFormMap map = getUserFormMap(x);																		
						unMappedObjectsListBox.addItem(x.getName());
						mappedObjectsListBox.removeItem(mappedObjectsListBox.getSelectedIndex());
						
						deletedUserMappedForms.add(map);
						
						List<UserFormMap> userMappedForms = RolesListUtil.getPermissionResolver().getUserMappedForms(user, mappedForms);
						if(userMappedForms.size() < 1)
							RolesListUtil.removeViewFormsRoleAddedOnMap(user);
						
						break;
					}
				}
			}
		}
		else{
			if(unMappedObjectsListBox.getItemCount() < 0)
				Utilities.displayMessage("There are no Forms mapped to selected User.");
			else
				Utilities.displayMessage("Select a Form to Proceed!");
		}

	}

	/**
	 * Retrieves a given <code>UserFormMap</code> given a <code>FormDef.</code>
	 * 
	 * @param form <code>FormDef</code> to retrieve <code>UserFormMap</code> for.
	 * @return <code>UserFormMap</code>
	 */
	private UserFormMap getUserFormMap(FormDef form) {
		for(UserFormMap map : mappedForms){
			if(map.getUserId() == user.getUserId() && map.getFormId() == form.getFormId())
				return map;
			
		}
		return null;
	}

	/**
	 * @param deletedUserMappedForms
	 */
	public void setDeletedUserMappedForms(List<UserFormMap> deletedUserMappedForms) {
		this.deletedUserMappedForms = deletedUserMappedForms;
		
	}

	/**
	 * Sets the <tt>UserFormMaps.</tt>
	 * @param mappedForms <tt>Mapped Forms</tt> to set.
	 */
	public void setUserMappedForms(List<UserFormMap> mappedForms) {
		this.mappedForms = mappedForms;
		
	}

	
	@Override
	protected void saveMap() {
		//We save the User Mapped Forms
		MainViewControllerFacade.saveMappedForms();
	}

	/**
	 * @param userMappedStudies
	 */
	public void setUserMappedStudies(List<UserStudyMap> userMappedStudies) {
		this.mappedStudies = userMappedStudies;		
	}
}
