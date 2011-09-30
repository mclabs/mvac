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
package org.openxdata.server.admin.client.view.contextmenu;

import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.treeview.listeners.ContextMenuInitListener;
import org.openxdata.server.admin.client.view.treeview.listeners.ExtendedContextInitMenuListener;
import org.openxdata.server.admin.client.view.widget.factory.OpenXDataWidgetFactory;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * Encapsulates Context Menu pop up on the tree view <code>objects.</code>
 * 
 * @author Angel
 *
 */
public class OpenXDataContextMenu {

	/** Handle to <tt>Widget Factory.</tt>*/
	protected static OpenXDataWidgetFactory widgetFactory;
	
	/**
	 * Constructs an instance of this <tt>class.</tt>
	 */
	public OpenXDataContextMenu(){}
	
	/**
	 * Loads the Administrative context menu with full blown action controls
	 * 
	 * @param contextMenuListener Listener for <tt>context menu events.</tt>
	 * @param contextMenuLabels Labels to bind to the <tt>context menu.</tt>
	 * 
	 * @return <tt>Context Menu</tt> configured for the logged on <tt>User.</tt>
	 */
	public PopupPanel instanceOfAdminContextMenu(ContextMenuInitListener contextMenuListener, UIViewLabels contextMenuLabels){
		
        final PopupPanel popup = new PopupPanel(true,true);
        MenuBar menuBar = new MenuBar(true);
        popup.setWidget(menuBar);
        
        loadAddMenuItems(popup, menuBar, contextMenuListener, contextMenuLabels);
        loadDeleteMenuItems(popup, menuBar, contextMenuListener, contextMenuLabels);

        return popup;
		
	}
	
	/**
	 * Creates an instance of the <code>Context Menu</code> according to the <code>User Permissions</code>.
	 * 
	 * @param contextMenuListener Listener for <tt>context menu events.</tt>
	 * @param contextMenuLabels Labels to bind to the <tt>context menu.</tt>
	 * 
	 * @return <tt>Context Menu</tt> configured for the logged on <tt>User.</tt>
	 */
	public PopupPanel instanceOfUserWithPermissions(final ContextMenuInitListener contextMenuListener,	UIViewLabels contextMenuLabels){
		
		//The pop up that will be initialized (Context Menu)
		PopupPanel popup = new PopupPanel(true,true);
		
		//The menu bar to bind to the pop up
	    MenuBar menuBar = new MenuBar(true);
	    
	    popup.setWidget(menuBar);
	    
		if(RolesListUtil.getPermissionResolver().isAddPermission()){
			loadAddMenuItems(popup, menuBar, contextMenuListener, contextMenuLabels);
		}
		if(RolesListUtil.getPermissionResolver().isDeletePermission()){
			loadDeleteMenuItems(popup, menuBar, contextMenuListener, contextMenuLabels);
		}
		
		return popup;
		
	}

	/**
	 * Bind delete functionality to the <tt>context menu.</tt>
	 * 
	 * @param popup <tt>Pop up</tt> to hold <tt>Context Menu.</tt>
	 * @param menuBar <tt>Menu Bar</tt> for binding labels.
	 * @param contextMenuListener Listener for <tt>context menu events.</tt>
	 * @param contextMenuLabels Labels to bind to the <tt>context menu.</tt>
	 * 
	 * @return <tt>Pop up panel</tt> with relevant controls according to <tt>User Permissions.</tt>
	 */
	private static PopupPanel loadDeleteMenuItems(final PopupPanel popup, MenuBar menuBar, final ContextMenuInitListener contextMenuListener, UIViewLabels contextMenuLabels) {
		String deletelabel = contextMenuLabels.getDeleteLabel();
		
		menuBar.addItem(Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().delete(),deletelabel),true,new Command(){
			@Override
			public void execute() {popup.hide(); contextMenuListener.deleteSelectedItem();}});
		
		return popup;
		
	}

	/**
	 * Bind add functionality to the <tt>context menu.</tt>
	 * 
	 * @param popup <tt>Pop up</tt> to hold <tt>Context Menu.</tt>
	 * @param menuBar <tt>Menu Bar</tt> for binding labels.
	 * @param contextMenuListener Listener for <tt>context menu events.</tt>
	 * @param contextMenuLabels Labels to bind to the <tt>context menu.</tt>
	 * 
	 * @return <tt>Pop up panel</tt> with relevant controls according to <tt>User Permissions.</tt>
	 */
	private static PopupPanel loadAddMenuItems(final PopupPanel popup, MenuBar menuBar, final ContextMenuInitListener contextMenuListener, UIViewLabels contextMenuLabels) {
		
		String addItemLabel = contextMenuLabels.getAddLabel();
		String addNewChildItemLabel =contextMenuLabels.getAddChildItemLabel();

		menuBar.addItem(Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().add(),addItemLabel),true, new Command(){
			@Override
			public void execute() {popup.hide(); contextMenuListener.addNewItem();}});

		menuBar.addSeparator();
		
		if(contextMenuListener instanceof ExtendedContextInitMenuListener){
			final ExtendedContextInitMenuListener extendedClassListener = (ExtendedContextInitMenuListener)contextMenuListener;
			menuBar.addItem(Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().addchild(), addNewChildItemLabel), true, new Command(){
				@Override
				public void execute(){popup.hide(); extendedClassListener.addNewChildItem();}
			});
			
			menuBar.addSeparator();
		}
		
		return popup;
		
	}

	/**
	 * Constructs a <tt>Context Menu</tt> for <tt>User</tt> without <tt>Permissions.</tt>
	 * @return Instance of {@link OpenXDataContextMenu }
	 */
	public PopupPanel instanceOfPermissionLessUser() {
		/*
		 * The pop up that will be initialized (Context Menu)
		 */
		PopupPanel popup = new PopupPanel(true,true);
	    
	    return popup;
	}
	
	/**
	 * Sets the <tt>Widget Factory.</tt>
	 * 
	 * @param widgetFactory <tt>Widget Factory to set.</tt>
	 */
	public void setWidgetFactory(OpenXDataWidgetFactory widgetFactory) {
		OpenXDataContextMenu.widgetFactory = widgetFactory;
		
	}

}
