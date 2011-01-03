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
package org.openxdata.server.admin.client.listeners;

/**
 * This interface is implemented by those classes 
 * which want to listen to events of changing an item's property. 
 * <p>
 * Examples of events would be when a form's name
 * changes, when a study's description changes, when a report's sql filter changes, etc.
 * <p>
 * An example is the <tt>StudiesTreeView</tt> which implements this <tt>interface</tt>
 * and then is called by the StudyView whenever the name and description properties of the study change.
 * </p>
 * </p>
 * 
 * Then in this <tt>callback</tt>, the <tt>StudiesTreeView</tt>
 * changes the tree node name and tool tip to match the new study name and description respectively.
 * <p>
 * @author daniel
 *
 */
public interface ItemChangeListener {

	/**
	 * Called when an item has any of its properties changed.
	 * 
	 * @param item the changed item which now already has the new property value.
	 */
	public void onItemChanged(Object item);

}
