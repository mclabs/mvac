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

import org.openxdata.server.admin.model.TaskDef;
import org.openxdata.server.admin.model.exception.OpenXDataException;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Defines the client side contract for the Task Service.
 * 
 * @author Angel
 *
 */
public interface TaskService extends RemoteService {
	
	/**
	 * Fetches all the <tt>Tasks</tt> in the system.
	 * 
	 * @return <tt>List</tt> of <tt>Tasks.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<TaskDef> getTasks() throws OpenXDataException;
	
	/**
	 * Saves a dirty or new <tt>Task.</tt>
	 * 
	 * @param task <tt>Task</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveTask(TaskDef task) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>Task.</tt>
	 * 
	 * @param task <tt>Task</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteTask(TaskDef task) throws OpenXDataException;
	
	/**
	 * Starts a given <tt>Task.</tt> After this operation, the status of the <tt>Task</tt> will be started/running.
	 * 
	 * @param task <tt>Task</tt> to start.
	 * @return <tt>True if started else false.</tt>
	 * 
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	Boolean startTask(TaskDef task) throws OpenXDataException;
	
	/**
	 * Stops a given <tt>Task.</tt> After this operation, the status of the <tt>Task</tt> will be stopped.
	 * 
	 * @param task <tt>Task</tt> to stop.
	 * @return <tt>True if stopped else false.</tt>
	 * 
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	Boolean stopTask(TaskDef task) throws OpenXDataException;
}
