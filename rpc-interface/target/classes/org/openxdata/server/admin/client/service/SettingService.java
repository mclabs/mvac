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

import org.openxdata.server.admin.model.Setting;
import org.openxdata.server.admin.model.SettingGroup;
import org.openxdata.server.admin.model.exception.OpenXDataException;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Defines the client side contract for the Setting Service.
 * 
 * @author Angel
 *
 */
public interface SettingService extends RemoteService {

	/**
	 * Retrieves a <tt>Setting.</tt>
	 * 
	 * @param name Name of <tt>Setting</tt> to retrieve.
	 * @return <tt>Setting</tt> if it exists.
	 * 
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	String getSetting(String name) throws OpenXDataException;
	
	/**
	 * Fetches all the <tt>Settings</tt> in the system.
	 * 
	 * @return <tt>List</tt> of <tt>Settings.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<SettingGroup> getSettings() throws OpenXDataException;
	
	/**
	 * Saves a dirty or new <tt>Setting.</tt>
	 * 
	 * @param setting <tt>Setting</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveSetting(Setting setting) throws OpenXDataException;
	
	/**
	 * Saves a dirty or new <tt>Setting Group.</tt>
	 * 
	 * @param settingGroup <tt>Setting Group</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveSettingGroup(SettingGroup settingGroup) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>Setting.</tt>
	 * 
	 * @param setting <tt>Setting</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteSetting(Setting setting) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>Setting Group.</tt>
	 * 
	 * @param settingGroup <tt>Setting Group</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteSettingGroup(SettingGroup settingGroup) throws OpenXDataException;
}
