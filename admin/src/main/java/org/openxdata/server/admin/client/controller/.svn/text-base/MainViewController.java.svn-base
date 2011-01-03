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
package org.openxdata.server.admin.client.controller;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObserver;
import org.openxdata.server.admin.client.view.MainView;
import org.openxdata.server.admin.client.view.OpenXDataBaseView;
import org.openxdata.server.admin.client.view.ReportView;
import org.openxdata.server.admin.client.view.RoleView;
import org.openxdata.server.admin.client.view.StudyView;
import org.openxdata.server.admin.client.view.UserView;
import org.openxdata.server.admin.client.view.treeview.OpenXDataBaseTreeView;
import org.openxdata.server.admin.client.view.treeview.ReportsTreeView;
import org.openxdata.server.admin.client.view.treeview.RolesTreeView;
import org.openxdata.server.admin.client.view.treeview.SettingsTreeView;
import org.openxdata.server.admin.client.view.treeview.StudiesTreeView;
import org.openxdata.server.admin.client.view.treeview.TasksTreeView;
import org.openxdata.server.admin.client.view.treeview.UsersTreeView;

import com.google.gwt.user.client.ui.Composite;

/**
 * This controller deals with loading and saving of data, to and from the database, 
 * for the various views.
 * 
 * @author daniel
 * @author Mark
 *
 */
public class MainViewController {
			
	/**
	 * An instance of {@link org.openxdata.server.admin.client.controller.UserViewController}
	 * 
	 * This will handle all movement of data for the views in relation to loading, saving and
	 * movement of Users related data.
	 */
	private UserViewController userViewController;
	
	/**
	 * An instance of {@link org.openxdata.server.admin.client.controller.TasksViewController}
	 * 
	 * This will handle all movement of data for the views in relation to loading, saving and
	 * movement of Tasks related data.
	 */
	private TasksViewController tasksViewController;
	
	/**
	 * An instance of {@link org.openxdata.server.admin.client.controller.RolesViewController}
	 * 
	 * This will handle all movement of data for the views in relation to loading, saving and
	 * movement of Permissions related data.
	 */
	private RolesViewController rolesViewController;
	
	/**
	 * An instance of {@link org.openxdata.server.admin.client.controller.UtilityViewController}
	 * 
	 * This will handle all movement of data for the views in relation to loading, saving and
	 * movement of Utilities related data. Utilities include locales, mobile menu text
	 */
	private UtilityViewController utilityViewController;
	
	/**
	 * An instance of {@link org.openxdata.server.admin.client.controller.StudiesViewController}
	 * 
	 * This will handle all movement of data for the views in relation to loading, saving and
	 * movement of Studies related data.
	 */
	private StudiesViewController studiesViewController;
	
	/**
	 * An instance of {@link org.openxdata.server.admin.client.controller.ReportsViewController}
	 * 
	 * This will handle all movement of data for the views in relation to loading, saving and
	 * movement of Reports related data.
	 */
	private ReportsViewController reportsViewController;	
	
	/**
	 * An instance of {@link org.openxdata.server.admin.client.controller.SettingsViewController}
	 * 
	 * This will handle all data movement for the views in relation to loading, saving and
	 * movement of Settings related data.
	 */
	private SettingsViewController settingsViewController;
	
	/**
	 * Initializes the MainViewController with all the ancillary controllers for the views.
	 * 
	 * @param mainView The main view of the application
	 * @param studiesTreeView Studies tree view that will be loaded on the UI
	 * @param usersTreeView Users tree view that will be loaded on the UI
	 * @param rolesTreeView Settings tree view that will be loaded on the UI
	 * @param tasksTreeView Tasks tree view that will be loaded on the UI
	 * @param settingsTreeView Reports tree view that will be loaded on the UI
	 * @param reportsTreeView Reports view that will be loaded on the UI
	 * @param studyView Roles tree view that will be loaded on the UI
	 * @param userView Studies view that will be loaded on the UI
	 * @param roleView Role view that will be loaded on the UI
	 * @param reportView View to display Report Properties
	 */
	public MainViewController(Composite mainView, OpenXDataBaseTreeView studiesTreeView, OpenXDataBaseTreeView usersTreeView,
			OpenXDataBaseTreeView rolesTreeView, OpenXDataBaseTreeView tasksTreeView, OpenXDataBaseTreeView settingsTreeView,OpenXDataBaseTreeView reportsTreeView, OpenXDataBaseView studyView,
			OpenXDataBaseView userView, OpenXDataBaseView roleView,	OpenXDataBaseView reportView) {


		setupUtilityViewController(mainView);
		setupTasksViewController(tasksTreeView);			
		setupSettingsViewController(settingsTreeView);
		setupUserViewController(usersTreeView,studyView);
		
		setupRolesViewController(rolesTreeView, roleView);
		setupReportsViewController(reportsTreeView, reportView, userView);
		setupStudiesViewController(studiesTreeView, studyView, userView, reportView);
	}
	
	/**
	 * Sets up the {@link UtilityViewController}
	 * 
	 * @param mainView instance of {@link MainView} that was created by the factory.
	 */
	private void setupUtilityViewController(Composite mainView) {
		
		utilityViewController = new UtilityViewController();
		
		//Registering Observers
		utilityViewController.addObserver(Context.getContextInstance());//Register the Context first because other classes depend on it.	
	}

	/**
	 * Sets up the {@link TasksViewController}
	 * 
	 * @param rolesTreeView instance of {@link TasksTreeView} that was created by the factory.
	 */
	private void setupTasksViewController(OpenXDataBaseTreeView tasksTreeView) {
		tasksViewController = new TasksViewController((TasksTreeView) tasksTreeView);
		
		//Registering Observers
		tasksViewController.addObserver(tasksTreeView);
		
	}

	/**
	 * Sets up the {@link SettingsViewController}
	 * 
	 * @param settingsTreeView instance of {@link SettingsTreeView} that was created by the factory.
	 */
	private void setupSettingsViewController(OpenXDataBaseTreeView settingsTreeView) {
		settingsViewController = new SettingsViewController((SettingsTreeView) settingsTreeView);
		
		//Registering Observers
		settingsViewController.addObserver(Context.getContextInstance());//Register the Context first because other classes depend on it.
		settingsViewController.addObserver(settingsTreeView);
		
		
	}

	/**
	 * Sets up the {@link RolesViewController}
	 * 
	 * @param rolesTreeView instance of {@link RolesTreeView} that was created by the factory.
	 * @param roleView instance of {@link RoleView} that was created by the factory.
	 */
	private void setupRolesViewController(OpenXDataBaseTreeView rolesTreeView, OpenXDataBaseView roleView) {
		
		rolesViewController = new RolesViewController(rolesTreeView, roleView);
		
		//Registering Observers		
		rolesViewController.addObserver(Context.getContextInstance());//Register the Context first because other classes depend on it.
		rolesViewController.addObserver(rolesTreeView);	
		rolesViewController.addObserver((OpenXDataObserver) roleView);
		
		
	}

	/**
	 * Sets up the {@link ReportsViewController}
	 * 
	 * @param reportsTreeView instance of {@link ReportsTreeView} that was created by the factory.
	 * @param reportView instance of {@link ReportView} that was created by the factory.
	 * @param userView instance of {@link UserView} that was created by the factory.
	 */
	private void setupReportsViewController(OpenXDataBaseTreeView reportsTreeView, OpenXDataBaseView reportView, OpenXDataBaseView userView) {
		
		reportsViewController = new ReportsViewController(reportsTreeView, reportView, userView);
		
		//Registering Observers
		reportsViewController.addObserver(Context.getContextInstance());//Register the Context first because other classes depend on it.
		reportsViewController.addObserver((OpenXDataObserver) userView);
		reportsViewController.addObserver((OpenXDataObserver) reportView);
		reportsViewController.addObserver(reportsTreeView);
		
	}

	/**
	 * Sets up the {@link StudiesViewController}
	 * 
	 * @param studiesTreeView instance of {@link StudiesTreeView} that was created by the factory.
	 * @param studyView instance of {@link StudyView} that was created by the factory.
	 * @param userView instance of {@link UserView} that was created by the factory.
	 * @param reportView instance of {@link ReportView} that was created by the factory.
	 */
	private void setupStudiesViewController(OpenXDataBaseTreeView studiesTreeView, OpenXDataBaseView studyView, OpenXDataBaseView userView, OpenXDataBaseView reportView) {
		
		studiesViewController = new StudiesViewController(studiesTreeView, userView);
		
		//Registering observers
		studiesViewController.addObserver(Context.getContextInstance());//Register the Context first because other classes depend on it.
		studiesViewController.addObserver((OpenXDataObserver) userView);
		studiesViewController.addObserver((OpenXDataObserver) studyView);
		studiesViewController.addObserver((OpenXDataObserver) reportView);		
		studiesViewController.addObserver(studiesTreeView);
		
	}

	/**
	 * Sets up the {@link UserViewController}.
	 * 
	 * @param usersTreeView instance of {@link UsersTreeView} that was created by the factory.
	 * 
	 */
	private void setupUserViewController(OpenXDataBaseTreeView usersTreeView, OpenXDataBaseView studyView) {
		
		userViewController = new UserViewController((UsersTreeView) usersTreeView);
		
		//Registering observers
		userViewController.addObserver(Context.getContextInstance());//Register the Context first because other classes depend on it.
		userViewController.addObserver(usersTreeView);	
		userViewController.addObserver((StudyView)studyView);
	}

	/**
	 * Returns an instance of the Permission Controller for the application.
	 * Should never be set manually but left to the Main View Controller to build one
	 * in order to have a single one for the whole application
	 * 
	 * @return The PermissionController
	 */
	public RolesViewController getRolesViewController() {
		return rolesViewController;
	}
	
	/**
	 * Returns an instance of the User Controller for the application.
	 * Should never be set manually but left to the Main View Controller to build one
	 * in order to have a single one for the whole application
	 * 
	 * @return The UserViewController
	 */
	public UserViewController getUserViewController(){
		return this.userViewController;
	}

	/**
	 * Returns an instance of the Studies Controller for the application.
	 * Should never be set manually but left to the Main View Controller to build one
	 * in order to have a single one for the whole application
	 * 
	 * @return The StudiesViewController
	 */
	public StudiesViewController getStudiesViewController() {
		return studiesViewController;
	}

	/**
	 * Returns an instance of the Reports Controller for the application.
	 * Should never be set manually but left to the Main View Controller to build one
	 * in order to have a single one for the whole application
	 * 
	 * @return The ReportsViewController
	 */
	public ReportsViewController getReportsViewController() {
		return reportsViewController;
	}

	/**
	 * Returns an instance of the Tasks Controller for the application.
	 * Should never be set manually but left to the Main View Controller to build one
	 * in order to have a single one for the whole application
	 * 
	 * @return The TasksViewController
	 */
	public TasksViewController getTasksViewController() {
		return tasksViewController;
	}

	/**
	 * Returns an instance of the Settings Controller for the application.
	 * Should never be set manually but left to the Main View Controller to build one
	 * in order to have a single one for the whole application
	 * 
	 * @return The SettingsViewController
	 */
	public SettingsViewController getSettingsViewController() {
		return settingsViewController;
	}

	/**
	 * Returns an instance of the Utility Controller for the application.
	 * Should never be set manually but left to the Main View Controller to build one
	 * in order to have a single one for the whole application
	 * 
	 * @return The UtilityViewController
	 */
	public UtilityViewController getUtilityViewController() {
		return utilityViewController;
	}
}
