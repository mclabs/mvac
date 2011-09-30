package org.openxdata.server.admin.client.view;

import junit.framework.Assert;

import org.junit.Test;
import org.openxdata.server.admin.client.SeleniumTestCase;
import org.openxdata.server.admin.client.TestConstants;


/**
 * Tests the login view and ensures that it has the correct content.
 * 
 * @author daniel
 *
 */
public class LoginViewContentTest extends SeleniumTestCase {

	/** xpath locator for user name text input element. */
	public static final String LOCATOR_USER_NAME_TEXT = "//input[@type='text']";

	/** xpath locator for password text input element. */
	public static final String LOCATOR_PASSWORD_TEXT = "//input[@type='password']";

	/** xpath locator for login button element. */
	public static final String LOCATOR_LOGIN_BUTTON = "//button[@type='button']";


	@Test
	public void shouldHaveExpectedWidgets() throws Exception {	
		selenium.open(TestConstants.URL_SUFFIX);

		Assert.assertEquals("OpenXData Server Admin", selenium.getTitle());
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_USER_NAME_TEXT));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_PASSWORD_TEXT));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_LOGIN_BUTTON));
	}
}
