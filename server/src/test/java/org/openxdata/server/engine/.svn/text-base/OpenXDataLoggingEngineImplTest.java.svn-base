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
package org.openxdata.server.engine;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openxdata.server.admin.model.util.DiagnosedStatus;
import org.openxdata.server.admin.model.util.Diagnosis;
import org.openxdata.server.admin.model.util.ErrorRiskLevel;
import org.openxdata.server.engine.util.LoggingEngineUtil;
import org.openxdata.test.TestUtil;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Tests the {@link OpenXDataLoggingEngineImpl}
 * 
 * @author Angel
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({OpenXDataLoggingEngineImpl.class, LoggingEngineUtil.class})
public class OpenXDataLoggingEngineImplTest {
	
	private Diagnosis diagnosis;
	private Diagnosis mockDiagnosis;
    private OpenXDataLoggingEngine mockEngine;
    private OpenXDataLoggingEngine loggingEngine;
    
    private String mockLogFileStream = "ERROR, WARN, ERROR, DEBUG";
    
    @Before
    public void setUp(){
    	
    	mockDiagnosis = PowerMock.createMock(Diagnosis.class);
    	loggingEngine = new OpenXDataLoggingEngineImpl();
    	mockEngine = PowerMock.createMock(OpenXDataLoggingEngineImpl.class);
    }

    @Before
    public void createDiagnostics() {
        diagnosis = new Diagnosis();
        diagnosis.setErrorCount(1);
    }

    @Test
    public void testMockDiagnosis() throws Exception{
    	
    	expect(mockEngine.processLogFile(TestUtil.getTestHTMLLogFilePath())).andReturn(mockDiagnosis);
    	
    	// Prepare the Error Count Stub for default value
    	expect(mockDiagnosis.getErrorCount()).andStubReturn(0);

    	// Prepare the Risk Level Stub for default value
    	expect(mockDiagnosis.getRiskLevel()).andStubReturn(null);
    	
    	// Prepare the Latest Error Stub for default value
    	expect(mockDiagnosis.getLatestError()).andStubReturn(null);

    	// Prepare the Log File Stream Stub for default value
    	expect(mockDiagnosis.getLogFileStream()).andStubReturn(null);

    	// Prepare the Diagnosed Status Stub for default value
    	expect(mockDiagnosis.getDiagnosedStatus()).andStubReturn(null);

    	PowerMock.replayAll();
    	
    	Diagnosis actualDiagnosis = loggingEngine.processLogFile(TestUtil.getTestHTMLLogFilePath());
    	    	    	
    	assertNotNull(mockDiagnosis);
    	assertNotNull(actualDiagnosis);
    	assertTrue(actualDiagnosis != mockDiagnosis);
    	
    	// Check Default Properties
    	assertNull(mockDiagnosis.getRiskLevel());
    	
    	assertNull(mockDiagnosis.getLatestError());
    	
    	assertNull(mockDiagnosis.getLogFileStream());
    	
    	assertNull(mockDiagnosis.getDiagnosedStatus());

    	assertEquals(0, mockDiagnosis.getErrorCount());
    	
    	PowerMock.verify(OpenXDataLoggingEngineImpl.class);
    }
    
    @Test
    public void testActualDiagnosis() throws Exception{
    	
    	expect(mockEngine.processLogFile(TestUtil.getTestHTMLLogFilePath())).andReturn(mockDiagnosis);

    	PowerMock.replayAll();
    	
    	Diagnosis actualDiagnosis = loggingEngine.processLogFile(TestUtil.getTestHTMLLogFilePath());
    	    	    	
    	assertNotNull(mockDiagnosis);
    	assertNotNull(actualDiagnosis);
    	assertTrue(actualDiagnosis != mockDiagnosis);
    	
    	// Check Default Properties
    	assertNotNull(actualDiagnosis.getRiskLevel());
    	
    	assertNotNull(actualDiagnosis.getLatestError());
    	
    	assertNotNull(actualDiagnosis.getLogFileStream());
    	
    	assertNotNull(actualDiagnosis.getDiagnosedStatus());

    	assertEquals(2, actualDiagnosis.getErrorCount());
    	
    	PowerMock.verify(OpenXDataLoggingEngineImpl.class);
    }

    @Test
    public void testDiagnosticsLog() throws Exception {
        String filepath = "/home/test/testfile.log";
        OpenXDataLoggingEngineImpl engine = PowerMock.createPartialMockForAllMethodsExcept(OpenXDataLoggingEngineImpl.class, "processLogFile");

        PowerMock.expectPrivate(engine, "processPlainTextLogFile", filepath).andReturn(diagnosis);

        PowerMock.replayAll();
        Diagnosis actual = engine.processLogFile(filepath);
        assertEquals(diagnosis, actual);
        
        PowerMock.verifyAll();
    }

    @Test
    public void testDiagnosisErrorCountProperty(){    	
    	
    	Diagnosis actualDiagnosis = loggingEngine.processLogFile(TestUtil.getTestHTMLLogFilePath());
    	
    	// Prepare the Log File Stream Stub
    	EasyMock.expect(mockDiagnosis.getErrorCount()).andStubReturn(6);
    	
    	PowerMock.replayAll();    	    	
    	
    	assertNotNull(actualDiagnosis.getErrorCount());
    	assertEquals(2, actualDiagnosis.getErrorCount());
    	
    	PowerMock.verify();
    }
    
    @Test
    public void testDiagnosisErrorRiskLevelProperty(){
    	
    	Diagnosis actualDiagnosis = loggingEngine.processLogFile(TestUtil.getTestHTMLLogFilePath());
    	
    	// Prepare the Risk Level Stub
    	EasyMock.expect(mockDiagnosis.getRiskLevel()).andStubReturn(ErrorRiskLevel.UNDEFINED);
    	
    	PowerMock.replayAll();
    	
    	assertNotNull(actualDiagnosis.getRiskLevel());
    	assertEquals(ErrorRiskLevel.MEDIUM, actualDiagnosis.getRiskLevel());
    	
    	PowerMock.verify();
    }
    
    @Test
    public void testDiagnosisLatestErrorProperty(){
    	
    	String mockLatestError = "org.oxd.test.TestError";
    	Diagnosis actualDiagnosis = loggingEngine.processLogFile(TestUtil.getTestHTMLLogFilePath());
    	
    	// Prepare the Risk Level Stub
    	EasyMock.expect(mockDiagnosis.getLatestError()).andStubReturn(mockLatestError);
    	
    	PowerMock.replayAll();
    	
    	assertNotNull(mockDiagnosis.getLatestError());
    	assertEquals("org.oxd.test.TestError", mockDiagnosis.getLatestError());
    	
    	assertNotNull(actualDiagnosis.getLatestError());
    	assertEquals("com.mchange.v2.c3p0.management.ActiveManagementCoordinator", actualDiagnosis.getLatestError());
    	
    	assertTrue(mockDiagnosis.getLatestError() != actualDiagnosis.getLatestError());
    	
    	PowerMock.verify();
    }
    
    @Test
    public void testDiagnosisLogFileStreamProperty(){
    	
    	String dummyLogFileOutput = "ERROR, WARN, ERROR, DEBUG";
    	Diagnosis actualDiagnosis = loggingEngine.processLogFile(TestUtil.getTestHTMLLogFilePath());
    	
    	// Prepare the Log File Stream Stub
    	EasyMock.expect(mockDiagnosis.getLogFileStream()).andStubReturn(mockLogFileStream);
    	
    	PowerMock.replayAll(); 
    	
    	assertNotNull(mockDiagnosis.getLogFileStream());
    	assertEquals(dummyLogFileOutput, mockDiagnosis.getLogFileStream());
    	
    	assertNotNull(actualDiagnosis.getLogFileStream());
    	//assertEquals(actualDiagnosis.getLogFileStream(), TestUtil.getDummyLogFileStream());
    	
    	PowerMock.verify();
    }
    
    @Test
    public void testDiagnosisDiagnosedStatusProperty(){
    	
    	Diagnosis actualDiagnosis = loggingEngine.processLogFile(TestUtil.getTestHTMLLogFilePath());
    	
    	// Prepare the Diagnosed Status Stub
    	EasyMock.expect(mockDiagnosis.getDiagnosedStatus()).andStubReturn(DiagnosedStatus.UNDEFINED);
    	
    	PowerMock.replayAll(); 
    	
    	assertNotNull(mockDiagnosis.getDiagnosedStatus());
    	assertEquals(DiagnosedStatus.UNDEFINED, mockDiagnosis.getDiagnosedStatus());
    	
    	assertNotNull(actualDiagnosis.getDiagnosedStatus());
    	assertEquals(DiagnosedStatus.UNSTABLE, actualDiagnosis.getDiagnosedStatus());
    	
    	PowerMock.verify();
    }
}
