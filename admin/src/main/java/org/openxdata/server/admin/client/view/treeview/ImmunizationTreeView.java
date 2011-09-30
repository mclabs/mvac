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
 * @author soyfactor
 */
public class ImmunizationTreeView extends OpenXDataBaseTreeView {

    /**
     *
     * @param openXDataViewFactory
     */
    public ImmunizationTreeView(OpenXDataViewFactory openXDataViewFactory) {
        super("Immunizations",openXDataViewFactory);
    }


    @Override
    UIViewLabels getContextMenuLabels() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void changeEditableProperties(Object editable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void setUp() {
        //register with event dispatchers
        //super.registerWithEventDispatchers();
        
        openxdataStackPanel = widgetFactory.getOpenXdataStackPanel();

        tree = new Tree(widgetFactory.getOpenXDataImages());

        scrollPanel.setWidget(tree);
        scrollPanel.setWidth("100%");
        scrollPanel.setHeight("100");


        // Make this class the Listener
        //tree.addSelectionHandler(this);

        TreeItem titem = new TreeItem("<b>Appointments</b>");
        tree.addItem(titem);

        // Initialize the ScrollPanel to be the main widget for the Tree View
        initWidget(scrollPanel);

        Utilities.maximizeWidget(this);


        


    }

    @Override
    public void addNewItem() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteSelectedItem() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(OpenXDataObservable observable, Object observedModelObjects) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
