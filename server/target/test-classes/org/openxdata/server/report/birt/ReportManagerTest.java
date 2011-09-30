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
package org.openxdata.server.report.birt;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openxdata.test.BaseContextSensitiveTest;

/**
 * 
 * @author Daniel
 * @author Jonny
 *
 */
@Ignore("BIRT needs to be installed")
public class ReportManagerTest extends BaseContextSensitiveTest {

    private final static String DESIGN_FILENAME = "default.rptdesign";
    private ReportManager reportManager;

    @Before
    public void initReportManager() {
        reportManager = ReportManager.getInstance();
        assertNotNull(reportManager);
    }

    @After
    public void closeReportManager() {
        reportManager.shutdown();
    }

    @Test
    public void reportEngineInit() {
        InputStream designXml = ClassLoader.getSystemResourceAsStream(DESIGN_FILENAME);
        OutputStream report = reportManager.getReportStream("", designXml, "html");
        assertNotNull(report);
    }
}
