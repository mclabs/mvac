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
package org.openxdata.server.admin.model.mapping;

import org.openxdata.server.admin.model.AbstractEditable;
import org.openxdata.server.admin.model.StudyDef;
import org.openxdata.server.admin.model.User;

/**
 * Maps <code>Studies</code> to <code>Users</code>.
 * 
 * @author Angel
 * 
 */
public class UserStudyMap extends AbstractEditable {

	/**
	 * Generated serialization version ID
	 */
	private static final long	serialVersionUID	= 2870582564160870766L;
	private int	              userStudyMapId;
	private int	              userId;
	private int	              studyId;

	/**
	 * Creates an instance of this <code>class</code>.
	 */
	public UserStudyMap() {
	}

	public int getUserStudyMapId() {
		return this.userStudyMapId;
	}

	@Override
	public int getId() {
		return this.userStudyMapId;
	}
	
	public void setUserStudyMapId(int userStudyId) {
		this.userStudyMapId = userStudyId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStudyId() {
		return this.studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	@Override
	public boolean isNew() {
		return this.userStudyMapId == 0;
	}

	/**
	 * Adds the specified <code>User</code> to the Map.
	 * @param user <code>User</code> to remove.
	 */
	public void addUser(User user) {
		setUserId(user.getUserId());
	}

	/**
	 * Removes the specified <code>User</code> from the Map.
	 * @param user <code>User</code> to remove.
	 */
	public void removeUser(User user) {
		setUserId(user.getUserId());
	}

	/**
	 * Adds the specified <code>StudyDef</code> to the Map.
	 * @param study <code>StudyDef</code> to remove.
	 */
	public void addStudy(StudyDef study) {
		setStudyId(study.getStudyId());
	}

	/**
	 * Removes the specified <code>StudyDef</code> from the Map.
	 * @param study <code>StudyDef</code> to remove.
	 */
	public void removeStudy(StudyDef study) {
		setStudyId(study.getStudyId());
	}
}
