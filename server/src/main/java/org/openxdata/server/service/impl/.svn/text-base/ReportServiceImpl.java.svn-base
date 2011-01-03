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
package org.openxdata.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.openxdata.server.OpenXDataPropertyPlaceholderConfigurer;
import org.openxdata.server.admin.model.Report;
import org.openxdata.server.admin.model.ReportGroup;
import org.openxdata.server.admin.model.mapping.UserReportGroupMap;
import org.openxdata.server.admin.model.mapping.UserReportMap;
import org.openxdata.server.dao.ReportDAO;
import org.openxdata.server.dao.ReportGroupDAO;
import org.openxdata.server.dao.UserReportGroupMapDAO;
import org.openxdata.server.dao.UserReportMapDAO;
import org.openxdata.server.report.birt.ReportColumn;
import org.openxdata.server.report.birt.ReportDesigner;
import org.openxdata.server.report.birt.ReportManager;
import org.openxdata.server.service.ReportService;
import org.openxdata.server.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Default implementation for <code>Report Service</code>.
 * @author Angel
 *
 */
@Service("reportService")
@Transactional(propagation=Propagation.REQUIRED)
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportDAO reportDAO;
	
	@Autowired
	private ReportGroupDAO reportGroupDAO;
	
	@Autowired
	private UserReportMapDAO userReportMapDAO;
	
	@Autowired
	private UserReportGroupMapDAO userReportGroupMapDAO;
	
	@Autowired
	private OpenXDataPropertyPlaceholderConfigurer propertyPlaceholder;

	@Override
	public void deleteUserMappedReport(UserReportMap map) {
		userReportMapDAO.deleteUserMappedReport(map);
		
	}

	@Override
	public void deleteReport(Report report) {
		reportDAO.deleteReport(report);
		
	}

	@Override
	public void deleteReportGroup(ReportGroup reportGroup) {
		reportGroupDAO.deleteReportGroup(reportGroup);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserReportMap> getUserMappedReports() {
		return userReportMapDAO.getUserMappedReports();
	}

	@Override
	@Transactional(readOnly=true)
	public String getReportData(String baseUrl, Report report, String format) {
		return ReportManager.getInstance().getReportText(baseUrl, getReportDesign(report));
	}

	@Override
	@Transactional(readOnly=true)
	public byte[] getReportDataBytes(String baseUrl, Report report,	String format) {
		return ReportManager.getInstance().getReportBytes(baseUrl, getReportDesign(report));
	}

	@Override
	@Transactional(readOnly=true)
	public byte[] getReportDataBytes(String baseUrl, Integer reportId, String format) {
		return getReportDataBytes(baseUrl, reportDAO.getReport(reportId), format);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Report> getReports() {
		return reportDAO.getReports();
	}
	
	@Override
	@Transactional(readOnly=true)
	public ReportGroup getReportGroup(String groupName) {
		return reportGroupDAO.getReportGroup(groupName);
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public void saveUserMappedReport(UserReportMap map) {
		userReportMapDAO.saveUserMappedReport(map);
	}

	@Override
	public void saveReport(Report report) {
		reportDAO.saveReport(report);
	}

	@Override
	public void saveReportGroup(ReportGroup reportGroup) {
		reportGroupDAO.saveReportGroup(reportGroup);		
	}
	
	private String getReportDesign(Report report) {
		//Load the report definition object from the database.
		if(report == null)
			return null;

		//Set the default report type and title.
		String type = "Report Listing", title = "", xAxisTitle = "", yAxisTitle = "", oddColor = "White", evenColor = "#AACCFF";

		//Extract the report type and title from parameter values.
		String values = report.getParamValues();
		if(values != null && values.trim().length() > 0){
			try{
				do{
					int pos1 = values.indexOf('|');
					type = values.substring(0, pos1);

					pos1++;
					int pos2 = values.indexOf('|',pos1);
					if(pos2 < 0)
						pos2 = values.length();
					title= values.substring(pos1,pos2);

					if(pos2 == values.length())
						break;

					pos1 = pos2+1;
					pos2 = values.indexOf('|',pos1);
					if(pos2 < 0)
						pos2 = values.length();
					xAxisTitle = values.substring(pos1,pos2);

					if(pos2 == values.length())
						break;

					pos1 = pos2+1;
					pos2 = values.indexOf('|',pos1);
					if(pos2 < 0)
						pos2 = values.length();
					yAxisTitle = values.substring(pos1,pos2);

					if(pos2 == values.length())
						break;

					pos1 = pos2+1;
					pos2 = values.indexOf('|',pos1);
					if(pos2 < 0)
						pos2 = values.length();
					oddColor = values.substring(pos1,pos2);

					if(pos2 == values.length())
						break;

					pos1 = pos2+1;
					pos2 = values.indexOf('|',pos1);
					if(pos2 < 0)
						pos2 = values.length();
					evenColor = values.substring(pos1,pos2);
				}
				while(false);

			}catch(Exception ex){}
		}

		//If no report design specified, create one on the fly.
		String design = report.getDefinition();
		if(design == null || design.trim().length() == 0){
			String dbUrl = propertyPlaceholder.getResolvedProps().getProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/openxdata?autoReconnect=true");
			String dbDriver = propertyPlaceholder.getResolvedProps().getProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			design = new ReportDesigner(dbUrl, dbDriver).createReportDesign(type, title, xAxisTitle, yAxisTitle, getReportCols(type,report), report.getQuerySql(), evenColor, oddColor);
		}

		return design;
	}
	
	/**
	 * Gets a list of columns that a to be displayed for a given report.
	 * 
	 * @param type the report type
	 * @param report the report definition object.
	 * @return the column list
	 */
	private List<ReportColumn> getReportCols(String type, Report report) {
		List<ReportColumn> cols = new ArrayList<ReportColumn>();

		Document doc = XmlUtil.fromString2Doc(report.getQueryDefinition());
		NodeList nodes = doc.getDocumentElement().getElementsByTagName("DisplayFields");

		if(nodes.getLength() > 0){
			NodeList fieldNodes = nodes.item(0).getChildNodes();

			if(type.equals(ReportDesigner.REPORT_TYPE_LISTING)){
				for(int index = 0; index < fieldNodes.getLength(); index++)
					processColNode(fieldNodes.item(index),cols);
			}
			else{
				for(int index = fieldNodes.getLength() - 1; index >= 0 ; index--)
					processColNode(fieldNodes.item(index),cols);
			}
		}

		return cols;
	}

	private void processColNode(Node node, List<ReportColumn> cols) {
		if(node.getNodeType() != Node.ELEMENT_NODE)
			return;

		Element element = (Element)node;
		cols.add(new ReportColumn(element.getAttribute("text"),element.getAttribute("text"),element.getAttribute("type")));
	}

    @Override
	@Transactional(readOnly = true)
	public List<UserReportGroupMap> getUserMappedReportGroups() {
		return userReportGroupMapDAO.getUserMappedReportGroups();
	}

	@Override
	public void deleteUserMappedReportGroup(UserReportGroupMap map) {
		userReportGroupMapDAO.deleteUserMappedReportGroup(map);
	}

	@Override
	public void saveUserMappedReportGroup(UserReportGroupMap map) {
		userReportGroupMapDAO.saveUserMappedReportGroup(map);
	}


	/* (non-Javadoc)
	 * @see org.openxdata.server.service.ReportService#getReportGroups()
	 */
	@Override
	public List<ReportGroup> getReportGroups() {
		return reportGroupDAO.getReportGroups();
	}
}
