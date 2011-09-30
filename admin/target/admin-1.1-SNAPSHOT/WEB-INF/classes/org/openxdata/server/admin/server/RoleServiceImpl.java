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

import org.openxdata.server.admin.model.Permission;
import org.openxdata.server.admin.model.Role;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.rpc.OxdPersistentRemoteService;
import org.springframework.web.context.WebApplicationContext;

/**
 * Default Implementation for the <code>PermissionService Interface.</code>
 * 
 * @author Angel
 *
 */
public class RoleServiceImpl extends OxdPersistentRemoteService implements org.openxdata.server.admin.client.service.RoleService {

	private static final long serialVersionUID = -4262487595919371747L;
	private org.openxdata.server.service.RoleService roleService;
	
	public RoleServiceImpl() {}
	
	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext ctx = getApplicationContext();
		roleService = (org.openxdata.server.service.RoleService)ctx.getBean("roleService");
	}	

	@Override
	public void deletePermission(Permission permission) throws OpenXDataException {
		roleService.deletePermission(permission);		
	}

	@Override
	public void deleteRole(Role role) throws OpenXDataException {
		roleService.deleteRole(role);
		
	}

	@Override
	public List<Permission> getPermissions() throws OpenXDataException {
		return roleService.getPermissions();
	}

	@Override
	public List<Role> getRoles() throws OpenXDataException {
		return roleService.getRoles();
	}

	@Override
	public void savePermission(Permission permission) throws OpenXDataException {
		roleService.savePermission(permission);
	}

	@Override
	public void saveRole(Role role) throws OpenXDataException {
		roleService.saveRole(role);
	}
}
