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
package org.openxdata.server.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openxdata.test.TestUtil;

/**
 * Test the {@linkplain HTMLUtil} <tt>class.</tt>
 * 
 * @author Angel
 *
 */
public class Log4jHtmlParserTest {
	
	
	@Test
	public void testGetNodeList(){
		
		String LogOutPut = Log4jHtmlParser.processtLatestError(TestUtil.getTestHTMLLogFilePath());
		
		assertNotNull(LogOutPut);
	}
}
