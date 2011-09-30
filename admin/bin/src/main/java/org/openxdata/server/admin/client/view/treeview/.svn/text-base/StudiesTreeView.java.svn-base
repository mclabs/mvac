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

import java.util.List;
import java.util.Vector;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.controller.observe.StudiesObserver;
import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.listeners.GetFileNameDialogEventListener;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.DataCheckUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.StudyView;
import org.openxdata.server.admin.client.view.bar.OpenXDataMenuBar;
import org.openxdata.server.admin.client.view.constants.OpenXDataStackPanelConstants;
import org.openxdata.server.admin.client.view.dialogs.FormVersionOpenDialog;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.view.helper.StudiesTreeViewHelper;
import org.openxdata.server.admin.client.view.listeners.FormVersionOpenDialogListener;
import org.openxdata.server.admin.client.view.listeners.OnDataCheckListener;
import org.openxdata.server.admin.client.view.listeners.OpenXDataExportImportApplicationEventListener;
import org.openxdata.server.admin.client.view.treeview.listeners.ExtendedContextInitMenuListener;
import org.openxdata.server.admin.model.Editable;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.mapping.UserFormMap;
import org.openxdata.server.admin.model.mapping.UserStudyMap;
import org.purc.purcforms.client.controller.OpenFileDialogEventListener;
import org.purc.purcforms.client.util.FormUtil;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * This widgets displays studies, their forms and versions in a tree view format.
 * 
 * @author daniel
 * @author Angel 
 *
 */
public class StudiesTreeView extends OpenXDataBaseTreeView implements OnDataCheckListener, FormVersionOpenDialogListener, GetFileNameDialogEventListener, 
			 OpenFileDialogEventListener, ExtendedContextInitMenuListener, StudiesObserver, OpenXDataExportImportApplicationEventListener {


	/** The list of studies. */
	private List<StudyDef> studies;
	
	/** Flag to indicate if */
	private boolean deleteData = false;
	
	/** The list of deleted studies. */
	private List<StudyDef> deletedStudies;

	/** The list of user mapped studies. */
	private List<UserStudyMap> mappedStudies;
	
	@SuppressWarnings("unused")
	private List<UserFormMap> mappedForms;	
	
	/** Handle to data check utility instance of {@linkplain DataCheckUtil}.*/
	private DataCheckUtil dataCheck = new DataCheckUtil(this);	
	
	/**
	 * Creates a new instance of the studies tree view.
	 * @param openXDataViewFactory 
	 */
	public StudiesTreeView(OpenXDataViewFactory openXDataViewFactory){		
		super("Studies", openXDataViewFactory);
	} 

	@Override
	public void setUp(){
		
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
		
		// Maximize this widget
		Utilities.maximizeWidget(this);
		
		// Initialize the Context Menu.
		popup = initContextMenu();
		
		// Sets up the Helper class.
		initializeHelper();
		
	}

	/**
	 * Initializes the helper class.
	 */
	private void initializeHelper() {
		
		// Set the pop up Panel
		StudiesTreeViewHelper.setPopupPanel(popup);
		
		// Set the Tree
		StudiesTreeViewHelper.setTree(tree);
		
		//Inject WidgetFactory into StudiesTreeViewHelper
		StudiesTreeViewHelper.setWidgetFactory(widgetFactory);
	}

	/**
	 * Adds more studiesTreeView specific items
	 */
	protected PopupPanel initContextMenu() {
		PopupPanel popup = super.initContextMenu(this);
		if(popup != null){
			MenuBar menuBar = (MenuBar)popup.getWidget();
			if(menuBar != null){
				addAdminControlsToContextMenu(menuBar);
			}
		}
		
		return popup;
	}

	/**
	 * Adds <tt>StudiesTreeView</tt> specific controls to the <tt>Context Menu.</tt>
	 * 
	 * @param menuBar {@link OpenXDataMenuBar} to add controls to.
	 */
	private void addAdminControlsToContextMenu(MenuBar menuBar) {
		
		if(RolesListUtil.getPermissionResolver().isExtraPermission("Design Form Version")){
			menuBar.addSeparator();
			menuBar.addItem(Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().add(), "Design Form version"), true, new Command(){
				@Override
				public void execute(){popup.hide();designItem();}
			});
		}

		if(RolesListUtil.getPermissionResolver().isExtraPermission("Export Item")){
			menuBar.addSeparator();
			menuBar.addItem(Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().add(), "Export Item"),true, new Command(){
				@Override
				public void execute(){popup.hide();exportSelectedItem();}
			});
		}
		
		if(RolesListUtil.getPermissionResolver().isExtraPermission("Import Item")){
			menuBar.addSeparator();
			menuBar.addItem(Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().add(), "Import Item"), true, new Command(){
				@Override
				public void execute(){popup.hide(); importSelectedItem();}
			});
		}
	}

	/**
	 * Displays a list of studies in the view.
	 * 
	 * @param studies the study list.
	 */
	public void loadStudies(List<StudyDef> studies){
		tree.clear();			
		
		this.studies = studies;
		deletedStudies = new Vector<StudyDef>();
		User user = Context.getAuthenticatedUser();
		
		if(isLoadData()){
			
			if(studies == null){				
				studies = new Vector<StudyDef>();
				studies = Context.getStudies();
				return;
			}
			
			if(Context.getAuthenticatedUser().hasAdministrativePrivileges()){				
				StudiesTreeViewHelper.loadAllStudies(studies);
			}
			else if(!Context.getAuthenticatedUser().hasAdministrativePrivileges()){
				StudiesTreeViewHelper.loadStudiesAccordingToUserPrivileges(studies, user, mappedStudies);
			}
		}
	}
	
	/**
	 * Displays a list of Forms in the <tt>Tree View.</tt>
	 * 
	 * @param mappedForms the Forms list.
	 */
	private void loadMappedForms(List<UserFormMap> mappedForms) {
		
		this.mappedForms = mappedForms;
		User user = Context.getAuthenticatedUser();
		if(!user.hasAdministrativePrivileges()){
			StudiesTreeViewHelper.loadMappedForms(user, mappedForms);
		}
	}

	/**
	 * Loads a study and its contents in this view.
	 * 
	 * @param studyDef the study definition object.
	 */
	public void loadStudy(StudyDef studyDef){
		StudiesTreeViewHelper.loadStudy(studyDef);
	}

	/**
	 * @see org.openxdata.server.admin.client.listeners.AppEventListener#onNewItem()
	 */
	@Override
	public void addNewItem(){
		addNewItem(null);
	}

	/**
	 * Adds a new item with an optional xform.
	 * 
	 * @param xForm the xforms xml.
	 */
	public void addNewItem(String xForm){
		StudiesTreeViewHelper.addNewItem(xForm, tree, studies, popup);
	}

	/**
	 * @see org.openxdata.server.admin.client.listeners.AppEventListener#onNewChildItem()
	 */
	@Override
	public void addNewChildItem(){
		StudiesTreeViewHelper.addNewChildItem(tree, studies, popup);
	}

	/**
	 * Designs the selected form version.
	 */
	private void designItem(){
		//TODO Should do this through an interface		
		deleteData = false;
		if(itemSelectionListener instanceof StudyView) {
			dataCheck.itemHasFormData((Editable)tree.getSelectedItem().getUserObject());
		}
	}

	/**
	 * Deletes the selected question.
	 */
	@Override
	public void deleteSelectedItem(){
		
		deleteData = true;
		TreeItem item = tree.getSelectedItem();
		if(item == null){
			//TODO add message for internationalization purposes
			Window.alert("Please first select the item to delete");
			return;
		}
		
		dataCheck.itemHasFormData((Editable) item.getUserObject());

	}

	/**
	 * Deletes the selected study, form, or form version.
	 */
	private void deleteItem() {

		FormUtil.dlg.hide();
		
		TreeItem parent = item.getParentItem();

		boolean inCutMode = false;
		if(!inCutMode && !Window.confirm(getDeleteMessage(item.getUserObject())))
			return;

		if(parent != null){
			int index = parent.getChildIndex(item);

			//If last item is the one selected, the select the previous, else the next.
			if(index == parent.getChildCount()-1)
				index -= 1;

			removeFormDefItem(item,parent);

			//Remove the selected item.
			item.remove();

			//If no more kids, then select the parent.
			if(parent.getChildCount() == 0)
				tree.setSelectedItem(parent);
			else
				tree.setSelectedItem(parent.getChild(index));
		}
		else{ //Must be the study root
			deletedStudies.add((StudyDef)item.getUserObject());
			studies.remove(item.getUserObject());
			Utilities.removeRootItem(tree, item);

			if(tree.getItemCount() == 0)
				itemSelectionListener.onItemSelected(this, null);
		}
	}

	/**
	 * Gets the delete confirm message.
	 * 
	 * @param item the item about to be deleted.
	 * @return the delete confirm message.
	 */
	private String getDeleteMessage(Object item){
		return StudiesTreeViewHelper.getDeleteMessage(item, tree);
	}

	private void removeFormDefItem(TreeItem item, TreeItem parent){
		StudiesTreeViewHelper.removeFormDefItem(item, parent);
	}

	@Override
	public void changeEditableProperties(Object item) {
		StudiesTreeViewHelper.changeEditableProperties(item, tree, popup);
	}
	
	public List<StudyDef> getDeletedStudies(){
		return deletedStudies;
	}

	/**
	 * Checks if the list of studies is valid for saving.
	 * 
	 * @return true if valid, else false.
	 */
	public boolean isValidStudyList(){
		return StudiesTreeViewHelper.isValidStudyList(tree);
	}

	@Override
	public void onOptionSelected(int option) {		
		StudiesTreeViewHelper.onOptionSelected(option, tree, item, itemSelectionListener, popup);

	}

	public void importSelectedItem(){
		StudiesTreeViewHelper.importSelectedItem(this);
	}

	public void exportSelectedItem(){
		StudiesTreeViewHelper.exportSelectedItem(item, this);
	}

	@Override
	public void onSetFileName(String fileName){
		StudiesTreeViewHelper.onSetFileName(fileName, item);
	}

	@Override
	public void onSetFileContents(String contents) {
		StudiesTreeViewHelper.onSetFileContents(tree, item, contents, popup);
	}

	@Override
	public void onDataCheckComplete(boolean hasData, String currentItem) {
		
		FormUtil.dlg.hide();
		
		/* Dialog to determine that option to take in regard to Editable with data.*/
		FormVersionOpenDialog versionOpenDialog =  new FormVersionOpenDialog(this);
		
		if(!deleteData){
			if(hasData){					
				versionOpenDialog.setTitle(OpenXDataFacade.getOpenXDataConstants().label_formversionedittitle());
				versionOpenDialog.center();
			}
			else{
				((StudyView)itemSelectionListener).designItem(false, tree.getSelectedItem().getUserObject());
			}
		}
		else if(deleteData){
			
			if(hasData){
				versionOpenDialog.hide();
				Window.alert("The selected { " + currentItem + " } has data and cannot be deleted!");
			}
			else
				deleteItem();
		}
		
	}

	@Override
	UIViewLabels getContextMenuLabels() {
        UIViewLabels labels = new UIViewLabels();
        
        labels.setAddLabel(OpenXDataFacade.getOpenXDataConstants().label_addnewstudy());
        labels.setAddChildItemLabel(OpenXDataFacade.getOpenXDataConstants().label_addnewform());
        
        labels.setDeleteLabel(OpenXDataFacade.getOpenXDataConstants().label_delete_selected());
        labels.setDeleteChildItemLabel(OpenXDataFacade.getOpenXDataConstants().label_deleteform());
        
        return labels;
	}

	@Override
	public void update(OpenXDataObservable observable, Object observedModelObject) {
		//do nothing
	}

	@Override
	public void updateStudies(OpenXDataObservable observable, List<StudyDef> studies) {
		loadStudies(studies);
	}

	@Override
	public void updateUserMappedForms(OpenXDataObservable observable, List<UserFormMap> userMappedForms) {
		loadMappedForms(userMappedForms);		
	}

	@Override
	public void updateUserMappedStudies(OpenXDataObservable observable, List<UserStudyMap> userMappedStudies) {
		this.mappedStudies = userMappedStudies;
	}

	@Override
	public void exportAsPdf() {
		//do nothing
		
	}
	
	@Override
	public void onDeleteItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_STUDIES){
			if(RolesListUtil.getPermissionResolver().isDeleteStudies()){
				deleteSelectedItem();
			}
			else{
				Window.alert("You do not have sufficient priviledges to delete Studies, forms and form versions! Contact your system administrator");
			}
		}
	}
	
	@Override
	public void onExport() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_STUDIES){
			if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Export_Studies")){
				exportSelectedItem();
			}
			else{
				Window.alert("You do not have sufficient privileges to export Studies");
			}
		}
		
	}
		
	@Override
	public void onImport() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_STUDIES){
			if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Import_Studies")){
				importSelectedItem();
			}
			else{
				Window.alert("You do not have sufficient privileges to import Users!");
			}
		}
		
	}
	
	@Override
	public void onNewChildItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_STUDIES){
			if(RolesListUtil.getPermissionResolver().isAddStudies()){
				if(!((StudyView) widgetFactory.getStudyView()).isInFormDesignMode()){
					addNewChildItem();
				}
			}
			else{
				Window.alert("You do not have sufficient priviledges to add Studies, forms and form versions! Contact your system administrator");
			}
		}
	}
		
	@Override
	public void onNewItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_STUDIES){
			if(RolesListUtil.getPermissionResolver().isAddStudies()){
				if(!((StudyView) widgetFactory.getStudyView()).isInFormDesignMode()){
					addNewItem();
				}
			}
			else{
				Window.alert("You do not have sufficient priviledges to add Studies, forms and form versions! Contact your system administrator");
			}
		}
	}
		
	@Override
	public void onOpen() {
		if(((StudyView) widgetFactory.getStudyView()).isInFormDesignMode())
			((StudyView) widgetFactory.getStudyView()).openForm();
		else
			onImport();
		
	}
		
	@Override
	public void onRefresh() {
		MainViewControllerFacade.refreshData();
		
	}
	
	@Override
	public void onSave() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_STUDIES){
			MainViewControllerFacade.saveStudies();
		}
	}
}
