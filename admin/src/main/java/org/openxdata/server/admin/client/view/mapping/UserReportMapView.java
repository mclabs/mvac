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
import org.openxdata.server.admin.model.Report;
import org.openxdata.server.admin.model.Role;
import org.openxdata.server.admin.model.mapping.UserReportMap;

/**
 * Encapsulates the <tt>User Report Mapping</tt> functionality.
 * 
 * @author Angel
 *
 */
public class UserReportMapView extends OpenXDataBaseObjectMapView {
	
	/**
	 * Concrete implementation of reports
	 * 
	 * This will override the [objectsToMap] in the super class
	 */
	private List<Report> reports;
	
	/**
	 * Concrete implementation of <code>mapped reports</code> 
	 * 
	 * This will <code>override</code> the <code>mappedObjects</code> in the <code>super class</code>. 
	 */
	private List<UserReportMap> mappedReports;
	
	/**
	 * List of reports that have been un mapped from the user
	 */
	private List<UserReportMap> deletedUserMappedReports;
	
	/**
	 * Creates an instance of this class.
	 * 
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for this <tt>widget.</tt>
	 */
	public UserReportMapView(ItemChangeListener itemChangeListener) {
		super(itemChangeListener);
	}

	
	@Override
	public void initializeObjectProperties() {
		
		// Clear boxes for new User Roles.
		mappedObjectsListBox.clear();
		unMappedObjectsListBox.clear();
		
		reports = Context.getReports();
		
		// Retrieve currently mapped Reports for the currently selected user
		List<UserReportMap> userMappedReports = RolesListUtil.getPermissionResolver().getUserMappedReports(user, mappedReports);
		
		// Bind only distinct studies to the list boxes. 	
		if(reports != null && userMappedReports != null){
			for(Report xReport : reports){
				
				// If User has the Report, add it to the mapped
				// objects list box else add it to the unmapped objects list box.
				if(hasProperty(xReport, userMappedReports)){
					mappedObjectsListBox.addItem(xReport.getName());
				}
				else{
					unMappedObjectsListBox.addItem(xReport.getName());
				}
			}
		}
		else {
			if(reports != null){
				for(Report xReport : reports){
					unMappedObjectsListBox.addItem(xReport.getName());
				}
			}
		}
	}
	
	
	@Override
	protected void mapItemTobject() {
		if(unMappedObjectsListBox.getSelectedIndex() > -1){			
			for(Report x : reports){
				if(x.getName().equals(unMappedObjectsListBox.getItemText(unMappedObjectsListBox.getSelectedIndex()))){
					if(user != null){
						if(!user.hasAdministrativePrivileges()){
							UserReportMap map = new UserReportMap();
							
							map.addReport(x);
							map.addUser(user);
							map.setDirty(true);
							mappedReports.add(map);
							
							if(!user.hasRole(new Role("Role_View_Reports_")))
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
				Utilities.displayMessage("There are no Reports to map to selected User. Either they have all been mapped to the selected User or there are no " +
						"Reports in the System. Create some Reports to Map to selected User.");
			else
				Utilities.displayMessage("Select a Report to Proceed!");
		}
		
	}
	
	/**
	 * Checks if the manipulated object has a specified property.
	 * 
	 * @param report - property to check on object being manipulated.
	 * @param userMappedPermissions - List of available objects to check from.
	 * 
	 * @return <code> True only and only if(object.exists() == true)</code>
	 */
	private boolean hasProperty(Object report, List<UserReportMap> userMappedPermissions) {
		if(mappedReports != null){
			for(UserReportMap x : userMappedPermissions){
				if(x.getReportId() == ((Report) report).getReportId())
					return true;
			}
		}
		
		return false;
	}

	
	@Override
	UIViewLabels getMapViewLabels() {
		UIViewLabels labels = new UIViewLabels();
		labels.setLabel("User Reports");		
        
		labels.setRightListBoxLabel("Reports");    
        labels.setLeftListBoxLabel("User Reports");
        
        labels.setMapButtonText("Add Report");
        labels.setUnMapButtonText("Remove Report");
        
        labels.setAddButtonTitle("Adds the selected Report to the User.");
        labels.setRemoveButtonTitle("Removes the selected Report from the User.");
        
		return labels;
	}

	
	@Override
	protected void unMapItemFromObject() {
		if(mappedObjectsListBox.getSelectedIndex() > -1){
			for(Report xReport : reports){
				if(xReport.getName().equals(mappedObjectsListBox.getItemText(mappedObjectsListBox.getSelectedIndex()))){
					if(!user.hasAdministrativePrivileges()){
						UserReportMap map = getUserReportMap(xReport);
						deletedUserMappedReports.add(map);
											
						unMappedObjectsListBox.addItem(xReport.getName());
						mappedObjectsListBox.removeItem(mappedObjectsListBox.getSelectedIndex());
						
						List<UserReportMap> userMappedReportsX = RolesListUtil.getPermissionResolver().getUserMappedReports(user, mappedReports);
						if(userMappedReportsX.size() < 1)
							RolesListUtil.removeViewReportsRoleAddedOnMap(user);
						
						break;
					}
				}
			}
		}
		else{
			if(unMappedObjectsListBox.getItemCount() < 0)
				Utilities.displayMessage("There are no Reports mapped to selected User.");
			else
				Utilities.displayMessage("Select a Report to Proceed!");
		}
		
	}
	
	/**
	 * Retrieves a <code>UserReportMap</code> give a <code>Report.</code>
	 * 
	 * @param xReport <code>Report</code> to retrieve map for.
	 * @return Map if exists in the list.
	 */
	private UserReportMap getUserReportMap(Report xReport) {
		for(UserReportMap map : mappedReports){
			if(map.getUserId() == user.getUserId() && map.getReportId() == xReport.getReportId())
				return map;
		}
		
		return null;
	}

	/**
	 * @param deletedUserMappedReports
	 */
	public void setDeletedUserMappedReports(List<UserReportMap> deletedUserMappedReports) {
		this.deletedUserMappedReports = deletedUserMappedReports;
		
	}

	/**
	 * @param userMappedReports
	 */
	public void setUserMappedReports(List<UserReportMap> userMappedReports) {
		this.mappedReports = userMappedReports;
		
	}

	
	@Override
	protected void saveMap() {
		// We save all the User Mapped Reports
		MainViewControllerFacade.saveMappedReports();
		
	}
}
