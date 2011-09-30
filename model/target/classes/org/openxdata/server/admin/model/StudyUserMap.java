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
package org.openxdata.server.admin.model;

/**
 * 
 * This class maps <code>Studies</code> to <code>Users</code>.
 * 
 * @author Mark 
 *
 */
public class StudyUserMap  extends AbstractEditable {

	/**
	 * Serialisation ID
	 */
	private static final long serialVersionUID = 3915994296425862957L;
	
	/**
	 * numeric identifier of the map object
	 */
	private int studyUserId;
	
	/**
	 * numeric identifier of the user mapped to the map
	 */
	private int userId;
	
	/**
	 * numeric identifier of the study mapped to the map
	 */
	private int studyId;
	
	/**
	 * Default constructor used by spring to initialise object
	 */
	public StudyUserMap(){}

	/**
	 * Overloaded constructor that initialises a new object give another map object
	 * 
	 * @param map object to copy from
	 */
	public StudyUserMap(StudyUserMap map){
		setStudyUserId(map.studyUserId);
		setUserId(map.userId);
		setStudyId(map.studyId);
		
	}
	
	/**
	 * Sets the object's studyId
	 * @param studyId id to set
	 */
	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	/**
	 * Return the current objects studyId
	 * @return numeric identifier for the user mapped to the map
	 */
	public int getStudyId() {
		return studyId;
	}
	
	/**
	 * Sets the object's userId
	 * @param userId userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Returns the current object's userId
	 * @return numeric identifier for the user mapped to the study
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Sets the object's studyuserId
	 * @param studyUserId
	 */
	public void setStudyUserId(int studyUserId) {
		this.studyUserId = studyUserId;
	}

	/**
	 * Returns the current object's studyuserId
	 * @return
	 */
	public int getStudyUserId() {
		return studyUserId;
	}

	@Override
	public int getId() {
		return studyUserId;
	}
	
	/**
	 * Maps a study to the current map
	 * @param study study to map
	 */
	public void addStudy(StudyDef study){
		
		setStudyId(study.getStudyId());
	}
	
	/**
	 * Maps a user to the current map
	 * @param user user to map
	 */
	public void addUser(User user){
		
		setUserId(user.getUserId());
	}
	
	@Override
	public boolean isNew() {
		
		return this.studyUserId == 0;
	}
	
	/**
	 * Unmaps a user to the current map
	 * @param user user to unmap
	 */
	public void removeUser(User user) {
		setUserId(user.getUserId());
		
	}

	/**
	 * Unmaps a study to the current map
	 * @param study study to unmap
	 */
	public void removeStudy(StudyDef study) {
		setStudyId(study.getStudyId());
		
	}

}
