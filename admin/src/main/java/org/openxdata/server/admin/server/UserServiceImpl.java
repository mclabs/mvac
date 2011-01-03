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
package org.openxdata.server.admin.server;

import java.util.List;

import javax.servlet.ServletException;

import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.rpc.OxdPersistentRemoteService;
import org.springframework.web.context.WebApplicationContext;

/**
 * Default Implementation for the <code>UserService Interface.</code>
 * 
 * @author Angel
 *
 */
public class UserServiceImpl extends OxdPersistentRemoteService implements org.openxdata.server.admin.client.service.UserService{

	/** Generated serialization ID.*/
	private static final long serialVersionUID = 2600958435557581185L;
	
	private org.openxdata.server.service.UserService userService;
	
	public UserServiceImpl() {}
	
	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext ctx = getApplicationContext();		
		userService = (org.openxdata.server.service.UserService)ctx.getBean("userService");
	}

	
	@Override
	public void deleteUser(User user) throws OpenXDataException {
		userService.deleteUser(user);
	}

	@Override
	public List<User> getUsers() throws OpenXDataException {
		return userService.getUsers();
	}

	@Override
	public void saveUser(User user) throws OpenXDataException {
		userService.saveUser(user);
	}

	@Override
	public User getUser(String username) throws OpenXDataException {
		return userService.findUserByUsername(username);
	}

	@Override
	public Boolean checkIfUserChangedPassword(User user) throws OpenXDataException {
		return userService.checkIfUserChangedPassword(user);
	}
	
	@Override
	public void logout() throws OpenXDataException{
		userService.logout();
	}
}
