/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.server.admin.client.view.treeview;

import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;

/**
 *
 * @author kay
 */
public class WorkFlowTreeView extends OpenXDataBaseTreeView
{

    public WorkFlowTreeView(OpenXDataViewFactory openXDataViewFactory)
    {
        super("Workflows", openXDataViewFactory);
    }

    @Override
    UIViewLabels getContextMenuLabels()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void changeEditableProperties(Object editable)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void setUp()
    {
        //Register this class with Event Dispatchers.
        super.registerWithEventDispatchers();

        openxdataStackPanel = widgetFactory.getOpenXdataStackPanel();

        // Initialize the Tree View
        tree = new Tree(widgetFactory.getOpenXDataImages());
        tree.ensureSelectedItemVisible();

        //Setting Scroll Panel properties.
        scrollPanel.setWidget(tree);
        scrollPanel.setWidth("100%");
        scrollPanel.setHeight("100");

        // Make this class the Listener
        tree.addSelectionHandler(this);

       TreeItem titem = new TreeItem("<b>Match WorkFlows</b>");
       tree.addItem(titem);

        // Initialize the ScrollPanel to be the main widget for the Tree View
        initWidget(scrollPanel);

        // Initialize the Context Menu.
//		popup = initContextMenu();

        // Maximize this widget
        Utilities.maximizeWidget(this);
    }

    @Override
    public void addNewItem()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteSelectedItem()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(OpenXDataObservable observable, Object observedModelObjects)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
