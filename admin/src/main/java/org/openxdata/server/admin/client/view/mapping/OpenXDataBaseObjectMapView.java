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
package org.openxdata.server.admin.client.view.mapping;

import org.openxdata.server.admin.client.listeners.ItemChangeListener;
import org.openxdata.server.admin.client.listeners.ItemSelectionListener;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.treeview.UsersTreeView;
import org.openxdata.server.admin.client.view.widget.OpenXDataButton;
import org.openxdata.server.admin.client.view.widget.OpenXDataFlexTable;
import org.openxdata.server.admin.client.view.widget.factory.OpenXDataWidgetFactory;
import org.openxdata.server.admin.model.User;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

/**
 * Base <code>widget</code> that encapsulates 
 * operations that accomplish mapping of <code>Permissions to Roles.</code></p>
 * 
 * @author Angel
 *
 */
public abstract class OpenXDataBaseObjectMapView extends Composite implements ItemSelectionListener {
	
	/** User to whom we mapping objects to.*/
	protected User user;	
	
	/**
	 * Variable to monitor the number of times this widget has been called.
	 */
	protected int modCount;
	
	/**
	 * Button that will encapsulate the mapping of a property to the object.
	 */
	protected Button btnAdd;
	
	/** The Save <tt>Button.</tt>*/
	protected Button btnSave;
	
	/**
	 * Button that will encapsulate the un mapping of a property to the object.
	 */
	protected Button btnRemove;		
	
	/** Handle to <tt>Widget Factory.</tt>*/
	protected OpenXDataWidgetFactory widgetFactory;  
	
	/**
	 * Event Listener for changes on this object.
	 */
	protected ItemChangeListener itemChangeListener;	
	
	/**
	 * Table to hold widgets and gives them an aesthetic look.
	 */
	protected FlexTable table = new OpenXDataFlexTable();
	
	/**
	 * Panel used to arrange widgets vertically.
	 */
	protected VerticalPanel vPanel = new VerticalPanel();
	
	/**
	 * List Box to display properties mapped to the current object.
	 */
	protected ListBox mappedObjectsListBox = new ListBox(true);
	
	/**
	 * List Box to display all properties not mapped to the object
	 */
	protected ListBox unMappedObjectsListBox = new ListBox(true);
	
	/**
	 * Sole constructor. (For invocation by subclass constructors, typically implicit.)
	 * <p>
	 * Construct a <tt>Mapping View</tt> with <tt>ItemChangeListener.</tt></p>
	 * 
	 * @param itemChangeListener - Object that is firing events.
	 */
	protected OpenXDataBaseObjectMapView(ItemChangeListener itemChangeListener){
		assert(itemChangeListener != null);
		
		this.itemChangeListener = itemChangeListener;
		
		setupWidgets();
		setupEventListeners();
	}
	
	/**
	 * Sets up event listeners for the controls on the widget
	 * 
	 * When overridden, a call to super.setupEventListeners() should be made to initialize event
	 * super specific controls. A client setupEventListeners can be called to initialize the sub class
	 * control and later super.setupEventListeners().
	 * 
	 * Not recommended for overriding. Called in super constructor and might render unexpected behavior
	 * if overridden.
	 * 
	 */
	protected void setupEventListeners() {
		
		btnAdd.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				mapItemTobject();
				
			}
			
		});
		
		btnRemove.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				unMapItemFromObject();			
			}
			
		});
		
		btnSave.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				saveMap();
				
			}});
	}
	
	/**
	 * Saves the <tt>User Mapped Objects</tt> on the current <tt>Widget.</tt> 
	 */
	protected abstract void saveMap();
	
	/**
	 * Initialize the widgets to bind to the control.
	 * <p>
	 * When overridden, a call to super.setupWidgets() should be made to initialize.
	 * super specific widgets. A client setupWidgets can be called to initialize the sub class
	 * control and later super.setupWidgets().
	 * </p>
	 * Not recommended for overriding. Called in super constructor and might render unexpected behavior if overridden.
	 */
	protected void setupWidgets() {
		
		//Setting the properties of the Add Button
		btnAdd = new OpenXDataButton(getMapViewLabels().getMapButtonText());
		btnAdd.setWidth("160px");
		btnAdd.setTitle(getMapViewLabels().getAddButtonTitle());
		
		//Setting the properties of the Remove Button
		btnRemove = new OpenXDataButton(getMapViewLabels().getUnMapButtonText());
		btnRemove.setWidth("160px");
		btnRemove.setTitle(getMapViewLabels().getRemoveButtonTitle());
		
		//Setting the properties of the Save Button.
		btnSave = new OpenXDataButton("Save");
		btnSave.setWidth("160px");
		btnSave.setTitle("Saves the individual Map that has just been made.");
		
		//Bind the buttons to the vertical Panel.
		vPanel.add(btnAdd);
		vPanel.add(btnRemove);
		
		vPanel.setSpacing(10);
		vPanel.setWidth("100%");
		
		//Maximize the mapping boxes.
		mappedObjectsListBox.setWidth("100%");
		unMappedObjectsListBox.setWidth("100%");		
		
		//Add widgets to the table
		table.setWidget(0, 0, new Label(getMapViewLabels().getRightListBoxLabel()));
		table.setWidget(1, 0, unMappedObjectsListBox);
		table.setWidget(1, 2, vPanel);
		table.setWidget(0, 3, new Label(getMapViewLabels().getLeftListBoxLabel()));
		table.setWidget(1, 3, mappedObjectsListBox);
		table.setWidget(2, 0, btnSave);
		
		//Set the formatting of the cells to hold the widgets so that they can!
		FlexCellFormatter cellFormatter = table.getFlexCellFormatter();
		cellFormatter.setWidth(0, 0, "50%");
		cellFormatter.setWidth(2, 3, "100%");
		cellFormatter.setColSpan(2, 3, 3);
		cellFormatter.setAlignment(2, 3, HasHorizontalAlignment.ALIGN_RIGHT , HasVerticalAlignment.ALIGN_MIDDLE);
		
		//Maximizing the table
		Utilities.maximizeWidget(table); 	    
		
	    initWidget(table);
		
		setWidth("100%");	
	}
	
	/**
	 * Initializes the selected <code>User's properties</code>
	 * 
	 * @param abstractEditable the object instance of AbstractEditable for whom to initialize properties.
	 */
	protected abstract void initializeObjectProperties();
	
	/**
	 * Member that handles the <code>mapping </code>
	 * of a <code>permission</code> to the <code>Role.</code>
	 * 
	 * <p>
	 * It also handles the UI movement of a 
	 * mapped <code>Permission</code> from the current permissions box to the <code>Mapped permissions box.</code>
	 * </p>
	 */
	protected abstract void mapItemTobject();
	
	/**
	 * Member that handles the removing of a mapped permission from a role.
	 * 
	 * It also handles the UI movement of a mapped permission from the mapped permissions box box to the current permissions box
	 */
	protected abstract void unMapItemFromObject();
		
    /**
     * Sets and Retrieves the labels for the ContextMenu
     * @return context menu labels
     */
    abstract UIViewLabels getMapViewLabels();
    
	/**
	 * Sets the <tt>Widget Factory.</tt>
	 * 
	 * @param widgetFactory <tt>Widget Factory to set.</tt>
	 */
	public void setWidgetFactory(OpenXDataWidgetFactory widgetFactory) {
		this.widgetFactory = widgetFactory;		
	}
	
	/**
	 * Member fired when the selected item changes on the <tt>Tree View.</tt>
	 * <p>
	 * After this operation, the selected user will be the one selected on the <tt>User Tree View.</tt>
	 * </p>
	 * 
	 * @throws NullPointerException if(item == null) 
	 */
	@Override
	public void onItemSelected(Composite sender, Object item) {
		if(sender.getClass().equals(UsersTreeView.class)){
			
			// This is a workaround a known bug in GWT 1.5 and lower
			// where a Tree view selection event [onItemSelected] would fired twice returning the selected item twice.
			if(user == item){
				return;
			}
			else{
				this.user = (User) item;
				initializeObjectProperties();
			}
		}
	}
}
