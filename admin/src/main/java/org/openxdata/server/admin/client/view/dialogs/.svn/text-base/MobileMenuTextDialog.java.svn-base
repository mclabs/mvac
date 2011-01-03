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

import java.util.ArrayList;
import java.util.List;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.callback.OpenXDataAsyncCallback;
import org.openxdata.server.admin.client.view.widget.OpenXDataButton;
import org.openxdata.server.admin.model.Locale;
import org.openxdata.server.admin.model.MobileMenuText;
import org.purc.purcforms.client.util.FormUtil;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * This is the widget used for translating mobile menu text/words into a
 * target/selected language.
 * 
 * @author Laiton Namutebi
 * 
 */
public class MobileMenuTextDialog {

	/** Dialog box to lay out widgets. */
	private DialogBox dialog = new DialogBox();
	private VerticalPanel majorPanel = new VerticalPanel();
	private ScrollPanel main = new ScrollPanel();
	private VerticalPanel mainPanel = new VerticalPanel();
	private HorizontalPanel select = new HorizontalPanel();
	private HorizontalPanel buttonsPanel = new HorizontalPanel();
	private HorizontalPanel spacer = new HorizontalPanel();
	private HorizontalPanel closePanel = new HorizontalPanel();

	/** Button to save to database. */
	private Button save = new OpenXDataButton("Save");

	/** Button to reset the table. */
	private Button cancel = new OpenXDataButton("Cancel");

	/** Grid to display table headers. */
	private Grid header = new Grid(1, 2);

	/** Table of mobile menu text. */
	private FlexTable wordTable = new FlexTable();

	/** Image to close dialog box. */
	private Image closeImg = new Image();

	private Label selecttext = new Label("Select language to translate to:    ");

	/** Drop down list box of languages. */
	private ListBox lang = new ListBox();

	/** List of languages. */
	private List<Locale> locales;

	/** List of mobile menu text in selected language. */
	private List<MobileMenuText> mobileMenuText = new ArrayList<MobileMenuText>();

	/** List of mobile menu text in english(Default Language). */
	private List<MobileMenuText> defaultMobileMenuText = new ArrayList<MobileMenuText>();

	/** List for handling words translated to a selected language in the table. */
	private MobileMenuText newMobileMenuText;

	/** Text field for entering new mobile menu text. */
	private TextBox input;

	/** String of selected language. */
	private String targetLang;

	/** String of Selected language key. */
	private String targetLangKey;

	/** HTML Table formatter */
	private HTMLTable.RowFormatter rf = wordTable.getRowFormatter();

	/**
	 * 
	 * Loads the dialog box widgets
	 * 
	 */
	public void loaddialog() {

		// setting path to image.
		closeImg.setUrl("images/alert.png");

		// click listerner for image.
		closeImg.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				dialog.hide();
			}
		});

		// loading languages from the database into the list.
		locales = Context.getLocales();

		//adding style the select language text.
		selecttext.addStyleName("select");
		
		//adding style to the list box items. 
		lang.addStyleName("select2");

		select.setCellVerticalAlignment(selecttext,	HasVerticalAlignment.ALIGN_MIDDLE);
		
		//adding button widget to the button panel.
		buttonsPanel.add(save);
		
		save.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				if (verifyInput()) 
				{
					saveElements();
				}else 
				{
					Window.alert("Please fill in all the required fields");
				}
			}
		});

		//adding style to the save and cancel buttons. 
		save.addStyleName("btn");
		cancel.addStyleName("btn");

		//adding button widget to the button panel.
		buttonsPanel.add(cancel);
		
		cancel.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				refreshTable();
			}
		});

		//adding languages to the list box
		lang.addItem("-- Select Language -- ");
		if(locales != null){
			for (Locale locale : locales) {
				if(!locale.getKey().equals("en"))
				lang.addItem(locale.getName(), locale.getKey());
			}
		}

		//listener to changing item selection
		lang.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				refreshTable();
			}
		});

		buttonsPanel.setSpacing(5);

		// adding widgets to the top panel and setting its size
		select.add(selecttext);
		select.add(lang);
		select.setSize("100%", "100%");

		// adding style to the table header
		header.addStyleName("FlexTable-Header2");
		header.setCellSpacing(0);
		header.getCellFormatter().setWidth(0, 0, "300px");
		
		//setting the default table headers
		header.setText(0, 0, "English");
		header.setText(0, 1, "Translate to");
		
		//setting table header size
		header.setWidth("650px");

		wordTable.setCellSpacing(0);
		wordTable.addStyleName("FlexTable2");
		wordTable.setSize("650px", "100%");
		
		

		DeferredCommand.addCommand(new Command() {
			@Override
			public void execute() {
				try 
				{
					//dialog to display when loading languages from database
					FormUtil.dlg.setText("Loading Data......");
					FormUtil.dlg.center();
					
					//call to server to read data from database using RPC call.
					Context.getUtilityService().getMobileMenuText("en", 
							new OpenXDataAsyncCallback<List<MobileMenuText>>() {
						@Override
						public void onOtherFailure(Throwable caught) {	
							FormUtil.dlg.hide();
							Window.alert(caught.getMessage());
						}
						
						@Override
						public void onSuccess(List<MobileMenuText> result) 
						{	
							//loading the result into the list from database
							defaultMobileMenuText = result;
							int k = 0;
							
							//Integrating through the list items
							for (MobileMenuText word : defaultMobileMenuText)
							{
								input = new TextBox();
								input.setVisibleLength(50);
								input.setText("");
								
								//loading the table with languages along with there keys
								wordTable.setText(k, 0, word.getMenuText());
								wordTable.setWidget(k, 1, input);

								//Styling the table row with different colors
								if (k == 0 || (k % 2) == 0)
								{
									rf.addStyleName(k,"FlexTable-EvenRow");
								} 
								else 
								{
									rf.addStyleName(k,"FlexTable-OddRow");
								}
								k++;
							}
							FormUtil.dlg.hide();
						}
					  });

				} catch (Exception ex) {
					FormUtil.dlg.hide();
					FormUtil.displayException(ex);
				}
			}
		});

		spacer.setHeight("10px");
		
		//adding close image to the dialog box 
		closePanel.add(closeImg);
		closePanel.setCellHorizontalAlignment(closeImg, HasHorizontalAlignment.ALIGN_RIGHT);
		closePanel.addStyleName("closeDialog");
		closePanel.setWidth("100%");

		mainPanel.add(spacer);
		mainPanel.add(wordTable);
		mainPanel.add(buttonsPanel);
		mainPanel.setCellHorizontalAlignment(buttonsPanel, HasHorizontalAlignment.ALIGN_CENTER);
		main.add(mainPanel);
		main.setSize("680px", "400px");
		majorPanel.add(closePanel);
		majorPanel.add(select);
		majorPanel.add(header);
		majorPanel.add(main);
		
		dialog.setText("Translate");
		dialog.add(majorPanel);
		dialog.center();
		dialog.show();
		dialog.setSize("680px", "100%");
		
		refreshTable();
	}

    /**
	 * 
	 *  Checks for blank text fields in the table 
	 *  
	 */
	public boolean verifyInput() {
		
		//text field to store words entered in the table
		TextBox txt2;
		
		//string to hold validation result
		String isValid = "True";

		//iterating through the table values
		for (int i = 0; i < wordTable.getRowCount(); i++) 
		{
			//assigning table text field value to txt2 text box
			txt2 = (TextBox) wordTable.getWidget(i, 1);
			
			//checking for blank text field values
			if (txt2.getText().trim().length() == 0) 
			{
				isValid = "False";
			}
		}
		
		if (isValid.equals("True")) 
		{
			return true;
		} 
		else {
			return false;
		}
	}

	/**
	 * 
	 *  save mobile menu text translations into the database 
	 *  
	 */
	public void saveElements()
	{
		//String to hold selected language key
		String key = lang.getValue(lang.getSelectedIndex());		
		
		TextBox txt;
		String defaultWord;

		if (targetLang.equals("-- Select Language --")) {
			;
		} else {

			for (int i = 0; i < wordTable.getRowCount(); i++)
			{
				//text field instance
				txt = new TextBox();
				txt = (TextBox) wordTable.getWidget(i, 1);
				defaultWord = wordTable.getText(i, 0).trim();

				for (MobileMenuText engKey : defaultMobileMenuText) 
				{
					if (defaultWord.equals(engKey.getMenuText())) 
					{
						newMobileMenuText = new MobileMenuText();
						newMobileMenuText.setLocaleKey(key);
						newMobileMenuText.setMenuId(engKey.getMenuId());
						newMobileMenuText.setMenuText(txt.getText().trim());
						
						
							if (mobileMenuText.size() < i + 1) 
							{
								mobileMenuText.add(i, newMobileMenuText);
							} else {
								mobileMenuText.set(i, newMobileMenuText);
							}
						
						break;
					}
				}
			}
		
			//Saving translated mobile menu text into the database.
			Context.getUtilityService().saveMobileMenuText(mobileMenuText, 
					new OpenXDataAsyncCallback<Void> ()
			{
				@Override
				public void onOtherFailure(Throwable caught) {
					Window.alert("Failed:" + caught.getMessage());
				}

				@Override
				public void onSuccess(Void result)
				{
					Window.alert("Database Successfully Updated");
					refreshTable();
				}
			});

		}

	}

	/** 
	 * 
	 * loads the table form the database 
	 * 
	 */
	public void refreshTable() {

		//getting the selected language in the list box
		targetLang = lang.getItemText(lang.getSelectedIndex());
		targetLangKey = lang.getValue(lang.getSelectedIndex());
		
		if (targetLang.equals("-- Select Language -- ")) 
		{
			header.setText(0, 1, "Translate to");
			save.setEnabled(false);
			cancel.setEnabled(false);
			
			for (int j = 0; j < defaultMobileMenuText.size(); j++) 
			{
				//loading the table
				input = new TextBox();
				input.setText("");
				input.setVisibleLength(50);

				wordTable.setWidget(j, 1, input);
				
				//adding style to the table rows
				if (j == 0 || (j % 2) == 0) {

					rf.addStyleName(j, "FlexTable-EvenRow");
				} else {
					rf.addStyleName(j, "FlexTable-OddRow");
				}
			}
		} else {

			if (!mobileMenuText.isEmpty())
				mobileMenuText.clear();
			
			FormUtil.dlg.setText("loading Data.....");
			FormUtil.dlg.center();

			//loading mobile menu text from the database into the table.
			DeferredCommand.addCommand(new Command() {
				@Override
				public void execute() {
					try {
						Context.getUtilityService().getMobileMenuText(targetLangKey, 
								new OpenXDataAsyncCallback<List<MobileMenuText>>() {
							@Override
							public void onOtherFailure(Throwable caught) {
								FormUtil.dlg.hide();
								Window.alert(caught.getMessage());
							}
							@Override
							public void onSuccess(List<MobileMenuText> result) 
							{
								mobileMenuText = result;
								
								//Enabling Buttons.
								save.setEnabled(true);
								cancel.setEnabled(true);
								
								header.setText(0, 1, targetLang);

								if (!result.isEmpty()) 
								{
									//Loading the table with mobile menu text from the database
									for (MobileMenuText word : mobileMenuText) 
									{
										//text field to handle text from the database
										input = new TextBox();
										input.setText(word.getMenuText());
										
										//setting the width of the text field.
										input.setVisibleLength(50);
										
										int x = 0;
										
										for (MobileMenuText engKey : defaultMobileMenuText) 
										{
											//checking if database text is corresponding to the English text in that row
											if (engKey.getMenuId() == word.getMenuId()) 
											{
												
												wordTable.setWidget(x,1, input);
												break;
											}
											
											//styling the table rows
											if (x == 0 || (x % 2) == 0) 
											{
												rf.addStyleName(x,"FlexTable-EvenRow");
											} else {
												rf.addStyleName(x,"FlexTable-OddRow");
											}
											x++;												
										}
									}
								} else 
								{
									for (int k = 0; k < defaultMobileMenuText.size(); k++) 
									{										
										input = new TextBox();
										input.setText("");
										input.setVisibleLength(50);
										wordTable.setWidget(k, 1, input);

									}
								}
									FormUtil.dlg.hide();
							}
						});
					} catch (Exception ex) {
						FormUtil.dlg.hide();
						FormUtil.displayException(ex);
					}
				}
			});

		}
	}

}
