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
package org.openxdata.server.admin.client.view.treeview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.openxdata.server.admin.client.controller.facade.MainViewControllerFacade;
import org.openxdata.server.admin.client.controller.observe.OpenXDataObservable;
import org.openxdata.server.admin.client.controller.observe.TasksObserver;
import org.openxdata.server.admin.client.internationalization.OpenXDataFacade;
import org.openxdata.server.admin.client.permissions.UIViewLabels;
import org.openxdata.server.admin.client.permissions.util.RolesListUtil;
import org.openxdata.server.admin.client.util.Utilities;
import org.openxdata.server.admin.client.view.constants.OpenXDataStackPanelConstants;
import org.openxdata.server.admin.client.view.factory.OpenXDataViewFactory;
import org.openxdata.server.admin.client.view.listeners.OpenXDataViewApplicationEventListener;
import org.openxdata.server.admin.client.view.widget.CompositeTreeItem;
import org.openxdata.server.admin.client.view.widget.TreeItemWidget;
import org.openxdata.server.admin.model.TaskDef;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * This widgets lists tasks and enables one to manage them.
 * 
 * @author daniel
 * @author Angel
 *
 */
public class TasksTreeView extends OpenXDataBaseTreeView implements OpenXDataViewApplicationEventListener, TasksObserver{

	/** Menu item for stopping a task from running. */
	private MenuItem mnuStop;
	
	/** Menu item for starting to run a task. */
	private MenuItem mnuStart;	
	
	/** List of tasks. */
	private List<TaskDef> tasks;
	
	/** List of deleted tasks. */
	private List<TaskDef> deletedTasks;	
	
	/**
	 * Creates a new instance of the tasks list widget.
	 * @param openXDataViewFactory 
	 * 
	 * @param images the tree item images.
	 */
	public TasksTreeView(OpenXDataViewFactory openXDataViewFactory){		
		super("Tasks",openXDataViewFactory);
	}

	
	@Override
	protected void setUp(){
		
		//Register this class with Event Dispatchers.
		super.registerWithEventDispatchers();
		
		openxdataStackPanel = widgetFactory.getOpenXdataStackPanel();
		
		// Initialize the Tree View
		tree = new Tree(widgetFactory.getOpenXDataImages());
		tree.ensureSelectedItemVisible();

		//Setting Scroll Panel properties.
		scrollPanel.setWidget(tree);
		scrollPanel.setWidth("100%");
		scrollPanel.setHeight("100");
		
		// Make this class the Listener
		tree.addSelectionHandler(this);

		// Initialize the ScrollPanel to be the main widget for the Tree View
		initWidget(scrollPanel);
		
		// Maximize this widget
		Utilities.maximizeWidget(this);
		
		// Initialize the Context Menu.
		popup = initContextMenu();
	}

	protected PopupPanel initContextMenu(){
		
		final PopupPanel popup = super.initContextMenu(this);
		
		if(popup != null){
			MenuBar menuBar = (MenuBar)popup.getWidget();
			if(menuBar != null){					
				menuBar.addSeparator();
				mnuStart = menuBar.addItem(Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().play(),OpenXDataFacade.getOpenXDataConstants().label_start()),true,new Command(){
					@Override
					public void execute() {popup.hide(); startTask(); }});
				
				menuBar.addSeparator();
				mnuStop = menuBar.addItem(Utilities.createHeaderHTML(widgetFactory.getOpenXDataImages().stop(),OpenXDataFacade.getOpenXDataConstants().label_stop()),true,new Command(){
					@Override
					public void execute() {popup.hide(); stopTask(); }});

				popup.setWidget(menuBar);
			}
		}
		
		return popup;
	}

	/**
	 * Loads tasks in the display widget.
	 * 
	 * @param tasks the tasks to load.
	 */
	public void loadTasks(List<TaskDef> tasks){
		this.tasks = tasks;
		deletedTasks = new Vector<TaskDef>();
		
		if(isLoadData()){
			tree.clear();

			TreeItem root; TaskDef task;
			for(int i=0; i<tasks.size(); i++){
				task = tasks.get(i);
				root = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), task.getName(),popup));
				root.setTitle(task.getDescription());
				root.setUserObject(task);
				tree.addItem(root);
			}
		}
	}

	/**
	 * @see com.google.gwt.user.client.ui.TreeListener#onTreeItemSelected(TreeItem)
	 */
	public void onTreeItemSelected(TreeItem item) {
		TaskDef taskDef = (TaskDef)item.getUserObject();
		updateTaskListeners(taskDef);
	}

	/**
	 * Adds a new task.
	 */
	@Override
	public void addNewItem(){
		TaskDef task = new TaskDef(OpenXDataFacade.getOpenXDataConstants().label_new_task());
		task.setStartOnStartup(true);
		TreeItem root = new CompositeTreeItem(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), task.getName(),popup));
		root.setUserObject(task);
		tree.addItem(root);
		tasks.add(task);
		tree.setSelectedItem(root);
	}
	
	/**
	 * Deletes the selected Task.
	 */
	@Override
	public void deleteSelectedItem(){
		TreeItem item = tree.getSelectedItem();
		if(item == null){
			Window.alert(OpenXDataFacade.getOpenXDataConstants().label_deletetaskselect());
			return;
		}

		if( !Window.confirm(OpenXDataFacade.getOpenXDataConstants().label_deletetaskconfirmation()))
			return;

		deletedTasks.add((TaskDef)item.getUserObject());
		tasks.remove(item.getUserObject());
		Utilities.removeRootItem(tree, item);
		
		if(tree.getItemCount() == 0)
			itemSelectionListener.onItemSelected(this, null);
	}

	
	@Override
	public void changeEditableProperties(Object item) {
		TreeItem treeItem = tree.getSelectedItem();
		if(item == null)
			return; //How can this happen?

		TaskDef task = (TaskDef)item;
		treeItem.setWidget(new TreeItemWidget(widgetFactory.getOpenXDataImages().lookup(), task.getName(),popup));
		treeItem.setTitle(task.getDescription());
		task.setDirty(true);
	}
	
	/**
	 * Gets a list of tasks that have been deleted.
	 * 
	 * @return the task list.
	 */
	public List<TaskDef> getDeletedTasks(){
		return deletedTasks;
	}
	
	/**
	 * Checks if the list of tasks is valid for saving.
	 * 
	 * @return true if valid, else false.
	 */
	public boolean isValidTasksList()
	{
		Map <String,String> map = new HashMap<String,String>();
		int index = tree.getItemCount();
		
		for(int j=0;j<index;j++)
		{
			if(map.containsKey(tree.getItem(j).getText().toLowerCase())){
				
				tree.setSelectedItem(tree.getItem(j));
				Window.alert(OpenXDataFacade.getOpenXDataConstants().label_existingtask() +tree.getItem(j).getText());
			    return false;
			}
			else
				map.put(tree.getItem(j).getText().toLowerCase(),tree.getItem(j).getText());
		}
		return true;
		
	}
	
	/**
	 * Starts the running of a task.
	 */
	private void startTask(){
		if(!Window.confirm(OpenXDataFacade.getOpenXDataConstants().label_starttask()))
			return;
		
		MainViewControllerFacade.startTask((TaskDef)tree.getSelectedItem().getUserObject());
	}
	
	/**
	 * Stops a task from running.
	 */
	private void stopTask(){
		if(!Window.confirm(OpenXDataFacade.getOpenXDataConstants().label_starttask()))
			return;
		
		MainViewControllerFacade.stopTask((TaskDef)tree.getSelectedItem().getUserObject());
	}
	
	/**
	 * Called when a task has been started.
	 * 
	 * @param taskDef the task definition object.
	 */
	public void onTaskStarted(TaskDef taskDef){
		taskDef.setRunning(true);
		updateTaskListeners(taskDef);
	}
	
	/**
	 * Called when a task has been stopped.
	 * 
	 * @param taskDef the task definition object.
	 */
	public void onTaskStopped(TaskDef taskDef){
		taskDef.setRunning(false);
		updateTaskListeners(taskDef);
	}
	
	/**
	 * Notifies task event listeners when the status of a task has been changed.
	 * 
	 * @param taskDef the task definition object.
	 */
	private void updateTaskListeners(TaskDef taskDef){
		mnuStart.setVisible(!taskDef.isRunning());
		mnuStop.setVisible(taskDef.isRunning());
		
		itemSelectionListener.onItemSelected(this,taskDef);
	}

    @Override
	UIViewLabels getContextMenuLabels() {
        UIViewLabels labels = new UIViewLabels();
        labels.setAddLabel(OpenXDataFacade.getOpenXDataConstants().label_addnewtask());
        labels.setDeleteLabel(OpenXDataFacade.getOpenXDataConstants().label_deletetask());
        return labels;
    }

	
	@Override
	public void update(OpenXDataObservable observable, Object observedModelObjects) {
		//do nothing
	}

	
	@Override
	public void updateTasks(OpenXDataObservable observable, List<TaskDef> tasks) {
		this.tasks = tasks;
		loadTasks(tasks);
		
	}
	
	
	@Override
	public void onDeleteItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_TASKS){
			if(RolesListUtil.getPermissionResolver().isDeleteTasks()){
				deleteSelectedItem();
			}
			else{
				Window.alert("You do not have sufficient priviledges to delete Tasks! Contact your system administrator");
			}
		}
		
	}
	
	
	@Override
	public void onNewChildItem() {
		// do nothing
		
	}

	
	@Override
	public void onNewItem() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_TASKS){
			if(RolesListUtil.getPermissionResolver().isAddTasks()){
				addNewItem();
			}
			else{
				Window.alert("You do not have sufficient priviledges to add Tasks! Contact your system administrator");
			}
		}
		
	}
	
	
	@Override
	public void onRefresh() {
		MainViewControllerFacade.refreshData();
		
	}
	
	
	@Override
	public void onSave() {
		if(openxdataStackPanel.getSelectedIndex() == OpenXDataStackPanelConstants.INDEX_TASKS){
			MainViewControllerFacade.saveTasks();
		}
		
	}
}
