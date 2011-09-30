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
package org.openxdata.server.admin.client.listeners;

/**
 * Interface for listening to application level events.
 * 
 * @author daniel
 * @author Angel
 *
 */
public interface AppEventListener {

	/**
	 * Called when the user wants to logout of the application.
	 */
	void onLogout();
	
	/**
	 * Called to display help files.
	 */
	void onShowHelpContents();
	
	/**
	 * Called to display the about openxdata dialog box.
	 */
	void onShowAboutInfo();
	
	/**
	 * Called to let the user customize openxdata.
	 */
	void onShowOptions();
	
	/**
	 * Displays the mobile installer screen.
	 */
	void mobileInstaller();
	
	/**
	 * Changes to a particular locale.
	 * 
	 * @param locale the locale to change to.
	 */
	void changeLocale(String locale);
	
	/**
	 * Displays the Diagnostic tool for analysis.
	 */
	void onShowDiagnosticToolClick();
	
	
}
