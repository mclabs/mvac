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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.openxdata.server.admin.model.MobileMenuText;
import org.openxdata.server.service.UserService;
import org.openxdata.server.service.UtilityService;
import org.openxdata.test.BaseContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Tests methods in the UtilityService which deal with MobileMenuText.
 * 
 * @author daniel
 *
 */
public class MobileMenuTextServiceTest extends BaseContextSensitiveTest {

	@Autowired
	protected UtilityService utilityService;
	
	@Autowired
	protected UserService userService;
	
	@Test
	public void getMobileMenuText_shouldReturnAllMobileMenuText() throws Exception {
		
		List<MobileMenuText> textList = utilityService.getMobileMenuText("en");
		
		Assert.assertNotNull(textList);
		Assert.assertEquals(1, textList.size());
		Assert.assertEquals("Login", textList.get(0).getMenuText());
	}
	
	@Test
	public void saveMobileMenuText_shouldSaveMobileMenuTextList() throws Exception {
		final String textName = "Exit";
		
		List<MobileMenuText> textList = utilityService.getMobileMenuText("en");
		Assert.assertEquals(1,textList.size());
		Assert.assertNull(getMobileMenuText(textName,textList));
		
		MobileMenuText mobileMenuText = new MobileMenuText();
		mobileMenuText.setMenuText(textName);
		mobileMenuText.setLocaleKey("en");
		mobileMenuText.setMenuId((short)2);
		mobileMenuText.setCreator(userService.getUsers().get(0));
		mobileMenuText.setDateCreated(new Date());
		
		textList = new ArrayList<MobileMenuText>();
		textList.add(mobileMenuText);
		
		utilityService.saveMobileMenuText(textList);
		
		textList = utilityService.getMobileMenuText("en");
		Assert.assertEquals(2,textList.size());
		Assert.assertNotNull(getMobileMenuText(textName,textList));
	}
	
	/**
	 * Gets a MobileMenuText object for a given name from a list of MobileMenuText objects.
	 * 
	 * @param name the name of the MobileMenuText to look for.
	 * @param textList the list of MobileMenuText objects.
	 * @return the MobileMenuText object that matches the given name.
	 */
	private MobileMenuText getMobileMenuText(String name, List<MobileMenuText> textList){
		for(MobileMenuText text : textList){
			if(text.getMenuText().equals(name))
				return text;
		}
		
		return null;
	}
}
