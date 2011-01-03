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

import org.openxdata.server.admin.model.Report;
import org.openxdata.server.admin.model.ReportGroup;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.admin.model.mapping.UserReportGroupMap;
import org.openxdata.server.admin.model.mapping.UserReportMap;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * Defines the client side contract for the Report Service.
 * 
 * @author Angel
 *
 */
public interface ReportService extends RemoteService {
	
	/**
	 * Fetches all the <tt>Reports</tt> in the system.
	 * 
	 * @return <tt>List</tt> of <tt>Reports.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<ReportGroup> getReports() throws OpenXDataException;
	
	String getReportData(Report report, String format) throws OpenXDataException;

	/**
	 * Saves a dirty or new <tt>Report.</tt>
	 * 
	 * @param report <tt>Report</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveReport(Report report) throws OpenXDataException;
	
	/**
	 * Saves a dirty or new <tt>Report Group.</tt>
	 * 
	 * @param reportGroup <tt>Report Group</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveReportGroup(ReportGroup reportGroup) throws OpenXDataException;
		
	/**
	 * Deletes a given <tt>Report.</tt>
	 * 
	 * @param report <tt>Report</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteReport(Report report) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>Report Group.</tt>
	 * 
	 * @param reportGroup <tt>Report Group</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteReportGroup(ReportGroup reportGroup) throws OpenXDataException;
	
	/**
	 * Fetches all the <tt>User Mapped Report Groups</tt> in the system.
	 * 
	 * @return <tt>List</tt> of <tt>User Mapped Report Groups.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<UserReportGroupMap> getUserMappedReportGroups() throws OpenXDataException;
	
	/**
	 * Save a dirty or new <tt>User Mapped Report Group.</tt>
	 * 
	 * @param userReportGroupMap <tt>User Mapped Report Group</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveUserMappedReportGroup(UserReportGroupMap userReportGroupMap) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>User Mapped Report Group.</tt>
	 * 
	 * @param userReportGroupMap <tt>User Mapped Report Group</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteUserMappedReportGroup(UserReportGroupMap userReportGroupMap) throws OpenXDataException;
	
	/**
	 * Fetches all the <tt>User Mapped Reports</tt> in the system.
	 * 
	 * @return <tt>List</tt> of <tt>User Mapped Reports.</tt>
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	List<UserReportMap> getUserMappedReports() throws OpenXDataException;
	
	/**
	 * Save a dirty or new <tt>User Mapped Report.</tt>
	 * 
	 * @param userReportMap <tt>User Mapped Report</tt> to save.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void saveUserMappedReport(UserReportMap userReportMap) throws OpenXDataException;
	
	/**
	 * Deletes a given <tt>User Mapped Report.</tt>
	 * 
	 * @param userReportMap <tt>User Mapped Report</tt> to delete.
	 * @throws OpenXDataException For any <tt>exception</tt> that occurs on the <tt>service layer.</tt>
	 */
	void deleteUserMappedReport(UserReportMap userReportMap) throws OpenXDataException;

}
