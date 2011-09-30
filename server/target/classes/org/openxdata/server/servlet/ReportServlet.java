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
package org.openxdata.server.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openxdata.server.OpenXDataConstants;
import org.openxdata.server.service.ReportService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet that handles requests for fetching report contents.
 * 
 * @author daniel
 *
 */
public class ReportServlet extends HttpServlet {

	private ReportService reportService;
	
    public static final long serialVersionUID = 122221111111113L;

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ServletContext sctx = this.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sctx);
		reportService = (ReportService) ctx.getBean("reportService");
	}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-store");

        String format = request.getParameter("format");
        response.setContentType(format.equalsIgnoreCase("pdf") ? OpenXDataConstants.HTTP_HEADER_CONTENT_TYPE_PDF : OpenXDataConstants.HTTP_HEADER_CONTENT_TYPE_TEXT_HTML);

        String fileName = request.getParameter("name");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        Integer reportId = Integer.parseInt(request.getParameter("reportId"));
        response.getOutputStream().write(reportService.getReportDataBytes(request.getRequestURI(),
                reportId, format));
    }
}
