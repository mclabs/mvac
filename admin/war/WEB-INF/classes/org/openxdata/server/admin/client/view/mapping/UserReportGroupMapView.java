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
import org.openxdata.server.admin.model.ReportGroup;
import org.openxdata.server.admin.model.Role;
import org.openxdata.server.admin.model.mapping.UserReportGroupMap;

/**
 * Encapsulates the <tt>User Report Group Mapping</tt> functionality.
 * 
 * @author Angel
 *
 */
public class UserReportGroupMapView extends OpenXDataBaseObjectMapView {
	
	/** List of all system <tt>Report Groups.</tt>*/
	private List<ReportGroup> reportGroups;
	
	/** List of <tt>UserReportGroupMaps.</tt>*/
	private List<UserReportGroupMap> mappedReportGroups;
	
	/** List of deleted <tt> UserMappedReportGroups.</tt>*/
	private List<UserReportGroupMap> deletedUserMappedReportGroups;
	
	/**
	 * Creates an instance of this class.
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for this <tt>widget.</tt>
	 */
	public UserReportGroupMapView(ItemChangeListener itemChangeListener) {
		super(itemChangeListener);
	}

	
	@Override
	public void initializeObjectProperties() {
		
		// Clear boxes for new User Roles.
		mappedObjectsListBox.clear();
		unMappedObjectsListBox.clear();
		
		reportGroups = Context.getReportGroups();
		
		// Retrieve currently mapped Report Groups for the currently selected user
		List<UserReportGroupMap> userMappedReportGroups = RolesListUtil.getPermissionResolver().getUserMappedReportGroups(user, mappedReportGroups);
		
		// Bind only distinct Report Groups to the list boxes. 				
		if(reportGroups != null && userMappedReportGroups.size() > 0){
			for(ReportGroup def : reportGroups){
				
				// If User has the Report Group, add it to the mapped
				// objects list box else add it to the unmapped objects list box.
				if(hasProperty(def, userMappedReportGroups)){
					mappedObjectsListBox.addItem(def.getName());
				}
				else{
					unMappedObjectsListBox.addItem(def.getName());
				}
			}
		}
		else {
			if(reportGroups != null){
				for(ReportGroup x : reportGroups){
					unMappedObjectsListBox.addItem(x.getName());
				}
			}
		}
	}
	
	
	@Override
	protected void mapItemTobject() {
		if(unMappedObjectsListBox.getSelectedIndex() > -1){			
			for(ReportGroup x : reportGroups){
				if(x.getName().equals(unMappedObjectsListBox.getItemText(unMappedObjectsListBox.getSelectedIndex()))){
					if(user != null){
						if(!user.hasAdministrativePrivileges()){		
							UserReportGroupMap map = new UserReportGroupMap();
							
							map.addUser(user);
							map.addReportGroup(x);						
							map.setDirty(true);
							
							mappedReportGroups.add(map);
							
							if(!user.hasRole(new Role("Role_View_ReportGroups_")))
								RolesListUtil.addViewReportGroupsRoleOnReportGroupMap(user);
							
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
				Utilities.displayMessage("There are no Report Groups to map to selected User. Either they have all been mapped to the selected User or " +
						"there are no Report Groups in the System. Create some Report Groups to Map to selected user.");
			else
				Utilities.displayMessage("Select a Report Group to Proceed!");
		}

	}

	
	@Override
	UIViewLabels getMapViewLabels() {
        UIViewLabels labels = new UIViewLabels();
        
        labels.setRightListBoxLabel("Report Groups");    
        labels.setLeftListBoxLabel("User Report Groups");
        
        labels.setMapButtonText("Add Report Group");
        labels.setUnMapButtonText("Remove Report Group");
        
        labels.setAddButtonTitle("Adds the selected Report Group to the User.");
        labels.setRemoveButtonTitle("Removes the selected Report Group from the User.");
        
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
	private boolean hasProperty(Object arg, List<UserReportGroupMap> userMappedPermissions) {
		boolean ret = false;		
		for(UserReportGroupMap rpt : userMappedPermissions){
			if(rpt.getReportGroupId() == ((ReportGroup) arg).getReportGroupId()){
				ret = true;
				break;
			}
		}
		
		return ret;
	}
	
	
	@Override
	protected void unMapItemFromObject() {
		if(mappedObjectsListBox.getSelectedIndex() > -1){			
			/*
			 *Get the report id and the current user id for constructing the report User Object 
			 */
			for(ReportGroup x : reportGroups){
				if(x.getName().equals(mappedObjectsListBox.getItemText(mappedObjectsListBox.getSelectedIndex()))){
					if(user != null & !user.hasAdministrativePrivileges()){

						UserReportGroupMap map = getUserReportGroupMap(x);						
						deletedUserMappedReportGroups.add(map);
						
						unMappedObjectsListBox.addItem(x.getName());
						mappedObjectsListBox.removeItem(mappedObjectsListBox.getSelectedIndex());
						
						List<UserReportGroupMap> userMappedReportGroups = RolesListUtil.getPermissionResolver().getUserMappedReportGroups(user, mappedReportGroups);
						if(userMappedReportGroups.size() < 1)
							RolesListUtil.removeViewReportGroupsRoleOnReportGroupMap(user);
						
						break;						
					}
				}
			}
		}
		else{
			if(unMappedObjectsListBox.getItemCount() < 0)
				Utilities.displayMessage("There are no Report Groups mapped to selected User.");
			else
				Utilities.displayMessage("Select a Report Group to Proceed!");
		}

	}
	
	private UserReportGroupMap getUserReportGroupMap(ReportGroup reportGroup) {
		for(UserReportGroupMap map : mappedReportGroups){
			if(map.getUserId() == user.getUserId() && map.getReportGroupId() == reportGroup.getReportGroupId())
				return map;
		}
		return null;
	}
	
	/**
	 * @param deletedUserMappedReportGroups
	 */
	public void setDeletedUserMappedReportGroups(List<UserReportGroupMap> deletedUserMappedReportGroups) {
		this.deletedUserMappedReportGroups = deletedUserMappedReportGroups;
		
	}

	/**
	 * @param userMappedReportGroups
	 */
	public void setUserMappedReportGroups(List<UserReportGroupMap> userMappedReportGroups) {
		this.mappedReportGroups = userMappedReportGroups;
		
	}

	
	@Override
	protected void saveMap() {
		//We save all the User Mapped Report Groups
		MainViewControllerFacade.saveMappedReportGroups();
		
	}
}
