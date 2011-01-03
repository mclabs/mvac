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
package org.openxdata.server.admin.client.util;


import java.util.Arrays;

import org.openxdata.server.admin.client.gwt.test.OpenXDataGwtTestBase;

/**
 *
 * @author Ronald.K
 */
public class CronEntityGwtTest extends OpenXDataGwtTestBase
{

    /**
     * Test of getRepeat method, of class CronEntity.
     */
    public void testGetRepeat()
    {
        System.out.println("getRepeat");
        CronEntity instance = new CronEntity("5/10", 0, 31, CronEntity.DAY_OF_MONTH);
        int expResult = 10;
        int result = instance.getRepeat();
        assertEquals(expResult, result);

        instance = new CronEntity("0", 0, 31, CronEntity.DAY_OF_MONTH);
        expResult = -1;
        result = instance.getRepeat();
        assertEquals(expResult, result);

    }

    /**
     * Test of getValues method, of class CronEntity.
     */
    public void testGetValues()
    {
        System.out.println("getValues");
        CronEntity instance = new CronEntity("*", 0, 31, CronEntity.DAY_OF_MONTH);
        int[] expResult = null;
        int[] result = instance.getValues();
        assertEquals(expResult, result);

        instance = new CronEntity("?", 0, 31, CronEntity.DAY_OF_MONTH);
        expResult = null;
        result = instance.getValues();
        assertEquals(expResult, result);

        instance = new CronEntity("10", 0, 31, CronEntity.DAY_OF_MONTH);
        expResult = new int[]{10};
        result = instance.getValues();
        assertTrue(Arrays.equals(expResult, result));

        instance = new CronEntity("2,3,4", 0, 31, CronEntity.DAY_OF_MONTH);
        expResult = new int[]{2, 3, 4};
        result = instance.getValues();
        assertTrue(Arrays.equals(expResult, result));

        instance = new CronEntity("5/10", 0, 31, CronEntity.DAY_OF_MONTH);
        expResult = new int[]{5, 15, 25};
        result = instance.getValues();
        assertTrue(Arrays.equals(expResult, result));


    }
}
