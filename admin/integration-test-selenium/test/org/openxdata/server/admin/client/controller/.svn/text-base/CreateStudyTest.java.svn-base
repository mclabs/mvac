package org.openxdata.server.admin.client.controller;

import org.junit.Test;
import org.openxdata.server.admin.client.SeleniumTestCase;
import org.openxdata.server.admin.client.view.ToolbarContentTest;


/**
 * Tests study creation process.
 * 
 * @author daniel
 *
 */
public class CreateStudyTest extends SeleniumTestCase {

	
	@Test
	public void newStudyCmdShouldCreateStudyFormVersion(){
		
		login();
		
		clickItem(ToolbarContentTest.LOCATOR_ADD_NEW_BUTTON);

		selenium.type("//input[@type='text']", "Sample Study");
		
		clickItem(ToolbarContentTest.LOCATOR_SAVE_BUTTON);
			
		//Assert.assertTrue(selenium.isAlertPresent());
		//Studies Saved Successfully
		//selenium.click(ToolbarContentTest.LOCATOR_ADD_NEW_BUTTON);
		//Assert.assertTrue(selenium.isElementPresent("gwt-uid-7"));
	}
}
