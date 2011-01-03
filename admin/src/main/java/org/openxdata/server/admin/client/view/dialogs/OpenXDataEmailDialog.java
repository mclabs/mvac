/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

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

import java.util.List;
import java.util.Vector;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.callback.OpenXDataAsyncCallback;
import org.openxdata.server.admin.client.util.AsyncCallBackUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.widget.OpenXDataButton;
import org.openxdata.server.admin.client.view.widget.OpenXDataFlexTable;
import org.openxdata.server.admin.client.view.widget.OpenXDataLabel;
import org.openxdata.server.admin.model.util.OpenXDataEmail;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

/**
 * Encapsulates functionality for sending Email(s) in OXD. 
 * Handles the sending of Email to one or more specified recipients.
 * 
 * <p>
 * Note: that we do not add functionality to capture a <tt>User</tt> defined 
 * <tt>Email body</tt> as was not envisioned/needed at moment of design. This type can be extended to handle other functionalities like adding <tt>Email body</tt>.
 * </p>
 * 
 * <b>Example Usage:</b>
 * 
 * <pre class="code">
 * 
 * OpenXDataEmailDialog emailDialog = new OpenXDataEmailDialog();
 * 
 * emailDialog.initializeDialog(); //This will prepare the Dialog for sending Email.
 * 
 * </pre><p>
 * 
 * 
 * @author Angel
 *
 */
public class OpenXDataEmailDialog extends DialogBox {
	
	/** Caption Label for To field.*/
	private Label toLabel;
	
	/** TexBox to capture recipients.*/
	private TextBox toTextBox;
	
	/** Caption for CC Label.*/
	private Label ccLabel;
	
	/** TextBox to capture Carbon Copy recipients.*/
	private TextBox ccTextBox;
	
	/** Caption Label for Subject field.*/
	private Label subjectLabel;
	
	/** TextBox to capture the Subject.*/
	private TextBox subjectTextBox;
	
	/** RadioButton for specifying attachment of Error Log.*/
	private RadioButton attachErrorLog;
	
	/** RadioButton for specifying attachment of Latest Error only.*/
	private RadioButton attachLatestErrorOnly;
	
	/** Button to model sending of the email.*/
	private Button sendButton;
	
	/** Button to model canceling of email operation.*/
	private Button cancelButton;
	
	/**
	 * Constructs an instance of this type.
	 */
	public OpenXDataEmailDialog(){}
	
	/**
	 * Sets Up the <tt>Widgets</tt> onto the 
	 * <tt>Dialog</tt> and organizes them for viewing.
	 */
	protected void setUpWidgets(){
		
		// Setting the title for the Dialog.
		setText("Diagnostic Tool Email Options");
		
		// Properties for the To Widgets.
		toLabel = new OpenXDataLabel("To: ");
		toTextBox = new TextBox();
		toTextBox.setWidth("400px");
		 
		// Properties for the CC widgets.
		ccLabel = new OpenXDataLabel("CC: ");
		ccTextBox = new TextBox();
		ccTextBox.setWidth("400px");
		 
		// Properties for the Subject widgets.
		subjectLabel = new OpenXDataLabel("Subject: ");
		subjectTextBox = new TextBox();
		subjectTextBox.setWidth("400px");
		 
		// Attach Latest Error Log Radio options.
		attachErrorLog = new RadioButton("attach");
		attachErrorLog.setText("Attach Error Log");
		attachErrorLog.setTitle("Attaches the Error Log to the Email.");
		
		// Attach Latest Error Only Radio options.
		attachLatestErrorOnly = new RadioButton("attach");
		attachLatestErrorOnly.setText("Send Latest Error Only");
		attachLatestErrorOnly.setTitle("Attaches the Latest Error only to the Email.");
		
		
		// Properties for the Send Button.
		sendButton = new OpenXDataButton("Send");
		sendButton.setWidth("110px");
		sendButton.setTitle("Sends the Composed Email.");
		
		// Properties for the Cancel Button.
		cancelButton = new OpenXDataButton("Cancel");
		cancelButton.setWidth("110px");
		cancelButton.setTitle("Cancels the Email Operation.");
		 
		// Table for organizing the widgets.
		FlexTable table = new OpenXDataFlexTable();
		FlexCellFormatter formatter = table.getFlexCellFormatter();		
		 
		// Set To fields.
		table.setWidget(0, 0, toLabel);
		table.setWidget(0, 1, toTextBox);
		formatter.setWidth(0, 1, "20%");
		formatter.setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_LEFT);
		 
		// Set CC fields.
		table.setWidget(1, 0, ccLabel);
		table.setWidget(1, 1, ccTextBox);
		formatter.setWidth(1, 1, "20%");
		formatter.setHorizontalAlignment(1, 1, HasHorizontalAlignment.ALIGN_LEFT);
		 
		// Set the Subject fields.
		table.setWidget(2, 0, subjectLabel);
		table.setWidget(2, 1, subjectTextBox);
		formatter.setWidth(2, 1, "20%");
		formatter.setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_LEFT);
		 
		// Set the Radio button fields.
		table.setWidget(3, 0, attachErrorLog);
		table.setWidget(4, 0, attachLatestErrorOnly);
		
		// Set the Buttons.
		table.setWidget(5, 0, sendButton);
		table.setWidget(5, 1, cancelButton);
		
		Utilities.maximizeWidget(table);
		
		setWidget(table);
	}

	/**
	 * Sets Up <tt>Event Listeners</tt> for 
	 * the <tt>Widgets</tt> on the <tt>Dialog.</tt>
	 */
	private void setUpEventListeners() {
		sendButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				prepareEmail();
				
			}});
		
		cancelButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				hide();
				
			}});
	}

	/**
	 * Prepares an Email as prescribed by the <tt>User.</tt>
	 */
	protected void prepareEmail() {
		if(toTextBox.getText().length() > 0){
			if(attachErrorLog.getValue() || attachLatestErrorOnly.getValue()){
				
				// Build Email.
				OpenXDataEmail email = buildOpenXDataEmail();
				
				// Send the Email.
				sendEmail(email);
			}
			else{
				Utilities.displayMessage("Specify atleast one attachment to send with the Email.");
			}
		}
	}
	
	/**
	 * Constructs an <tt>OpenXDataEmail</tt> that can be passed to the server for transfer over the wire.
	 * 
	 * @return constructed <tt>OpenXDataEmail.</tt>
	 */
	private OpenXDataEmail buildOpenXDataEmail() {
		
		OpenXDataEmail email = new OpenXDataEmail();
		
		// Build the recipient lists
		List<String> recipients = buildRecipientList(toTextBox.getText());
		List<String> ccRecipients = buildRecipientList(ccTextBox.getText());
		
		// Subject
		String subject = subjectTextBox.getText() == null ? "OpenXData Diagnostic Logs" : subjectTextBox.getText(); 
		
		email.setRecipients(recipients);
			
		email.setCarbonCopyRecipients(ccRecipients);
		email.setSubject(subject);
		
		// User attachment selection.
		email.setAttachErrorLog(attachErrorLog.getValue());
		email.setAttachLatestError(attachLatestErrorOnly.getValue());
		
		
		return email;
	}

	/**
	 * Builds a List of valid of recipients given a list of Email addresses.
	 * 
	 * @param emailList List of Email addresses from which to build recipients.
	 * 
	 * @return List of Valid Email Addresses.
	 */
	private List<String> buildRecipientList(String emailList) {
		
		// Holds valid Email addresses.
		List<String> validRecipients = new Vector<String>();
		
		if(emailList != null && emailList != ""){
			// Validate Email Addresses.
			if(Utilities.validateEmail(emailList)){
				
				// Build multiple Email Addresses.
				if(emailList.contains(",")){				
					String[] recipients = emailList.split(",");
					for(int index = 0; index < recipients.length; index++){
						validRecipients.add(recipients[index]);
					}
				}
				else {
					// Just add the one Email Address.
					validRecipients.add(emailList.trim());
				}
				
				return validRecipients;
			}
			else{
				Utilities.displayMessage("The Email Addresses entered have invalid characters or are mispelt. Please cross check to proceed!");
			}
		}

		return null;
	}
	
	/**
	 * Sends an Email using the <tt>Service Layer.</tt>
	 * 
	 * @param email Email to send.
	 */
	private void sendEmail(OpenXDataEmail email) {
		Context.getUtilityService().sendEmail(email, new OpenXDataAsyncCallback<Boolean>(){

			@Override
			public void onOtherFailure(Throwable throwable) {
				AsyncCallBackUtil.handleGenericOpenXDataException(throwable);
				
			}

			@Override
			public void onSuccess(Boolean isEmailSent) {
				handleReturnedResult(isEmailSent);
				
			}});
	}

	/**
	 * Handles the server returned result of the send email operation.
	 * 
	 * @param isEmailSent Returned Result.
	 */
	protected void handleReturnedResult(Boolean isEmailSent) {
		if(isEmailSent){
			Utilities.displayMessage("Email successfully sent!");
		}
		else{
			Utilities.displayMessage("Problems occurred during the sending of the Email. Double check that your connection is working properly!");
		}
	}

	/**
	 * Initializes this <tt>Dialog</tt> with the relevant <tt>Widgets.</tt>
	 */
	public void initializeDialog() {
		
		setUpWidgets();
		setUpEventListeners();
		
		// Center the Dialog.
		this.center();
		
	}
}
