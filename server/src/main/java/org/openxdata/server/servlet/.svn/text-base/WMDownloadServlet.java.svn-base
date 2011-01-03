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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openxdata.server.FormsServer;
import org.openxdata.server.OpenXDataConstants;
import org.openxdata.server.service.FormDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WMDownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 2L;

    @Autowired
    private FormDownloadService formDownloadService;
    
    @Override
    public void init() throws ServletException {
		ServletContext sctx = this.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sctx);
		formDownloadService = (FormDownloadService) ctx.getBean("formDownloadService");
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter(OpenXDataConstants.REQUEST_PARAMETER_ACTION);

            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", -1);
            response.setHeader("Cache-Control", "no-store");
            response.setContentType(OpenXDataConstants.HTTP_HEADER_CONTENT_TYPE_XML);

            if (action == null) {
                new FormsServer(formDownloadService).processConnection(request.getInputStream(), response.getOutputStream());
            } else {

                if (OpenXDataConstants.ACTION_DOWNLOAD_STUDIES.equalsIgnoreCase(action)) {
                    downloadStudies(response);
                } else if (OpenXDataConstants.REQUEST_ACTION_DOWNLOAD_FORMS.equalsIgnoreCase(action)) {
                    String studyId = request.getParameter("studyid");
                    if (studyId != null && studyId.length() > 0) {
                        downloadForms(response, Integer.parseInt(studyId));
                    }
                } else if (OpenXDataConstants.REQUEST_ACTION_UPLOAD_DATA.equalsIgnoreCase(action)) {
                	// do nothing???
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void downloadForms(HttpServletResponse response, int studyId) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        formDownloadService.downloadForms(studyId, dos, "", "");
        baos.flush();
        dos.flush();
        byte[] data = baos.toByteArray();
        baos.close();
        dos.close();
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));

        PrintWriter out = response.getWriter();
        out.println("<study>");

        try {
            dis.readByte(); //reads the size of the studies

            while (true) {
                String value = dis.readUTF();
                out.println("<form>" + value + "</form>");
            }
        } catch (EOFException exe) {
            //exe.printStackTrace();
        }

        out.println("</study>");
        out.flush();
        dis.close();
    }

    private void downloadStudies(HttpServletResponse response) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        formDownloadService.downloadStudies(dos, "", "");
        baos.flush();
        dos.flush();
        byte[] data = baos.toByteArray();
        baos.close();
        dos.close();

        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));

        PrintWriter out = response.getWriter();
        out.println("<StudyList>");

        try {
            @SuppressWarnings("unused")
            byte size = dis.readByte(); //reads the size of the studies

            while (true) {
                String value = "<study id=\"" + dis.readInt() + "\" name=\"" + dis.readUTF() + "\"/>";
                out.println(value);
            }
        } catch (EOFException exe) {
            //exe.printStackTrace();
        }
        out.println("</StudyList>");
        out.flush();
        dis.close();
    }

}
