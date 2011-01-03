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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.callback.OpenXDataAsyncCallback;
import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.listeners.GetFileNameDialogEventListener;
import org.openxdata.server.admin.client.listeners.ItemSelectionListener;
import org.openxdata.server.admin.client.service.StudyManagerServiceAsync;
import org.openxdata.server.admin.client.view.dialogs.GetFileNameDialog;
import org.openxdata.server.admin.client.view.treeview.StudiesTreeView;
import org.openxdata.server.admin.client.view.widget.OpenXDataButton;
import org.openxdata.server.admin.client.view.widget.OpenXDataFlexTable;
import org.openxdata.server.admin.model.FormDataHeader;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.FormDefVersion;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.User;
import org.purc.purcforms.client.util.FormUtil;
import org.zenika.widget.client.datePicker.DatePicker;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;


/**
 * This widget displays a list of data that has been collected for gives forms,
 * dates and users.
 * 
 * @author daniel
 *
 */
public class StudyDataView extends Composite implements GetFileNameDialogEventListener {

	private List<FormDataHeader> formDataList;
	private ListBox lbUser = new ListBox(false);
	private ListBox lbForm = new ListBox(false);
	private DatePicker dpToDate = new DatePicker();
	private DatePicker dpFromDate = new DatePicker();
	private FlexTable table = new OpenXDataFlexTable();
	private ItemSelectionListener itemSelectionListener;
	private Button btnExportCsv = new OpenXDataButton(OpenXDataFacade.getOpenXDataConstants().label_export_csv());
	private Button btnAddNew = new OpenXDataButton(OpenXDataFacade.getOpenXDataConstants().label_add_new());

	private List<User> users;
	private List<StudyDef> studies;
	private List<FormDefVersion> forms;


	/**
	 * Constructs an instance of this <tt>Class.</tt>
	 * @param itemSelectionListener the listener for selection on <tt>{@link StudiesTreeView}</tt> change events.
	 */
	public StudyDataView(ItemSelectionListener itemSelectionListener){
		this.itemSelectionListener = itemSelectionListener;
		initWidgets();
	}

	private void initWidgets(){

		table.setWidget(0, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_form()));
		table.setWidget(0, 1, new Label(OpenXDataFacade.getOpenXDataConstants().label_version()));
		table.setWidget(0, 2, new Label(OpenXDataFacade.getOpenXDataConstants().label_description()));
		table.setWidget(0, 3, new Label("Creator"));
		table.setWidget(0, 4, new Label("Date submitted"));
		table.setWidget(0, 5, new Label("Changed by"));
		table.setWidget(0, 6, new Label("Date changed"));
		table.setWidget(0, 7, new Label(OpenXDataFacade.getOpenXDataConstants().label_action()));

		table.setStyleName("cw-FlexTable");

		FlexCellFormatter cellFormatter = table.getFlexCellFormatter();
		cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormatter.setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormatter.setHorizontalAlignment(0, 2, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormatter.setHorizontalAlignment(0, 3, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormatter.setHorizontalAlignment(0, 4, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormatter.setHorizontalAlignment(0, 5, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormatter.setHorizontalAlignment(0, 6, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormatter.setHorizontalAlignment(0, 7, HasHorizontalAlignment.ALIGN_CENTER);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.add(new Label(OpenXDataFacade.getOpenXDataConstants().label_form()));
		horizontalPanel.add(lbForm);
		horizontalPanel.add(new Label(OpenXDataFacade.getOpenXDataConstants().label_from()));
		horizontalPanel.add(dpFromDate);
		horizontalPanel.add(new Label(OpenXDataFacade.getOpenXDataConstants().label_to()));
		horizontalPanel.add(dpToDate);
		horizontalPanel.add(new Label(OpenXDataFacade.getOpenXDataConstants().label_user()));
		horizontalPanel.add(lbUser);

		Button btn = new OpenXDataButton(OpenXDataFacade.getOpenXDataConstants().label_search());
		horizontalPanel.add(btn);
		horizontalPanel.setSpacing(5);

		btn.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				search();
			}
		});

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.add(table);
		initWidget(verticalPanel);

		FormUtil.maximizeWidget(horizontalPanel);
		FormUtil.maximizeWidget(table);
		FormUtil.maximizeWidget(verticalPanel);

		btnExportCsv.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				exportCsv();
			}
		});
		
		btnAddNew.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				addNew();
			}
		});
		
		addNewExportButtons(0);
	}

	private void loadUsers(){
		lbUser.clear();
		if(users == null)
			return;

		lbUser.addItem("", "");
		for(User user : users)
			lbUser.addItem(user.getName(), String .valueOf(user.getUserId()));
	}

	private void loadForms(){
		lbForm.clear();
		if(studies == null)
			return;

		forms = new ArrayList<FormDefVersion>();
		lbForm.addItem("", "");
		for(StudyDef studyDef : studies){
			for(FormDef formDef : studyDef.getForms()){
				for(FormDefVersion formDefVersion : formDef.getVersions()){
					lbForm.addItem(formDef.getName() + "-" + formDefVersion.getName(), String.valueOf(formDefVersion.getFormDefVersionId()));
					forms.add(formDefVersion);
				}
			}
		}
	}

	public void search() {
		FormUtil.dlg.setText(OpenXDataFacade.getOpenXDataConstants().label_loading_data());
		FormUtil.dlg.center();

		DeferredCommand.addCommand(new Command(){
			@Override
			public void execute() {
				try{
					while(table.getRowCount() > 1)
						table.removeRow(1);

					StudyManagerServiceAsync service = Context.getStudyManagerService();

					service.getFormData(getSelFormId(), getSelUserId(), getSelFromDate(), getSelToDate(), 
							new OpenXDataAsyncCallback<List<FormDataHeader>>() {
						
						@Override
						public void onOtherFailure(Throwable caught) {
							FormUtil.dlg.hide();
							Window.alert(caught.getMessage());
						}

						@Override
						public void onSuccess(List<FormDataHeader> formDataList) {
							loadData(formDataList);
							FormUtil.dlg.hide();
						}
					});
				}
				catch(Exception ex){
					FormUtil.dlg.hide();
					FormUtil.displayException(ex);
				}	
			}
		});
	}

	private Integer getSelFormId(){
		int index = lbForm.getSelectedIndex();
		if(index > 0)
			return forms.get(index-1).getFormDefVersionId();
		return null;
	}

	private Integer getSelUserId(){
		int index = lbUser.getSelectedIndex();
		if(index > 0)
			return users.get(index-1).getUserId();
		return null;
	}

	private Date getSelFromDate(){
		return dpFromDate.getSelectedDate();
	}

	private Date getSelToDate(){
		return dpToDate.getSelectedDate();
	}

	private void loadData(List<FormDataHeader> formDataList){
		this.formDataList = formDataList;

		if(formDataList == null)
			return;

		DateTimeFormat dateFormat = DateTimeFormat.getFormat(Context.getSetting("displayDateTimeFormat","dd-MM-yyyy hh:mm:ss a"));
		
		int index = 0; String description = null;
		for(FormDataHeader formData : formDataList){
			index++;

			description = formData.getDescription();
			if(description == null || description.trim().length() == 0)
				description = OpenXDataFacade.getOpenXDataConstants().label_no_description();

			table.setWidget(index, 0, new Label(index + ") " + formData.getFormName()));
			table.setWidget(index, 1, new Label(formData.getVersionName()));
			table.setWidget(index, 2, new Label(description));
			table.setWidget(index, 3, new Label(formData.getCreator()));
			table.setWidget(index, 4, new Label(dateFormat.format(formData.getDateCreated())));
			
			String text = "EMPTY";
			if(formData.getChangedBy() != null)
				text = formData.getChangedBy();
			
			table.setWidget(index, 5, new Label(text));
			
			text = "EMPTY";
			if(formData.getDateChanged() != null)
				text = dateFormat.format(formData.getDateChanged());
			
			table.setWidget(index, 6, new Label(text));

			HorizontalPanel panel = new HorizontalPanel();
			Button btn = new OpenXDataButton(OpenXDataFacade.getOpenXDataConstants().label_open());
			panel.add(btn);
			table.setWidget(index, 7, panel);
			table.getCellFormatter().setHorizontalAlignment(index, 7, HasHorizontalAlignment.ALIGN_CENTER);

			btn.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					Widget sender = (Widget) event.getSource();
					openForm(sender.getParent());
				}
			});
			
			btn = new Button("Delete");
			panel.add(btn);

			btn.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					Widget sender = (Widget) event.getSource();
					deleteForm(sender.getParent());
				}
			});
		}

		addNewExportButtons(index);
	}
	
	private void addNewExportButtons(int index){
		table.setWidget(++index, 0,btnAddNew);
		table.setWidget(index, 1,btnExportCsv);
		FlexCellFormatter cellFormatter = table.getFlexCellFormatter();
		cellFormatter.setHorizontalAlignment(index, 0, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormatter.setHorizontalAlignment(index, 1, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormatter.setColSpan(index, 0, 5);
		cellFormatter.setColSpan(index, 1, 5);
	}

	private int getWidgetIndex(Widget widget){
		int rowCount = table.getRowCount();
		for(int row = 0; row < rowCount; row++){
			if(widget == table.getWidget(row, 0) || widget == table.getWidget(row, 7))
				return row;
		}
		return -1;
	}

	private void openForm(Widget widget){
		int index = getWidgetIndex(widget) - 1;
		itemSelectionListener.onItemSelected(this, formDataList.get(index));
	}
	
	private void deleteForm(Widget widget){
		int index = getWidgetIndex(widget) - 1;
		FormDataHeader formDataHeader = formDataList.get(index);
		
		String desc = formDataHeader.getDescription();
		if(desc == null)
			desc = "";
		if(!Window.confirm("Do you really want to delete all data collected on this form " + desc + " ?"))
			return;
		
		formDataHeader.deleted = true;
		itemSelectionListener.onItemSelected(this, formDataHeader);
		table.removeRow(index+1); //TODO May need to delete after onSuccess callback from the database
		formDataList.remove(index);
	}

	public void setUsers(List<User> users){
		this.users = users;
		loadUsers();
	}

	public void setStudies(List<StudyDef> studies){
		this.studies = studies;
		loadForms();
	}

	private void exportCsv(){
		if(lbForm.getSelectedIndex() < 1){
			//TODO add message for internationalization purposes
			Window.alert("Please select the form to export.");
			return;
		}
		
		new GetFileNameDialog(this, OpenXDataFacade.getOpenXDataConstants().label_export_as(),OpenXDataFacade.getOpenXDataConstants().label_export(),"DataExport").center();
	}
	
	private void exportCsv(String fileName){

		final String name = fileName;
		
		FormUtil.dlg.setText(OpenXDataFacade.getOpenXDataConstants().label_exporting_data());
		FormUtil.dlg.center();

		DeferredCommand.addCommand(new Command(){
			@Override
			public void execute() {
				try{
					Integer formId = getSelFormId();
					if(formId == null){
						FormUtil.dlg.hide();
						//TODO add message for internationalization purposes
						Window.alert("Please select the form to export.");
						return;
					}

					String url = "dataexport?";
					url += "format=csv";
					url += "&formId=" + formId;
					url += "&filename=" + name;
					
					if(getSelUserId() != null)
						url += "&userId=" + getSelUserId();

					if(getSelFromDate() != null)
						url += "&fromDate=" + getSelFromDate().getTime();

					if(getSelToDate() != null)
						url += "&toDate=" + getSelToDate().getTime();

					Window.Location.replace(URL.encode(url));
					
					FormUtil.dlg.hide();		
				}
				catch(Exception ex){
					FormUtil.dlg.hide();
					FormUtil.displayException(ex);
				}	
			}
		});
	}
	
	private void addNew(){
		FormDefVersion formDefVersion  = null;
		
		int index = lbForm.getSelectedIndex();
		if(index > 0)
			formDefVersion = forms.get(index-1);
		
		if(formDefVersion == null){
			//TODO add message for internationalization purposes
			Window.alert("Please select the form to add.");
			return;
		}
		
		itemSelectionListener.onItemSelected(this, formDefVersion);
	}
	
	@Override
	public void onSetFileName(String fileName){
		if(fileName != null && fileName.trim().length() > 0)
			exportCsv(fileName);
	}
}
