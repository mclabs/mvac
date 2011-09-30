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

import java.util.List;
import java.util.Vector;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.controller.observe.ReportsObserver;
import org.openxdata.server.admin.client.controller.observe.StudiesObserver;
import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.listeners.ItemSelectionListener;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.view.mapping.UserFormMapView;
import org.openxdata.server.admin.client.view.mapping.UserReportGroupMapView;
import org.openxdata.server.admin.client.view.mapping.UserReportMapView;
import org.openxdata.server.admin.client.view.mapping.UserStudyMapView;
import org.openxdata.server.admin.model.ReportGroup;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.mapping.UserFormMap;
import org.openxdata.server.admin.model.mapping.UserReportGroupMap;
import org.openxdata.server.admin.model.mapping.UserReportMap;
import org.openxdata.server.admin.model.mapping.UserStudyMap;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

/**
 * Displays properties of the selected <tt>User</tt> and allows you to manipulate them.
 * 
 * @author Angel
 * @author daniel
 *
 */
public class UserView extends OpenXDataBaseView implements StudiesObserver, ReportsObserver {

	/** The user whose properties we are displaying. */
	private User user;
	
	/** Widget for modeling the <tt>User Status.</tt>*/
	private ListBox cboStatus;
	
	private final int TAB_INDEX_PROPERTIES = 0;	
	
	/** Widget for displaying and entering user email address. */
	private TextBox txtEmail;
	
	/** Widget for displaying and entering user name. */
	private TextBox txtName;
	
	/** Widget for displaying and entering user phone number. */
	private TextBox txtPhoneNo;
	
	/** Widget for displaying and entering user last name. */
	private TextBox txtLastName;
	
	/** Widget for displaying and entering user first name. */ 
	private TextBox txtFirstName;
	
	/** Widget for displaying and entering user middle name. */
	private TextBox txtMiddleName;	
		
	/** Widget for entering user secret answer. */
	private TextBox txtSecretAnswer;	
	
	/** Widget for entering user secret question. */
	private TextBox txtSecretQuestion;
	
	/** Widget for entering user password. */
	private TextBox txtPassword;

	/** List of all <code>User Mapped Forms.</code> */
	private List<UserFormMap> userMappedForms;

	/** List of all <code>User Mapped Studies.</code>*/
	private List<UserStudyMap> userMappedStudies;

	/** List of all <code>User Mapped Reports.</code>*/
	private List<UserReportMap> userMappedReports;

	/** List of all deleted <code>User Mapped Forms.</code>*/
	private List<UserFormMap> deletedUserMappedForms;

	/** List of all deleted <code>User Mapped Studies.</code>*/
	private List<UserStudyMap> deletedUserMappedStudies;

	/** List of all deleted <code>User Mapped Reports.</code>*/
	private List<UserReportMap> deletedUserMappedReports;
	
	/** List of all <code>User Mapped Report Groups.</code>*/
	private List<UserReportGroupMap> userMappedReportGroups;
	
	/** Widget for re entering user password. */
	private TextBox txtConfirmPassword;
	
	/** List of all <code>Users Tree View Item Selection Listeners</code> maintained by the class.*/
	private List<ItemSelectionListener> itemSelectionListeners;
	
	/** List of all deleted <code>User Mapped Report Groups.</code>*/
	private List<UserReportGroupMap> deletedUserMappedReportGroups;
	
	/**
	 * Constructor that takes itemChangeListener parameter
	 * @param itemChangeListener itemChangeListener listener to <tt>User</tt> property changes.
	 * @param openXDataViewFactory 
	 */
	public UserView(ItemChangeListener itemChangeListener, OpenXDataViewFactory openXDataViewFactory){
		super(itemChangeListener, openXDataViewFactory);
		
	}
	
	
	@Override
	protected void setUp() {		
		
		txtEmail = new TextBox();
		
		txtName = new TextBox();

		cboStatus = new ListBox();
		
		txtPhoneNo = new TextBox();
		
		txtLastName = new TextBox();
		
		txtFirstName = new TextBox();
		
		txtMiddleName = new TextBox();	
			
		txtSecretAnswer = new TextBox();	
		
		txtSecretQuestion = new TextBox();
		
		txtPassword = new PasswordTextBox();
		
		txtConfirmPassword = new PasswordTextBox();
		
		openxdataStackPanel = widgetFactory.getOpenXdataStackPanel();	
		
		itemSelectionListeners = new Vector<ItemSelectionListener>();
		
		//Register this class with Event Dispatchers.
		super.registerWithEventDispatchers();
		
		if (RolesListUtil.getPermissionResolver().isPermission("Users")) {
			loadView();
		} else {
			loadPermissionLessView();
		}
	}
	
	/**
	 * Loads the View according to the <code>User Permissions.</code>
	 */
	private void loadView() {
		table.setWidget(0, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_name()));
		table.setWidget(1, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_first_name()));
		table.setWidget(2, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_middle_name()));
		table.setWidget(3, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_last_name()));
		table.setWidget(4, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_email()));
		table.setWidget(5, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_phone_no()));
		table.setWidget(6, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_password()));
		table.setWidget(7, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_confirm_password()));
		table.setWidget(8, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_secret_question()));
		table.setWidget(9, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_secret_answer()));
		table.setWidget(10, 0, new Label(OpenXDataFacade.getOpenXDataConstants().label_user_status()));
		
		table.setWidget(0, 1, txtName);
		table.setWidget(1, 1, txtFirstName);
		table.setWidget(2, 1, txtMiddleName);
		table.setWidget(3, 1, txtLastName);
		table.setWidget(4, 1, txtEmail);
		table.setWidget(5, 1, txtPhoneNo);
		table.setWidget(6, 1, txtPassword);
		table.setWidget(7, 1, txtConfirmPassword);
		table.setWidget(8, 1, txtSecretQuestion);
		table.setWidget(9, 1, txtSecretAnswer);
		table.setWidget(10, 1, cboStatus);
		
		txtName.setWidth("100%");
		txtFirstName.setWidth("100%");
		txtMiddleName.setWidth("100%");
		txtLastName.setWidth("100%");
		txtEmail.setWidth("100%");
		txtPhoneNo.setWidth("100%");
		txtPassword.setWidth("100%");
		txtConfirmPassword.setWidth("100%");
		txtSecretQuestion.setWidth("100%");
		txtSecretAnswer.setWidth("100%");
		cboStatus.setWidth("100%");
		
		bindUserStatusTypes();
		
		FlexCellFormatter cellFormatter = table.getFlexCellFormatter();
		cellFormatter.setWidth(0, 0, "20%");
		
		table.getRowFormatter().removeStyleName(0, "FlexTable-Header");
		table.setStyleName("cw-FlexTable");
		
		Utilities.maximizeWidget(table);
		
		tabs.add(table, OpenXDataFacade.getOpenXDataConstants().label_properties());
		
		if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Map_Objects_To_Users")){		
			
			if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Map_Roles_to_Users")){
				setupUserRoleMapView();
			}
				
			
			if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Map_Studies_To_Users")){
				setupUserStudyMapView();
			}
			
			if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Map_Forms_To_Users")){
				setupUserFormMapView();
			}
			
			if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Map_ReportGroups_To_Users")){
				setupUserReportGroupMapView();
			}
			
			if(RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Map_Reports_To_Users")){
				setupUserReportMapView();
			}
		}
		
		Utilities.maximizeWidget(tabs);	    
	    initWidget(tabs);
		
		setWidth("100%");
		setupEventListeners();
		tabs.selectTab(0);
		
		setEnabled(false);
	}

	/**
	 * Sets up the <code>User Report Map View.</code>
	 */
	private void setupUserReportMapView() {
		deletedUserMappedReports = new Vector<UserReportMap>();
		tabs.add(widgetFactory.getUserReportMapView(), "User Reports");
		((UserReportMapView)widgetFactory.getUserReportMapView()).setDeletedUserMappedReports(deletedUserMappedReports);
		itemSelectionListeners.add(widgetFactory.getUserReportMapView());
	}

	/**
	 * Sets up the <code>User Report Group Map View.</code>
	 */
	private void setupUserReportGroupMapView() {
		deletedUserMappedReportGroups = new Vector<UserReportGroupMap>();
		((UserReportGroupMapView)widgetFactory.getUserReportGroupMapView()).setDeletedUserMappedReportGroups(deletedUserMappedReportGroups);
		
		tabs.add(widgetFactory.getUserReportGroupMapView(), "User Report Group Permissions");
		itemSelectionListeners.add(widgetFactory.getUserReportGroupMapView());
	}

	/**
	 * Sets up the <code>User Form Map View.</code>
	 */
	private void setupUserFormMapView() {
		deletedUserMappedForms = new Vector<UserFormMap>();
		((UserFormMapView)widgetFactory.getUserFormMapView()).setDeletedUserMappedForms(deletedUserMappedForms);
		
		tabs.add(widgetFactory.getUserFormMapView(), "User Form Permissions");
		itemSelectionListeners.add(widgetFactory.getUserFormMapView());
		
	}

	/**
	 * Sets up the <code>User Role Map View.</code>
	 */
	private void setupUserRoleMapView() {
		tabs.add(widgetFactory.getUserRoleMapView(), "User Roles");		
		itemSelectionListeners.add(widgetFactory.getUserRoleMapView());
	}

	/**
	 * Sets up the <code>User Study Map View.</code>
	 */
	private void setupUserStudyMapView() {
		deletedUserMappedStudies = new Vector<UserStudyMap>();
		((UserStudyMapView)widgetFactory.getUserStudyMapView()).setDeletedUserMappedStudies(deletedUserMappedStudies);
		
		tabs.add(widgetFactory.getUserStudyMapView(), "User Study Permissions");
		itemSelectionListeners.add(widgetFactory.getUserStudyMapView());
	}

	/**
	 * Bind the <code>User</code> status types to the <code>Combo box.</code>
	 */
	private void bindUserStatusTypes() {
		for(String type : Utilities.getUserStatusTypes())
			cboStatus.addItem(type);
		
	}
	
	/**
	 * Load view for user without permissions
	 */
	private void loadPermissionLessView() {
		table.setWidget(0, 0, new Label(OpenXDataFacade.getOpenXDataConstants().ascertain_permissionLessView() + "Users"));
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
	
	/**
	 * Member variable to set up event listeners for the controls on the widget
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
				char keyCode = event.getCharCode();
				if(keyCode == KeyCodes.KEY_ENTER)
					txtFirstName.setFocus(true);
			}
		});
		
		txtFirstName.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateFirstName();
			}
		});
		txtFirstName.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updateFirstName();
				char keyCode = event.getCharCode();
				if(keyCode == KeyCodes.KEY_ENTER)
					txtMiddleName.setFocus(true);
			}
		});
		
		txtMiddleName.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateMiddleName();
			}
		});
		txtMiddleName.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updateMiddleName();
				char keyCode = event.getCharCode();
				if(keyCode == KeyCodes.KEY_ENTER)
					txtLastName.setFocus(true);
			}
		});
		
		txtLastName.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateLastName();
			}
		});
		txtLastName.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updateLastName();
				char keyCode = event.getCharCode();
				if(keyCode == KeyCodes.KEY_ENTER)
					txtEmail.setFocus(true);
			}
		});
		
		txtEmail.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateEmail();
			}
		});
		txtEmail.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updateEmail();
				char keyCode = event.getCharCode();
				if(keyCode == KeyCodes.KEY_ENTER)
					txtPhoneNo.setFocus(true);
			}
		});
		
		txtPhoneNo.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updatePhoneNo();
			}
		});
		txtPhoneNo.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updatePhoneNo();
				char keyCode = event.getCharCode();
				if(keyCode == KeyCodes.KEY_ENTER)
					txtPassword.setFocus(true);
			}
		});
		
		txtSecretQuestion.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateSecretQuestion();
			}
		});
		txtSecretQuestion.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updateSecretQuestion();
				char keyCode = event.getCharCode();
				if(keyCode == KeyCodes.KEY_ENTER)
					txtSecretAnswer.setFocus(true);
			}
		});
		
		txtSecretAnswer.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateSecretAnswer();
			}
		});
		txtSecretAnswer.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updateSecretAnswer();
			}
		});
		
		txtConfirmPassword.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updatePassword();
				validatePasswordEquality();
			}
		});
		txtConfirmPassword.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				updatePassword();
				char keyCode = event.getCharCode();
				if(keyCode == KeyCodes.KEY_ENTER)
					txtSecretQuestion.setFocus(true);
			}
		});
		
		txtPassword.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				char keyCode = event.getCharCode();
				if(keyCode == KeyCodes.KEY_ENTER)
					txtConfirmPassword.setFocus(true);
			}
		});
		
		txtPassword.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				if (!validateUserPassword()) {
					String message = "The User password specified is less than the default length that is specified in the system. "
							+ "The Password should be equal or more than "
							+ Context.getSetting("defaultUserPasswordLength", "6") + " characters.";

					Utilities.displayMessage(message);
				}
			}
		});
	
		tabs.addSelectionHandler(new SelectionHandler<Integer>() {
			@Override
			public void onSelection(SelectionEvent<Integer> event) {
				initTabProperties(event.getSelectedItem());
			}
		});
		
		cboStatus.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				updateUserStatus();
			}
		});
	}
	
	/**
	 * Checks to see if the <code>User</code> Password is of the specified length.
	 * 
	 * @param user - <code>User object</code> whose password is being checked
	 * @return - <code>True If(txtPassword.getText().Length() > 6(or default Password Length as set by administrator)</code>
	 * <p><code>else false</p></code>
	 */
	protected boolean validateUserPassword() {
		boolean validated = false;
		String systemSettingPasswordLengthValue = Context.getSetting("defaultPasswordLength", "6");
		int passwordLengthValue = Integer.parseInt(systemSettingPasswordLengthValue);
		
		if(txtPassword.getText().equals(""))
			return true;
		
		if(txtPassword.getText().length() >= passwordLengthValue ) {
			validated = true;
			
			txtSecretAnswer.setEnabled(validated);
			txtSecretQuestion.setEnabled(validated);
			txtConfirmPassword.setEnabled(validated);
		}
			
		else {
			validated = false;
			
			txtSecretAnswer.setEnabled(validated);
			txtSecretQuestion.setEnabled(validated);
			txtConfirmPassword.setEnabled(validated);
		}			
		
		return validated;
		
	}

	/**
	 * Checks to ensure if the Password and the Confirmation Password Match.
	 */
	private void validatePasswordEquality() {
		if(!txtPassword.getText().equals(txtConfirmPassword.getText())) {
			Utilities.displayMessage("The Passwords entered do not match! Please check and rectify to proceed!");
			
			txtSecretAnswer.setEnabled(false);
			txtSecretQuestion.setEnabled(false);			
		}
		else {
			txtSecretAnswer.setEnabled(true);
			txtSecretQuestion.setEnabled(true);
		}
	}
	
	/**
	 * Member that updates the name of the user on the display (tree view) as it changes
	 * The changes are also captured and stored on the object
	 */
	private void updateName(){
		if(txtName.isVisible()){
			user.setName(txtName.getText());
			itemChangeListener.onItemChanged(user);
		}
	}
	
	/**
	 * Member that updates the phone number of the user as it changes on the display
	 */
	private void updatePhoneNo(){
		if(txtPhoneNo.isVisible()){
			user.setPhoneNo(txtPhoneNo.getText());
			itemChangeListener.onItemChanged(user);
		}
	}
	
	/**
	 * Member that updates the first name as it changes on the display
	 */
	private void updateFirstName(){
		if(txtFirstName.isVisible()){
			user.setFirstName(txtFirstName.getText());
			itemChangeListener.onItemChanged(user);
		}
	}
	
	/**
	 * Member that updates the middle name as it changes on the display
	 */
	private void updateMiddleName(){
		user.setMiddleName(txtMiddleName.getText());
		itemChangeListener.onItemChanged(user);
	}
	
	/**
	 * Member that updates the last name as it changes on the display
	 */
	private void updateLastName(){
		user.setLastName(txtLastName.getText());
		itemChangeListener.onItemChanged(user);
	}
	
	/**
	 * Member that updates the email address as it changes on the display
	 */
	private void updateEmail(){
		if (!Utilities.validateEmail(txtEmail.getText())) {
			String message =
				"The email address is not a valid email address.";
			Utilities.displayMessage(message);
		} else {
			user.setEmail(txtEmail.getText());
			itemChangeListener.onItemChanged(user);
		}
	}
	
	/**
	 * Member that updates the secret question as it changes on the display
	 */
	private void updateSecretQuestion(){
		user.setSecretQuestion(txtSecretQuestion.getText());
		itemChangeListener.onItemChanged(user);
	}
	
	/**
	 * Member that updates the secret answer as it changes on the display
	 */
	private void updateSecretAnswer(){
		user.setSecretAnswer(txtSecretAnswer.getText());
		itemChangeListener.onItemChanged(user);
	}
	
	/**
	 * Member that updates the password as it changes on the display
	 */
	private void updatePassword(){
		String password = txtPassword.getText();
		String confirmPassword = txtConfirmPassword.getText();
		
		if(password == null || confirmPassword == null || 
		   password.trim().length() == 0 || confirmPassword.trim().length() == 0
		   ||!password.equals(confirmPassword))
			return;
		
		user.setClearTextPassword(txtPassword.getText());
		itemChangeListener.onItemChanged(user);
	}
	
	/**
	 * Updates the <code>User</code> status as selected on the view.
	 */
	private void updateUserStatus() {
		
		if(user != null){
			if(user.isDefaultAdministrator()){
				Utilities.displayMessage("You cannot disable the default Administrator!");
				cboStatus.setSelectedIndex(0);
			}
			else if(Utilities.isUserGuyzb(user.getName())){
				
				if(cboStatus.getItemText(cboStatus.getSelectedIndex()).equals("Active")){
					Utilities.displayMessage("You are enabling guyzb. This User ships with the system and his password is known by the community. " +
					"You are advised to change the password to avoid any security holes or breaches.");
				}
				setStatus();
			}
			else{
				setStatus();
			}
		}
	}

	/**
	 * Sets the <tt>User Status.</tt>
	 */
	private void setStatus() {
		user.setStatusAfterGiveType(cboStatus.getItemText(cboStatus.getSelectedIndex()));
		itemChangeListener.onItemChanged(user);
	}

	/**
	 * Member fired when an item is selected on the tree view
	 */
	@Override
	public void onItemSelected(Composite sender, Object item) {	
		
		setEnabled(true);
		
		if(item == null)
			clear();
		else{
			user = (User)item;
			if(table.isVisible()){
				setTextBoxProperties();
				txtName.setFocus(true);
				txtName.selectAll();
			}
		}
				
		notifyItemSelectionListeners(sender, user);
	}	
	
	/**
	 * Notifies all the registered <code>Item Selection Listeners.</code>
	 * 
	 * @param item Item that has been selected on the <code>tree view.</code>
	 * @param sender The notifier.
	 * 
	 */
	private void notifyItemSelectionListeners(Composite sender, Object item) {
		for(ItemSelectionListener xListener : itemSelectionListeners){
			xListener.onItemSelected(sender, item);
		}
	}

	/**
	 * Predicate member that clears the contents in the text boxes on the display
	 */
	private void clear() {
		txtName.setText(null);
		txtFirstName.setText(null);
		txtMiddleName.setText(null);
		txtLastName.setText(null);
		txtEmail.setText(null);
		txtSecretQuestion.setText(null);
		txtSecretAnswer.setText(null);
		txtPassword.setText(null);
		txtConfirmPassword.setText(null);
		txtPhoneNo.setText(null);
		
	}

	/**
	 * Member that enables/disables the controls on the widget
	 * @param enabled - parameter to enable the control. True for enabling, otherwise disable
	 */
	private void setEnabled(boolean enabled){
		txtName.setEnabled(enabled);
		txtFirstName.setEnabled(enabled);
		txtMiddleName.setEnabled(enabled);
		txtLastName.setEnabled(enabled);
		txtEmail.setEnabled(enabled);
		txtSecretQuestion.setEnabled(enabled);
		txtSecretAnswer.setEnabled(enabled);
		txtPassword.setEnabled(enabled);
		txtConfirmPassword.setEnabled(enabled);
		txtPhoneNo.setEnabled(enabled);
	}

	/**
	 * @see org.openxdata.server.admin.client.listeners.ItemChangeListener#onItemChanged(Object)
	 */
	public void onItemChanged(Object item) {	
		setEnabled(true);
		user = (User)item;
		
		if(table.isVisible()){
			setTextBoxProperties();
			txtName.setFocus(true);
			txtName.selectAll();
		}

		//userRoleMapView.onItemChanged(item);
		
	}

	/**
	 * Sets text box widget values to the user's properties.
	 */
	private void setTextBoxProperties() {
		txtName.setText(user.getName());
		txtFirstName.setText(user.getFirstName());
		txtMiddleName.setText(user.getMiddleName());
		txtLastName.setText(user.getLastName());
		txtEmail.setText(user.getEmail());
		txtSecretQuestion.setText(user.getSecretQuestion());
		txtSecretAnswer.setText(user.getSecretAnswer());
		txtPhoneNo.setText(user.getPhoneNo());
		txtPassword.setText("");
		txtConfirmPassword.setText("");
		
		//Setting the User Status
		cboStatus.setSelectedIndex(user.getStatus());
	}

	/**
	 * @see com.google.gwt.user.client.ui.TabListener#onBeforeTabSelected(SourcesTabEvents, int)
	 */
	public void initTabProperties(int tabIndex) {
		if(tabIndex == TAB_INDEX_PROPERTIES) {
			if(this.user != null)
				setTextBoxProperties();
		}
	
	}

	/**
	 * Sets the system <code>User Mapped Studies.</code>
	 * @param userMappedStudies <code>List</code> of <code>User Mapped Studies.</code>
	 */
	public void setUserMappedStudies(List<UserStudyMap> userMappedStudies){
		this.userMappedStudies = userMappedStudies;
		
		((UserFormMapView)widgetFactory.getUserFormMapView()).setUserMappedStudies(userMappedStudies);
		((UserStudyMapView)widgetFactory.getUserStudyMapView()).setUserMappedStudies(userMappedStudies);
		((UserStudyMapView)widgetFactory.getUserStudyMapView()).initializeObjectProperties();
	}
	
	/**
	 * Returns the <code>User Mapped Studies.</code>
	 * @return <code>List</code> of <code>Mapped Studies.</code>
	 */
	public List<UserStudyMap> getUserMappedStudies(){
		return userMappedStudies;
	}
	
	/**
	 * Sets the system <code>User Mapped Forms.</code>
	 * @param userMappedForms <code>List</code> of <code>User Mapped Forms.</code>
	 */
	public void setUserMappedForms(List<UserFormMap> userMappedForms){
		this.userMappedForms = userMappedForms;		
		((UserFormMapView)widgetFactory.getUserFormMapView()).setUserMappedForms(userMappedForms);
		((UserFormMapView)widgetFactory.getUserFormMapView()).initializeObjectProperties();
	}
	
	/**
	 * Returns the <code>User Mapped Forms.</code>
	 * @return <code>List</code> of </code>User Mapped Forms.</code>
	 */
	public List<UserFormMap> getUserMappedForms(){
		return userMappedForms;
	}
	
	/**
	 * Sets the system <code>User Mapped Report Groups.</code>
	 * @param userMappedReportGroups <code>List</code> of <code>User Mapped Report Groups.</code>
	 */
	public void setUserMappedReportGroups(List<UserReportGroupMap> userMappedReportGroups){
		this.userMappedReportGroups = userMappedReportGroups;
		((UserReportGroupMapView)widgetFactory.getUserReportGroupMapView()).setUserMappedReportGroups(userMappedReportGroups);
		((UserReportGroupMapView)widgetFactory.getUserReportGroupMapView()).initializeObjectProperties();
	}
		
	/**
	 * Returns the <code>User Mapped Report Groups.</code>
	 * @return <code>List</code> of <code>User Mapped Report Groups.</code>
	 */
	public List<UserReportGroupMap> getUserMappedReportGroups(){
		return userMappedReportGroups;
	}
	
	/**
	 * Sets the system <code> User Mapped Reports.</code>
	 * @param userMappedReports <code>List</code> of <code>Mapped Reports.</code>
	 */
	public void setUserMappedReports(List<UserReportMap> userMappedReports){
		this.userMappedReports = userMappedReports;
		((UserReportMapView)widgetFactory.getUserReportMapView()).setUserMappedReports(userMappedReports);
		((UserReportMapView)widgetFactory.getUserReportMapView()).initializeObjectProperties();
	}
	
	/**
	 * Returns the <code>User Mapped Report Groups.</code>
	 * @return <code>List</code> of <code>User Mapped Report Groups.</code>
	 */
	public List<UserReportMap> getUserMappedReports(){
		return userMappedReports;
	}
	
	/**
	 * Retrieves the deleted <code>User Mapped Studies.</code>
	 * @return <code>List</code> of deleted <code>User Mapped Studies.</code>
	 */
	public List<UserStudyMap> getDeletedUserMappedStudies(){
		return deletedUserMappedStudies;
	}
	
	/**
	 * Retrieves the deleted <code>User Mapped Forms.</code>
	 * @return <code>List</code> of deleted <code>User Mapped Forms.</code>
	 */
	public List<UserFormMap> getDeletedUserMappedForms(){
		return deletedUserMappedForms;
	}
	
	/**
	 * Retrieves the deleted <code>User Mapped Report Groups.</code>
	 * @return <code>List</code> of deleted </code>User Mapped Report Groups.</code>
	 */
	public List<UserReportGroupMap> getDeletedUserMappedReportGroups(){
		return deletedUserMappedReportGroups;
	}
	
	/**
	 * Retrieves the deleted <code>User Mapped Reports.</code>
	 * @return <code>List</code> of deleted <code>User Mapped Reports.</code>
	 */
	public List<UserReportMap> getDeletedUserMappedReports(){
		return deletedUserMappedReports;
	}
	
	
	@Override
	public void updateUserMappedForms(OpenXDataObservable observable, List<UserFormMap> userMappedForms) {
		setUserMappedForms(userMappedForms);
		
	}
	
	
	@Override
	public void updateUserMappedStudies(OpenXDataObservable observable, List<UserStudyMap> userMappedStudies) {
		setUserMappedStudies(userMappedStudies);		
	}

	
	@Override
	public void updateUserMappedReportGroups(OpenXDataObservable observable, List<UserReportGroupMap> userMappedReportGroups) {
		setUserMappedReportGroups(userMappedReportGroups);
		
	}
	
	
	@Override
	public void updateUserMappedReports(OpenXDataObservable observable,	List<UserReportMap> userMappedReports) {
		setUserMappedReports(userMappedReports);
		
	}

	
	@Override
	public void update(OpenXDataObservable observable,	Object observedModelObjects) {
		// do nothing
		
	}

	
	@Override
	public void updateStudies(OpenXDataObservable observable, List<StudyDef> studies) {
		// do nothing
		
	}

	
	@Override
	public void updateReportGroups(OpenXDataObservable observable, List<ReportGroup> reportGroups) {
		// do nothing
		
	}

}
