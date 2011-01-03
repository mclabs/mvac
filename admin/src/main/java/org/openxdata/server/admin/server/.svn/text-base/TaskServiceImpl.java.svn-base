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

import org.openxdata.server.admin.model.TaskDef;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.rpc.OxdPersistentRemoteService;
import org.springframework.web.context.WebApplicationContext;

/**
 * Default Implementation for the <code>TaskService Interface.</code>
 * 
 * @author Angel
 *
 */
public class TaskServiceImpl extends OxdPersistentRemoteService implements
org.openxdata.server.admin.client.service.TaskService {

	/**
	 * Generated Serialisation ID.
	 */
	private static final long serialVersionUID = -7724890075405637511L;
	
	private org.openxdata.server.service.TaskService taskService;
	
	public TaskServiceImpl() {}
	
	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext ctx = getApplicationContext();
		taskService = (org.openxdata.server.service.TaskService)ctx.getBean("taskService");
	}
	
	@Override
	public void deleteTask(TaskDef task) throws OpenXDataException {
		taskService.deleteTask(task);
	}

	@Override
	public List<TaskDef> getTasks() throws OpenXDataException {
		return taskService.getTasks();
	}

	@Override
	public void saveTask(TaskDef task) throws OpenXDataException {
		taskService.saveTask(task);
		
	}

	@Override
	public Boolean startTask(TaskDef taskDef) throws OpenXDataException {
		return taskService.startTask(taskDef);
	}

	@Override
	public Boolean stopTask(TaskDef taskDef) throws OpenXDataException {
		return taskService.stopTask(taskDef);
	}

}
