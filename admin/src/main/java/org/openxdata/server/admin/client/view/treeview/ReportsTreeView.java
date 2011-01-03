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
import java.util.List;
import java.util.Vector;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.controller.observe.ReportsObserver;
import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.constants.OpenXDataStackPanelConstants;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.view.listeners.OpenXDataViewApplicationEventListener;
import org.openxdata.server.admin.client.view.treeview.listeners.ExtendedContextInitMenuListener;
import org.openxdata.server.admin.client.view.widget.CompositeTreeItem;
import org.openxdata.server.admin.client.view.widget.TreeItemWidget;
import org.openxdata.server.admin.model.Report;
import org.openxdata.server.admin.model.ReportGroup;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.mapping.UserReportGroupMap;
import org.openxdata.server.admin.model.mapping.UserReportMap;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * This widget displays a list of reports and their groups to the user in a hierarchical view.
 * 
 * @author daniel
 * @author Angel
 *
 */
public class ReportsTreeView extends OpenXDataBaseTreeView implements ExtendedContextInitMenuListener, OpenXDataViewApplicationEventListener, ReportsObserver {
	
	/** List of deleted reports. */
	private List<Report> deletedReports;
	
	/** List of report groups. */
	private List<ReportGroup> reportGroups;
	
	/** List of deleted report groups. */
	private List<ReportGroup> deletedReportGroups;

	private List<UserReportGroupMap> mappedReportGroups;
	
	/**
	 * Creates a new instance of the reports tree view.
	 * @param openXDataViewFactory 
	 */
	public ReportsTreeView(OpenXDataViewFactory openXDataViewFactory){
		super("Reports",openXDataViewFactory);
	}
	
	@Override
	protected void setUp() {
		
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
	 * Loads a list of report groups and their contained child reports and groups.
	 * 
	 * @param reportGroups the report group list.
	 */
	public void loadReportGroups(List<ReportGroup> reportGroups){
		this.reportGroups = reportGroups;
		deletedReports = new Vector<Report>();
		deletedReportGroups = new Vector<ReportGroup>();
		
		User user = Context.getAuthenticatedUser();		
		if(isLoadData()){
			tree.clear();
			if(reportGroups == null){
				reportGroups = new Vector<ReportGroup>();
				return;
			}
			
			if(Context.getAuthenticatedUser().hasAdministrativePrivileges()){
				
				loadReports(reportGroups);
			}
			else if(!Context.getAuthenticatedUser().hasAdministrativePrivileges()){
				if(mappedReportGroups != null){
					List<UserReportGroupMap> userMappedReports = getUserMappedReportGroups(user);
					
					for(byte i=0; i<reportGroups.size(); i++){
						if(userMappedReports != null){
							for(UserReportGroupMap map : userMappedReports){
								List<ReportGroup> mapGroup = new Vector<ReportGroup>();								
								mapGroup.add(getReportGroup(map));
								loadReports(mapGroup);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Retrieves a given <tt>User's mapped Report Groups.</tt>
	 * 
	 * @param user <tt>User</tt> to retrieve <tt>Report Groups</tt> for.
	 * @return <tt>List</tt> of <tt>UserReportGroupMaps.</tt>
	 */
	private List<UserReportGroupMap> getUserMappedReportGroups(User user) {
		List<UserReportGroupMap> xUserMappedReportGroups = new Vector<UserReportGroupMap>();
		for(UserReportGroupMap map : mappedReportGroups){
			if(map.getUserId() == user.getUserId()){
				xUserMappedReportGroups.add(map);
			}
		}
		
		return xUserMappedReportGroups;
	}

	private ReportGroup getReportGroup(UserReportGroupMap map) {
		ReportGroup reportGroup = null;		
		for(ReportGroup grp : reportGroups){
			if(isGroupParentReportGroup(map, grp)){
				reportGroup = grp;
				break;
			}
		}
		
		return reportGroup;
	}

	private boolean isGroupParentReportGroup(UserReportGroupMap map, ReportGroup grp) {
		for(Report rpt : grp.getReports()){
			if(rpt.getReportId() == map.getReportGroupId())
				return true;
		}
		
		return false;
	}

	private void loadReports(List<ReportGroup> reportGroups) {
		TreeItem root; 
		ReportGroup reportGroup;
		for(int i=0; i<reportGroups.size(); i++){
			reportGroup = reportGroups.get(i);
			if(reportGroup.getParentReportGroup() == null){
				root = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), reportGroup.getName(),popup));
				root.setTitle(reportGroup.getDescription());
				root.setUserObject(reportGroup);
				tree.addItem(root);

				loadReportGroup(reportGroup,root);
			}
		}
		
	}

	/**
	 * Loads a report group as a child of a given parent tree item.
	 * 
	 * @param reportGroup the report group to load.
	 * @param parent the parent tree item.
	 */
	private void loadReportGroup(ReportGroup reportGroup,TreeItem parent){
		if(reportGroup.getReports() != null){
			for(Report report : reportGroup.getReports()){
				TreeItem item = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().filtersgroup(), report.getName(),popup));;
				item.setTitle(reportGroup.getDescription());
				item.setUserObject(report);
				parent.addItem(item);
			}
		}

		if(reportGroup.getGroups() != null){
			for(ReportGroup rptGroup : reportGroup.getGroups()){
				TreeItem item = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), rptGroup.getName(),popup));;
				item.setTitle(rptGroup.getDescription());
				item.setUserObject(rptGroup);
				parent.addItem(item);

				loadReportGroup(rptGroup,item);
			}
		}
	}

	/**
	 * Adds a new report group as a child of the selected tree item 
	 * which should be another report group.
	 */
	@Override
	public void addNewItem(){
		TreeItem parent = tree.getSelectedItem();

		if(parent != null && parent.getUserObject() instanceof Report){
			Window.alert("Please add a group to another group instead of report.");
			return;
		}

		ReportGroup reportGroup = new ReportGroup("New Report Group");
		TreeItem root = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), reportGroup.getName(),popup));
		root.setUserObject(reportGroup);
		reportGroup.setDirty(true);

		if(parent != null){
			parent.addItem(root);
			//((ReportGroup)parent.getUserObject()).addReportGroup(reportGroup);
			reportGroup.setParentReportGroup((ReportGroup)parent.getUserObject());

			if(!reportGroup.getParentReportGroup().isNew())
				reportGroups.add(reportGroup);
			else
				reportGroup.getParentReportGroup().addReportGroup(reportGroup);

			parent.setState(true);
		}
		else{
			tree.addItem(root);
			reportGroups.add(reportGroup);
		}

		tree.setSelectedItem(root);
	}

	/**
	 * Adds a new report group.
	 */
	public void addNewReportGroup(){
		ReportGroup reportGroup = new ReportGroup("New Report Group");
		TreeItem root = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), reportGroup.getName(),popup));
		root.setUserObject(reportGroup);
		reportGroup.setDirty(true);

		tree.addItem(root);
		reportGroups.add(reportGroup);
		tree.setSelectedItem(root);
	}

	/**
	 * Adds a new report as a child of the selected tree item 
	 * which must be a report group.
	 */
	public void addNewReport(){
		TreeItem item = tree.getSelectedItem();
		if(item == null)
			return;

		if(!(item.getUserObject() instanceof ReportGroup)){
			Window.alert("Please add the report to a group.");
			return;
		}

		Report report = new Report("New Report");
		TreeItem root = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().filtersgroup(), report.getName(),popup));
		root.setUserObject(report);
		report.setDirty(true);
		report.setDateCreated(new Date());
		report.setCreator(Context.getAuthenticatedUser());


		ReportGroup reportGroup = (ReportGroup)item.getUserObject();
		item.addItem(root);
		reportGroup.addReport(report);
		reportGroup.setDirty(true);
		report.setReportGroup(reportGroup);
		item.setState(true);

		tree.setSelectedItem(root);
	}

	@Override
	public void changeEditableProperties(Object item) {
		TreeItem treeItem = tree.getSelectedItem();
		if(item == null)
			return; //How can this happen?

		if(item instanceof Report){
			Report report = (Report)item;
			treeItem.setWidget(new TreeItemWidget(widgetFactory.getOpenXDataImages().filtersgroup(), report.getName(),popup));
			treeItem.setTitle(report.getDescription());
			report.setDirty(true);
		}
		else{
			ReportGroup reportGroup = (ReportGroup)item;
			treeItem.setWidget(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), reportGroup.getName(),popup));
			treeItem.setTitle(reportGroup.getDescription());
			reportGroup.setDirty(true);
		}
	}

	/**
	 * Gets the list of deleted reports.
	 * 
	 * @return the report list.
	 */
	public List<Report> getDeletedReports(){
		return deletedReports;
	}

	/**
	 * Gets the list of deleted report groups.
	 * 
	 * @return the report group list.
	 */
	public List<ReportGroup> getDeletedReportGroups(){
		return deletedReportGroups;
	}

	/**
	 * Deletes the selected report or group.
	 */
	@Override
	public void deleteSelectedItem(){
		TreeItem item = tree.getSelectedItem();
		if(item == null){
			//TODO add message for internationalization purposes
			Window.alert("Please first select the item to delete");
			return;
		}

		//TODO add message for internationalization purposes
		if( !Window.confirm("Do you really want to delete the selected item?"))
			return;

		if(item.getUserObject() instanceof Report){
			Report report = (Report)item.getUserObject();
			deletedReports.add(report);
			report.getReportGroup().removeReport(report);
			//report.getReportGroup().setDirty(true);
		}
		else{
			deletedReportGroups.add((ReportGroup)item.getUserObject());
			reportGroups.remove(item.getUserObject());
		}

		if(item.getParentItem() == null)
			Utilities.removeRootItem(tree, item);
		else
			item.remove();

		if(tree.getItemCount() == 0)
			itemSelectionListener.onItemSelected(this, null);
	}
	
	@Override
	UIViewLabels getContextMenuLabels() {
        UIViewLabels labels = new UIViewLabels();
        
        labels.setAddLabel(OpenXDataFacade.getOpenXDataConstants().label_addreportgroup());
        labels.setDeleteLabel(OpenXDataFacade.getOpenXDataConstants().label_deletereport());
        labels.setAddChildItemLabel(OpenXDataFacade.getOpenXDataConstants().label_addnewreport());
        labels.setDeleteChildItemLabel("Delete Report");
        return labels;
	}

	
	@Override
	public void addNewChildItem() {
		addNewReport();
		
	}

	/**
	 * Sets all the system <tt>UserReportMaps.</tt>
	 * 
	 * @param mappedReports <tt>UserReportMaps</tt> to set.
	 */
	public void setMappedReportGroups(List<UserReportGroupMap> mappedReports) {
		this.mappedReportGroups = mappedReports;
		
	}

	
	@Override
	public void update(OpenXDataObservable observable, Object observedModelObject) {
		//do nothing
	}

	
	@Override
	public void updateUserMappedReportGroups(OpenXDataObservable observable, List<UserReportGroupMap> userMappedReportGroups) {
		setMappedReportGroups(userMappedReportGroups);
		
	}

	
	@Override
	public void updateUserMappedReports(OpenXDataObservable observable,	List<UserReportMap> userMappedReports) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void updateReportGroups(OpenXDataObservable observable, List<ReportGroup> reportGroups) {
		loadReportGroups(reportGroups);
		
	}
	
	
	@Override
	public void onDeleteItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_REPORTS){
			if(RolesListUtil.getPermissionResolver().isDeleteReportGroups()){
				deleteSelectedItem();
			}
			else{
				Window.alert("You do not have sufficient priviledges to delete Report Groups and Reports! Contact your system administrator");
			}
		}		
	}

	
	@Override
	public void onNewChildItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_REPORTS){
			if(RolesListUtil.getPermissionResolver().isAddReportGroups()){
				addNewChildItem();
			}
			else{
				Window.alert("You do not have sufficient priviledges to add Report Groups and Reports! Contact your system administrator");
			}
		}
	}

	
	@Override
	public void onNewItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_REPORTS){
			if(RolesListUtil.getPermissionResolver().isAddReportGroups()){
				addNewItem();
			}
			else{
				Window.alert("You do not have sufficient priviledges to add Report Groups and Reports! Contact your system administrator");
			}
		}
	}

	
	@Override
	public void onRefresh() {
		MainViewControllerFacade.refreshData();
		
	}

	
	@Override
	public void onSave() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_REPORTS){
			MainViewControllerFacade.saveReports();
		}
	}

}