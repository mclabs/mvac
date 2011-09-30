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
package org.openxdata.server.admin.client.tools;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.callback.OpenXDataAsyncCallback;
import org.openxdata.server.admin.client.util.AsyncCallBackUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.widget.OpenXDataButton;
import org.openxdata.server.admin.client.view.widget.OpenXDataFlexTable;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

/**
 * Displays the formatted output from the <tt>HTML Log File</tt>.
 * 
 * @author Angel
 *
 */
public class HTMLLogFileView extends DialogBox {
	
	/** The button to clear the Log*/
	private Button clearButton;
	
	/** The button to close this view.*/
	private Button closeButton;
	
	/** The widgets to display Log in HTML format. */
	private HTML logOutputWidget;
	
	/** Scroll Panel to aid in the view because it can be big*/
	private ScrollPanel scrollPanel;
	
	/**
	 * Constructs an instance of this <tt>class.</tt>
	 */
	public HTMLLogFileView(){
		
		// Make User aware of what we displaying not to leave them in oblivion.
		this.setText("Displaying recent Activity as captured in the OpenXData Log File.");	
	}

	/**
	 * Sets up <tt>Event Listeners</tt> for this objects's <tt>widgets.</tt>
	 */
	private void setUpEventListeners() {
		closeButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				hide();
				
			}});
		
		clearButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				clearLogFiles();
				
			}});
	}

	/**
	 * Clears the Log Files. All logged activity will be lost after this operation.
	 */
	protected void clearLogFiles() {
		
		Context.getUtilityService().clearLogFiles(new OpenXDataAsyncCallback<Void>(){

			@Override
			public void onOtherFailure(Throwable throwable) {
				AsyncCallBackUtil.handleGenericOpenXDataException(throwable);				
			}

			@Override
			public void onSuccess(Void result) {
				
				// Notify the User of successful operation.
				Utilities.displayMessage("Successfully cleared the Log File.");
				
				// Hide the parent dialog.
				hide();
				
			}});		
	}
	
	/**
	 * Initializes the <tt>Widget</tt> with the relevant controls.
	 * 
	 * @param height The Height for objects on this <tt>Dialog.</tt>
	 * @param width The Width for objects on this <tt>Dialog.</tt>
	 */
	private void setUp(String width, String height) {
		
		// Widget size.
		setWidth(width);
		setHeight(height);
		
		logOutputWidget = new HTML();
		
		// Setting scroll panel properties
		scrollPanel = new ScrollPanel();
		
		// Size
		scrollPanel.setWidth(width);
		scrollPanel.setHeight(height);
		
		// Add Widget
		scrollPanel.setWidget(logOutputWidget);

		// Table to hold all widgets.
		FlexTable table = new OpenXDataFlexTable();				
		FlexCellFormatter formatter = table.getFlexCellFormatter();		
		
		// Adding the Panel
		table.setWidget(0, 0, scrollPanel);
		formatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_RIGHT);		
		
		// Initialize Clear button.
		clearButton = new OpenXDataButton("Clear Log");
		clearButton.setWidth("120px");
		clearButton.setHeight("30px");
		clearButton.setTitle("Clears the Log File. All logged activity will be lost after this operation.");
		
		// Initialize Close button.
		closeButton = new OpenXDataButton("Close");
		closeButton.setWidth("120px");
		closeButton.setHeight("30px");
		closeButton.setTitle("Closes the Diagnostic Tool and takes you back to the main application dashboard.");
		
		// Adding close caption button.
		HorizontalPanel utilityPanel = new HorizontalPanel();
		utilityPanel.setCellHorizontalAlignment(closeButton, HasHorizontalAlignment.ALIGN_RIGHT);
		utilityPanel.addStyleName("closeDialog");
		
		utilityPanel.add(clearButton);
		utilityPanel.add(closeButton);		

		table.setWidget(1, 0, utilityPanel);
		
		
		setWidget(table);
	}
	
	/**
	 * Initializes the dialog and displays the <tt>Log File.</tt>
	 * 
	 * @param html HTML to display.
	 */
	public void initializeDialog(String html){
		
		// Compute width relative to browser width.
		String width = String.valueOf(Window.getClientWidth() / 2 ) + "px";
		
		// Compute height relative to browser height.
		String height = String.valueOf(Window.getClientHeight() / 2 ) + "px";
		
		setUp(width, height);
		setUpEventListeners();
		
		setHTMLContent(html);
		
		this.center();
		
		
	}

	/**
	 * Sets the HTML formatted output.
	 * 
	 * @param html HTML output.
	 */
	private void setHTMLContent(String html){
		this.logOutputWidget.setHTML(html);
	}
}
