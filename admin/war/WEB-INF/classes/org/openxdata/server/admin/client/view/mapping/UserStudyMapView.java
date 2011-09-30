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
import org.openxdata.server.admin.model.Role;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.mapping.UserStudyMap;

/**
 * Encapsulates the <tt>User Study Mapping</tt> functionality.
 * 
 * @author Angel
 *
 */
public class UserStudyMapView extends OpenXDataBaseObjectMapView {
	
	/**
	 * Concrete implementation of studies 
	 * 
	 * This will override the [objectsToMap] in the super class
	 */
	private List<StudyDef> studies;
	
	/**
	 * List of studies that are currently mapped to the all <code>Users.</code>
	 */
	private List<UserStudyMap> mappedStudies;
	
	/**
	 * List of studies that have been removed from the user*/
	private List<UserStudyMap> deletedUserMappedStudies;
	
	/**
	 * Creates an instance of this class.
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for this <tt>widget.</tt>
	 */
	public UserStudyMapView(ItemChangeListener itemChangeListener){
		super(itemChangeListener);
	}
	
	
	@Override
	public void initializeObjectProperties() { 
		
		// Clear boxes for new User Roles.
		mappedObjectsListBox.clear();
		unMappedObjectsListBox.clear();
		
		studies = Context.getStudies();
		
		// Retrieve currently mapped studies for the currently selected user
		List<UserStudyMap> userMappedStudies = RolesListUtil.getPermissionResolver().getUserMappedStudies(user, mappedStudies);
		
		// Bind only distinct studies to the list boxes. 		
		if(studies != null && userMappedStudies.size() > 0){
			for(StudyDef def : studies){
				
				// If User has the Study, add it to the mapped
				// objects list box else add it to the unmapped objects list box.
				if(hasProperty(def, userMappedStudies)){
					mappedObjectsListBox.addItem(def.getName());
				}
				else{
					unMappedObjectsListBox.addItem(def.getName());
				}
			}
		}
		else {
			if(studies != null){
				for(StudyDef x : studies){
					unMappedObjectsListBox.addItem(x.getName());
				}
			}
		}
	}
	
	/**
	 * Map study to the user.
	 * 
	 * Remove it from the unmapped list box to the current mapped studies box for the user
	 */
	@Override protected void mapItemTobject() {
		if(unMappedObjectsListBox.getSelectedIndex() > -1){			
			for(StudyDef x : studies){
				if(x.getName().equals(unMappedObjectsListBox.getItemText(unMappedObjectsListBox.getSelectedIndex()))){
					if(user != null){
						if(!user.hasAdministrativePrivileges()){
							UserStudyMap map = new UserStudyMap();
							
							map.addStudy(x);
							map.addUser(user);
							map.setDirty(true);
							mappedStudies.add(map);
							
							if(!user.hasRole(new Role("Role_View_Studies_")))
								RolesListUtil.addViewStudiesRoleOnStudyMap(user);
							
							user.setDirty(true);
							
							//Moving the item to the right List boxes.
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
				Utilities.displayMessage("There are no Studies to map to selected User. Either they have all been mapped to the selected User or there are no " +
						"Studies in the System. Create some Studies to Map to Users.");
			else
				Utilities.displayMessage("Select a Study to Proceed!");
		}
	}
	
	/**
	 * Remove study from <code>User.</code>
	 * 
	 * Remove it from the user list box and take it to the unmapped studies box
	 */
	@Override protected void unMapItemFromObject() {
		if(mappedObjectsListBox.getSelectedIndex() > -1){
			
			// Get the study id and the current user id for constructing the Study User Object.
			for(StudyDef x : studies){
				if(x.getName().equals(mappedObjectsListBox.getItemText(mappedObjectsListBox.getSelectedIndex()))){
					if(user != null & !user.hasAdministrativePrivileges()){
						UserStudyMap map = getUserStudyMap(x);																		
						unMappedObjectsListBox.addItem(x.getName());
						mappedObjectsListBox.removeItem(mappedObjectsListBox.getSelectedIndex());
						
						deletedUserMappedStudies.add(map);
						
						List<UserStudyMap> userMappedStudiesX = RolesListUtil.getPermissionResolver().getUserMappedStudies(user, mappedStudies);
						if(userMappedStudiesX.size() < 1)
							RolesListUtil.removeViewStudiesRoleAddedOnMap(user);
						
						break;
					}
				}
			}
		}
		else{
			if(unMappedObjectsListBox.getItemCount() < 0)
				Utilities.displayMessage("There are no Studies mapped to selected User.");
			else
				Utilities.displayMessage("Select a Study to Proceed!");
		}
		
	}
	
	/**
	 * Retrieves a given <code>UserStudyMap</code> given a <code>StudyDef.</code>
	 * 
	 * @param study <code>StudyDef</code> to retrieve <code>UserStudyMap</code> for.
	 * @return <code>UserStudyMap</code>
	 */
	private UserStudyMap getUserStudyMap(StudyDef study) {
		for(UserStudyMap map : mappedStudies){
			if(map.getUserId() == user.getUserId() && map.getStudyId() == study.getStudyId())
				return map;
			
		}
		return null;
	}
	
	/**
	 * Checks if the manipulated object has a specified property.
	 * 
	 * @param arg - property to check on object being manipulated.
	 * @param userMappedPermissions - List of available objects to check from.
	 * 
	 * @return <code> True only and only if(object.exists() == true)</code>
	 */
	private boolean hasProperty(Object arg, List<UserStudyMap> userMappedPermissions) {
		
		boolean ret = false;		
		for(Object x : userMappedPermissions){
			if(((UserStudyMap) x).getStudyId() == ((StudyDef) arg).getStudyId()){
				ret = true;
				break;
			}
		}
		
		return ret;
	}

	
	@Override
	UIViewLabels getMapViewLabels() {
		UIViewLabels labels = new UIViewLabels();
		labels.setLabel("User Studies");
        
		labels.setRightListBoxLabel("Studies");    
        labels.setLeftListBoxLabel("User Studies");
        
        labels.setMapButtonText("Add Study");
        labels.setUnMapButtonText("Remove Study");
        
        labels.setAddButtonTitle("Adds the selected Study to the User.");
        labels.setRemoveButtonTitle("Removes the selected Study from the User.");
        
		return labels;
	}

	/**
	 * Sets all the system <code>User Mapped Studies.</code>
	 * 
	 * @param userMappedStudies List of <code>User Mapped Studies.</code>
	 */
	public void setUserMappedStudies(List<UserStudyMap> userMappedStudies) {
		this.mappedStudies = userMappedStudies;
	}

	/**
	 * @param deletedUserMappedStudies
	 */
	public void setDeletedUserMappedStudies(List<UserStudyMap> deletedUserMappedStudies) {
		this.deletedUserMappedStudies = deletedUserMappedStudies;
		
	}

	
	@Override
	protected void saveMap() {
		//We save all User Mapped Studies
		MainViewControllerFacade.saveMappedStudies();		
	}
}
