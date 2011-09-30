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

import static org.openxdata.server.servlet.Verify.isNullOrEmpty;
import static org.openxdata.server.servlet.Verify.isValidId;
import static org.openxdata.server.servlet.Verify.isValidType;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openxdata.server.OpenXDataConstants;
import org.openxdata.server.export.FormExport;
import org.openxdata.server.export.StudyExport;
import org.openxdata.server.export.VersionExport;
import org.openxdata.server.service.DataExportService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet that handles export of studies.
 *
 * @author daniel
 * @author Jonny Heggheim
 *
 */
public class StudyExportServlet extends HttpServlet {

	private DataExportService dataExportService;
	
    private static final long serialVersionUID = 1119111102030345L;
    
    @Override
    public void init() throws ServletException {
		ServletContext sctx = this.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sctx);
		dataExportService = (DataExportService) ctx.getBean("dataExportService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        String type = request.getParameter("type");
        String filename = request.getParameter("filename");

        if (!isValidId(sid)) {
            setBadRequest(response, "Missing or wrong parameter for id");
            return;
        }

        if (!isValidType(type)) {
            setBadRequest(response, "Missing or empty parameter for type");
            return;
        }

        if (isNullOrEmpty(filename)) {
            filename = "dataexport";
        }

        String xml = "";
        Integer id = Integer.parseInt(sid);
        if ("study".equals(type)) {
            xml = StudyExport.export(dataExportService.getStudyDef(id));
        } else if ("form".equals(type)) {
            xml = FormExport.export(dataExportService.getFormDef(id));
        } else if ("version".equals(type)) {
            xml = VersionExport.export(dataExportService.getFormDefVersion(id));
        } else {
            setBadRequest(response, type + " is not a valid valid type");
            return;
        }

        response.setContentType(OpenXDataConstants.HTTP_HEADER_CONTENT_TYPE_XML);
        response.setDateHeader("Expires", -1);
        response.setHeader("Content-Disposition", "attachment; filename=" + filename + ".xml");
        response.setHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        response.addHeader("Cache-Control", "no-store");

        response.getOutputStream().print(xml);
    }

    private void setBadRequest(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType("text/plain");
        response.getOutputStream().println(message);
    }

    void setDataExportService(DataExportService dataExportService) {
        this.dataExportService = dataExportService;
    }
}