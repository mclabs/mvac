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
import org.openxdata.server.admin.model.ReportGroup;
import org.openxdata.server.admin.model.User;

/**
 * Maps <code>Report Groups</code> to <code>User</code>.
 * 
 * @author Angel
 * 
 */
public class UserReportGroupMap extends AbstractEditable {

	private int	userId;
	private int	reportGroupId;
	private int	userReportGroupMapId;

	/**
	 * Generated serialization Version ID.
	 */
	private static final long	serialVersionUID	= 3676224125250551016L;

	/**
	 * Creates an instance of this <code>class</code>.
	 */
	public UserReportGroupMap() {
	}

	public int getUserReportGroupMapId() {
		return this.userReportGroupMapId;
	}

	@Override
	public int getId() {
		return this.userReportGroupMapId;
	}
	
	public void setUserReportGroupMapId(int userReportId) {
		this.userReportGroupMapId = userReportId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getReportGroupId() {
		return this.reportGroupId;
	}

	public void setReportGroupId(int reportId) {
		this.reportGroupId = reportId;
	}

	@Override
	public boolean isNew() {
		return this.userReportGroupMapId == 0;
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
	 * Adds the specified <code>ReportGroup</code> to the Map.
	 * @param reportGroup <code>ReportGroup</code> to remove.
	 */
	public void addReportGroup(ReportGroup reportGroup) {
		setReportGroupId(reportGroup.getReportGroupId());
	}

	/**
	 * Removes the specified <code>ReportGroup</code> from the Map.
	 * @param reportGroup <code>ReportGroup</code> to remove.
	 */
	public void removeReportGroup(ReportGroup reportGroup) {
		setReportGroupId(reportGroup.getReportGroupId());
	}

}
