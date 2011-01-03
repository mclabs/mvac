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
package org.openxdata.server.export.rdbms.engine;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.openxdata.test.XFormsFixture;

public class StructureBuilderTest {

    @Test
    public void testSampleFormStructure() throws Exception {
        testSampleFormStructure(Constants.DB_MYSQL);
        testSampleFormStructure(Constants.DB_MSACCESS);
        testSampleFormStructure(Constants.DB_ORACLE);
        testSampleFormStructure(Constants.DB_POSTGRESQL);
        testSampleFormStructure(Constants.DB_SQLSERVER);
    }
    
    private void testSampleFormStructure(int dbms) throws Exception {
        List<TableQuery> structure = RdmsEngine.getStructureSql(XFormsFixture.getSampleForm(), dbms);
        /*for (String key : structure.keySet()) {
            System.out.println("table="+key);
            System.out.println("sql="+structure.get(key));
            System.out.println("----------------------------------------");
        }*/
        Assert.assertEquals(dbms+">Two tables created - patientreq + kid", 2, 
                structure.size());
        
        TableQuery firstTable = structure.get(0); 
        Assert.assertEquals("First table is patientreg", "patientreg", firstTable.getTableName());
        String firstSql = firstTable.getSql();
        Assert.assertTrue(dbms+">firstSql contains SQL to create patientreq table", 
                firstSql.startsWith("CREATE TABLE patientreg"));
        Assert.assertTrue(dbms+">firstSql contains SQL to create patientreq table", 
                firstSql.contains("openxdata_form_data_id VARCHAR(50)"));
        Assert.assertTrue(dbms+">firstSql contains SQL to create patientreq table", 
                firstSql.contains("openxdata_user_id VARCHAR(50)"));
        Assert.assertTrue(dbms+">firstSql contains SQL to create patientreq table", 
                firstSql.contains("openxdata_user_name VARCHAR(50)"));
        Assert.assertTrue(dbms+">firstSql contains SQL to create patientreq table", 
                firstSql.contains("patientid VARCHAR(255)"));
        Assert.assertTrue(dbms+">firstSql contains SQL to create patientreq table", 
                firstSql.contains("title VARCHAR(255)"));
        Assert.assertTrue(dbms+">firstSql contains SQL to create patientreq table", 
                firstSql.contains("endtime TIME"));
        
        TableQuery secondTable = structure.get(1); 
        Assert.assertEquals("Second table is kid", "kid", secondTable.getTableName());
        String secondSql = secondTable.getSql();
        Assert.assertTrue(dbms+">secondSql contains SQL to create kid table", 
                secondSql.startsWith("CREATE TABLE kid"));
        Assert.assertTrue(dbms+">secondSql contains SQL to create kid table", 
                secondSql.contains("Id VARCHAR(200) PRIMARY KEY"));
        Assert.assertTrue(dbms+">secondSql contains SQL to create kid table", 
                secondSql.contains("Id VARCHAR(200) PRIMARY KEY"));
        Assert.assertTrue(dbms+">secondSql contains SQL to create kid table", 
                secondSql.contains("openxdata_form_data_id VARCHAR(50)"));
        Assert.assertTrue(dbms+">secondSql contains SQL to create kid table", 
                secondSql.contains("openxdata_user_id VARCHAR(50)"));
        Assert.assertTrue(dbms+">secondSql contains SQL to create kid table", 
                secondSql.contains("openxdata_user_name VARCHAR(50)"));
        Assert.assertTrue(dbms+">secondSql contains SQL to create kid table", 
                secondSql.contains("kidname VARCHAR(255)"));
        Assert.assertTrue(dbms+">secondSql contains SQL to create kid table", 
                secondSql.contains("kidsex VARCHAR(255)"));
        
        if (dbms == Constants.DB_MYSQL) {
            Assert.assertTrue(dbms+">firstSql ends with INNODB table definition", 
                    firstSql.endsWith("TYPE = INNODB;"));
            Assert.assertTrue(dbms+">secondSql ends with INNODB table definition", 
                    secondSql.endsWith("TYPE = INNODB;"));
        } else {
            Assert.assertFalse(dbms+">firstSql does not end with INNODB table definition", 
                    firstSql.endsWith("TYPE = INNODB;"));
            Assert.assertFalse(dbms+">secondSql does not end with INNODB table definition", 
                    secondSql.endsWith("TYPE = INNODB;"));
        }
    }
}