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

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.listeners.AppEventListener;
import org.openxdata.server.admin.client.listeners.LogoutListener;
import org.openxdata.server.admin.client.locale.OpenXdataText;
import org.openxdata.server.admin.client.locale.TextConstants;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.tools.MobileInstaller;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.dialogs.OpenXDataDiagnosticToolDialog;
import org.openxdata.server.admin.client.view.treeview.ReportsTreeView;
import org.openxdata.server.admin.client.view.treeview.RolesTreeView;
import org.openxdata.server.admin.client.view.treeview.SettingsTreeView;
import org.openxdata.server.admin.client.view.treeview.StudiesTreeView;
import org.openxdata.server.admin.client.view.treeview.TasksTreeView;
import org.openxdata.server.admin.client.view.treeview.UsersTreeView;
import org.openxdata.server.admin.client.view.widget.OpenXDataStackPanel;
import org.openxdata.server.admin.client.view.widget.factory.OpenXDataWidgetFactory;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.ClosingHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;

/**
 * Application Main View.
 * <p>
 * This view deals with setting up of the 
 * various contained views, switching between them, and calling methods onto them.
 * </p>
 * 
 * @author daniel
 * @author Angel
 *
 */
public class MainView extends Composite implements ResizeHandler, AppEventListener
{

    /** Logout listener for this sessions */
    private LogoutListener logoutListener;
    /** OpenXdata Stack Panel to hold Tree Views.*/
    private OpenXDataStackPanel openXdataStackPanel;
    /** Handle to <tt>Widget Factory.</tt>*/
    private OpenXDataWidgetFactory widgetFactory;

    /**
     * Constructs an instance of this class with a <code>Logout Listener</code>
     *
     * @param logoutListener <code>Logout Listener for this class</code>.
     */
    public MainView(LogoutListener logoutListener)
    {
        this.logoutListener = logoutListener;
    }

    /**
     * Initializes the <tt>MainView widgets and layout.</tt>
     */
    public void initializeMainViewWidgets()
    {
        setUp();
        setupViewController();
    }

    /**
     * Initializes the widgets to be bound to the
     * main view with Permission Resolver Object to handle permissions.
     */
    private void setUp()
    {

        // Set up the Item Selection Listeners for the Tree Views
        ((StudiesTreeView) widgetFactory.getStudiesTreeView()).setItemSelectionListener(widgetFactory.getStudyView());
        ((UsersTreeView) widgetFactory.getUsersTreeView()).setItemSelectionListener(widgetFactory.getUserView());
        ((RolesTreeView) widgetFactory.getRolesTreeView()).setItemSelectionListener(widgetFactory.getRoleView());

        ((TasksTreeView) widgetFactory.getTasksTreeView()).setItemSelectionListener(widgetFactory.getTaskView());
        ((SettingsTreeView) widgetFactory.getSettingsTreeView()).setItemSelectionListener(widgetFactory.getSettingView());
        ((ReportsTreeView) widgetFactory.getReportsTreeView()).setItemSelectionListener(widgetFactory.getReportView());
        widgetFactory.getFlowTreeView().setItemSelectionListener(widgetFactory.getWorkFlowView());

        // Add the Views to the Main Panel
        bindViewsToPanel();

        Event.addNativePreviewHandler(new NativePreviewHandler()
        {

            @Override
            public void onPreviewNativeEvent(NativePreviewEvent event)
            {
                handleNativeEvent(event);
            }
        });

        Window.addWindowClosingHandler(new ClosingHandler()
        {

            @Override
            public void onWindowClosing(ClosingEvent event)
            {
                onLogout();

            }
        });
    }

    /**
     * Binds tree views to the panel
     */
    private void bindViewsToPanel()
    {

        //Stack Panel to organize MainView
        openXdataStackPanel = widgetFactory.getOpenXdataStackPanel();

        openXdataStackPanel.add(widgetFactory.getStudiesTreeView(), Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().studies(), OpenXdataText.get(TextConstants.STUDIES)), true);

        openXdataStackPanel.add(widgetFactory.getUsersTreeView(), Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().users(), OpenXdataText.get(TextConstants.USERS)), true);

        openXdataStackPanel.add(widgetFactory.getRolesTreeView(), Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().roles(), OpenXdataText.get(TextConstants.ROLES)), true);

        openXdataStackPanel.add(widgetFactory.getTasksTreeView(), Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().tasks(), OpenXdataText.get(TextConstants.TASKS)), true);

        openXdataStackPanel.add(widgetFactory.getSettingsTreeView(), Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().settings(), OpenXdataText.get(TextConstants.SETTINGS)), true);

        openXdataStackPanel.add(widgetFactory.getReportsTreeView(), Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().reports(), OpenXdataText.get(TextConstants.REPORTS)), true);

        //ADDED
        openXdataStackPanel.add(widgetFactory.getFlowTreeView(), "<b>WorkFlows</b>", true);

        openXdataStackPanel.setWidth("100%");

        widgetFactory.getHorizontalSplitPanel().setLeftWidget(openXdataStackPanel);

        widgetFactory.getVerticalPanel().add(widgetFactory.getHorizontalSplitPanel());

        DockPanel dockPanel = new DockPanel();
        dockPanel.add(widgetFactory.getVerticalPanel(), DockPanel.CENTER);

        Utilities.maximizeWidget(dockPanel);
        initWidget(dockPanel);
    }

    /**
     * Builds the Main View Controller
     */
    private void setupViewController()
    {

        MainViewControllerFacade.prepareMainViewController(
                widgetFactory.getMainView(),
                widgetFactory.getStudiesTreeView(),
                widgetFactory.getUsersTreeView(),
                widgetFactory.getRolesTreeView(),
                widgetFactory.getTasksTreeView(),
                widgetFactory.getSettingsTreeView(),
                widgetFactory.getReportsTreeView(),
                widgetFactory.getStudyView(),
                widgetFactory.getUserView(),
                widgetFactory.getRoleView(),
                widgetFactory.getReportView());
    }

    /**
     * Sets the <tt>Widget Factory.</tt>
     *
     * @param widgetFactory <tt>Widget Factory to set.</tt>
     */
    public void setWidgetFactory(OpenXDataWidgetFactory widgetFactory)
    {
        this.widgetFactory = widgetFactory;
    }

    @Override
    public void onLogout()
    {
        logoutListener.onLogout();
    }

    @Override
    public void onShowAboutInfo()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void onShowHelpContents()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void onShowOptions()
    {
    }

    /**
     * Resets the size of the <tt>MainView.</tt>
     */
    public void resize(int width, int height)
    {
        widgetFactory.getHorizontalSplitPanel().setSize(width + "px", (height - 50) + "px");

        int shortcutHeight = height - openXdataStackPanel.getAbsoluteTop();//8;
        if (shortcutHeight < 1)
            shortcutHeight = 1;

        openXdataStackPanel.setHeight(shortcutHeight + "px");
    }

    @Override
    public void mobileInstaller()
    {
        if (RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Mobile_Installer")) {
            new MobileInstaller().center();
        }
    }

    @Override
    public void changeLocale(String locale)
    {
        if (RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Change_Locale")) {
            Context.setLocale(locale);
            ((StudyView) widgetFactory.getStudyView()).changeLocale(locale);
        } else {
            Window.alert("You do not have sufficient prviledges to change locales");
        }
    }

    @Override
    public void onShowDiagnosticToolClick()
    {
        if (RolesListUtil.getPermissionResolver().isExtraPermission("Perm_Diagnose_System")) {
            new OpenXDataDiagnosticToolDialog().initializeDiagnostics();
        }
    }

    /**
     * Handles the event to ascertain OXD diagnostic tool
     * combination and display the <tt>Diagnostic Tool.</tt>
     *
     * @param event <tt>Native Event</tt> fired.
     */
    protected boolean handleNativeEvent(NativePreviewEvent event)
    {

        // Check if the event fired is type of KeyPress.
        // If we don't do this, we shall handle all events
        // as MainView is on top of the Event stack. It can make
        // the browser to hang and take long to respond to anything.
        if (event.getNativeEvent().getType().equalsIgnoreCase("keypress")) {

            // Check if 'Ctrl + Shift + X' was pressed.
            //
            // Please note that the API gives
            // no guarantees that the key code will be
            // the same across all browser implementations.
            int pressedKey = event.getNativeEvent().getKeyCode();

            // Determine if Control + Shift keys was pressed.
            if (event.getNativeEvent().getCtrlKey() && event.getNativeEvent().getShiftKey()) {

                // Determine if X was pressed with Ctrl + shift.
                if (pressedKey == 88) {
                    onShowDiagnosticToolClick();
                }
            }
        }

        return true;
    }

    @Override
    public void onResize(ResizeEvent event)
    {
        int width = event.getWidth();
        int height = event.getHeight();
        resize(width, height);
    }
}
