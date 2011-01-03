package org.openxdata.server.admin.client.controller;

import junit.framework.Assert;

import org.junit.Test;
import org.openxdata.server.admin.client.SeleniumTestCase;


/**
 * Tests editing of studies.
 * 
 * @author daniel
 *
 */
public class StudyEditTest extends SeleniumTestCase {

	public static final String LOCATOR_NAME_TEXTBOX = "//input[@type='text']";
	public static final String LOCATOR_DESCRIPTION_TEXTBOX = "//tr[2]/td[2]/input";
	public static final String LOCATOR_ISDEFAULT_CHECKBOX = "gwt-uid-49";
	
	
	@Test
	public void shouldEditStudyNameAndSave(){
		
		login();
		
		selenium.click("//span[@id='gwt-uid-188']/table/tbody/tr/td[2]/div");
		Assert.assertTrue(selenium.isElementPresent("gwt-uid-7"));
	}
}
