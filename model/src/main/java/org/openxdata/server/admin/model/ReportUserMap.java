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
 * This class maps reports to users
 * 
 * @author Angel
 */
public class ReportUserMap extends AbstractEditable {
	
	/**
	 * Generated serialisation ID
	 */
	private static final long serialVersionUID = 8140917616720802044L;

	/**
	 * numeric identifier of the report user map object
	 */
	private int reportUserId;
	
	/**
	 * numeric identifier of the user mapped to the report user map
	 */
	private int userId;
	
	/**
	 * numeric identifier of the report mapped to the report user map
	 */
	private int reportId;
	
	/**
	 * Default constructor used by spring to initialise object
	 */
	public ReportUserMap(){}

	/**
	 * Overloaded constructor that initialises a new object give another map object
	 * 
	 * @param reportUserMap object to copy from
	 */
	public ReportUserMap(ReportUserMap reportUserMap){
		setReportUserId(reportUserMap.getReportUserId());
		setUserId(reportUserMap.getUserId());
		setReportId(reportUserMap.getReportId());
		
	}
	
	/**
	 * Sets the object's reportId
	 * 
	 * @param reportId id to set
	 */
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	/**
	 * Return the current objects reportId
	 * 
	 * @return numeric identifier for the user mapped to the map
	 */
	public int getReportId() {
		return reportId;
	}
	
	/**
	 * Sets the object's userId
	 * 
	 * @param userId userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Returns the current object's userId
	 * 
	 * @return numeric identifier for the user mapped to the report
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Sets the object's reportUserId
	 * 
	 * @param reportUserId
	 */
	public void setReportUserId(int reportUserId) {
		this.reportUserId = reportUserId;
	}

	public int getReportUserId() {
		return reportUserId;
	}
	
	@Override
	public int getId() {
		return reportUserId;
	}
		
	/**
	 * Maps a report to the current report user map
	 * @param report report to map
	 */
	public void addReport(Report report){
		
		setReportId(report.getReportId());
	}
	
	/**
	 * Maps a user to the current report user map
	 * @param user user to map
	 */
	public void addUser(User user){
		
		setUserId(user.getUserId());
	}
	
	@Override
	public boolean isNew() {
		
		return this.reportUserId == 0;
	}
	
	/**
	 * Unmaps a user to the current map
	 * 
	 * @param user user to unmap
	 */
	public void removeUser(User user) {
		setUserId(user.getUserId());
		
	}

	/**
	 * Unmaps a report to the current map
	 * @param report report to unmap
	 */
	public void removeReport(Report report) {
		setReportId(report.getReportId());
		
	}
}
