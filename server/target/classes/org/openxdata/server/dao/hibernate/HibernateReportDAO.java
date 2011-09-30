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
package org.openxdata.server.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.openxdata.server.admin.model.Report;
import org.openxdata.server.dao.ReportDAO;
import org.springframework.security.annotation.Secured;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provides a hibernate implementation
 * of the <code>ReportDAO</code> data access <code> interface.</code>
 * 
 * @author Angel
 *
 */
@Repository("reportDAO")
@Transactional(propagation=Propagation.MANDATORY)
public class HibernateReportDAO extends BaseDAOImpl<Report> implements ReportDAO {
	
	@Override
	@Secured("Perm_Delete_Reports")
	public void deleteReport(Report report) {
		remove(report);
	}
	
	@Override
	@Secured("Perm_View_Reports")
	public Report getReport(Integer reportId) {
		Query query = getSessionFactory().getCurrentSession().createQuery(
		"from Report where reportId = :reportId");
		query.setParameter("reportId", reportId);
		
		return (Report) query.uniqueResult();
	}
	
	@Override
	@Secured("Perm_View_Reports")
	public List<Report> getReports() {
		return findAll();
	}
	
	@Override
	@Secured("Perm_Add_Reports")
	public void saveReport(Report report) {
		save(report);
	} 

}
