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

import javax.servlet.ServletException;

import org.openxdata.server.admin.model.User;
import org.openxdata.server.rpc.OxdPersistentRemoteService;
import org.springframework.web.context.WebApplicationContext;

public class AuthenticationServiceImpl extends OxdPersistentRemoteService implements
org.openxdata.server.admin.client.service.AuthenticationService {
	
	private static final long serialVersionUID = 1L;
	
	private org.openxdata.server.service.AuthenticationService authenticationService;

	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext ctx = getApplicationContext();
		authenticationService = (org.openxdata.server.service.AuthenticationService)ctx.getBean("authenticationService");
	}
	
	@Override
	public User authenticate(String username, String password) {
		return authenticationService.authenticate(username, password);
	}
	
	@Override
	public Boolean isValidUserPassword(String username, String password) {
		return authenticationService.isValidUserPassword(username, password);
	}
}
