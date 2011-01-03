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
package org.openxdata.server.admin.client.view.bar;

import java.util.List;
import java.util.Vector;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.VersionInfo;
import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.listeners.AppEventListener;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.view.event.dispatcher.ExtendedEventDispatcher;
import org.openxdata.server.admin.client.view.listeners.OpenXDataExportImportApplicationEventListener;
import org.openxdata.server.admin.client.view.listeners.OpenXDataViewApplicationEventListener;
import org.openxdata.server.admin.client.view.listeners.OpenXDataViewExtendedApplicationEventListener;
import org.openxdata.server.admin.client.view.widget.factory.OpenXDataWidgetFactory;
import org.openxdata.server.admin.model.Locale;
import org.openxdata.server.admin.model.User;
import org.purc.purcforms.client.util.FormUtil;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PushButton;

/**
 * 
 * Encapsulates <tt>Tool Bar</tt> controls on the view.
 *  
 * @author Angel
 *
 */
public class OpenXDataToolBar extends Composite implements ExtendedEventDispatcher {
	

	/** The tool bar buttons. */
	private static PushButton btnCut;
	private static PushButton btnCopy;
	private static PushButton btnPaste;
	private static PushButton btnLogout;
	private static PushButton btnRefresh;
	private static PushButton btnNewItem;
	private static PushButton btnSameSize;
	private static PushButton btnAlignTop;
	private static PushButton btnSave;
	private static PushButton btnOpenForm;
	private static PushButton btnAlignLeft;
	private static PushButton btnSameWidth;
	private static PushButton btnMoveItemUp;
	private static PushButton btnAlignRight;
	private static PushButton btnSameHeight;
	private static PushButton btnDeleteItem;
	private static PushButton btnAddNewItem;
	private static PushButton btnAlignBottom;
	private static PushButton btnMoveItemDown;
	private static PushButton btnAddNewChildItem;
	

	/** The button to export the report to PDF format. */
	private PushButton btnPdf;

	/** Label to display the name of the currently logged on user. */
	private Label lblTitleUser;

	/** Widget to display the list of languages or locales. */
	private static ListBox cbLanguages;

	/** Main widget for this tool bar. */
	private static HorizontalPanel panel;

	/** Listener to the tool bar button click events. */
	private AppEventListener appEventListener;
	
	/** List of registered <tt>Event Listeners.</tt>*/
	private List<OpenXDataViewApplicationEventListener> viewApplicationEventListeners;
	
	/** Handle to <tt>Widget Factory.</tt>*/
	private OpenXDataWidgetFactory widgetFactory;	
	
	/** Constructs an instance of this <tt>class.</tt>*/
	public OpenXDataToolBar(){}
	
	/** Initialize <tt>Tool Bar widgets</tt> before binding them to the <tt>Tool Bar.</tt> */
	public void setUp(){
		
		//Initialize Panel to hold widgets.
		panel = new HorizontalPanel();
		
		//Initialize the Languages combo box
		cbLanguages = new ListBox(false);
		
		btnNewItem = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().newform()));
		btnOpenForm = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().open()));
		btnSave = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().save()));
		
		btnAddNewItem = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().add()));
		btnAddNewChildItem = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().addchild()));
		btnDeleteItem = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().delete()));
		btnMoveItemUp = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().moveup()));
		btnMoveItemDown = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().movedown()));
		
		btnAlignLeft = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().justifyleft()));
		btnAlignRight = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().justifyright()));
		btnAlignTop = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().alignTop()));
		btnAlignBottom = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().alignBottom()));
		btnSameWidth = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().samewidth()));
		btnSameHeight = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().sameheight()));
		btnSameSize = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().samesize()));
		
		btnCut = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().cut()));
		btnCopy = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().copy()));
		btnPaste = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().paste()));
		btnRefresh = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().loading()));
		btnPdf = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().pdf()));
		btnLogout = new PushButton(FormUtil.createImage(widgetFactory.getOpenXDataImages().logout()));
		
		btnNewItem.setTitle(OpenXDataFacade.getOpenXDataConstants().label_new());
		btnOpenForm.setTitle(OpenXDataFacade.getOpenXDataConstants().label_open());
		btnSave.setTitle(OpenXDataFacade.getOpenXDataConstants().label_save());
		
		btnAddNewItem.setTitle(OpenXDataFacade.getOpenXDataConstants().label_add_new());
		btnAddNewChildItem.setTitle(OpenXDataFacade.getOpenXDataConstants().label_add_new_child());
		btnDeleteItem.setTitle(OpenXDataFacade.getOpenXDataConstants().label_delete());
		btnMoveItemUp.setTitle(OpenXDataFacade.getOpenXDataConstants().label_move_up());
		btnMoveItemDown.setTitle(OpenXDataFacade.getOpenXDataConstants().label_move_down());
		
		btnCut.setTitle(OpenXDataFacade.getOpenXDataConstants().label_cut());
		btnCopy.setTitle(OpenXDataFacade.getOpenXDataConstants().label_copy());
		btnPaste.setTitle(OpenXDataFacade.getOpenXDataConstants().label_paste());
		btnRefresh.setTitle(OpenXDataFacade.getOpenXDataConstants().label_refresh());
		
		btnAlignLeft.setTitle(OpenXDataFacade.getOpenXDataConstants().label_align_left());
		btnAlignRight.setTitle(OpenXDataFacade.getOpenXDataConstants().label_align_right());
		btnAlignTop.setTitle(OpenXDataFacade.getOpenXDataConstants().label_align_top());
		btnAlignBottom.setTitle(OpenXDataFacade.getOpenXDataConstants().label_align_botton());
		btnSameWidth.setTitle(OpenXDataFacade.getOpenXDataConstants().label_make_same_width());
		btnSameHeight.setTitle(OpenXDataFacade.getOpenXDataConstants().label_make_same_height());
		btnSameSize.setTitle(OpenXDataFacade.getOpenXDataConstants().label_make_same_size());
		
		btnPdf.setTitle(OpenXDataFacade.getOpenXDataConstants().label_exporttopdf());
		btnLogout.setTitle(OpenXDataFacade.getOpenXDataConstants().label_logout());
		
		//Holds the Application Event Listeners registered on this class.
		viewApplicationEventListeners = new Vector<OpenXDataViewApplicationEventListener>();
		
		// Set up event listeners
		setupClickListeners();
		
		// Initialize widget.
		initWidget(panel);
		
		
	}
	
	/**
	 * Sets up event listeners for the buttons on the tool bar UI
	 */
	private void setupClickListeners(){
		
		btnNewItem.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyOnNewItemEventListeners();}});
		
		btnSave.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyOnSaveEventListeners();}});
		
		btnRefresh.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyOnRefreshEventListeners();}});
		
		btnAddNewItem.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyOnNewItemEventListeners();}});
		
		btnDeleteItem.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyOnDeleteItemEventListeners();}});
		
		btnAddNewChildItem.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyOnNewChildItemEventListeners();}});
		
		btnOpenForm.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyOnOpenEventListeners();}});
		
		btnMoveItemUp.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyMoveItemUpEventListeners();}});
		
		btnMoveItemDown.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyMoveItemDownEventListeners();}});
		
		btnAlignLeft.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyAlignLeftEventListeners();}});
		
		btnAlignRight.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyAlignRightEventListeners();}});
		
		btnAlignTop.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyAlignTopEventListeners();}});
		
		btnAlignBottom.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyAlignBottomEventListeners();}});
		
		btnCut.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyCutItemEventListeners();}});
		
		btnCopy.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyCopyItemEventListeners();}});
		
		btnPaste.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyPasteItemEventListeners();}});
		
		btnSameWidth.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyMakeSameWidthEventListeners();}});
		
		btnSameHeight.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyMakeSameHeightEventListeners();}});
		
		btnSameSize.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyMakeSameSizeEventListeners();}});
		
		
		btnPdf.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				notifyOnExportAsPdfEventListeners();}});
		
		btnLogout.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				appEventListener.onLogout();}
			
		});	
		
	}
	
	/**
	 * Arranges <tt>Widgets</tt> on the <tt>Tool Bar.</tt>
	 */
	private void setupLanguageToolBar() {	
		setCurrentlyLoggedOnUser();
		
		Label label = new Label(OpenXDataFacade.getOpenXDataConstants().label_language());
		panel.add(label);
		panel.setCellHorizontalAlignment(label,HasHorizontalAlignment.ALIGN_RIGHT);
		
		setUpLocaleEventListener();		
		panel.add(cbLanguages);
		panel.setCellHorizontalAlignment(cbLanguages,HasHorizontalAlignment.ALIGN_RIGHT);		
		panel.setSpacing(3);
	}

	/**
	 * Sets up the <tt>Event Listener</tt> for changing the <tt>Locale.</tt>
	 */
	private void setUpLocaleEventListener() {
		cbLanguages.addItem("English","en");
		cbLanguages.addItem("Luganda","lug");
		cbLanguages.addItem("Swahili","swa");
		cbLanguages.addItem("Lusoga","lus");
		cbLanguages.addItem("Runyankole","rny");
		cbLanguages.addItem("Lugisu","lugi");
		cbLanguages.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				Object sender = event.getSource();
				appEventListener.changeLocale(((ListBox)sender).getValue(((ListBox)sender).getSelectedIndex()));
			}
		});
	}
	
	/**
	 * Sets the title on the <tt>Tool Bar</tt> to the currently logged in <tt>User.</tt>
	 */
	private void setCurrentlyLoggedOnUser(){
		String name = "";
		lblTitleUser = new Label();
		User user = Context.getAuthenticatedUser();
		
		if(user != null)
			name = user.getFullName().trim();
		
		if(panel.getWidgetIndex(lblTitleUser) < 0){
			panel.add(lblTitleUser);
			panel.setCellWidth(lblTitleUser,"100%");
			panel.setCellHorizontalAlignment(lblTitleUser,HasHorizontalAlignment.ALIGN_CENTER);
		}
		
		lblTitleUser.setText("OpenXData " + VersionInfo.VERSION + "  (User:" + name +")");
	}
	
	/**
	 * Refreshes the dash board and reloads data
	 */
	public void refresh(){
		MainViewControllerFacade.refreshData();
	}

	/**
	 * Utility method to bind specific add buttons
	 */
	private void bindMenuBarFunctionalButtons() {
		
		panel.add(btnNewItem);
		panel.add(btnOpenForm);
		panel.add(btnSave);
		panel.add(btnAddNewItem);
		panel.add(btnAddNewChildItem);
	}

	/**
	 * Sets the panel properties(spacing)
	 * Also add the title for the user
	 */
	private void setUpPanel() {
		setupLanguageToolBar();
		
		panel.add(cbLanguages);
		panel.setCellHorizontalAlignment(cbLanguages,HasHorizontalAlignment.ALIGN_RIGHT);

		//Set a 3 pixels spacing between tool bar buttons.
		panel.setSpacing(3);
	}

	/**
	 * Utility method to bind specific edit buttons
	 */
	private void bindClipBoardButtons() {
		
		panel.add(btnCut);
		panel.add(btnCopy);
		panel.add(btnPaste);
		panel.add(btnDeleteItem);
		
		panel.add(btnRefresh);
	}

	/**
	 * Utility method to bind specific view buttons
	 */
	private void bindAlignmentButtons() {
		
		panel.add(btnMoveItemUp);
		panel.add(btnMoveItemDown);
		
		panel.add(btnAlignLeft);
		panel.add(btnAlignRight);
		panel.add(btnAlignTop);
		panel.add(btnAlignBottom);
		panel.add(btnSameWidth);
		panel.add(btnSameHeight);
		panel.add(btnSameSize);
		
		panel.add(btnRefresh);
	}
	
	/**
	 * Adds extra buttons to the <tt>Tool Bar.</tt>
	 */
	private void bindExtraButtons(){
		panel.add(btnPdf);
	}
	
	/**
	 * Refreshes the <tt>Locales.</tt>
	 */
	public void refreshLocales(){
		cbLanguages.clear();

		List<Locale> locales = Context.getLocales();
		if(locales != null){
			for(Locale locale : locales)
				cbLanguages.addItem(locale.getName(), locale.getKey());
		}
	}

	/**
	 * Sets the Log out button of the tool bar
	 */
	private void addLogoutButton() {
		panel.add(btnLogout);
		
	}
		
	/**
	 * Creates an administrative <tt>Tool Bar.</tt>
	 * 
	 * @return instance of {@link OpenXDataToolBar}
	 */
	public OpenXDataToolBar instanceOfAdminUser() {
		this.bindMenuBarFunctionalButtons();
		this.bindClipBoardButtons();
		this.bindAlignmentButtons();
		this.bindExtraButtons();
		
		this.addLogoutButton();
		
		this.setUpPanel();		
		
		return this;
	}

	/**
	 * Creates a <tt>Tool Bar</tt> according to <tt>User Permissions.</tt>
	 * 
	 * @return instance of {@link OpenXDataToolBar}
	 */
	public OpenXDataToolBar instanceOfUserPermissions() {
		
		if(RolesListUtil.getPermissionResolver().isAddPermission()){
			this.bindMenuBarFunctionalButtons();			
		}	
		
		if(RolesListUtil.getPermissionResolver().isEditPermission()){
			this.bindClipBoardButtons();
		}
		if(RolesListUtil.getPermissionResolver().isViewPermission()){
			this.bindAlignmentButtons();
			this.bindExtraButtons();
		}
		
		this.addLogoutButton();
		
		this.setUpPanel();
		
		return this;
	}
	
	@Override
	public void setApplicationEventListener(AppEventListener applicationEventListener){
		this.appEventListener = applicationEventListener;
	}
		
	@Override
	public void registerApplicationEventListener(OpenXDataViewApplicationEventListener eventListener){
		viewApplicationEventListeners.add(eventListener);
	}
	
	@Override
	public void removeApplicationEventListener(OpenXDataViewApplicationEventListener eventListener){
		viewApplicationEventListeners.remove(eventListener);
	}
	
	@Override
	public void registerAdvancedApplicationEventListener(OpenXDataViewExtendedApplicationEventListener eventListener){
		viewApplicationEventListeners.add(eventListener);
	}
	
	@Override
	public void removeAdvancedApplicationEventListener(OpenXDataViewExtendedApplicationEventListener eventListener){
		viewApplicationEventListeners.remove(eventListener);
	}

	@Override
	public void notifyAlignBottomEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).alignBottom();
			}
		}
	}

	@Override
	public void notifyAlignLeftEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).alignLeft();		
			}
		}		
	}

	@Override
	public void notifyAlignRightEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).alignRight();				
			}
		}
	}

	@Override
	public void notifyAlignTopEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).alignTop();				
			}
		}
	}

	@Override
	public void notifyCopyItemEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).copyItem();				
			}
		}
	}

	@Override
	public void notifyCutItemEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).cutItem();				
			}
		}
	}

	@Override
	public void notifyMakeSameHeightEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).makeSameHeight();				
			}
		}
	}

	@Override
	public void notifyMakeSameSizeEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).makeSameSize();				
			}
		}
	}

	@Override
	public void notifyMakeSameWidthEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).makeSameWidth();				
			}
		}
	}

	@Override
	public void notifyMoveItemDownEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).moveItemDown();				
			}
		}
	}

	@Override
	public void notifyMoveItemUpEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).moveItemUp();				
			}
		}
	}

	@Override
	public void notifyOpenFormEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).openForm();				
			}
		}
	}

	
	@Override
	public void notifyPasteItemEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).pasteItem();				
			}
		}
	}

	@Override
	public void notifyOnExportEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataExportImportApplicationEventListener)xViewAppEventListener).onExport();				
			}
		}	
	}

	@Override
	public void notifyOnFormatEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataViewExtendedApplicationEventListener){
				((OpenXDataViewExtendedApplicationEventListener)xViewAppEventListener).format();				
			}
		}
	}

	@Override
	public void notifyOnImportEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataExportImportApplicationEventListener){
				((OpenXDataExportImportApplicationEventListener)xViewAppEventListener).onImport();				
			}
		}
	}

	@Override
	public void notifyOnNewItemEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			xViewAppEventListener.onNewItem();
		}
	}

	@Override
	public void notifyOnOpenEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataExportImportApplicationEventListener){
				((OpenXDataExportImportApplicationEventListener)xViewAppEventListener).onOpen();
			}
		}		
	}

	
	@Override
	public void notifyOnRefreshEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			xViewAppEventListener.onRefresh();
		}
	}

	@Override
	public void notifyOnSaveEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			xViewAppEventListener.onSave();
		}
	}

	@Override
	public void notifyOnNewChildItemEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			xViewAppEventListener.onNewChildItem();
		}
	}

	@Override
	public void notifyOnExportAsPdfEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			if(xViewAppEventListener instanceof OpenXDataExportImportApplicationEventListener){
				((OpenXDataExportImportApplicationEventListener)xViewAppEventListener).exportAsPdf();				
			}
		}
	}

	@Override
	public void notifyOnDeleteItemEventListeners() {
		for(OpenXDataViewApplicationEventListener xViewAppEventListener : viewApplicationEventListeners){
			xViewAppEventListener.onDeleteItem();
		}
	}

	@Override
	public void registerExportImportApplicationEventListener(OpenXDataExportImportApplicationEventListener eventListener) {
		viewApplicationEventListeners.add(eventListener);
		
	}

	@Override
	public void removeExportImportApplicationEventListener(OpenXDataExportImportApplicationEventListener eventListener) {
		viewApplicationEventListeners.remove(eventListener);
		
	}

	/**
	 * Sets the <tt>Widget Factory.</tt>
	 * 
	 * @param widgetFactory <tt>Widget Factory to set.</tt>
	 */
	public void setWidgetFactory(OpenXDataWidgetFactory widgetFactory) {
		this.widgetFactory = widgetFactory;
		
	}
}
