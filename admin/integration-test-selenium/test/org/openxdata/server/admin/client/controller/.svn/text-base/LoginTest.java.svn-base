package org.openxdata.server.admin.client.controller;

import junit.framework.Assert;

import org.junit.Test;
import org.openxdata.server.admin.client.SeleniumTestCase;
import org.openxdata.server.admin.client.TestConstants;
import org.openxdata.server.admin.client.view.LoginViewContentTest;


/**
 * Tests login view to ensure that only valid logins are allowed.
 * 
 * @author daniel
 *
 */
public class LoginTest extends SeleniumTestCase {

	
	@Test
	public void shouldFailForInvalidLogin() throws Exception {	
		selenium.open(TestConstants.URL_SUFFIX);
		
		selenium.type(LoginViewContentTest.LOCATOR_USER_NAME_TEXT, "guyzba");
		selenium.type(LoginViewContentTest.LOCATOR_PASSWORD_TEXT, "daniel123");
		selenium.click(LoginViewContentTest.LOCATOR_LOGIN_BUTTON);
		
		Assert.assertTrue(selenium.isTextPresent("Invalid UserName or Password"));
	}
	
	
	@Test
	public void shouldSucceedForValidLogin() throws Exception {	
		selenium.open(TestConstants.URL_SUFFIX);
		
		selenium.type(LoginViewContentTest.LOCATOR_USER_NAME_TEXT, "guyzb");
		selenium.type(LoginViewContentTest.LOCATOR_PASSWORD_TEXT, "daniel123");
		selenium.click(LoginViewContentTest.LOCATOR_LOGIN_BUTTON);
		
		Assert.assertFalse(selenium.isTextPresent("Invalid UserName or Password"));
	}
}
