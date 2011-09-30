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
package org.openxdata.server.admin.client.view.widget;

import org.openxdata.server.admin.client.gwt.test.OpenXDataGwtTestBase;

/**
 * Tests the {@link OpenXDataFlexTable} class.
 * <p>
 * This <tt>Test Class</tt> is NO substitute for <tt>Selenium tests.</tt> It should be adequately beefed with UI tests using selenium.
 * </p>
 * 
 * @author Angel
 *
 */
public class OpenXDataFlexTableGwtTest extends OpenXDataGwtTestBase {

	public void testTableNotNull(){
		assertNotNull(new OpenXDataFlexTable());
	}
	
	public void testHasStyleName(){
		assertEquals("FlexTable2", new OpenXDataFlexTable().getStylePrimaryName());
	}
	
	public void testHasRowStyleName(){
		assertEquals("FlexTable-Header",new OpenXDataFlexTable().getRowFormatter().getStyleName(0));
	}
	
	public void testHasNoStyleName(){
		assertNotSame("Angel", new OpenXDataFlexTable().getStylePrimaryName());
	}
	
	public void testHasNoRowStyleName(){
		assertNotSame("Angel", new OpenXDataFlexTable().getRowFormatter().getStyleName(0));
	}
}
