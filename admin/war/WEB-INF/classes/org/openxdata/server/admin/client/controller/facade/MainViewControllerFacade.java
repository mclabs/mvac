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
package org.openxdata.server.admin.client.controller.facade;

import org.openxdata.server.admin.client.controller.MainViewController;
import org.openxdata.server.admin.client.listeners.StackPanelListener;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.OpenXDataBaseView;
import org.openxdata.server.admin.client.view.ReportView;
import org.openxdata.server.admin.client.view.StudyView;
import org.openxdata.server.admin.client.view.bar.OpenXDataToolBar;
import org.openxdata.server.admin.client.view.constants.OpenXDataStackPanelConstants;
import org.openxdata.server.admin.client.view.treeview.OpenXDataBaseTreeView;
import org.openxdata.server.admin.client.view.widget.OpenXDataLabel;
import org.openxdata.server.admin.client.view.widget.factory.OpenXDataWidgetFactory;
import org.openxdata.server.admin.model.TaskDef;
import org.openxdata.server.admin.model.exception.OpenXDataException;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import org.openxdata.server.OpenXDataConstants;
import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.events.ViewMatchWorkflowsEvent;
import org.openxdata.server.admin.client.view.WorkFlowView;

/**
 * This class encapsulates direct calls to the specific 
 * <code>MainViewController</code> from the caller and forwards those 
 * calls to the correct <code>View Controller</code> to effect an operation.
 * 
 * @author Angel on Dec 17, 2009
 *
 */
public class MainViewControllerFacade implements StackPanelListener
{

    /** Handle to <tt>Widget Factory.</tt>*/
    protected static OpenXDataWidgetFactory widgetFactory;
    /**
     * MainViewController that will be used to forward calls.
     */
    private static MainViewController mainViewControllerInstance;

    /**
     * Loads <code>Studies</code>.
     *
     * @param reload parameter to indicate if
     * <code>database</code> call should be made in subsequent calls of this method.
     */
    public static void loadStudies(boolean reload)
    {
        getMVCInstance().getStudiesViewController().loadStudies(reload);
    }

    /**
     * @return <code>this</code> instance of <code>MainViewController</code>
     */
    private static MainViewController getMVCInstance()
    {
        return mainViewControllerInstance;
    }

    /**
     * Loads <code>Users</code>.
     *
     * @param reload parameter to indicate if
     * <code>database</code> call should be made in subsequent calls of this method.
     */
    public static void loadUsers(boolean reload)
    {
        getMVCInstance().getUserViewController().loadUsers(reload);
    }

    /**
     * Loads <code>Roles</code>.
     *
     * @param reload parameter to indicate if
     * <code>database</code> call should be made in subsequent calls of this method.
     */
    public static void loadRoles(boolean reload)
    {
        getMVCInstance().getRolesViewController().loadRoles(reload);
    }

    /**
     * Loads <code>Permissions</code>.
     *
     * @param reload parameter to indicate if
     * <code>database</code> call should be made in subsequent calls of this method.
     */
    public static void loadPermissions(boolean reload)
    {
        getMVCInstance().getRolesViewController().loadPermissions(reload);
    }

    /**
     * Loads <code>Tasks</code>.
     *
     * @param reload parameter to indicate if
     * <code>database</code> call should be made in subsequent calls of this method.
     */
    public static void loadTasks(boolean reload)
    {
        getMVCInstance().getTasksViewController().loadTasks(reload);
    }

    /**
     * Loads <code>Settings</code>.
     *
     * @param reload parameter to indicate if
     * <code>database</code> call should be made in subsequent calls of this method.
     */
    public static void loadSettings(boolean reload)
    {
        getMVCInstance().getSettingsViewController().loadSettings(reload);
    }

    /**
     * Loads <code>Reports</code>.
     *
     * @param reload parameter to indicate if
     * <code>database</code> call should be made in subsequent calls of this method.
     */
    public static void loadReports(boolean reload)
    {
        getMVCInstance().getReportsViewController().loadReports(reload);
    }

    /**
     * Saves new, modified or dirty <code>Studies</code>.
     */
    public static void saveStudies()
    {
        getMVCInstance().getStudiesViewController().saveStudies();

        Window.alert("Successfully Saved Studies.");
    }

    /**
     * Saves new, modified or dirty <code>Users</code>.
     * @throws OpenXDataException
     *
     * @throws OpenXDataException For any <code>Exception</code> that might occur during saving.
     */
    public static void saveUsers()
    {
        getMVCInstance().getUserViewController().saveUsers();

        Window.alert("Successfully Saved Users.");
    }

    /**
     * Saves new, modified or dirty <code>Roles</code>.
     */
    public static void saveRoles()
    {
        getMVCInstance().getRolesViewController().saveRoles();

        Window.alert("Successfully Saved Roles.");
    }

    /**
     * Saves new, modified or dirty <code>Tasks</code>.
     */
    public static void saveTasks()
    {
        getMVCInstance().getTasksViewController().saveTasks();

        Window.alert("Successfully Saved Tasks.");
    }

    /**
     * Saves new, modified or dirty <code>Settings</code>.
     */
    public static void saveSettings()
    {
        getMVCInstance().getSettingsViewController().saveSettings();

        Window.alert("Successfully Saved Settings.");
    }

    /**
     * Saves new, modified or dirty <code>Reports</code>.
     */
    public static void saveReports()
    {
        getMVCInstance().getReportsViewController().saveReports();

        Window.alert("Successfully Saved Reports.");
    }

    /**
     * Loads Locales from the database.
     *
     * @param reload
     */
    public static void loadLocales(boolean reload)
    {
        getMVCInstance().getUtilityViewController().loadLocales(reload);
    }

    /**
     * Loads all the persisted <code>UserStudyMap objects.</code>
     *
     * @param reload parameter to determine if a database reload is needed.
     */
    public static void loadAllUserMappedStudies(boolean reload)
    {
        getMVCInstance().getStudiesViewController().loadMappedStudies(reload);
    }

    /**
     * Loads all the persisted <code>UserReportGroupMap objects.</code>
     *
     * @param reload parameter to determine if a database reload is needed.
     */
    public static void loadAllUserMappedReportGroups(boolean reload)
    {
        getMVCInstance().getReportsViewController().loadMappedReportGroups(reload);
    }

    /**
     * Saves <code>User Mapped Report Groups.</code>
     */
    public static void saveMappedReportGroups()
    {
        getMVCInstance().getReportsViewController().saveMappedReportGroups();
    }

    /**
     * Saves <code>User Mapped Studies.</code>
     */
    public static void saveMappedStudies()
    {
        getMVCInstance().getStudiesViewController().saveMappedStudies();
    }

    /**
     * Saves <code>User Mapped Forms.</code>
     */
    public static void saveMappedForms()
    {
        getMVCInstance().getStudiesViewController().saveUserMappedForms();
    }

    /**
     * Saves <code>User Mapped Reports.</code>
     */
    public static void saveMappedReports()
    {
        getMVCInstance().getReportsViewController().saveMappedReports();
    }

    /**
     * Loads all the persisted <code>UserFormMap objects.</code>
     *
     * @param reload parameter to determine if a database reload is needed.
     */
    public static void loadAllUserMappedForms(boolean reload)
    {
        getMVCInstance().getStudiesViewController().loadMappedForms(reload);
    }

    /**
     * Loads all the persisted <code>UserReportMap objects.</code>
     *
     * @param reload parameter to determine if a database reload is needed.
     */
    public static void loadAllUserMappedReports(boolean reload)
    {
        getMVCInstance().getReportsViewController().loadMappedReports(reload);
    }

    /**
     * Prepares the {@link MainViewController}
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
    public static void prepareMainViewController(Composite mainView, OpenXDataBaseTreeView studiesTreeView,
            OpenXDataBaseTreeView usersTreeView, OpenXDataBaseTreeView rolesTreeView, OpenXDataBaseTreeView tasksTreeView, OpenXDataBaseTreeView settingsTreeView,
            OpenXDataBaseTreeView reportsTreeView, OpenXDataBaseView studyView, OpenXDataBaseView userView, OpenXDataBaseView roleView, OpenXDataBaseView reportView)
    {

        if (getMVCInstance() == null)
            mainViewControllerInstance =
                    new MainViewController(mainView, studiesTreeView, usersTreeView, rolesTreeView,
                    tasksTreeView, settingsTreeView, reportsTreeView, studyView, userView, roleView, reportView);
    }

    /**
     * Loads preliminary data for the all the views.
     */
    public static void loadPreliminaryViewData()
    {

        Utilities.displayNotificationMessage("Loading Data...");

        DeferredCommand.addCommand(new Command()
        {

            @Override
            public void execute()
            {

                //The outline below should be changed with caution.
                //Observables do not provide a guarantee on when they will notify observers
                //so we need some objects at the earliest time possible like Permissions, Roles and Users.
                if (RolesListUtil.getPermissionResolver().isPermission("Perm_View_Permissions"))
                    MainViewControllerFacade.loadPermissions(false);

                if (RolesListUtil.getPermissionResolver().isViewPermission("Perm_View_Roles"))
                    MainViewControllerFacade.loadRoles(false);

                if (RolesListUtil.getPermissionResolver().isViewPermission("Perm_View_Users"))
                    MainViewControllerFacade.loadUsers(false);

                if (RolesListUtil.getPermissionResolver().isViewPermission("Perm_View_Studies"))
                    MainViewControllerFacade.loadStudies(false);

                if (RolesListUtil.getPermissionResolver().isViewPermission("Perm_View_Settings"))
                    MainViewControllerFacade.loadSettings(false);

                if (RolesListUtil.getPermissionResolver().isViewPermission("Perm_View_Reports"))
                    MainViewControllerFacade.loadReports(false);

                if (RolesListUtil.getPermissionResolver().isViewPermission("Perm_View_Mapped_Studies"))
                    MainViewControllerFacade.loadAllUserMappedStudies(false);

                if (RolesListUtil.getPermissionResolver().isViewPermission("Perm_View_Mapped_Forms"))
                    MainViewControllerFacade.loadAllUserMappedForms(false);

                if (RolesListUtil.getPermissionResolver().isViewPermission("Perm_View_Mapped_Report_Groups"))
                    MainViewControllerFacade.loadAllUserMappedReportGroups(false);

                if (RolesListUtil.getPermissionResolver().isViewPermission("Perm_View_Mapped_Reports"))
                    MainViewControllerFacade.loadAllUserMappedReports(false);

                ((OpenXDataToolBar) widgetFactory.getOpenXDataToolBar()).refresh();

                ((OpenXDataLabel) widgetFactory.getNotificationLabel()).setDefaultText();
            }
        });
    }

    /**
     * Saves all the dirty <tt>editables</tt> in the system.
     *
     * @throws Exception if any <tt>exception</tt> occurs.
     */
    public static void saveData() throws Exception
    {

        Utilities.displayNotificationMessage("Saving Data...");

        DeferredCommand.addCommand(new Command()
        {

            @Override
            public void execute()
            {
                switch (widgetFactory.getOpenXdataStackPanel().getSelectedIndex()) {
                    case OpenXDataStackPanelConstants.INDEX_STUDIES:
                        saveStudies();
                        saveMappedStudies();
                        break;
                    case OpenXDataStackPanelConstants.INDEX_USERS:
                        saveUsers();
                        break;
                    case OpenXDataStackPanelConstants.INDEX_ROLES:
                        saveRoles();
                        break;
                    case OpenXDataStackPanelConstants.INDEX_TASKS:
                        saveTasks();
                        break;
                    case OpenXDataStackPanelConstants.INDEX_SETTINGS:
                        saveSettings();
                        break;
                    case OpenXDataStackPanelConstants.INDEX_REPORTS:
                        saveReports();
                        saveMappedReports();
                        break;
                }
                ((OpenXDataLabel) widgetFactory.getNotificationLabel()).setDefaultText();

            }
        });

        Window.alert("Data Successfully Saved.");
    }

    /**
     * Refreshes the data in the system by making service layer calls to pull new data.
     */
    public static void refreshData()
    {

        Utilities.displayNotificationMessage("Refreshing Data...");
        DeferredCommand.addCommand(new Command()
        {

            @Override
            public void execute()
            {
                switch (widgetFactory.getOpenXdataStackPanel().getSelectedIndex()) {
                    case OpenXDataStackPanelConstants.INDEX_STUDIES:
                        if (((StudyView) widgetFactory.getStudyView()).isInFormDesignMode())
                            ((StudyView) widgetFactory.getStudyView()).refreshItem();
                        else {
                            loadStudies(true);
                            loadAllUserMappedStudies(true);
                        }
                        break;
                    case OpenXDataStackPanelConstants.INDEX_USERS:
                        loadUsers(true);
                        break;
                    case OpenXDataStackPanelConstants.INDEX_ROLES:
                        loadRoles(true);
                        break;
                    case OpenXDataStackPanelConstants.INDEX_TASKS:
                        loadTasks(true);
                        break;
                    case OpenXDataStackPanelConstants.INDEX_SETTINGS:
                        loadSettings(true);
                        break;
                    case OpenXDataStackPanelConstants.INDEX_REPORTS:
                        if (((ReportView) widgetFactory.getReportView()).isInReportDataMode())
                            ((ReportView) widgetFactory.getReportView()).refresh();
                        else {
                            loadReports(true);
                            loadAllUserMappedReports(true);
                        }
                        break;
                }
                ((OpenXDataLabel) widgetFactory.getNotificationLabel()).setDefaultText();

            }
        });
    }

    @Override
    public void onSelectedIndexChanged(final int newIndex)
    {

        Utilities.displayNotificationMessage("Loading Data... ");
        DeferredCommand.addCommand(new Command()
        {

            @Override
            public void execute()
            {
                switch (newIndex) {
                    case OpenXDataStackPanelConstants.INDEX_STUDIES:
                        MainViewControllerFacade.loadAllUserMappedStudies(false);
                        MainViewControllerFacade.loadStudies(false);
                        widgetFactory.getHorizontalSplitPanel().setRightWidget(widgetFactory.getStudyView());
                        break;
                    case OpenXDataStackPanelConstants.INDEX_USERS:
                        MainViewControllerFacade.loadRoles(false);
                        MainViewControllerFacade.loadUsers(false);
                        widgetFactory.getHorizontalSplitPanel().setRightWidget(widgetFactory.getUserView());
                        break;
                    case OpenXDataStackPanelConstants.INDEX_ROLES:
                        MainViewControllerFacade.loadRoles(false);
                        widgetFactory.getHorizontalSplitPanel().setRightWidget(widgetFactory.getRoleView());
                        break;
                    case OpenXDataStackPanelConstants.INDEX_TASKS:
                        MainViewControllerFacade.loadTasks(false);
                        widgetFactory.getHorizontalSplitPanel().setRightWidget(widgetFactory.getTaskView());
                        break;
                    case OpenXDataStackPanelConstants.INDEX_SETTINGS:
                        MainViewControllerFacade.loadSettings(false);
                        widgetFactory.getHorizontalSplitPanel().setRightWidget(widgetFactory.getSettingView());
                        break;
                    case OpenXDataStackPanelConstants.INDEX_REPORTS:
                        MainViewControllerFacade.loadAllUserMappedReports(false);
                        MainViewControllerFacade.loadReports(false);
                        widgetFactory.getHorizontalSplitPanel().setRightWidget(widgetFactory.getReportView());
                        break;

                    case OpenXDataStackPanelConstants.INDEX_WORKFLOWs:
                        Context.getEventBus().fireEvent(new ViewMatchWorkflowsEvent());
                        widgetFactory.getHorizontalSplitPanel().setRightWidget(widgetFactory.getWorkFlowView());
                        break;


                }

                ((OpenXDataLabel) widgetFactory.getNotificationLabel()).setDefaultText();
            }
        });


    }

     private WorkFlowView workFlowView;
    /**
     * Retrieves the configure instance of this <tt>class.</tt>
     * @return instance of {@link MainViewControllerFacade}
     */
    public static MainViewControllerFacade getInstance()
    {
        return MainViewControllerFacadeHolder.INSTANCE;
    }

    /**
     * Holds an instance to this <tt>class.</tt>
     *
     * @author Angel
     *
     */
    private static class MainViewControllerFacadeHolder
    {

        private static MainViewControllerFacade INSTANCE = new MainViewControllerFacade();
    }

    /**
     * Private constructor to avoid outside initialization of this <tt>class.</tt>
     */
    private MainViewControllerFacade()
    {
    }

    /**
     * Starts a given <tt>TaskDef.</tt>
     *
     * @param task <tt>TaskDef</tt> to start.
     */
    public static void startTask(TaskDef task)
    {
        getMVCInstance().getTasksViewController().startTask(task);
    }

    /**
     * Stops a given <tt>TaskDef.</tt>
     *
     * @param task <tt>TaskDef</tt> to stop.
     */
    public static void stopTask(TaskDef task)
    {
        getMVCInstance().getTasksViewController().stopTask(task);
    }

    /**
     * Sets the <tt>Widget Factory.</tt>
     *
     * @param openxdataWidgetFactory <tt>Widget Factory to set.</tt>
     */
    public static void setWidgetFactory(OpenXDataWidgetFactory openxdataWidgetFactory)
    {
        MainViewControllerFacade.widgetFactory = openxdataWidgetFactory;

    }
}
