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
import static org.openxdata.server.servlet.Verify.isValidDate;
import static org.openxdata.server.servlet.Verify.isValidId;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.time.DateUtils;

import org.openxdata.server.export.CSVDataExport;
import org.openxdata.server.export.DataExport;

/**
 * Servlet that handles export of collected data. For now export are in CSV.
 *
 * @author daniel
 * @author Jonny Heggheim
 *
 */
//TODO This class should be renamed to something like CSVDataExportServlet
//I agree - Jonny Heggheim
public class DataExportServlet extends HttpServlet {

    private static final long serialVersionUID = 1239141102030345L;

    private DataExport dataExport = new CSVDataExport();

    void setDataExport(DataExport dataExport) {
        this.dataExport = dataExport;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sFormId = request.getParameter("formId");
        String sFromDate = request.getParameter("fromDate");
        String sToDate = request.getParameter("toDate");
        String sUserId = request.getParameter("userId");
        String filename = request.getParameter("filename");

        if (!isValidId(sFormId)) {
            setBadRequest(response, "Missing or wrong parameter formId");
            return;
        }

        Date fromDate = null;
        if (isValidDate(sFromDate)) {
            fromDate = new Date(Long.parseLong(sFromDate));
        }

        Date toDate = null;
        if (isValidDate(sToDate)) {
            toDate = new Date(Long.parseLong(sToDate));
            toDate = DateUtils.addDays(toDate, 1);
        }

        Integer userId = null;
        if (isValidId(sUserId)) {
            userId = Integer.parseInt(sUserId);
        }

        if (isNullOrEmpty(filename)) {
            filename = "dataexport";
        }

        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF-8");
        response.setDateHeader("Expires", -1);
        response.setHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        response.addHeader("Cache-Control", "no-store");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename + ".csv");

        dataExport.export(response.getWriter(), Integer.parseInt(sFormId), fromDate, toDate, userId);
    }

    private void setBadRequest(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType("text/plain");
        response.getOutputStream().println(message);
    }
}
