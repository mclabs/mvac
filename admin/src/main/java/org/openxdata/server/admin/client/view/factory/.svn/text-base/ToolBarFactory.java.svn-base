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

import org.openxdata.server.admin.client.view.bar.OpenXDataToolBar;
import org.openxdata.server.admin.client.view.widget.factory.OpenXDataWidgetFactory;

/**
 * Creates a tool bar based on the <code>User Permissions</code>.
 * <p>
 * This class should not be called directory but rather the <tt>OpenXDataViewFactory</tt> should delegate specific creation responsibilities to it.
 * </p>
 * @author Angel
 *
 */
public class ToolBarFactory {	
	
	/**
	 * Create a <tt>Tool Bar</tt> according to the <code>User Permissions.</code>
	 * 
	 * @param openXDataViewFactory <tt>WidgetFactory</tt> for this session.
	 * 
	 * @return instance of {@link OpenXDataToolBar}.
	 */
	public static OpenXDataToolBar instanceOfUserPermissions(OpenXDataWidgetFactory openXDataViewFactory){
		
		OpenXDataToolBar toolBar = new OpenXDataToolBar();	
		
		// Set widget factory
		toolBar.setWidgetFactory(openXDataViewFactory);

		// Set up the widgets on it
		toolBar.setUp();
		
		return toolBar.instanceOfUserPermissions();
		
	}
	
	/**
	 * Creates administrator tool bar with full blown action controls
	 * 
	 * @param openXDataViewFactory <tt>WidgetFactory</tt> for this session.
	 * 
	 * @return instance of {@link OpenXDataToolBar}.
	 */
	public static OpenXDataToolBar instanceOfAdministrator(OpenXDataWidgetFactory openXDataViewFactory){
		
		OpenXDataToolBar toolBar = new OpenXDataToolBar();		
		
		// Set widget factory
		toolBar.setWidgetFactory(openXDataViewFactory);

		// Set up the widgets on it
		toolBar.setUp();
		
		
		return toolBar.instanceOfAdminUser();
	}
}
