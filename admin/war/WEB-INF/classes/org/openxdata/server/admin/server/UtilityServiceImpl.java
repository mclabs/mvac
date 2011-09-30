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

import org.openxdata.server.admin.client.service.UtilityService;
import org.openxdata.server.admin.model.Locale;
import org.openxdata.server.admin.model.MobileMenuText;
import org.openxdata.server.admin.model.exception.OpenXDataException;
import org.openxdata.server.admin.model.util.Diagnosis;
import org.openxdata.server.admin.model.util.OpenXDataEmail;
import org.openxdata.server.rpc.OxdPersistentRemoteService;
import org.openxdata.server.service.LocaleService;
import org.springframework.web.context.WebApplicationContext;

/**
 * Default Implementation for the <code>UtilityService Interface.</code>
 * 
 * @author Angel
 * 
 */
public class UtilityServiceImpl extends OxdPersistentRemoteService implements UtilityService {

	private static final long serialVersionUID = 865681095382002202L;

	private org.openxdata.server.service.UtilityService utilityService;

	private org.openxdata.server.service.AuthenticationService authenticationService;
    private LocaleService localeService;
	
	public UtilityServiceImpl() {
	}

	@Override
	public void init() throws ServletException {
		super.init();
		WebApplicationContext ctx = getApplicationContext();

		utilityService = (org.openxdata.server.service.UtilityService) ctx.getBean("utilityService");
		
		authenticationService = (org.openxdata.server.service.AuthenticationService) ctx.getBean("authenticationService");

		localeService = (org.openxdata.server.service.LocaleService) ctx.getBean("localeService");
    }

	@Override
	public void deleteLocale(Locale locale) throws OpenXDataException {
		localeService.deleteLocale(locale);
	}

	@Override
	public List<Locale> getLocales() throws OpenXDataException {
		return localeService.getLocales();
	}

	@Override
	public List<MobileMenuText> getMobileMenuText(String locale) throws OpenXDataException {
		return utilityService.getMobileMenuText(locale);
	}

	@Override
	public Boolean installMobileApp(List<String> phonenos, String url, String modemComPort,
			int modemBaudRate, String promptText) throws OpenXDataException {
		return utilityService.installMobileApp(phonenos, url, modemComPort, modemBaudRate,
				promptText);
	}

	@Override
	public void saveLocale(List<Locale> locales) throws OpenXDataException {
		localeService.saveLocale(locales);
	}

	@Override
	public void saveMobileMenuText(List<MobileMenuText> mobileMenuText) throws OpenXDataException {
		utilityService.saveMobileMenuText(mobileMenuText);
	}

	@Override
	public Boolean checkIfPasswordsMatchOnAdministrator(String username, String password) throws OpenXDataException {
		return authenticationService.isValidUserPassword(username, password);
	}

	@Override
	public Diagnosis getLogFileProcessedOutput(String logFilePath) throws OpenXDataException {
		return utilityService.getLogFileProcessedOutput(logFilePath);
	}

	@Override
	public boolean sendEmail(OpenXDataEmail email) {
		return utilityService.sendEmail(email);
	}

	@Override
	public void clearLogFiles() {
		utilityService.clearLogFiles();
	}
}
