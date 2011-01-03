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

import org.openxdata.server.admin.client.view.bar.OpenXDataMenuBar;


/**
 * Creates an instance of the <OpenXDataMenuBar class</code> according to the <code>User</code> type.
 * <p>
 * This class should not be called directory but rather the <tt>OpenXDataViewFactory</tt> should delegate specific creation responsibilities to it.
 * </p>
 * @author Angel
 * @author daniel
 *
 */
public class MenuBarFactory {


	/**
	 * Prevent initialization of 
	 * this class as it is a factory class.
	 */
    private MenuBarFactory() {}
    
	/**
	 * Constructs a <tt>Menu Bar</tt> according to <tt>User Permissions.</tt>
	 */
	public static OpenXDataMenuBar instanceOfUserPermissions() {
		
		// Handle to Menu Bar.
		OpenXDataMenuBar menuBar = new OpenXDataMenuBar();
		
		// Construct a Menu Bar according to User Permissions.
		menuBar.constructMenuBarInstanceOfUserWithPermissions();
		
		return menuBar;
	}
	
	/**
	 * Constructs a <tt>Menu Bar</tt> for <tt>User</tt> with administrative privileges.
	 */
	public static OpenXDataMenuBar instanceOfAdministrator() {
		
		// Handle to Menu Bar.
		OpenXDataMenuBar menuBar = new OpenXDataMenuBar();
		
		// Construct a Menu Bar for Administrative User.
		menuBar.constructMenuBarInstanceOfAdministratorUser();
		
		return menuBar;
		
	}
}
