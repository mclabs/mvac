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

import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.listeners.ItemSelectionListener;
import org.openxdata.server.admin.client.view.bar.OpenXDataMenuBar;
import org.openxdata.server.admin.client.view.bar.OpenXDataToolBar;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.view.listeners.OpenXDataExportImportApplicationEventListener;
import org.openxdata.server.admin.client.view.listeners.OpenXDataViewApplicationEventListener;
import org.openxdata.server.admin.client.view.listeners.OpenXDataViewExtendedApplicationEventListener;
import org.openxdata.server.admin.client.view.treeview.OpenXDataBaseTreeView;
import org.openxdata.server.admin.client.view.widget.OpenXDataFlexTable;
import org.openxdata.server.admin.client.view.widget.OpenXDataStackPanel;
import org.openxdata.server.admin.client.view.widget.factory.OpenXDataWidgetFactory;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.FlexTable;

/**
 * <tt>Base class</tt> for all Views that are <tt>Composites</tt> and want to be notified of selections on the {@link OpenXDataBaseTreeView} intances.
 * 
 * @author Angel
 *
 */
public abstract class OpenXDataBaseView extends Composite implements ItemSelectionListener {

	/** Widget for organizing display in tabular format. */
	protected FlexTable table;
	
	/** Widget for organizing other tabs. */
	protected DecoratedTabPanel tabs;
	
	/** Item that has been selected on the <tt>Tree View.</tt>*/
	protected Object selectedItem;
	
    /** A handle to the <tt>StackPanel</tt> for use on <tt>AppEventListener</tt> members.*/
    protected OpenXDataStackPanel openxdataStackPanel;
    
	/** <tt>ItemChangeListener</tt> listening for change event on this widget*/
	protected ItemChangeListener itemChangeListener;

	/** Handle to <tt>Widget Factory.</tt>*/
	protected OpenXDataWidgetFactory widgetFactory;
	
	/**
	 * Sole constructor.  (For invocation by subclass constructors, typically implicit.)
     * <p>
	 * Defines a contract with a sub class to construct 
	 * an instance of this <tt>Object</tt> with a given <tt>ItemChangeListener.</tt>
	 * </p>
	 * @param itemChangeListener <tt>ItemChangeListener</tt> for the sub class.
	 * @param openXDataViewFactory 
	 */
	protected OpenXDataBaseView(ItemChangeListener itemChangeListener, OpenXDataViewFactory openXDataViewFactory){
		assert(itemChangeListener != null);
		
		this.itemChangeListener = itemChangeListener;
		this.widgetFactory = openXDataViewFactory;
		initializeView();
		setUp();
	}

	/**
	 * Initializes the control.
	 */
	private void initializeView() {
		
		// Initialize this widget's Main Views.
		tabs = new DecoratedTabPanel();
		table = new OpenXDataFlexTable();
	}
	
	/**
	 * Registers this class with the relevant <tt>Event Dispatchers.</tt>
	 * <p>
	 * <tt>Event Dispatchers can be {@link OpenXDataMenuBar} or {@link OpenXDataToolBar}.</p>
	 */
	protected void registerWithEventDispatchers() {
		
		if(this instanceof OpenXDataViewApplicationEventListener){
			((OpenXDataMenuBar) widgetFactory.getOpenXDataMenuBar()).registerApplicationEventListener((OpenXDataViewApplicationEventListener) this);
			((OpenXDataToolBar) widgetFactory.getOpenXDataToolBar()).registerApplicationEventListener((OpenXDataViewApplicationEventListener) this);
		}
		else if(this instanceof OpenXDataViewExtendedApplicationEventListener){
			((OpenXDataMenuBar) widgetFactory.getOpenXDataMenuBar()).registerAdvancedApplicationEventListener((OpenXDataViewExtendedApplicationEventListener) this);
			((OpenXDataToolBar) widgetFactory.getOpenXDataToolBar()).registerAdvancedApplicationEventListener((OpenXDataViewExtendedApplicationEventListener) this);
		}
		else if(this instanceof OpenXDataExportImportApplicationEventListener){
			((OpenXDataMenuBar) widgetFactory.getOpenXDataMenuBar()).registerExportImportApplicationEventListener((OpenXDataExportImportApplicationEventListener) this);
			((OpenXDataToolBar) widgetFactory.getOpenXDataToolBar()).registerExportImportApplicationEventListener((OpenXDataExportImportApplicationEventListener) this);
		}
	}

	@Override
	public void onItemSelected(Composite sender, Object item) {
		this.selectedItem = item;
	}
	
	/**
	 * Sets up the widgets on the <tt>View.</tt>
	 * <p>
	 * Should always be called after <tt>super.initializeView()</tt> to
	 * guarantee that the widgets will be ready to accept calls. 
	 * Violation of this contract can lead to illegal behavior and state cannot be guaranteed.
	 * </p>
	 */
	protected abstract void setUp();
}
