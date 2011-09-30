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

import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.view.contextmenu.OpenXDataContextMenu;
import org.openxdata.server.admin.client.view.treeview.listeners.ContextMenuInitListener;
import org.openxdata.server.admin.client.view.widget.factory.OpenXDataWidgetFactory;

import com.google.gwt.user.client.ui.PopupPanel;

/**
 *  
 * This class acts as a route to create the context menu for the various tree views on the Main View
 * The context menu created depends on the permissions that have been assigned to the logged on user at the moment.
 * 
 * <p>
 * This class should not be called directory but rather the <tt>OpenXDataViewFactory</tt> should delegate specific creation responsibilities to it.
 * </p>
 * @author Angel
 */
public class ContextMenuFactory {	

	/**
	 * Constructs a <tt>Context Menu</tt> for a <tt>User</tt> with administrative privileges.
	 * 
	 * @param openXDataViewFactory <tt>WidgetFactory</tt> configured for this session. 
	 * @param contextMenuListener Listener for <tt>context menu events.</tt>
	 * @param contextMenuLabels Labels to bind to the <tt>context menu.</tt>
	 * 
	 * @return <tt>Context Menu</tt> configured for the logged on <tt>User.</tt>
	 */
	public static PopupPanel constructContextMenuInstanceOfAdmin(OpenXDataWidgetFactory openXDataViewFactory, ContextMenuInitListener contextMenuListener, UIViewLabels contextMenuLabels) {
		
		//Handle to Context Menu
		OpenXDataContextMenu contextMenu = new OpenXDataContextMenu();
		
		// Set the Widget Factory
		contextMenu.setWidgetFactory(openXDataViewFactory);
		
		return contextMenu.instanceOfAdminContextMenu(contextMenuListener, contextMenuLabels);
	}
	
	/**
	 * Constructs a <tt>Context Menu</tt> according to the currently logged on <tt>User Permissions.</tt>
	 *
	 * @param openXDataViewFactory <tt>WidgetFactory</tt> configured for this session. 
	 * @param contextMenuListener Listener for <tt>context menu events.</tt>
	 * @param contextMenuLabels Labels to bind to the <tt>context menu.</tt>
	 * 
	 * @return <tt>Context Menu</tt> configured for the logged on <tt>User.</tt>
	 */
	public static PopupPanel constructContextMenuInstanceOfUserPermissions(OpenXDataViewFactory openXDataViewFactory, ContextMenuInitListener contextMenuListener, UIViewLabels contextMenuLabels) {
		
		//Handle to Context Menu
		OpenXDataContextMenu contextMenu = new OpenXDataContextMenu();
		
		// Set the Widget Factory
		contextMenu.setWidgetFactory(openXDataViewFactory);
		
		return contextMenu.instanceOfUserWithPermissions(contextMenuListener, contextMenuLabels);
	}
	
	/**
	 * Constructs a <tt>Context Menu</tt> for a <tt>User</tt> without <tt>Permissions.</tt>
	 * 
	 * @param openXDataViewFactory <tt>WidgetFactory</tt> configured for this session. 
	 * @return <tt>Context Menu</tt> configured for the logged on <tt>User.</tt>
	 */
	public static PopupPanel constructContextMenuInstanceOfPermissionLessUser(OpenXDataViewFactory openXDataViewFactory){
		
		//Handle to Context Menu
		OpenXDataContextMenu contextMenu = new OpenXDataContextMenu();
		
		// Set the Widget Factory
		contextMenu.setWidgetFactory(openXDataViewFactory);
		
		return contextMenu.instanceOfPermissionLessUser();
	}
}
