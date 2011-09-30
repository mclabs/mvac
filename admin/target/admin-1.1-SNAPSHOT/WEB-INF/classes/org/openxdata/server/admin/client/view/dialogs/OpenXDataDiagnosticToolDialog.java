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
package org.openxdata.server.admin.client.view.dialogs;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.callback.OpenXDataAsyncCallback;
import org.openxdata.server.admin.client.tools.DiagnosisView;
import org.openxdata.server.admin.client.tools.HTMLLogFileView;
import org.openxdata.server.admin.client.tools.StatusWatchTool;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.widget.OpenXDataButton;
import org.openxdata.server.admin.client.view.widget.OpenXDataFlexTable;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.util.Diagnosis;
import org.purc.purcforms.client.util.FormUtil;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * Models diagnostics and encapsulates functionality that a given {@link User} can use to determine the health of the system.
 * <p><b>
 * Note:</b> The diagnosis that is loaded depends on the logs that have been captured in the <tt>OpenXData</tt> specific <tt>Log File</tt> and 
 * not the <tt>tomcat Log File.</tt> Reason for this was to be able to define custom formatting that can make the reading of the logs easier hence
 * making manipulation easier.</p>
 * <p>
 * If the <tt>Log File</tt> is big, the diagnosis can take long and care should be taken before attempting to read the <tt>Log file</tt> for it might 
 * have serious ramifications like making the system non responsive to the <tt>User.</tt></p>
 * 
 * <b>Example Usage:</b>
 * <pre class="code">
 * 
 * if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Diagnose_System")){ // Always determine that the User has rights to diagnose system.
 *	new OpenXDataDiagnosticToolDialog().initializeDiagnostics();
 * }
 * 
 * </pre><p>
 * 
 * @author Angel
 *
 */
public class OpenXDataDiagnosticToolDialog extends DialogBox {
	
	// Closes the Dialog.
	private Button closeButton;
	
	// Sends an Email with the Log File
	// as an attachment to specified lists.
	private Button composeEmail;
	
	// Loads the Error Log in a Dialog.
	private Button errorLogButton;
	
	// Re diagnoses the system.
	private Button diagnoseButton;
	
	// Displays the Log File.
	private HTMLLogFileView htmlLogFileView;
	
	// Shows DIagnosis summary.
	private DiagnosisView diagnosticToolView;
	
	// Displays summary about system status.
	private StatusWatchTool statusWatchToolView;
	
	public OpenXDataDiagnosticToolDialog(){
		setText("OpenXData Diagnostic Tool");
		
		setupWidgets();
		setupEventListeners();
	}

	/**
	 * Sets up the widget.
	 */
	private void setupWidgets() {			
		
		// Tab to hold the view widgets.
		DecoratedTabPanel tabs = new DecoratedTabPanel();
		
		// Properties for the Status Watch View
		statusWatchToolView = new StatusWatchTool();
		tabs.add(statusWatchToolView, "Status");
		
		// Properties for Diagnosis Tool View.
		diagnosticToolView = new DiagnosisView();
		tabs.add(diagnosticToolView, "Diagnose");
		
		// Initialize HTML widget for later user
		htmlLogFileView = new HTMLLogFileView();
		
		
		tabs.selectTab(0);
		Utilities.maximizeWidget(tabs);			
		
		// Building the table to hold widgets.
		FlexTable table = new OpenXDataFlexTable();
		table.setWidget(0, 0, tabs);		
		
		// Setting Error Log Button Properties
		errorLogButton = new OpenXDataButton("Error Log");
		errorLogButton.setWidth("110px");
		errorLogButton.setTitle("Displays the Log File so that you can view the Latest activity in the system.");
		
		// Setting Diagnose Button properties.
		diagnoseButton = new OpenXDataButton("Diagnose");
		diagnoseButton.setWidth("110px");
		diagnoseButton.setTitle("Runs a system diagnosis to establish a health level and recent activity.");

		// Setting properties for the Email button
		composeEmail = new OpenXDataButton("Compose Email");
		composeEmail.setWidth("110px");
		composeEmail.setTitle("Allows you to compose an Email and send to specified receipients with specified attachments.");
		
		// Setting properties for the Close button
		closeButton = new OpenXDataButton("Close");
		closeButton.setWidth("110px");
		closeButton.setTitle("Closes the Diagnostic Tool and takes you back to the main application dashboard.");
		
		//Panel to hold the buttons.
		HorizontalPanel panel = new HorizontalPanel();
		
		//Add Buttons
		panel.add(diagnoseButton);
		panel.add(errorLogButton);
		panel.add(composeEmail);
		panel.add(closeButton);
		
		//Set the alignment of widgets on the Panel.
		panel.setCellHorizontalAlignment(closeButton, HasHorizontalAlignment.ALIGN_RIGHT);
		panel.setCellHorizontalAlignment(composeEmail, HasHorizontalAlignment.ALIGN_LEFT);
		panel.addStyleName("closeDialog");
		
		table.setWidget(1, 0, panel);
		
		//Remove the header style name to make the table pro!
		table.getRowFormatter().removeStyleName(0, "FlexTable-Header");
		
		Utilities.maximizeWidget(table);
		
		setWidget(table);
	}

	/**
	 * Sets up <code>Widget Event Listeners</code>.
	 */
	private void setupEventListeners() {
		
		diagnoseButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				diagnoseSystem(false);}});
		
		errorLogButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				diagnoseSystem(true);}});
		
		composeEmail.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				composeEmail();}});
		
		closeButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				hide();}});
		
	}

	/**
	 * Re diagnoses the system.
	 * 
	 * @param showLogFile Flag to determine whether to display <tt>Log File</tt> or not.
	 */
	protected void diagnoseSystem(final boolean showLogFile) {
		
		FormUtil.dlg.setText("Running System Diagnostics...");
		FormUtil.dlg.center();
		DeferredCommand.addCommand(new Command(){
			@Override
			public void execute() {
				Context.getUtilityService().getLogFileProcessedOutput("openxdata logs/openxdata-server-error.htm", new OpenXDataAsyncCallback<Diagnosis>(){

					@Override
					public void onOtherFailure(Throwable throwable) {
						Utilities.displayMessage(throwable.getLocalizedMessage());

					}

					@Override
					public void onSuccess(Diagnosis diagnosis) {
						updateDiagnosis(diagnosis, showLogFile);

					}});
			}});

		FormUtil.dlg.hide();

	}
	
	/**
	 * Displays the <tt>HTML Log </tt> output.
	 * @param diagnosis <tt>System DIagnosis.</tt>
	 */
	private void displayHTMLOutput(Diagnosis diagnosis) {		
		if(diagnosis != null){
			if(diagnosis.getLogFileStream().length() > 0){
				htmlLogFileView.initializeDialog(diagnosis.getLogFileStream());
			}
		}
	}
	
	/**
	 * Updates all controls with new Diagnosis information.
	 * 
	 * @param diagnosis Latest Diagnosis.
	 * @param showLogFile Flag to determine whether to display <tt>Log File</tt> or not.
	 */
	private void updateDiagnosis(Diagnosis diagnosis, boolean showLogFile) {
		if(showLogFile){
			displayHTMLOutput(diagnosis);
		}
		else{
			statusWatchToolView.update(null, diagnosis);
			diagnosticToolView.update(null, diagnosis);
		}
	}
	
	/**
	 * Allows <tt>User</tt> to compose an Email and send.
	 * <p> 
	 */
	protected void composeEmail() {
		new OpenXDataEmailDialog().initializeDialog();
		
		
		/*OpenXDataEmailDialog emailDialog = new OpenXDataEmailDialog();
		emailDialog.initializeDialog(); //This will prepare the Dialog for sending Email.*/	}
	
	/**
	 * Initialize the <tt>Diagnostic Tool</tt>.
	 */
	public void initializeDiagnostics(){
		diagnoseSystem(false);
		this.center();
	}
}
