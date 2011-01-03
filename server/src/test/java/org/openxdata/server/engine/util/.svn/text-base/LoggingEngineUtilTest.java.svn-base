/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

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
package org.openxdata.server.engine.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.Before;
import org.openxdata.test.TestUtil;
import org.openxdata.server.admin.model.util.DiagnosedStatus;
import org.openxdata.server.admin.model.util.ErrorRiskLevel;
import org.openxdata.server.engine.OpenXDataLoggingEngineImpl;

/**
 * Tests {@link LoggingEngineUtil}
 * 
 * @author Angel
 *
 */
public class LoggingEngineUtilTest {
	
	private String logFileContent = "";
	
	@Before
	public void setUp(){
		
		logFileContent = new OpenXDataLoggingEngineImpl().getLogFileContent(TestUtil.getTestHTMLLogFilePath());
	}	
	
	@Test
	public void testLogFileContent(){
		
		assertNotNull(logFileContent);
	}
	
	@Test
	public void testGetLatestError(){
		String latestError = LoggingEngineUtil.getLatestError(logFileContent);
		
		assertNotNull(latestError);
		assertEquals("com.mchange.v2.c3p0.management.ActiveManagementCoordinator", latestError);
	}
	
	@Test
	public void testDetermineDiagnosedStatus(){
		
		DiagnosedStatus status = LoggingEngineUtil.determineDiagnosedStatus(logFileContent);
		
		assertEquals(status, DiagnosedStatus.UNSTABLE);
	}
	
	@Test
	public void testDetermineErrorRiskLevel(){
		
		ErrorRiskLevel riskLevel = LoggingEngineUtil.determineErrorRiskLevel(logFileContent);
		
		assertEquals(riskLevel, ErrorRiskLevel.MEDIUM);
	}
	
	@Test
	public void testAnalyzeLogOutput(){
		int analyzedOutput = LoggingEngineUtil.analyzeLogOutput(logFileContent);
		
		assertTrue(analyzedOutput != 0);
		assertEquals(1, analyzedOutput);
	}
}
