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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openxdata.server.FormsServer;
import org.openxdata.server.OpenXDataConstants;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.serializer.XformSerializer;
import org.openxdata.server.service.AuthenticationService;
import org.openxdata.server.service.FormDownloadService;
import org.openxdata.server.service.SerializationService;
import org.openxdata.server.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet that handles download of studies,forms,users and upload of collected data
 * form mobile devices.
 * 
 * @author daniel
 *
 */
public class FormDownloadServlet extends HttpServlet{

	private FormsServer formsServer;
	private UserService userService;
	private FormDownloadService formDownloadService;
	private SerializationService serializationService;
	private AuthenticationService authenticationService;
	
	private Logger log = Logger.getLogger(this.getClass());

	public static final long serialVersionUID = 111111111111111L;

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ServletContext sctx = this.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sctx);
		
		// Manual Injection
		formsServer = (FormsServer) ctx.getBean("formsServer");
		userService = (UserService) ctx.getBean("userService");
		formDownloadService = (FormDownloadService) ctx.getBean("formDownloadService");
		serializationService = (SerializationService) ctx.getBean("serializationService");
		authenticationService = (AuthenticationService) ctx.getBean("authenticationService");
	}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OutputStream os = response.getOutputStream();
		try{
			String action = request.getParameter(OpenXDataConstants.REQUEST_PARAMETER_ACTION);

			if(action == null)
				formsServer.processConnection(request.getInputStream(), os);
			else{

				User user = authenticationService.authenticate(request.getParameter(OpenXDataConstants.REQUEST_PARAM_USERNAME),request.getParameter(OpenXDataConstants.REQUEST_PARAM_PASSWORD));
				if(user == null){
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					XformSerializer formSerializer = serializationService.getFormSerializer(request.getParameter(OpenXDataConstants.REQUEST_PARAM_FORM_SERIALIZER));
					formSerializer.serializeAccessDenied(os);
				}
				else{
					if(OpenXDataConstants.REQUEST_ACTION_UPLOAD_DATA.equalsIgnoreCase(action)){
						uploadData(request,response);
						String serializerKey = request.getParameter(OpenXDataConstants.REQUEST_PARAM_FORM_SERIALIZER);
						XformSerializer formSerializer = serializationService.getFormSerializer(serializerKey);
						formSerializer.serializeSuccess(os);
					}
					else if(OpenXDataConstants.REQUEST_ACTION_DOWNLOAD_FORMS.equalsIgnoreCase(action))
						downloadForms(request,response);
					else if(OpenXDataConstants.ACTION_DOWNLOAD_STUDIES.equalsIgnoreCase(action))
						downloadStudies(request,response);
					else if(OpenXDataConstants.REQUEST_ACTION_DOWNLOAD_USERS.equalsIgnoreCase(action))
						downloadUsers(request,response);
				}
			}
		}
		catch(Exception ex){
			try{
				String serializerKey = request.getParameter(OpenXDataConstants.REQUEST_PARAM_FORM_SERIALIZER);
				XformSerializer formSerializer = serializationService.getFormSerializer(serializerKey);
				formSerializer.serializeFailure(os, ex);
			}catch(Exception e){
				log.error(e.getLocalizedMessage(), e);
			}
		}
	}

	private void uploadData(HttpServletRequest request, HttpServletResponse response) throws IOException{
		byte status = OpenXDataConstants.STATUS_NULL;

		try{
			if(OpenXDataConstants.TRUE_TEXT_VALUE.equalsIgnoreCase(request.getParameter(OpenXDataConstants.REQUEST_PARAM_BATCH_ENTRY))){
				try{
					
					String serializerKey = request.getParameter(OpenXDataConstants.REQUEST_PARAM_FORM_SERIALIZER);
					XformSerializer formSerializer = serializationService.getFormSerializer(serializerKey);
					List<String> xforms = formSerializer.deSerialize(request.getInputStream(),getXforms());
					if(xforms != null){
						for(String xml : xforms)
							processForm(xml);

						status = OpenXDataConstants.STATUS_SUCCESS;
					}
					else{
						status = OpenXDataConstants.STATUS_FAILURE;
						formSerializer.serializeFailure(response.getOutputStream(), new Exception("No forms returned from the serializer"));
						log.warn("No forms returned by the serializer");
					}
				}
				catch(Exception ex){
					log.error(ex.getMessage(),ex);
					status = OpenXDataConstants.STATUS_FAILURE; 
				}
			}
			else{

				User user = authenticationService.authenticate(request.getParameter("uname"), request.getParameter("pw"));
				if(user == null)
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				else{
					response.setContentType("text/html");
                    String form = getRequestAsString(request);
					processForm(form);
				}
			}
		}
		catch(Exception ex){
			if(status == OpenXDataConstants.STATUS_NULL){
				PrintWriter out = response.getWriter();
				out.println("<HTML><HEAD><TITLE>Form Submission Status</TITLE>"+
						"</HEAD><BODY>Problem submitting form! <BR /> " + ex.getMessage() + "</BODY></HTML>");
				out.close();
			}
		}
	}

    /**
     * Reads text data from an http request stream.
     *
     * @param request the http request stream.
     * @return the text data.
     * @throws java.io.IOException
     */
    private String getRequestAsString(HttpServletRequest request) throws IOException {
        InputStream input = request.getInputStream();
        return IOUtils.toString(input, "UTF-8");
    }

	private void downloadForms(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String studyId = request.getParameter("studyId");
		if(studyId == null)
			formDownloadService.downloadForms(response.getOutputStream(),request.getParameter(OpenXDataConstants.REQUEST_PARAM_FORM_SERIALIZER),request.getParameter(OpenXDataConstants.REQUEST_PARAM_LOCALE));
		else
			formDownloadService.downloadForms(Integer.parseInt(studyId),response.getOutputStream(),request.getParameter(OpenXDataConstants.REQUEST_PARAM_FORM_SERIALIZER),request.getParameter(OpenXDataConstants.REQUEST_PARAM_LOCALE));
	}

	private void downloadStudies(HttpServletRequest request, HttpServletResponse response) throws IOException {
		formDownloadService.downloadStudies(response.getOutputStream(),request.getParameter(OpenXDataConstants.REQUEST_PARAM_STUDY_SERIALIZER),request.getParameter(OpenXDataConstants.REQUEST_PARAM_LOCALE));
	}

	private void downloadUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		formDownloadService.downloadUsers(response.getOutputStream(),request.getParameter(OpenXDataConstants.REQUEST_PARAM_USER_SERIALIZER));
	}

	/**
	 * Processes and saves form submitted data, which is the xforms xml model.
	 * 
	 * @param xml the xforms model xml.
	 */
	private void processForm(String xml){
		try{
			formDownloadService.saveFormData(xml, userService.getLoggedInUser(), new Date());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * Gets a map of xforms keyed by the formid
	 * 
	 * @return - the xforms map.
	 */
	private Map<Integer, String> getXforms() {
		return formDownloadService.getFormsVersionXmlMap();
	}
}
