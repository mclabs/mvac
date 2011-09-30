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
package org.openxdata.server.admin.client.view.factory;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.listeners.AppEventListener;
import org.openxdata.server.admin.client.listeners.LogoutListener;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.view.MainView;
import org.openxdata.server.admin.client.view.OpenXDataBaseView;
import org.openxdata.server.admin.client.view.ReportView;
import org.openxdata.server.admin.client.view.RoleView;
import org.openxdata.server.admin.client.view.SettingView;
import org.openxdata.server.admin.client.view.StudyView;
import org.openxdata.server.admin.client.view.TaskView;
import org.openxdata.server.admin.client.view.UserView;
import org.openxdata.server.admin.client.view.bar.OpenXDataMenuBar;
import org.openxdata.server.admin.client.view.bar.OpenXDataNotificationBar;
import org.openxdata.server.admin.client.view.bar.OpenXDataToolBar;
import org.openxdata.server.admin.client.view.images.OpenXDataImages;
import org.openxdata.server.admin.client.view.mapping.OpenXDataBaseObjectMapView;
import org.openxdata.server.admin.client.view.treeview.OpenXDataBaseTreeView;
import org.openxdata.server.admin.client.view.treeview.ReportsTreeView;
import org.openxdata.server.admin.client.view.treeview.RolesTreeView;
import org.openxdata.server.admin.client.view.treeview.SettingsTreeView;
import org.openxdata.server.admin.client.view.treeview.StudiesTreeView;
import org.openxdata.server.admin.client.view.treeview.TasksTreeView;
import org.openxdata.server.admin.client.view.treeview.UsersTreeView;
import org.openxdata.server.admin.client.view.treeview.listeners.ContextMenuInitListener;
import org.openxdata.server.admin.client.view.widget.OpenXDataLabel;
import org.openxdata.server.admin.client.view.widget.OpenXDataStackPanel;
import org.openxdata.server.admin.client.view.widget.factory.OpenXDataWidgetFactory;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.openxdata.server.admin.client.view.WorkFlowView;
import org.openxdata.server.admin.client.view.treeview.WorkFlowTreeView;

/**
 * Default implementation of the {@link OpenXDataWidgetFactory}.
 * 
 * <p>
 * The <tt>Composites</tt> returned from this factory are too abstract to be implemented AS IS. 
 * In some cases, you might be required to cast to known <tt>types</tt> before implementing custom behavior.
 * </p>
 *
 * @version 1.0
 * 
 * @author Angel
 *
 */
public class OpenXDataViewFactory implements OpenXDataWidgetFactory
{

    /** MainView for the application.*/
    private Composite mainView;
    /** Dock Panel used on the <tt>MainView</tt> to organize all widgets in a layout.*/
    private DockPanel dockPanel;
    /** Label for showing notifications to the <tt>User.</tt>*/
    private Label notificationLabel;
    /** Widget for listing of Users*/
    private UsersTreeView usersTreeView;
    /** Widget for listing of roles*/
    private RolesTreeView rolesTreeView;
    /** Vertical Panel to align <tt>Widgets.</tt>*/
    private VerticalPanel verticalPanel;
    /** Widget for listing of tasks*/
    private TasksTreeView tasksTreeView;
    /** Widget for displaying studies, forms and versions in a tree view format. */
    private StudiesTreeView studiesTreeView;
    /** Widget for listing of reports*/
    private ReportsTreeView reportsTreeView;
    /** Decorated Tab Panel to hold tabs.*/
    private DecoratedTabPanel decoratedPanel;
    /** The main openXDataToolBar. */
    private OpenXDataToolBar openxdataToolBar;
    /** The main menu bar factory that creates the menu bar. */
    private OpenXDataMenuBar openxdataMenuBar;
    /** Widget for listing of settings*/
    private SettingsTreeView settingsTreeView;
    /** Widget for displaying task properties*/
    private OpenXDataBaseView taskView;
    /** Widget for displaying settings properties*/
    private OpenXDataBaseView settingView;
    /** Widget for displaying User properties*/
    private OpenXDataBaseView userView;
    /** Widget for displaying Role properties*/
    private OpenXDataBaseView roleView;
    /** Widget for displaying Report properties*/
    private OpenXDataBaseView reportView;
    /** Widget for displaying Study properties*/
    private OpenXDataBaseView studyView;
    /** OpenXdata Stack Panel to hold Tree Views.*/
    private OpenXDataStackPanel openXdataStackPanel;
    /** Notification bar for displaying notifications to the <tt>Users.</tt>*/
    private OpenXDataNotificationBar notificationBar;
    /** HorizontalSplitPanel to align main widgets. */
    private HorizontalSplitPanel horizontalSplitClient;
    /** Widget for Mapping Permissions to Roles*/
    private OpenXDataBaseObjectMapView userRolePermissionMapView;
    /** Widget for Mapping Forms to Users*/
    private OpenXDataBaseObjectMapView userFormMapView;
    /** Widget for Mapping Report Groups to Users*/
    private OpenXDataBaseObjectMapView userReportGroupMapView;
    /** Widget for Mapping Reports to Users*/
    private OpenXDataBaseObjectMapView userReportMapView;
    /** Widget for Mapping Roles to Users*/
    private OpenXDataBaseObjectMapView userRoleMapView;
    /** Widget for Mapping Studies to Users*/
    private OpenXDataBaseObjectMapView userStudyMapView;
    /**
     * Instantiate an application-level image bundle.
     * This object will provide code access to all the images needed by widgets.
     */
    public static final OpenXDataImages images = (OpenXDataImages) GWT.create(OpenXDataImages.class);

    /** Constructs an instance of this <tt>class.</tt>*/
    public OpenXDataViewFactory()
    {
    }

    @Override
    public OpenXDataBaseTreeView getStudiesTreeView()
    {
        if (studiesTreeView == null) {
            studiesTreeView = new StudiesTreeView(this);
        }

        return studiesTreeView;
    }

    @Override
    public OpenXDataBaseTreeView getSettingsTreeView()
    {
        if (settingsTreeView == null) {
            settingsTreeView = new SettingsTreeView(this);
        }

        return settingsTreeView;
    }

    @Override
    public OpenXDataBaseTreeView getUsersTreeView()
    {
        if (usersTreeView == null) {
            usersTreeView = new UsersTreeView(this);
        }

        return usersTreeView;
    }

    @Override
    public OpenXDataBaseTreeView getRolesTreeView()
    {
        if (rolesTreeView == null) {
            rolesTreeView = new RolesTreeView(this);
        }

        return rolesTreeView;
    }

    @Override
    public OpenXDataBaseTreeView getReportsTreeView()
    {
        if (reportsTreeView == null) {
            reportsTreeView = new ReportsTreeView(this);
        }

        return reportsTreeView;
    }

    @Override
    public OpenXDataBaseTreeView getTasksTreeView()
    {
        if (tasksTreeView == null) {
            tasksTreeView = new TasksTreeView(this);
        }

        return tasksTreeView;
    }

    @Override
    public OpenXDataBaseView getTaskView()
    {
        if (taskView == null) {
            taskView = new TaskView(getTasksTreeView(), this);
        }

        return taskView;
    }

    @Override
    public OpenXDataBaseView getSettingView()
    {
        if (settingView == null) {
            settingView = new SettingView(getSettingsTreeView(), this);
        }

        return settingView;
    }

    @Override
    public OpenXDataBaseView getUserView()
    {
        if (userView == null) {
            userView = new UserView(getUsersTreeView(), this);
        }

        return userView;
    }

    @Override
    public OpenXDataBaseView getRoleView()
    {
        if (roleView == null) {
            roleView = new RoleView(getRolesTreeView(), this);
        }

        return roleView;
    }

    @Override
    public OpenXDataBaseView getReportView()
    {
        if (reportView == null) {
            reportView = new ReportView(getReportsTreeView(), this);
        }

        return reportView;
    }

    @Override
    public OpenXDataBaseView getStudyView()
    {
        if (studyView == null) {
            studyView = new StudyView(getStudiesTreeView(), this);
        }

        return studyView;
    }

    @Override
    public Composite getMainView(LogoutListener logoutListener)
    {
        if (mainView == null) {

            // Construct a new MainView
            mainView = MainViewFactory.createMainView(logoutListener);

            ((MainView) mainView).setWidgetFactory(this);

            // Initialize the widgets on the MainView
            ((MainView) mainView).initializeMainViewWidgets();
        }

        return mainView;
    }

    @Override
    public Composite getOpenXDataMenuBar()
    {
        if (openxdataMenuBar == null) {
            if (RolesListUtil.getInstance().isAdmin()) {

                // Construct an administrative Menu Bar.
                openxdataMenuBar = MenuBarFactory.instanceOfAdministrator();
                openxdataMenuBar.setApplicationEventListener((AppEventListener) mainView);
            } else {

                // Construct a Menu Bar according to User permissions.
                openxdataMenuBar = MenuBarFactory.instanceOfUserPermissions();
                openxdataMenuBar.setApplicationEventListener((AppEventListener) mainView);
            }
        }

        return openxdataMenuBar;
    }

    @Override
    public Composite getOpenXDataToolBar()
    {
        if (openxdataToolBar == null) {
            if (RolesListUtil.getInstance().isAdmin()) {

                // Prepare the Tool bar for administrative User.
                openxdataToolBar = ToolBarFactory.instanceOfAdministrator(this);

                // Set Application Event Listener.
                openxdataToolBar.setApplicationEventListener((AppEventListener) mainView);
            } else {

                // Prepare the Tool bar according to User Permissions.
                openxdataToolBar = ToolBarFactory.instanceOfUserPermissions(this);

                // Set Application Event Listener.
                openxdataToolBar.setApplicationEventListener((AppEventListener) mainView);
            }
        }

        return openxdataToolBar;
    }

    @Override
    public VerticalPanel getVerticalPanel()
    {
        if (verticalPanel == null) {
            verticalPanel = new VerticalPanel();

            verticalPanel.setWidth("100%");

            //Menu Bar
            verticalPanel.add(getOpenXDataMenuBar());

            //Notification Bar
            verticalPanel.add(getNotificationBar());

            //Tool Bar
            verticalPanel.add(getOpenXDataToolBar());

        }

        return verticalPanel;
    }

    @Override
    public Composite getNotificationBar()
    {
        if (notificationBar == null) {

            // Handle to the Notification Bar.
            notificationBar = new OpenXDataNotificationBar();

            // Set the Widget Factory
            notificationBar.setWidgetFactory(this);

            notificationBar.setUp();
        }

        return notificationBar;
    }

    @Override
    public Label getNotificationLabel()
    {
        if (notificationLabel == null)
            notificationLabel = new OpenXDataLabel(" ");

        return notificationLabel;
    }

    @Override
    public HorizontalSplitPanel getHorizontalSplitPanel()
    {
        if (horizontalSplitClient == null) {
            horizontalSplitClient = new HorizontalSplitPanel();

            horizontalSplitClient.setSplitPosition("20%");
            horizontalSplitClient.setRightWidget(studyView);
        }

        return horizontalSplitClient;
    }

    @Override
    public OpenXDataImages getOpenXDataImages()
    {
        return OpenXDataViewFactory.images;
    }

    @Override
    public OpenXDataBaseObjectMapView getRolePermissionMapView()
    {
        if (userRolePermissionMapView == null) {
            userRolePermissionMapView = UserObjectMapViewFactory.createOrGetRolePermissionMapView(rolesTreeView);
            userRolePermissionMapView.setWidgetFactory(this);
        }

        return userRolePermissionMapView;
    }

    @Override
    public OpenXDataBaseObjectMapView getUserFormMapView()
    {
        if (userFormMapView == null) {
            userFormMapView = UserObjectMapViewFactory.createOrGetUserFormMapView(usersTreeView);
            userFormMapView.setWidgetFactory(this);
        }

        return userFormMapView;
    }

    @Override
    public OpenXDataBaseObjectMapView getUserReportGroupMapView()
    {
        if (userReportGroupMapView == null) {
            userReportGroupMapView = UserObjectMapViewFactory.createOrGetUserReportGroupMapView(usersTreeView);
            userReportGroupMapView.setWidgetFactory(this);
        }

        return userReportGroupMapView;
    }

    @Override
    public OpenXDataBaseObjectMapView getUserReportMapView()
    {
        if (userReportMapView == null) {
            userReportMapView = UserObjectMapViewFactory.createOrGetUserReportMapView(usersTreeView);
            userReportMapView.setWidgetFactory(this);
        }

        return userReportMapView;
    }

    @Override
    public OpenXDataBaseObjectMapView getUserRoleMapView()
    {
        if (userRoleMapView == null) {
            userRoleMapView = UserObjectMapViewFactory.createOrGetUserRoleMapView(usersTreeView);
            userRoleMapView.setWidgetFactory(this);
        }

        return userRoleMapView;
    }

    @Override
    public OpenXDataBaseObjectMapView getUserStudyMapView()
    {
        if (userStudyMapView == null) {
            userStudyMapView = UserObjectMapViewFactory.createOrGetUserStudyMapView(usersTreeView);
            userStudyMapView.setWidgetFactory(this);
        }

        return userStudyMapView;
    }

    @Override
    public DecoratedTabPanel getDecoratedPanel()
    {
        if (decoratedPanel == null)
            decoratedPanel = new DecoratedTabPanel();

        return decoratedPanel;
    }

    @Override
    public OpenXDataStackPanel getOpenXdataStackPanel()
    {
        if (openXdataStackPanel == null)
            openXdataStackPanel = new OpenXDataStackPanel(MainViewControllerFacade.getInstance());

        return openXdataStackPanel;

    }

    public DockPanel getDockPanel()
    {
        if (dockPanel == null)
            dockPanel = new DockPanel();

        return dockPanel;
    }

    @Override
    public Composite getMainView()
    {
        return mainView;
    }

    @Override
    public PopupPanel getContextMenu(ContextMenuInitListener contextMenuListener, UIViewLabels labels, String treeViewName)
    {
        if (Context.getAuthenticatedUser().hasAdministrativePrivileges()) {
            return ContextMenuFactory.constructContextMenuInstanceOfAdmin(this, contextMenuListener, labels);
        } else if (RolesListUtil.getPermissionResolver().isAddPermission(treeViewName) || RolesListUtil.getPermissionResolver().isDeletePermission(treeViewName)) {
            return ContextMenuFactory.constructContextMenuInstanceOfUserPermissions(this, contextMenuListener, labels);
        } else {
            return ContextMenuFactory.constructContextMenuInstanceOfPermissionLessUser(this);
        }
    }
    private WorkFlowView workFlowView;
    private WorkFlowTreeView WorkFlowTreeView;

    @Override
    public WorkFlowView getWorkFlowView()
    {
        if (workFlowView == null)
            workFlowView = new WorkFlowView(getFlowTreeView(), this);
        return workFlowView;
    }

    @Override
    public WorkFlowTreeView getFlowTreeView()
    {
        if (WorkFlowTreeView == null)
            WorkFlowTreeView = new WorkFlowTreeView(this);
        return WorkFlowTreeView;
    }
}
