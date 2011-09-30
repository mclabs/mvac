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
package org.openxdata.server.admin.client.controller;

import java.util.List;

import org.openxdata.server.admin.client.Context;
import org.openxdata.server.admin.client.controller.callback.OpenXDataAsyncCallback;
import org.openxdata.server.admin.client.controller.callback.SaveAsyncCallback;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.listeners.SaveCompleteListener;
import org.openxdata.server.admin.client.locale.OpenXdataText;
import org.openxdata.server.admin.client.locale.TextConstants;
import org.openxdata.server.admin.client.util.AsyncCallBackUtil;
import org.openxdata.server.admin.client.util.MainViewControllerUtil;
import org.openxdata.server.admin.client.view.treeview.TasksTreeView;
import org.openxdata.server.admin.model.Editable;
import org.openxdata.server.admin.model.TaskDef;
import org.purc.purcforms.client.util.FormUtil;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

/**
 * This controller deals with loading and saving of Tasks related data
 * to and from the database for the various Tasks related views.
 * 
 * Also handles operations like starting and stopping of tasks
 * 
 * @author Angel
 *
 */
public class TasksViewController extends OpenXDataObservable implements SaveCompleteListener {

	private List<TaskDef> tasks;	
	private TasksTreeView tasksTreeView;
	
	/**
	 * Constructs an instance of this <tt>class</tt> given a <tt>View</tt> to update with <tt>Users.</tt>
	 * @param tasksTreeView <tt>View</tt> that is observing this <tt>Class.</tt>
	 */
	public TasksViewController(TasksTreeView tasksTreeView) {
		this.tasksTreeView = tasksTreeView;	
	}

	/**
	 * Loads tasks from the database.
	 * 
	 * @param reload set to false if you want to use the cached tasks, if any, without
	 *        having to reload them from the database.
	 */
	public void loadTasks(boolean reload){
		if(tasks != null && !reload)
			return;

		FormUtil.dlg.setText(OpenXdataText.get(TextConstants.LOADING_TASKS));
		FormUtil.dlg.center();

		DeferredCommand.addCommand(new Command(){
			@Override
			public void execute() {
				try{
					Context.getTaskService().getTasks(new OpenXDataAsyncCallback<List<TaskDef>>() {
						@Override
						public void onOtherFailure(Throwable caught) {
							FormUtil.dlg.hide();
							AsyncCallBackUtil.handleGenericOpenXDataException(caught);
						}

						@Override
						public void onSuccess(List<TaskDef> result) {
							tasks = result;
							
							setChanged();
						    notifyObservers(tasks, TaskDef.class);
						    
							FormUtil.dlg.hide();
						}
					});
				}
				catch(Exception ex){
					FormUtil.dlg.hide();
					FormUtil.displayException(ex);
				}	
			}
		});
	}
	
	/**
	 * Saves modified and new tasks to the database.
	 */
	public void saveTasks(){
		if(tasks == null)
			return;

		if(!tasksTreeView.isValidTasksList())
			return;

		List<TaskDef> deletedTasks = tasksTreeView.getDeletedTasks();

		/*SaveAsyncCallback callback = new SaveAsyncCallback(MainViewControllerUtil.getDirtyCount(tasks) + (deletedTasks != null ? deletedTasks.size() : 0),
				"Tasks Saved Successfully","Problem saving Tasks",tasks,deletedTasks,this);*/
		SaveAsyncCallback callback = new SaveAsyncCallback(MainViewControllerUtil.getDirtyCount(tasks) + (deletedTasks != null ? deletedTasks.size() : 0),
				OpenXdataText.get(TextConstants.TASKS_SAVED_SUCCESSFULLY),OpenXdataText.get(TextConstants.PROBLEM_SAVING_TASKS),tasks,deletedTasks,this);


		//Save new and modified tasks.
		for(TaskDef task : tasks) {
			if(!task.isDirty())
				continue;
			else{
				callback.setCurrentItem(task);
				MainViewControllerUtil.setEditableProperties(task);
			}

			Context.getTaskService().saveTask(task, callback);
		}

		//Save deleted tasks.
		if(deletedTasks != null){
			for(TaskDef task : deletedTasks) {
				callback.setCurrentItem(task);
				Context.getTaskService().deleteTask(task, callback);
			}
			deletedTasks.clear();
		}
	}

	/**
	 * Starts or runs a task.
	 * 
	 * @param taskDef the task definition object.
	 */
	public void startTask(TaskDef taskDef){
		FormUtil.dlg.setText(OpenXdataText.get(TextConstants.STARTING) + taskDef.getName() + OpenXdataText.get(TextConstants.TASK));
		FormUtil.dlg.center();

		final TaskDef task = taskDef;

		DeferredCommand.addCommand(new Command(){
			@Override
			public void execute() {
				try{
					Context.getTaskService().startTask(task, new OpenXDataAsyncCallback<Boolean>() {
						@Override
						public void onOtherFailure(Throwable caught) {
							FormUtil.dlg.hide();
							AsyncCallBackUtil.handleGenericOpenXDataException(caught);
						}

						@Override
						public void onSuccess(Boolean result) {
							if(result)
								tasksTreeView.onTaskStarted(task);
							
							FormUtil.dlg.hide();
						}
					});
				}
				catch(Exception ex){
					FormUtil.dlg.hide();
					FormUtil.displayException(ex);
				}	
			}
		});
	}

	/**
	 * Stops a task from running.
	 * 
	 * @param taskDef the task definition object.
	 */
	public void stopTask(TaskDef taskDef){
		FormUtil.dlg.setText(OpenXdataText.get(TextConstants.STOPPING) + taskDef.getName() + OpenXdataText.get(TextConstants.TASK));
		FormUtil.dlg.center();

		final TaskDef task = taskDef;

		DeferredCommand.addCommand(new Command(){
			@Override
			public void execute() {
				try{
					Context.getTaskService().stopTask(task, new OpenXDataAsyncCallback<Boolean>() {
						@Override
						public void onOtherFailure(Throwable caught) {
							FormUtil.dlg.hide();
							AsyncCallBackUtil.handleGenericOpenXDataException(caught);
						}

						@Override
						public void onSuccess(Boolean result) {
							if(result)
								tasksTreeView.onTaskStopped(task);
							FormUtil.dlg.hide();
						}
					});
				}
				catch(Exception ex){
					FormUtil.dlg.hide();
					FormUtil.displayException(ex);
				}	
			}
		});
	}
	
    @Override
	public void onSaveComplete(List<? extends Editable> modifiedList, List<? extends Editable> deletedList) {
    	MainViewControllerUtil.onSaveComplete(modifiedList, deletedList);
    	loadTasks(true);
	}
}
