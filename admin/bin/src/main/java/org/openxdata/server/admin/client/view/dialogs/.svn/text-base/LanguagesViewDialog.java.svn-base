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

import java.util.List;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.callback.OpenXDataAsyncCallback;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.widget.OpenXDataButton;
import org.openxdata.server.admin.client.view.widget.OpenXDataFlexTable;
import org.openxdata.server.admin.model.Locale;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTMLTable.Cell;

/**
 * This is the widget used to save new languages.
 * 
 * @author Laiton Namutebi
 * 
 */
public class LanguagesViewDialog {

	/** Dialog box to layout widgets. */
	private DialogBox dialog = new DialogBox();

	private ScrollPanel mainPanel = new ScrollPanel();
	private VerticalPanel contentPanel = new VerticalPanel();
	private HorizontalPanel buttonsPanel = new HorizontalPanel();

	/** Panel to space or separate the different panel vertically. */
	private HorizontalPanel spacer = new HorizontalPanel();

	/** text field to handle languages and language key/codes. */
	private TextBox txt;

	/** Button to save languages to the database. */
	private Button submit = new OpenXDataButton("Submit");

	/** Button to close dialog box. */
	private Button closeDialog = new OpenXDataButton("Close");

	/** Button to add more input fields to the table. */
	private Button addmore = new OpenXDataButton("Add New");

	/** Button to delete language from the table and database. */
	private Button delete;

	/** Table of languages. */
	private FlexTable newLangTable = new OpenXDataFlexTable();

	/** Table header row index. */
	private static final int HeaderRowIndex = 0;

	/** list of languages with codes. */
	private List<Locale> locales;

	/** language object. */
	private Locale locale;

	private String isValidDelete;

	/**
	 * 
	 * Loads dialog box widgets.
	 * 
	 */
	public void loaddialog() {

		loadDialogboxElements();
		dialog.setSize("430px", "100%");
		dialog.add(mainPanel);
		dialog.center();
		dialog.show();

	}

	/** method to set elements of the dialog box */
	public void loadDialogboxElements() {

		// Adding the table header row.
		newLangTable.insertRow(HeaderRowIndex);

		// Adding header row style.
		newLangTable.getRowFormatter().addStyleName(HeaderRowIndex,
				"FlexTable-Header");

		// Adding Header row elements.
		newLangTable.setText(0, 0, "Code");
		newLangTable.setText(0, 1, "Name");
		newLangTable.setText(0, 2, "Delete");

		// adding style to language table
		newLangTable.setCellSpacing(0);
		newLangTable.addStyleName("FlexTable");
		newLangTable.setWidth("100%");

		// listener to delete selected row on click of delete button in that row
		newLangTable.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Cell cell = newLangTable.getCellForEvent(event);
				TextBox txt1 = new TextBox();
				TextBox txt2 = new TextBox();

				int selectedColumn = cell.getCellIndex();
				int selectedRow = cell.getRowIndex();

				// checking if cell with delete button was clicked
				if (selectedColumn == 2) {

					txt1 = (TextBox) newLangTable.getWidget(selectedRow, 0);
					txt2 = (TextBox) newLangTable.getWidget(selectedRow, 1);

					// checks if text fields in deleted row are empty;
					if (txt1.getText().trim().length() == 0
							|| txt2.getText().trim().length() == 0) {
						newLangTable.removeRow(selectedRow);
					} else {
						deleteLang(selectedRow);
					}
				}

			}
		});

		// loading elements into dialog box
		dialog.setText("Languages");

		// loads the languages form the database into the table.
		loadLanguages();

		// listener to handle submit button click
		submit.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {

				if (newLangTable.getRowCount() <= 1) {

					Window.alert("Please enter a language to save ");
				}

				else if (verifyInput()) {
					// call on method that saves table contents to the database
					saveLangs();

				}
			}
		});

		// adding a css style to the button
		submit.addStyleName("btn");

		// listener to handle close button click
		closeDialog.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
			/*	//list of locales that are not saved to enable there removal from locales list on dialog box close
				List<Locale> removeLang = new ArrayList<Locale>();
				for(Locale locale : locales){
					if(locale.isNew())
						removeLang.add(locale);
				}				
				locales.removeAll(removeLang);*/
				
				
				dialog.hide();
			}
		});

		// attaching a style to the button
		closeDialog.addStyleName("btn");

		// listener to click on the button that adds more fields to the language
		// table
		addmore.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				addFields();
				mainPanel.scrollToBottom();
			}
		});

		// adding style
		addmore.addStyleName("btn");

		// adding elements to panel
		buttonsPanel.add(addmore);
		buttonsPanel.add(submit);
		buttonsPanel.add(closeDialog);
		buttonsPanel.setSpacing(5);

		// empty panel to separate panels
		spacer.setHeight("10px");

		// setting size of panel.
		contentPanel.setWidth("400px");
		contentPanel.setHeight("250px");

		//adding widgets to the content panel.
		contentPanel.add(newLangTable);
		contentPanel.add(spacer);
		contentPanel.add(buttonsPanel);
		contentPanel.setCellHorizontalAlignment(buttonsPanel,
				HasHorizontalAlignment.ALIGN_CENTER);

		mainPanel.add(contentPanel);
		mainPanel.setSize("430px", "250px");
	}

	/**
	 * 
	 * Loads the languages from the database into the table
	 * 
	 */
	public void loadLanguages() {

		// loading list with languages from the database
		locales = Context.getLocales();
		
		if (locales != null) {
			int row = 1;
			for (Locale locale : locales) {

				// declaring button that deletes language on click
				delete = new OpenXDataButton("X");
				delete.addStyleName("btn");

				//text fields to store a language key and language respectively.
				txt = new TextBox();
				TextBox txt2 = new TextBox();

				txt.setText(locale.getKey().trim());
				txt2.setText(locale.getName().trim());

				// Adding languages to the table
				newLangTable.setWidget(row, 0, txt);
				newLangTable.setWidget(row, 1, txt2);
				newLangTable.setWidget(row, 2, delete);
				++row;
			}

		}
	}

	/**
	 * 
	 * Removes rows with black text fields and checks if all text fields filled
	 * in
	 * 
	 */
	public boolean verifyInput() {

		TextBox txt2;
		TextBox txt3;
		String isValid = "True";

		// number of rows in the table
		int tablesize = newLangTable.getRowCount();													

		for (int i = 1; i < tablesize;) {

			txt2 = (TextBox) newLangTable.getWidget(i, 0);
			txt3 = (TextBox) newLangTable.getWidget(i, 1);

			// removing rows with empty text boxes
			if (txt2.getText().trim().length() == 0	&& txt3.getText().trim().length() == 0) {

				if (i <= locales.size()) {

					Locale loc = locales.get(i - 1);
					
					txt2.setText(loc.getKey());
					txt3.setText(loc.getName());
					
					newLangTable.setWidget(i, 0, txt2);
					newLangTable.setWidget(i, 1, txt3);
					
				} else {
					newLangTable.removeRow(i);
				}
				
			} else if (txt2.getText().trim().length() != 0
					&& txt3.getText().trim().length() == 0) {
				if (i <= locales.size()) {

					Locale loc = locales.get(i - 1);
					txt2.setText(loc.getKey());
					txt3.setText(loc.getName());
					
					newLangTable.setWidget(i, 0, txt2);
					newLangTable.setWidget(i, 1, txt3);
					
				} else {

					isValid = "False";
				}
				i++;
			} else if (txt2.getText().trim().length() == 0
					&& txt3.getText().trim().length() != 0) {
				if (i <= locales.size()) {

					Locale loc = locales.get(i - 1);
					txt2.setText(loc.getKey());
					txt3.setText(loc.getName());
					
					newLangTable.setWidget(i, 0, txt2);
					newLangTable.setWidget(i, 1, txt3);
					
				} else {
					isValid = "False";
				}
				i++;
			} else {
				i++;
			}
			tablesize = newLangTable.getRowCount();
		}
		if (isValid.equals("True")) {
			return true;
		} else {
			Window.alert("Please Enter all the required fields");
			return false;
		}

	}

	/**
	 * 
	 * Deletes a language from the table and database
	 * 
	 */
	public boolean deleteLang(final int row) {

		isValidDelete = "false";
		final int listIndex = row - 1;
		locale = new Locale();

		if (listIndex < locales.size()) {
			locale = locales.get(listIndex);
			Context.getUtilityService().deleteLocale(locale, new OpenXDataAsyncCallback<Void>() {
				
				@Override
				public void onOtherFailure(Throwable caught) {
					Window.alert("Failed: " + caught);
				}

				@Override
				public void onSuccess(Void result) {
					finalizeRemove(row, listIndex);
					loadLanguages();
				}

				/**
				 * @param row
				 * @param listIndex
				 */
				private void finalizeRemove(final int row, final int listIndex) {
					newLangTable.removeRow(row);
					locales.remove(listIndex);
					Window.alert("Database Successfully Updated");
				}
			});
		} else {
			newLangTable.removeRow(row);

		}

		if (isValidDelete.equals("true")) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 *  Add more fields to the language table 
	 *  
	 */
	public void addFields() {
		//length of the table
		int i = newLangTable.getRowCount();

		txt = new TextBox();
		// adding empty text box in specified cell
		newLangTable.setWidget(i, 0, txt);

		txt = new TextBox();
		
		// adding empty text box in specified cell
		newLangTable.setWidget(i, 1, txt);
		
		//button to delete languages form table and database.
		delete = new OpenXDataButton("X");
		delete.addStyleName("btn");
		newLangTable.setWidget(i, 2, delete);

	}

	/**
	 * 
	 *  Save languages to the database 
	 *  
	 */
	public void saveLangs() {
		
		
		//checking if table is not empty.
		if (newLangTable.getRowCount() > 1) {
			TextBox txt3;
			TextBox txt4;
			
			// list index tracker
			int j = 0;
			
			for (int i = 1; i < newLangTable.getRowCount(); i++) {
				
				txt3 = (TextBox) newLangTable.getWidget(i, 0);
				txt4 = (TextBox) newLangTable.getWidget(i, 1);

				//Instantiating locale object
				locale = new Locale();
				locale.setKey(txt3.getText().trim());
				locale.setName(txt4.getText().trim());

				if (i > locales.size()) {
					
					// adding language and code object to List
					locales.add(locale);
				
					
				} else {
					j = i - 1;
					
					//Instantiating locale object 
					Locale loc = new Locale();
					
					loc = locales.get(j);
					loc.setKey(locale.getKey());
					loc.setName(locale.getName());
					locales.set(j, loc);
				}
			}

			if (!locales.isEmpty()) {
				
				//Save languages to database.
				Context.getUtilityService().saveLocale(locales,new OpenXDataAsyncCallback<Void>() {

					@Override
					public void onOtherFailure(Throwable caught) {
						Utilities.displayNotificationMessage("Failed: " + caught);
					}
					
					@Override
					public void onSuccess(Void result) {
						Window.alert("Database Successfully Updated");
						loadLanguages();
					}
				});
			}
		}
	}
}
