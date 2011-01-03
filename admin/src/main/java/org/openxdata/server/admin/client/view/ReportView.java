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
import java.util.List;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.controller.observe.StudiesObserver;
import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.constants.OpenXDataStackPanelConstants;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.view.listeners.OpenXDataExportImportApplicationEventListener;
import org.openxdata.server.admin.client.view.widget.OpenXDataButton;
import org.openxdata.server.admin.client.view.widget.OpenXDataLabel;
import org.openxdata.server.admin.model.FormDef;
import org.openxdata.server.admin.model.FormDefVersion;
import org.openxdata.server.admin.model.Report;
import org.openxdata.server.admin.model.ReportGroup;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.mapping.UserFormMap;
import org.openxdata.server.admin.model.mapping.UserReportMap;
import org.openxdata.server.admin.model.mapping.UserStudyMap;
import org.purc.purcforms.client.QueryBuilderWidget;
import org.purc.purcforms.client.controller.OpenFileDialogEventListener;
import org.purc.purcforms.client.model.OptionDef;
import org.purc.purcforms.client.model.QuestionDef;
import org.purc.purcforms.client.util.FormUtil;
import org.purc.purcforms.client.util.StyleUtil;
import org.purc.purcforms.client.view.OpenFileDialog;
import org.purc.purcforms.client.xforms.XformBuilder;
import org.purc.purcforms.client.xforms.XformParser;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

/**
 * This widget displays properties of the selected report and lets you edit them.
 * 
 * @author daniel
 * @author Angel
 *
 */
public class ReportView extends OpenXDataBaseView implements SelectionHandler<Integer>, OpenXDataExportImportApplicationEventListener, OpenFileDialogEventListener, StudiesObserver{
	
	/** The report definition object. */
	private Report report;
	
	/** The report group object. */
	private ReportGroup reportGroup;
	
	/** Label for the report type. */
	private Label lblType;
	
	/** Label for the report title. */
	private Label lblTitle;

	/** Widget for entering the name of the report or group. */
	private TextBox txtName;

	/** Widget for entering the description of the report or group. */
	private TextBox txtDescription;

	/** List of form versions from which to select the one to use for the report. */
	private ListBox lbForms;

	/** Widget for displaying status of whether the report has a report definition file or not. */
	private TextBox txtDefinition;

	/** Widget for displaying status and selection of the report definition file. */
	private HorizontalPanel panelDef;

	/** Widget for entering the report type. */
	private ListBox lbType;

	/** Widget for entering the report title. */
	private TextBox txtTitle;

	/** Widget for entering the title for chart x axis. */
	private TextBox txtXAxisTitle;

	/** Widget for entering the title for chart y axis. */
	private TextBox txtYAxisTitle;

	private TextBox txtOddColor;
	
	private TextBox txtEvenColor;

	/** List of forms versions. */
	private List<FormDefVersion> forms;

	/** The index of the report design tab. */
	private final int TAB_INDEX_DESIGN = 1;

	/** The index of report data display tab. */
	private final int TAB_INDEX_DATA = 2;
	
	private boolean reportDefChanged = false;
	
	private Label lblFormSource;
	
	/** Widget for organizing report properties into categories using tabs. */
	private Label lblOddColor;
	
	private Label lblEvenColor;
	
	/** Button for clicking to select the report definiton file. */
	private Button btnRptDef;
	
	/** Label for the y axis title. */
	private Label lblYAxisTitle;
	
	/** Widget for displaying report data in html format. */
	private ReportDataView reportDataView;
	
	/** Label for the report definition file. */
	private Label lblReportFile;
	
	/** Label for the the x axis title. */
	private Label lblXAxisTitle;
	
	/** The query builder widget. */
	private QueryBuilderWidget queryBuilder;

	/** Widget for setting the color property. */
	private SuggestBox sgstOddColor;
	
	private SuggestBox sgstEvenColor;
	
	/**
	 * Creates a new instance of the report view.
	 * @param itemChangeListener listener to <tt>Report</tt> property changes.
	 * @param openXDataViewFactory 
	 */
	public ReportView(ItemChangeListener itemChangeListener, OpenXDataViewFactory openXDataViewFactory){
		super(itemChangeListener, openXDataViewFactory);
	}

	
	@Override
	protected void setUp() {
		
		lblType = new OpenXDataLabel("Type");
		
		lblTitle = new OpenXDataLabel("Title");
		
		txtName = new TextBox();
		
		txtDescription = new TextBox();
		
		lbForms = new ListBox(false);
		
		lblFormSource = new OpenXDataLabel("Form Source");
		
		lblOddColor = new OpenXDataLabel("Odd Row Color");
		
		lblEvenColor = new OpenXDataLabel("Even Row Color");
		
		txtDefinition = new TextBox();
		
		panelDef = new HorizontalPanel();
		
		lbType = new ListBox(false);
		
		txtTitle = new TextBox();
		
		txtTitle = new TextBox();
		
		txtXAxisTitle = new TextBox();
		
		txtYAxisTitle = new TextBox();
		
		txtOddColor = new TextBox();
		
		txtEvenColor = new TextBox();
		
		btnRptDef = new OpenXDataButton("Select");
		
		lblYAxisTitle = new OpenXDataLabel("Vertical Axis Title");
		
		reportDataView = new ReportDataView(this);
		
		lblReportFile = new OpenXDataLabel("Report definition file");
		
		lblXAxisTitle = new OpenXDataLabel("Horizontal Axis Title");
		
		queryBuilder = new QueryBuilderWidget();
		
		sgstOddColor = new SuggestBox(new MultiWordSuggestOracle(),txtOddColor);
		
		sgstEvenColor = new SuggestBox(new MultiWordSuggestOracle(),txtEvenColor);
		
		openxdataStackPanel = widgetFactory.getOpenXdataStackPanel();
		
		//Register this class with Event Dispatchers.
		super.registerWithEventDispatchers();
		
		if (RolesListUtil.getPermissionResolver().isPermission("Reports")) {
			loadView();
		} else {
			loadPermissionLessView();
		}
		
		enableReportProperties(false);
	}

	private void loadPermissionLessView() {
		table.setWidget(0, 0, new Label(OpenXDataFacade.getOpenXDataConstants().ascertain_permissionLessView() + "Reports"));
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
		table.setWidget(2, 0, lblFormSource);
		table.setWidget(3, 0, lblReportFile);

		table.setWidget(4, 0, lblType);
		table.setWidget(5, 0, lblTitle);
		table.setWidget(6, 0, lblXAxisTitle);
		table.setWidget(7, 0, lblYAxisTitle);
		table.setWidget(8, 0, lblOddColor);
		table.setWidget(9, 0, lblEvenColor);

		table.setWidget(0, 1, txtName);
		table.setWidget(1, 1, txtDescription);
		table.setWidget(2, 1, lbForms);

		panelDef.add(txtDefinition);
		panelDef.add(btnRptDef);
		panelDef.setCellWidth(btnRptDef, "20%");
		FormUtil.maximizeWidget(txtDefinition);
		table.setWidget(3, 1, panelDef);

		table.setWidget(4, 1, lbType);
		table.setWidget(5, 1, txtTitle);
		table.setWidget(6, 1, txtXAxisTitle);
		table.setWidget(7, 1, txtYAxisTitle);
		table.setWidget(8, 1, sgstOddColor);
		table.setWidget(9, 1, sgstEvenColor);

		txtName.setWidth("100%");
		txtDescription.setWidth("100%");
		lbForms.setWidth("100%");
		txtDefinition.setWidth("100%");
		panelDef.setWidth("100%");
		lbType.setWidth("100%");
		txtTitle.setWidth("100%");
		txtXAxisTitle.setWidth("100%");
		txtYAxisTitle.setWidth("100%");
		sgstOddColor.setWidth("100%");
		sgstEvenColor.setWidth("100%");

		FlexCellFormatter cellFormatter = table.getFlexCellFormatter();
		cellFormatter.setWidth(0, 0, "20%");
		table.getRowFormatter().removeStyleName(0, "FlexTable-Header");
		table.setStyleName("cw-FlexTable");
		
		Utilities.maximizeWidget(table);

		
		if (RolesListUtil.getPermissionResolver().isPermission("Reports")) {
			tabs.add(table, OpenXDataFacade.getOpenXDataConstants().label_properties());
		}

		if (RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Report_Query_Builder")) {
			tabs.add(queryBuilder, "Fields");
		}

		if (RolesListUtil.getPermissionResolver().isPermission("Reports")) {
			tabs.add(reportDataView, "Output");
		}
		
		Utilities.maximizeWidget(reportDataView);
		Utilities.maximizeWidget(tabs);

		initWidget(tabs);

		setWidth("100%");
		setupEventListeners();
		tabs.selectTab(0);
		tabs.addSelectionHandler(this);

		lbType.addItem("Report Listing");
		lbType.addItem("Bar Chart");
		lbType.addItem("Line Chart");
		lbType.addItem("Pie Chart");
		/*lbType.addItem("Area Chart");
		lbType.addItem("Tube Chart");
		lbType.addItem("Cone Chart");
		lbType.addItem("Pyramid Chart");
		lbType.addItem("Scatter Chart");
		lbType.addItem("Stock Chart");
		lbType.addItem("Bubble Chart");
		lbType.addItem("Difference Chart");*/

		StyleUtil.loadColorNames((MultiWordSuggestOracle)sgstOddColor.getSuggestOracle());
		StyleUtil.loadColorNames((MultiWordSuggestOracle)sgstEvenColor.getSuggestOracle());
		
		queryBuilder.hideDebugTabs();

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
			public void onKeyPress(KeyPressEvent arg0) {
				updateDescription();
			}
		});
		
		txtTitle.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateTypeAndTitle();
			}
		});
		txtTitle.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent arg0) {
				updateTypeAndTitle();
			}
		});
		txtXAxisTitle.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateTypeAndTitle();
			}
		});
		txtXAxisTitle.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent arg0) {
				updateTypeAndTitle();
			}
		});
		txtYAxisTitle.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateTypeAndTitle();
			}
		});
		txtYAxisTitle.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent arg0) {
				updateTypeAndTitle();
			}
		});

		lbType.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateTypeAndTitle();
			}
		});

		lbForms.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				if(report != null){
					//TODO May want to localize this.
					FormDefVersion formDefVersion = forms.get(lbForms.getSelectedIndex()-1);
					report.setFormDefVersionId(formDefVersion.getFormDefVersionId());
					report.setDirty(true);
					queryBuilder.setXform(getXform(formDefVersion));
				}
			}
		});

		final OpenFileDialogEventListener eventListener = this;
		btnRptDef.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				OpenFileDialog dlg = new OpenFileDialog(eventListener,"formopen");
				dlg.center();
			}
		});

		txtDefinition.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				if(report != null){
					if(txtDefinition.getText().trim().length() == 0)
						report.setDefinition(null);
					
					itemChangeListener.onItemChanged(report);
				}
			}
		});

		sgstOddColor.addSelectionHandler(new SelectionHandler<Suggestion>() {
			@Override
			public void onSelection(SelectionEvent<Suggestion> arg0) {
				updateTypeAndTitle();
			}
		});

		sgstEvenColor.addSelectionHandler(new SelectionHandler<Suggestion>() {
			@Override
			public void onSelection(SelectionEvent<Suggestion> arg0) {
				updateTypeAndTitle();
			}
		});

		txtOddColor.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateTypeAndTitle();
			}
		});

		txtEvenColor.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateTypeAndTitle();
			}
		});

	}

	/**
	 * Updates a report or group with the new name as typed by the user.
	 * 
	 * @param sender the widget having the new name.
	 */
	private void updateName(){
		if(report != null){
			report.setName(txtName.getText());
			itemChangeListener.onItemChanged(report);
		}
		else{
			reportGroup.setName(txtName.getText());
			itemChangeListener.onItemChanged(reportGroup);
		}
	}

	/**
	 * Updates a report or group with the new description as typed by the user.
	 * 
	 * @param sender the widget having the new description.
	 */
	private void updateDescription(){
		if(report != null){
			report.setDescription(txtDescription.getText());
			itemChangeListener.onItemChanged(report);
		}
		else{
			reportGroup.setDescription(txtDescription.getText());
			itemChangeListener.onItemChanged(reportGroup);
		}
	}	

	/**
	 * Updates a report with the new type or title as typed by the user.
	 */
	private void updateTypeAndTitle(){
		if(report != null){
			report.setParamValues(lbType.getItemText(lbType.getSelectedIndex())+"|"+txtTitle.getText()+
					"|" + txtXAxisTitle.getText() + "|" + txtYAxisTitle.getText() +
					"|" + txtOddColor.getText() + "|" + txtEvenColor.getText());
			itemChangeListener.onItemChanged(report);
		}
	}

	/**
	 * @see org.openxdata.server.admin.client.listeners.ItemSelectionListener#onItemSelected(Composite, Object)
	 */
	@Override
	public void onItemSelected(Composite sender,Object item) {
		report = null;
		reportGroup = null;
		reportDataView.loadReport(null);

		if(item instanceof Report){
			report = (Report)item;
			txtName.setText(report.getName());
			txtDescription.setText(report.getDescription());
			String def = report.getDefinition();
			if(def != null && def.trim().length() == 0)
				def = null;
			txtDefinition.setText(def == null ? null : "CLEAR");
			lbForms.setSelectedIndex(getFormIndex(report.getFormDefVersionId()));

			FormDefVersion formDefVersion = getFormDefVersion(report.getFormDefVersionId());
			if(formDefVersion != null)
				queryBuilder.setXform(getXform(formDefVersion));

			queryBuilder.setQueryDef(report.getQueryDefinition());
			queryBuilder.setSql(report.getQuerySql());

			enableReportProperties(true);

			reportDataView.setReport(report);
			getTypeAndTitle();

			if(tabs.getTabBar().getSelectedTab() == TAB_INDEX_DATA)
				reportDataView.refresh();
		}
		else{
			reportGroup = (ReportGroup)item;
			txtName.setText(reportGroup.getName());
			txtDescription.setText(reportGroup.getDescription());

			queryBuilder.setXform(null);
			queryBuilder.setQueryDef(null);
			queryBuilder.setSql(null);

			enableReportProperties(false);

			reportDataView.setReport(null);
		}

		if(tabs.getTabBar().getSelectedTab() == TAB_INDEX_DESIGN)
			queryBuilder.load();
	}	

	/**
	 * Enables or disables editing of report properties.
	 * 
	 * @param enabled set to true to enable, else false.
	 */
	private void enableReportProperties(boolean enabled){
		lbForms.setVisible(enabled);
		lblFormSource.setVisible(enabled);
		lblReportFile.setVisible(enabled);
		lblType.setVisible(enabled);
		lblTitle.setVisible(enabled);
		panelDef.setVisible(enabled);
		lbType.setVisible(enabled);
		txtTitle.setVisible(enabled);
		lblXAxisTitle.setVisible(enabled);
		lblYAxisTitle.setVisible(enabled);
		txtXAxisTitle.setVisible(enabled);
		txtYAxisTitle.setVisible(enabled);
		lblOddColor.setVisible(enabled);
		lblEvenColor.setVisible(enabled);
		txtOddColor.setVisible(enabled);
		txtEvenColor.setVisible(enabled);
	}

	/**
	 * Sets the list of available studies.
	 * 
	 * @param studies the study list.
	 */
	public void setStudies(List<StudyDef> studies){
		forms = loadForms(lbForms,studies);
	}

	/**
	 * Fills a list box with a form versions in a list of studies.
	 * 
	 * @param lbForm the list box.
	 * @param studies the study list.
	 * @return the loaded form versions list.
	 */
	public List<FormDefVersion> loadForms(ListBox lbForm, List<StudyDef> studies){
		lbForm.clear();
		List<FormDefVersion> forms = new ArrayList<FormDefVersion>();

		if(studies == null)
			return forms;

		lbForm.addItem("", "");
		for(StudyDef studyDef : studies){
			for(FormDef formDef : studyDef.getForms()){
				for(FormDefVersion formDefVersion : formDef.getVersions()){
					lbForm.addItem(formDef.getName() + "-" + formDefVersion.getName(), String.valueOf(formDefVersion.getFormDefVersionId()));
					forms.add(formDefVersion);
				}
			}
		}

		return forms;
	}

	/**
	 * Gets the FormDefVersion of a given form version id.
	 * 
	 * @param formDefVersionId the form version id.
	 * @return the FormDefVersion.
	 */
	public FormDefVersion getFormDefVersion(Integer formDefVersionId){
		if(formDefVersionId == null)
			return null;

		for(FormDefVersion formDefVersion : forms){
			if(formDefVersion.getFormDefVersionId() == formDefVersionId)
				return formDefVersion;
		}
		return null;
	}

	/**
	 * 
	 * @param formDefVersion
	 * @return
	 */
	public String getXform(FormDefVersion formDefVersion){
		//TODO This needs to be done more efficiently by not rebuilding the 
		//xform every time we change to a different report.
		org.purc.purcforms.client.model.FormDef formDef = XformParser.fromXform2FormDef(formDefVersion.getXform());

		QuestionDef qtnDef = new QuestionDef(formDef.getPageAt(0));
		qtnDef.setId(formDef.getQuestionCount() + 1);
		qtnDef.setVariableName("openxdata_user_name");
		qtnDef.setDataType(QuestionDef.QTN_TYPE_LIST_EXCLUSIVE);
		qtnDef.setText("User");
		formDef.addQuestion(qtnDef);

		int index = 0;
		List<User> users = Context.getUsers();
		for(User user : users)
			qtnDef.addOption(new OptionDef(++index, user.getName(), user.getName(),qtnDef));

		return FormUtil.formatXml(XformBuilder.fromFormDef2Xform(formDef));
	}

	/**
	 * Gets the list box index of a given form version id.
	 * 
	 * @param formDefVersionId the form version id.
	 * @return the list box index of the form version.
	 */
	public int getFormIndex(Integer formDefVersionId){
		if(formDefVersionId == null)
			return -1;

		for(int index = 0; index < forms.size(); index++){
			FormDefVersion formDefVersion = forms.get(index);
			if(formDefVersion.getFormDefVersionId() == formDefVersionId)
				return index+1;
		}
		return -1;
	}

	/**
	 * Displays a report with given html.
	 * 
	 * @param html the report html
	 */
	public void loadReport(String html){
		reportDataView.loadReport(html);
	}

	/**
	 * Gets the sql statement for the report.
	 * 
	 * @return the report sql statement.
	 */
	public String getSql(){
		if(tabs.getTabBar().getSelectedTab() != TAB_INDEX_DESIGN && report != null)
			return report.getQuerySql();
		return queryBuilder.getSql();
	}

	/**
	 * Saves values from the widgets to the report definition object.
	 */
	public void commitChanges(boolean optimize){
		//If we have the design tab selected, we are assuming user has made changes to the report
		if(!optimize || tabs.getTabBar().getSelectedTab() == TAB_INDEX_DESIGN){
			if(report != null){
				report.setQueryDefinition(queryBuilder.getQueryDef());
				report.setQuerySql(queryBuilder.getSql());
				report.setDirty(true);
			}
		}
	}

	@Override
	public void onSelection(SelectionEvent<Integer> event) {
		Integer selectedIndex = event.getSelectedItem();
		if(selectedIndex == TAB_INDEX_DESIGN)
			queryBuilder.load();
		else if(selectedIndex == TAB_INDEX_DATA){
			if(reportDefChanged)
				commitChanges(false);
			reportDataView.refresh();
		}
		
		reportDefChanged = (selectedIndex == TAB_INDEX_DESIGN);
	}

	/**
	 * @see org.purc.purcforms.client.controller.OpenFileDialogEventListener#onSetFileContents(String)
	 */
	@Override
	public void onSetFileContents(String contents){
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,"formopen");

		try{
			builder.sendRequest(null, new RequestCallback(){
				@Override
				public void onResponseReceived(Request request, Response response){
					String contents = response.getText();
					if(contents != null && contents.trim().length() > 0){
						report.setDefinition(contents);
						txtDefinition.setText("CLEAR");
						itemChangeListener.onItemChanged(report);
					}
				}

				@Override
				public void onError(Request request, Throwable exception){
					exception.printStackTrace();
					Window.alert(exception.getMessage());
				}
			});
		}
		catch(RequestException ex){
			ex.printStackTrace();
			Window.alert(ex.getMessage());
		}
	}

	/**
	 * Gets the report type and title as one string.
	 */
	private void getTypeAndTitle(){
		try{
			lbType.setSelectedIndex(0);
			txtTitle.setText(null);
			txtXAxisTitle.setText(null);
			txtYAxisTitle.setText(null);
			sgstOddColor.setText(null);
			sgstEvenColor.setText("#AACCFF");

			String values = report.getParamValues();
			if(values == null || values.trim().length() == 0)
				return;
			int pos1 = values.indexOf('|');
			lbType.setSelectedIndex(getChartTypeIndex(values.substring(0, pos1)));

			pos1++;
			int pos2 = values.indexOf('|',pos1);
			if(pos2 < 0)
				pos2 = values.length();
			txtTitle.setText(values.substring(pos1,pos2));

			if(pos2 == values.length())
				return;

			pos1 = pos2+1;
			pos2 = values.indexOf('|',pos1);
			if(pos2 < 0)
				pos2 = values.length();
			txtXAxisTitle.setText(values.substring(pos1,pos2));

			if(pos2 == values.length())
				return;

			pos1 = pos2+1;
			pos2 = values.indexOf('|',pos1);
			if(pos2 < 0)
				pos2 = values.length();
			txtYAxisTitle.setText(values.substring(pos1,pos2));

			if(pos2 == values.length())
				return;

			pos1 = pos2+1;
			pos2 = values.indexOf('|',pos1);
			if(pos2 < 0)
				pos2 = values.length();
			sgstOddColor.setText(values.substring(pos1,pos2));

			if(pos2 == values.length())
				return;

			pos1 = pos2+1;
			pos2 = values.indexOf('|',pos1);
			if(pos2 < 0)
				pos2 = values.length();
			sgstEvenColor.setText(values.substring(pos1,pos2));
		}
		catch(Exception ex){}
	}

	/**
	 * Gets the position index of a given chart type.
	 * 
	 * @param text the chart type.
	 * @return the chart type index.
	 */
	private int getChartTypeIndex(String text){
		if(text.equals("Bar Chart"))
			return 1;
		else if(text.equals("Line Chart"))
			return 2;
		else if(text.equals("Pie Chart"))
			return 3;
		else if(text.equals("Area Chart"))
			return 4;
		else if(text.equals("Tube Chart"))
			return 5;
		else if(text.equals("Cone Chart"))
			return 6;
		else if(text.equals("Pyramid Chart"))
			return 7;
		else if(text.equals("Scatter Chart"))
			return 8;
		else if(text.equals("Stock Chart"))
			return 9;
		else if(text.equals("Bubble Chart"))
			return 10;
		else if(text.equals("Difference Chart"))
			return 11;

		return 0; //"Report Listing"
	}

	/**
	 * Reloads report data.
	 */
	public void refresh(){
		reportDataView.refresh();
	}

	
	@Override
	public void exportAsPdf(){
		reportDataView.exportAsPdf();
	}

	/**
	 * Checks if we are displaying report data.
	 * 
	 * @return true if diplaying report data, else false.
	 */
	public boolean isInReportDataMode(){
		return tabs.getTabBar().getSelectedTab() == TAB_INDEX_DATA;
	}

	
	@Override
	public void update(OpenXDataObservable observable, Object observedModelObjects) {
		//do nothing
	}
	
	/**
	 * @return
	 */
	public List<UserReportMap> getDeletedUserMappedReportGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void updateStudies(OpenXDataObservable observable, List<StudyDef> studies) {
		setStudies(studies);
		
	}

	
	@Override
	public void updateUserMappedForms(OpenXDataObservable observable, List<UserFormMap> userMappedForms) {
		//do nothing
		
	}

	
	@Override
	public void updateUserMappedStudies(OpenXDataObservable observable, List<UserStudyMap> userMappedStudies) {
		// d nothing
		
	}

	
	@Override
	public void onExport() {
		exportAsPdf();
		
	}

	
	@Override
	public void onImport() {
		// do nothing
		
	}

	
	@Override
	public void onOpen() {
		// do nothing
		
	}

	
	@Override
	public void onDeleteItem() {
		// do nothing
		
	}

	
	@Override
	public void onNewChildItem() {
		// do nothing
		
	}

	
	@Override
	public void onNewItem() {
		// do nothing
		
	}

	
	@Override
	public void onRefresh() {
		MainViewControllerFacade.refreshData();
		
	}

	
	@Override
	public void onSave() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_REPORTS){
			MainViewControllerFacade.saveReports();
		}
	}
}
