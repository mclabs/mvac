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

import org.openxdata.server.admin.client.service.SmsService;
import org.openxdata.server.admin.model.FormSmsArchive;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.rpc.OxdPersistentRemoteService;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author Tumwebaze
 *
 */
public class SmsServiceImpl extends OxdPersistentRemoteService implements SmsService{

	private static final long serialVersionUID = 5348921955381512163L;
	private org.openxdata.server.service.SmsService smsService;
	
	public SmsServiceImpl(){
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext ctx = getApplicationContext();
		smsService = (org.openxdata.server.service.SmsService)ctx.getBean("smsService");
	}
	
	@Override
	public List<FormSmsArchive> getFormSmsArchives() throws OpenXDataException {
		return smsService.getFormSmsArchives();
	}
}