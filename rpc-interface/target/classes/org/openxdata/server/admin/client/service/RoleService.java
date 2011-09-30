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

import org.openxdata.server.admin.model.Permission;
import org.openxdata.server.admin.model.Role;
import org.openxdata.server.admin.model.exception.OpenXDataException;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * This interface defines the client side contract for the Permission Service.
 * 
 * @author Angel
 *
 */
public interface RoleService extends RemoteService {
	
	/**
	 * Fetches all the system <tt>Roles.</tt>
	 * 
	 * @return <tt>List</tt> of <tt>Roles.</tt>
	 * 
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<Role> getRoles() throws OpenXDataException;
	
	/**
	 * Saves a dirty or new <tt>Role</tt>.
	 * 
	 * @param role <tt>Role</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveRole(Role role) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>Role</tt>.
	 * 
	 * @param role <tt>Role</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteRole(Role role) throws OpenXDataException;
	
	/**
	 * Fetches all the system <tt>Permissions.</tt>
	 * 
	 * @return <tt>List</tt> of <tt>Permissions.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<Permission> getPermissions() throws OpenXDataException;
	
	/**
	 * Saves a dirty or new <tt>Permission.</tt>
	 * 
	 * @param permission <tt>Permission</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void savePermission(Permission permission) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>Permission.</tt>
	 * @param permission <tt>Permission</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deletePermission(Permission permission) throws OpenXDataException;
}
