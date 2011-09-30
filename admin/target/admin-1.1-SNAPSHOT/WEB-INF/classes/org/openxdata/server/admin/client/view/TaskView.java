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

import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.model.TaskDef;

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
 * Encapsulates properties of the selected task and lets you manipulate them.
 * 
 * @author daniel
 * @author Angel
 *
 */
public class TaskView extends OpenXDataBaseView {

	/** Widget for entering the name of the task. */
	private TextBox txtName;
	
	/** Widget for entering the description of the task. */
	private TextBox txtDescription;
	
	/** Widget for entering the class of the task. */
	private TextBox txtClass;

	/** Label to show whether a task is running or not. */
	private Label lblStarted;
	
	/** Widget for scheduling the task. */
	private ScheduleView scheduleView;
	
	/** Widget for displaying the task parameter list. */
	private ParametersView parametersView;

	/** The task definition object. */
	private TaskDef taskDef;

	/**
	 * Creates a new instance of the task view.
	 * 
	 * @param itemChangeListener listener to <tt>Task</tt> property changes.
	 * @param openXDataViewFactory 
	 */
	public TaskView(ItemChangeListener itemChangeListener, OpenXDataViewFactory openXDataViewFactory){
		super(itemChangeListener, openXDataViewFactory);
		
		this.itemChangeListener = itemChangeListener;
	}

	
	@Override
	protected void setUp() {
		
		txtName = new TextBox();
		
		txtDescription = new TextBox();
		
		txtClass = new TextBox();
		
		lblStarted = new Label("false");
		
		scheduleView = new ScheduleView();
		
		parametersView = new ParametersView();
		
		openxdataStackPanel = widgetFactory.getOpenXdataStackPanel();
		
		//Register this class with Event Dispatchers.
		super.registerWithEventDispatchers();
		
		if(RolesListUtil.getPermissionResolver().isPermission("Tasks")){
			loadView();
		}
		else loadPermissionLessView();
		
	}

	private void loadPermissionLessView() {
		table.setWidget(0, 0, new Label(OpenXDataFacade.getOpenXDataConstants().ascertain_permissionLessView() + "Tasks"));
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

	private void loadView() {
		table.setWidget(0, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_name()));
		table.setWidget(1, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_description()));
		table.setWidget(2, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_class()));
		table.setWidget(3, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_started()));

		table.setWidget(0, 1, txtName);
		table.setWidget(1, 1, txtDescription);
		table.setWidget(2, 1, txtClass);
		table.setWidget(3, 1, lblStarted);

		txtName.setWidth("100%");
		txtDescription.setWidth("100%");
		txtClass.setWidth("100%");

		FlexCellFormatter cellFormatter = table.getFlexCellFormatter();
		cellFormatter.setWidth(0, 0, "20%");
		cellFormatter.setColSpan(0, 1, 2);
		cellFormatter.setColSpan(1, 1, 2);
		cellFormatter.setColSpan(2, 1, 2);
		cellFormatter.setColSpan(3, 1, 2);

		table.getRowFormatter().removeStyleName(0, "FlexTable-Header");
		table.setStyleName("cw-FlexTable");
		Utilities.maximizeWidget(table);

		tabs.add(table, OpenXDataFacade.getOpenXDataConstants().label_definition());
		
		if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Task_Scheduling")){
			tabs.add(scheduleView, OpenXDataFacade.getOpenXDataConstants().label_schedule());
		}
		if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Task_Adding_Parameter")){
			tabs.add(parametersView, OpenXDataFacade.getOpenXDataConstants().label_parameters());
		}			
		
		Utilities.maximizeWidget(tabs);

		initWidget(tabs);

		setWidth("100%");
		setupEventListeners();
		tabs.selectTab(0);
		
		setEnabled(false);
	}

	/**
	 * Sets up event listeners.
	 */
	private void setupEventListeners(){
		txtName.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateName();
			}
		});
		txtName.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updateName();
				if(event.getCharCode() == KeyCodes.KEY_ENTER)
					txtDescription.setFocus(true);
			}
		});

		txtDescription.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateDescription();
			}
		});
		txtDescription.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updateDescription();
				if(event.getCharCode() == KeyCodes.KEY_ENTER)
					txtClass.setFocus(true);
			}
		});

		txtClass.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateClass();
			}
		});
		txtClass.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updateClass();
			}
		});
	}

	/**
	 * Updates a task with the new name as typed by the user.
	 * 
	 * @param sender the widget having the new name.
	 */
	private void updateName(){
		taskDef.setName(txtName.getText());
		itemChangeListener.onItemChanged(taskDef);
	}

	/**
	 * Updates a task with the new description as typed by the user.
	 * 
	 * @param sender the widget having the new description.
	 */
	private void updateDescription(){
		taskDef.setDescription(txtDescription.getText());
		itemChangeListener.onItemChanged(taskDef);
	}

	/**
	 * Updates a parameter with the new class as typed by the user.
	 * 
	 * @param sender the widget having the new class.
	 */
	private void updateClass(){
		taskDef.setTaskClass(txtClass.getText());
		itemChangeListener.onItemChanged(taskDef);
	}

	/**
	 * @see org.openxdata.server.admin.client.listeners.ItemSelectionListener#onItemSelected(Composite, Object)
	 */
	@Override
	public void onItemSelected(Composite sender,Object item) {
		setEnabled(item != null);

		if(item == null)
			clear();
		else{
			taskDef = (TaskDef)item;

			txtName.setText(taskDef.getName());
			txtDescription.setText(taskDef.getDescription());
			txtClass.setText(taskDef.getTaskClass());
			lblStarted.setText(taskDef.isRunning()? "True" : "False");
		}
		
		scheduleView.onItemSelected(taskDef);
		parametersView.onItemSelected(this,taskDef);
	}	
	
	/**
	 * Sets focus to the first widget.
	 */
	public void setFocus(){
		txtName.setFocus(true);
		txtName.selectAll();
	}

	/**
	 * Sets whether to enabled or disable this widget.
	 * 
	 * @param enabled set to true to enable, else false.
	 */
	private void setEnabled(boolean enabled){
		txtName.setEnabled(enabled);
		txtClass.setEnabled(enabled);
		txtDescription.setEnabled(enabled);
	}

	/**
	 * Clears contents of widgets in this view.
	 */
	private void clear(){
		taskDef = null;
		txtName.setText(null);
		txtDescription.setText(null);
		txtClass.setText(null);
	}
}
