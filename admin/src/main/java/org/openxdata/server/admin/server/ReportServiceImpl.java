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
package org.openxdata.server.admin.server;

import java.util.List;

import javax.servlet.ServletException;

import org.openxdata.server.admin.client.service.ReportService;
import org.openxdata.server.admin.model.Report;
import org.openxdata.server.admin.model.ReportGroup;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.admin.model.mapping.UserReportGroupMap;
import org.openxdata.server.admin.model.mapping.UserReportMap;
import org.openxdata.server.rpc.OxdPersistentRemoteService;
import org.springframework.web.context.WebApplicationContext;

/**
 * Default Implementation for the <code>ReportService Interface.</code>
 * 
 * @author Angel
 *
 */
public class ReportServiceImpl extends OxdPersistentRemoteService implements ReportService {

	private org.openxdata.server.service.ReportService reportService;
	private static final long serialVersionUID = -4224505027873253611L;
	
	public ReportServiceImpl() {}
	
	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext ctx = getApplicationContext();
		reportService = (org.openxdata.server.service.ReportService)ctx.getBean("reportService");
	}

	@Override
	public void deleteReport(Report report) throws OpenXDataException {
		reportService.deleteReport(report);

	}

	@Override
	public void deleteReportGroup(ReportGroup reportGroup)
			throws OpenXDataException {
		reportService.deleteReportGroup(reportGroup);
	}

	@Override
	public String getReportData(Report report, String format) throws OpenXDataException {
		return reportService.getReportData(getThreadLocalRequest().getRequestURL().toString(), report, format);
	}

	@Override
	public List<ReportGroup> getReports() throws OpenXDataException {
		return reportService.getReportGroups();
	}

	@Override
	public void saveReport(Report report) throws OpenXDataException {
		reportService.saveReport(report);

	}

	@Override
	public void saveReportGroup(ReportGroup reportGroup)
			throws OpenXDataException {
		reportService.saveReportGroup(reportGroup);
	}

	@Override
	public void deleteUserMappedReport(UserReportMap userReportMap) throws OpenXDataException {
		reportService.deleteUserMappedReport(userReportMap);
	}

	@Override
	public void deleteUserMappedReportGroup(UserReportGroupMap userReportGroupMap)
			throws OpenXDataException {
		reportService.deleteUserMappedReportGroup(userReportGroupMap);
	}

	@Override
	public List<UserReportGroupMap> getUserMappedReportGroups()	throws OpenXDataException {
		return reportService.getUserMappedReportGroups();
	}
	
	@Override
	public List<UserReportMap> getUserMappedReports() throws OpenXDataException {
		return reportService.getUserMappedReports();
	}

	@Override
	public void saveUserMappedReport(UserReportMap userReportMap) throws OpenXDataException {
		reportService.saveUserMappedReport(userReportMap);
	}

	@Override
	public void saveUserMappedReportGroup(UserReportGroupMap userReportMap) throws OpenXDataException {
		reportService.saveUserMappedReportGroup(userReportMap);
	}

	public byte[] getReportDataBytes(String baseUrl, Report report, String format) throws OpenXDataException {
		return reportService.getReportDataBytes(baseUrl, report, format);
	}
	
	public byte[] getReportDataBytes(String baseUrl, Integer reportId, String format) throws OpenXDataException {
		return reportService.getReportDataBytes(baseUrl, reportId, format);
	}

}
