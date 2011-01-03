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

import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.OpenXDataBaseObserverCompositeView;
import org.openxdata.server.admin.client.view.widget.OpenXDataFlexTable;
import org.openxdata.server.admin.model.util.Diagnosis;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

/**
 * Encapsulates the diagnosis functionality.
 * 
 * @author Angel
 *
 */
public class DiagnosisView extends OpenXDataBaseObserverCompositeView {	

	// Caption Label for latest Error.
	private Label latestError;
	
	// Caption Label for Error count.
	private Label numberOfErrors;

	// Caption Label for Diagnosed Status.
	private Label diagnosedStatus;	
	
	// Display area for diagnosed status.
	private ListBox diagnosedStatusBox;

	// Display area for latest Error.
	private TextArea latestErrorTextBox;
	
	// Display area for Error count.
	private TextBox numberOfErrorsTextBox;

	/**
	 * Constructs an instance of this <tt>class.</tt>
	 */
	public DiagnosisView(){
		setupWidgets();
	}

	/**
	 * Sets up the widget.
	 */
	private void setupWidgets() {
		
		// Label properties.
		latestError = new Label("Latest Error: ");
		numberOfErrors = new Label("Number Of Errors: ");
		diagnosedStatus = new Label("System Status");

		// Setting properties for 
		// Diagnosed Status List Box.
		diagnosedStatusBox = new ListBox();
		diagnosedStatusBox.setWidth("200px");
		
		// Setting properties for Errors count box.
		numberOfErrorsTextBox = new TextBox();
		numberOfErrorsTextBox.setWidth("200px");
		

		// Latest Error Text Box properties.
		latestErrorTextBox = new TextArea();
		latestErrorTextBox.setWidth("200px");
		latestErrorTextBox.setTitle("Displays the Latest Error that has occured during the recent activity");

		// Table to organize widgets
		FlexTable table = new OpenXDataFlexTable();
		FlexCellFormatter formatter = table.getFlexCellFormatter();

		// Add Diagnosed Status caption Label.
		table.setWidget(0, 0, diagnosedStatus);
		formatter.setColSpan(0, 0, 2);
		formatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_LEFT);
		
		// Add Diagnosed Status Box
		table.setWidget(0, 1, diagnosedStatusBox);
		formatter.setColSpan(0, 1, 2);
		formatter.setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_CENTER);

		table.setWidget(1, 0, numberOfErrors);
		formatter.setColSpan(1, 0, 2);
		formatter.setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_LEFT);
		
		table.setWidget(1, 1, numberOfErrorsTextBox);
		formatter.setColSpan(1, 1, 2);
		formatter.setHorizontalAlignment(1, 1, HasHorizontalAlignment.ALIGN_CENTER);

		table.setWidget(2, 0, latestError);
		formatter.setColSpan(2, 0, 2);
		formatter.setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_LEFT);
		
		table.setWidget(2, 1, latestErrorTextBox);
		formatter.setColSpan(2, 1, 2);
		formatter.setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_CENTER);

		Utilities.maximizeWidget(table);

		initWidget(table);

	}

	
	@Override
	public void update(OpenXDataObservable observable, Object diagnosis) {
		
		// Clear old displayed diagnosis.
		diagnosedStatusBox.clear();
		latestErrorTextBox.setText("");
		
		
		if(diagnosis != null){
			
			// Bind the Diagnosis to the Views.
			if(((Diagnosis) diagnosis).getLatestError().length() > 0){
				latestErrorTextBox.setText(((Diagnosis) diagnosis).getLatestError());							
			}
			else{
				latestErrorTextBox.setEnabled(false);
			}
			
			numberOfErrorsTextBox.setText(String.valueOf(((Diagnosis) diagnosis).getErrorCount()));
			diagnosedStatusBox.addItem(((Diagnosis) diagnosis).getDiagnosedStatus().valueOf(((Diagnosis) diagnosis).getDiagnosedStatus()));
		}
	}
}
