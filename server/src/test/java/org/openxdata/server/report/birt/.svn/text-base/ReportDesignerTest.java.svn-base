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

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import org.junit.Ignore;

/**
 * 
 * @author daniel
 *
 */
@Ignore("BIRT and MySQL need to be configured")
public class ReportDesignerTest extends TestCase {

    public void testGetLineChartReportDesign() {

        ReportDesigner reportDesigner = new ReportDesigner("jdbc:mysql://localhost:3306/openxdata?autoReconnect=true", "");

        List<ReportColumn> cols = new ArrayList<ReportColumn>();
        cols.add(new ReportColumn("name", "name", "string"));
        cols.add(new ReportColumn("description", "description", "string"));
        cols.add(new ReportColumn("value", "value", "string"));

        String xml = reportDesigner.createReportDesign("2", null, "", "", cols, "select * from setting", "", "");
        assert (xml != null);

        System.out.println(xml);
    }
}
