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

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openxdata.server.admin.model.MobileMenuText;
import org.openxdata.server.admin.model.User;
import org.openxdata.server.admin.model.util.DiagnosedStatus;
import org.openxdata.server.admin.model.util.Diagnosis;
import org.openxdata.server.admin.model.util.ErrorRiskLevel;
import org.openxdata.server.dao.MobileMenuTextDAO;
import org.openxdata.server.dao.SettingDAO;
import org.openxdata.server.engine.OpenXDataLoggingEngine;
import org.openxdata.test.BaseContextSensitiveTest;

/**
 * @author Angel
 *
 */
public class UtilityServiceTest extends BaseContextSensitiveTest {
	
    private UtilityServiceImpl utilityService;
	private MobileMenuTextDAO mobileMenuTextDAOMock;
	
	private OpenXDataLoggingEngine loggingEngineMock;
	
	private Diagnosis dummyDiagnosis;
	private MobileMenuText dummyMobileMenuText;
	
	@Before
	public void createMocks() {
		
		mock(SettingDAO.class);
		mobileMenuTextDAOMock = mock(MobileMenuTextDAO.class);
		loggingEngineMock = mock(OpenXDataLoggingEngine.class);
		utilityService = new UtilityServiceImpl(mobileMenuTextDAOMock, loggingEngineMock);
	}
	
	@Before
	public void createMobileMenuText() {

		final short menuId = 0;
		final String menuText = "dummyMenuText";
		final String localeKey = "dummyLocaleKey";
		
		dummyMobileMenuText = new MobileMenuText();
		
		dummyMobileMenuText.setMenuId(menuId);
		dummyMobileMenuText.setMenuText(menuText);
		dummyMobileMenuText.setLocaleKey(localeKey);
		dummyMobileMenuText.setCreator(new User("dummyUser"));
		dummyMobileMenuText.setDateCreated(new GregorianCalendar(2010, 7, 7).getTime());
	}
	
	@Before
	public void createDiagnosis() {
		final ErrorRiskLevel riskLevel = ErrorRiskLevel.UNDEFINED;
		final DiagnosedStatus diagnosedStatus = DiagnosedStatus.UNDEFINED;
		final String logFileStream = "Some Error occurred";
		final String latestError = "Dummy Latest Error";
		final int errorCount = 1;
		
		dummyDiagnosis = new Diagnosis();
		dummyDiagnosis.setRiskLevel(riskLevel);
		dummyDiagnosis.setDiagnosedStatus(diagnosedStatus);
		dummyDiagnosis.setLatestError(latestError);
		dummyDiagnosis.setLogFileStream(logFileStream);
		dummyDiagnosis.setErrorCount(errorCount);
		
	}
	
	@Test
	public void testGeMobileMenuText() {
		List<MobileMenuText> expected = new ArrayList<MobileMenuText>();
		expected.add(dummyMobileMenuText);
		
		when(mobileMenuTextDAOMock.getMobileMenuText("en")).thenReturn(expected);
		List<MobileMenuText> actual = utilityService.getMobileMenuText("en");
		
		assertSame(expected, actual);
		
		verify(mobileMenuTextDAOMock).getMobileMenuText("en");
		
	}
	
	@Test
	public void testSaveMobileMenuText() {
		List<MobileMenuText> text = new ArrayList<MobileMenuText>();
		text.add(dummyMobileMenuText);
		
		utilityService.saveMobileMenuText(text);
		verify(mobileMenuTextDAOMock).saveMobileMenuText(text);	
		
	}
	
	@Test
	public void testGetLogFileProcessedOutput() {
		when(loggingEngineMock.processLogFile("dummyFilePath")).thenReturn(dummyDiagnosis);
		Diagnosis actual = utilityService.getLogFileProcessedOutput("dummyFilePath");
		
		assertSame(dummyDiagnosis, actual);
		
		verify(loggingEngineMock).processLogFile("dummyFilePath");
	}
	
}
