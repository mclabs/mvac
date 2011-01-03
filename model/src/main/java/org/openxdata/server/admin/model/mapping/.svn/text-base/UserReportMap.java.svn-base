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
import org.openxdata.server.admin.model.Report;
import org.openxdata.server.admin.model.User;

/**
 * Maps <code>Reports</code> to <code>User</code>.
 * 
 * @author Angel
 *
 */
public class UserReportMap extends AbstractEditable {

	private int userId;
	private int reportId;
	private int userReportMapId;
	
	/**
	 * Generated serialization ID.
	 */
	private static final long serialVersionUID = 4321925710032960853L;

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param reportId the reportId to set
	 */
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	/**
	 * @return the reportId
	 */
	public int getReportId() {
		return reportId;
	}

	/**
	 * @param userReportId the userReportId to set
	 */
	public void setUserReportMapId(int userReportId) {
		this.userReportMapId = userReportId;
	}

	/**
	 * @return the userReportId
	 */
	public int getUserReportMapId() {
		return userReportMapId;
	}

	@Override
	public int getId() {
		return userReportMapId;
	}
	
	/**
	 * Adds the specified <code>User</code> to the Map.
	 * @param user <code>User</code> to remove.
	 */
	public void addUser(User user){
		setUserId(user.getUserId());
	}
	
	/**
	 * Removes the specified <code>User</code> from the Map.
	 * @param user <code>User</code> to remove.
	 */
	public void removeUser(User user){
		setUserId(user.getUserId());
	}
	
	/**
	 * Adds the specified <code>Report</code> to the Map.
	 * @param report <code>Report</code> to remove.
	 */
	public void addReport(Report report){
		setReportId(report.getReportId());
	}
	
	/**
	 * Removes the specified <code>Report</code> from the Map.
	 * @param report <code>Report</code> to remove.
	 */
	public void removeReport(Report report){
		setReportId(report.getReportId());
	}

}
