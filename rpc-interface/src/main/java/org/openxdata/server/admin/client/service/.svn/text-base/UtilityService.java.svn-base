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
package org.openxdata.server.admin.client.service;

import java.util.List;

import org.openxdata.server.admin.model.Locale;
import org.openxdata.server.admin.model.MobileMenuText;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.admin.model.util.Diagnosis;
import org.openxdata.server.admin.model.util.OpenXDataEmail;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Defines the client side contract for the Utility Service.
 * 
 * @author Angel
 *
 */
public interface UtilityService extends RemoteService {

	/**
	 * Fetches all the <tt>Mobile Menu Text</tt> in the system.
	 * 
	 * @param locale <tt>Locale</tt> to fetch <tt>Mobile Menu Text</tt> for.
	 * 
	 * @return <tt>List</tt> of <tt>Mobile Menu Text</tt> for the given <tt>Locale.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt> 
	 */
	List<MobileMenuText> getMobileMenuText(String locale) throws OpenXDataException;
	
	/**
	 * Saves dirty or new <tt>Mobile Menu Text.</tt>
	 * 
	 * @param mobileMenuText <tt>Mobile Menu Text</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>  
	 */
	void saveMobileMenuText(List<MobileMenuText> mobileMenuText) throws OpenXDataException;
	
	/**
	 * Fetches all the <tt>Locales</tt> in the system.
	 * 
	 * @return <tt>List</tt> of <tt>Locales.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt> 
	 */
	List<Locale> getLocales() throws OpenXDataException;
	
	/**
	 * Saves dirty or new <tt>Locales.</tt>
	 * 
	 * @param locales <tt>List</tt> of <tt>Locales.</tt>
	 * @return <tt>True only and only if the Locales</tt> are saved successfully.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt> 
	 */
	void saveLocale(List<Locale> locales) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>Locale.</tt>
	 * 
	 * @param locale <tt>Locale</tt> to delete.
	 * @return <tt>True only and only if the Locales</tt> are saved successfully.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt> 
	 */
	void deleteLocale(Locale locale) throws OpenXDataException;
		
	/**
	 * Installs the Mobile Application onto the mobile devices.
	 * 
	 * @param phonenos List of phones numbers for the Mobile devices.
	 * @param url URL where they will pick the mobile application.
	 * @param modemComPort Modem Port to send the WAP PUSH SMS through.
	 * @param modemBaudRate The Baud Rate to User.
	 * @param promptText The prompt text that will appear on the <tt>User's</tt> device to prompt them to download tha application.
	 * @return
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt> 
	 */
	Boolean installMobileApp(List<String> phonenos, String url, String modemComPort, int modemBaudRate, 
			String promptText) throws OpenXDataException;
	
	/**
	 * Checks if the a given password matches the <tt>User's</tt> default password that matches with the system.
	 * 
	 * @param username <tt>User</tt> we matching on.
	 * @param password Password we checking for match against the old password.
	 * @return <tt>True only and only if the given password matches the password of the User.</tt>
	 * 
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt> 
	 */
	Boolean checkIfPasswordsMatchOnAdministrator(String username, String password) throws OpenXDataException;
	
	/**
	 * Retrieves the output of the <tt>Log File.</tt>
	 * 
	 * @param logFilePath Relative path to the <tt>Log File.</tt> 
	 * @return <tt>Log File</tt> content.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt> 
	 */
	Diagnosis  getLogFileProcessedOutput(String logFilePath) throws OpenXDataException;
	
	/**
	 * Sends a given email.
	 * 
	 * @param email Email to send.
	 * @return <tt>True only and only if the email is sent successfully.</tt>
	 */
	boolean sendEmail(OpenXDataEmail email);
	
	/**
	 * Clears the Log File. After this operation, the Log File content will be null.
	 */
	void clearLogFiles();
}
