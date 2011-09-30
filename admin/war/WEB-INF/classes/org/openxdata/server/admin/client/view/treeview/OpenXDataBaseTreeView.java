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
package org.openxdata.server.admin.client.view.treeview;

import org.openxdata.server.admin.client.controller.observe.OpenXDataObserver;
import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.listeners.ItemSelectionListener;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.view.bar.OpenXDataMenuBar;
import org.openxdata.server.admin.client.view.bar.OpenXDataToolBar;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.view.listeners.OpenXDataExportImportApplicationEventListener;
import org.openxdata.server.admin.client.view.listeners.OpenXDataViewApplicationEventListener;
import org.openxdata.server.admin.client.view.listeners.OpenXDataViewExtendedApplicationEventListener;
import org.openxdata.server.admin.client.view.treeview.listeners.ContextMenuInitListener;
import org.openxdata.server.admin.client.view.widget.OpenXDataStackPanel;
import org.openxdata.server.admin.client.view.widget.factory.OpenXDataWidgetFactory;
import org.openxdata.server.admin.model.Editable;

import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * <tt>TreeView class</tt> that encapsulates <tt>Permission</tt>s related 
 * functionality for a <tt>TreeView</tt> and creating of specific <tt>context menus</tt> for the different <tt>tree views.</tt>
 * 
 * @author dagmar@cell-life.org.za 
 * @author Angel
 */
public abstract class OpenXDataBaseTreeView extends Composite implements
        SelectionHandler<TreeItem>, ItemChangeListener, ContextMenuInitListener,
                                                                         OpenXDataObserver {

    /** The tree widget to holding the items. */
    protected Tree tree;
    /** Last selected <tt>Tree Item.</tt>*/
    protected TreeItem item;
    /** Panel for the context menu for tree items. */
    protected PopupPanel popup;
    /** Name of the <tt>Tree View</tt>*/
    private String treeViewName;
    /**
     * <tt>ScrollPanel</tt> to aid in seeing hidden items when they can not fit in the available space.
     */
    protected ScrollPanel scrollPanel;
    /** A handle to the <tt>StackPanel</tt> for use on <tt>AppEventListener</tt> members.*/
    protected OpenXDataStackPanel openxdataStackPanel;
    /** <tt>ItemSelectionListener</tt> for this <tt>class.</tt>*/
    protected ItemSelectionListener itemSelectionListener;
    /** Handle to <tt>Widget Factory.</tt>*/
    protected OpenXDataWidgetFactory widgetFactory;

    /**
     * Sole constructor. (For invocation by subclass constructors, typically implicit.)
     * <p>
     * Creates a instance of this <tt>class</tt> with a given name.
     * </p>
     * @param treeViewName the name of the <tt>Tree View.</tt>
     * @param openXDataViewFactory 
     */
    protected OpenXDataBaseTreeView(String treeViewName,
                                    OpenXDataViewFactory openXDataViewFactory) {

        assert (treeViewName.length() > 0);
        this.treeViewName = treeViewName;
        this.widgetFactory = openXDataViewFactory;
        initializeTreeView();
        setUp();

        //This is just for solving a weird behavior when one changes a node text
        //and the click another node which gets the same text as the previously
        //selected text. Just comment it out and you will see what happens.
        //TODO: test with GWT2
        tree.addMouseUpHandler(new MouseUpHandler() {

            @Override
            public void onMouseUp(MouseUpEvent arg0) {
                tree.setSelectedItem(tree.getSelectedItem());
            }
        });
    }

    /**
     * Initializes the control.
     */
    private void initializeTreeView() {

        //Scroll Panel for this View.
        scrollPanel = new ScrollPanel();



    }

    /**
     * Registers this class with the relevant <tt>Event Dispatchers.</tt>
     * <p>
     * <tt>Event Dispatchers can be {@link OpenXDataMenuBar} or {@link OpenXDataToolBar}.</p>
     */
    protected void registerWithEventDispatchers() {

        if (this instanceof OpenXDataViewApplicationEventListener) {
            ((OpenXDataMenuBar) widgetFactory.getOpenXDataMenuBar()).registerApplicationEventListener((OpenXDataViewApplicationEventListener) this);
            ((OpenXDataToolBar) widgetFactory.getOpenXDataToolBar()).registerApplicationEventListener((OpenXDataViewApplicationEventListener) this);
        } else if (this instanceof OpenXDataViewExtendedApplicationEventListener) {
            ((OpenXDataMenuBar) widgetFactory.getOpenXDataMenuBar()).registerAdvancedApplicationEventListener((OpenXDataViewExtendedApplicationEventListener) this);
            ((OpenXDataToolBar) widgetFactory.getOpenXDataToolBar()).registerAdvancedApplicationEventListener((OpenXDataViewExtendedApplicationEventListener) this);
        } else if (this instanceof OpenXDataExportImportApplicationEventListener) {
            ((OpenXDataMenuBar) widgetFactory.getOpenXDataMenuBar()).registerExportImportApplicationEventListener((OpenXDataExportImportApplicationEventListener) this);
            ((OpenXDataToolBar) widgetFactory.getOpenXDataToolBar()).registerExportImportApplicationEventListener((OpenXDataExportImportApplicationEventListener) this);
        }
    }

    /**
     * Creates the <tt>Context Menu.</tt>
     * 
     * <p>
     * If overridden, the sub <tt>class</tt>
     * should provide a specific implementation that will return a pop up to the caller.
     * </p>
     * Can be <code>overridden.</code>
     * 
     * @return PopupPanel containing a menu with items the user has permissions for
     */
    protected PopupPanel initContextMenu(
            ContextMenuInitListener contextMenuListener) {
        return widgetFactory.getContextMenu(contextMenuListener, getContextMenuLabels(), treeViewName);
    }

    /**
     * Determines if the view should load data because the user has any related permission
     * @return true if the view should load data
     */
    protected boolean isLoadData() {
        return RolesListUtil.getPermissionResolver().isPermission(treeViewName);
    }

    /**
     * Sets and Retrieves the labels for the ContextMenu
     * @return context menu labels
     */
    abstract UIViewLabels getContextMenuLabels();

    @Override
    public void onSelection(SelectionEvent<TreeItem> event) {
        TreeItem selectedItem = event.getSelectedItem();
        //Should not call this more than once for the same selected item.
        if (!selectedItem.equals(item)) {

            this.item = selectedItem;

            itemSelectionListener.onItemSelected(this, item.getUserObject());

            //Expand the item if it has kids such that users do not have to
            //learn that they need to click the plus sign in order to expand.
            if (item.getChildCount() > 0) {
                item.setState(true);
            }
        }
    }

    /**
     * Sets the selection Listener for this <tt>Class.</tt>
     *
     * @param itemSelectionListener <tt>ItemSelectionListener</tt> to set.
     */
    public void setItemSelectionListener(
            ItemSelectionListener itemSelectionListener) {
        this.itemSelectionListener = itemSelectionListener;
    }

    /**
     * @see org.openxdata.server.admin.client.listeners.ItemChangeListener#onItemChanged(Object)
     */
    @Override
    public void onItemChanged(Object item) {
        changeEditableProperties(item);
    }

    /**
     * Implemented by members to continue the firing hierarchy of <tt>onItemChanged.</tt>
     * @param editable {@link Editable} whose properties have changed.
     *
     * @see org.openxdata.server.admin.client.listeners.ItemChangeListener#onItemChanged(Object)
     */
    protected abstract void changeEditableProperties(Object editable);

    /**
     * Sets up the widgets on the <tt>Tree View</tt>.
     * <p>
     * Should always be called after <tt>super.initializeView()</tt> to
     * guarantee that the widgets will be ready to accept calls.
     * Violation of this contract can lead to illegal behavior and state will be preserved in the child classes.
     * </p>
     */
    protected abstract void setUp();
}
