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

import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.exception.OpenXDataException;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Defines the client side contract for the User Service.
 * 
 * @author Angel
 *
 */
public interface UserService extends RemoteService {
	
    /**
     * Gets a user based on their username
     * @param username String login name
     * @return User, or null if no match found
     */
    User getUser(String username) throws OpenXDataException;  
	
	/**
	 * Saves a new and modified users to the database.
	 * 
	 * @param user the user to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveUser(User user) throws OpenXDataException;
    
	/**
     * Gets a list of users in the database.
     * 
     * @return the user list.
     * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
     */
	List<User> getUsers() throws OpenXDataException;
	
	/**
	 * Removes a user from the database.
	 * 
	 * @param user the user to remove.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt> 
	 */
	void deleteUser(User user) throws OpenXDataException;
	
	/**
	 * Ascertains if the Administrator changed the default password on initial login.
	 * 
	 * @return <code>True only and only if(checkIfUserChangedPassword(user) == true)</code> 
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt> 
	 */
	Boolean checkIfUserChangedPassword(User user) throws OpenXDataException;
	
	void logout() throws OpenXDataException;
}
