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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openxdata.server.service.SettingService;
import org.openxdata.server.util.OpenXDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet for serving BIRT reports images.
 * 
 * @author daniel
 *
 */
public class BirtImagesServlet  extends HttpServlet  {

    private SettingService settingService;
	
	private static final long serialVersionUID = 1239999102030344L;

    @Override
    public void init() throws ServletException {
		ServletContext sctx = this.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sctx);
        settingService = (SettingService) ctx.getBean("settingService");
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pathName = settingService.getSetting("birtImageDir", OpenXDataUtil.getApplicationDataDirectory() + 
				"BIRT" + File.separator + "images" + File.separator);

		FileInputStream is = new FileInputStream(pathName + request.getParameter("imageName"));

		OutputStream out = response.getOutputStream();
		int ch;

		while( ( ch = is.read() ) != -1 )
			out.write( ch );

		out.close();
	}
}
