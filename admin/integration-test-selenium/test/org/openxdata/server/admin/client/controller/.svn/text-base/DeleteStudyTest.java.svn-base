package org.openxdata.server.admin.client.controller;

import junit.framework.Assert;

import org.junit.Test;
import org.openxdata.server.admin.client.SeleniumTestCase;
import org.openxdata.server.admin.client.view.StudyContentTest;
import org.openxdata.server.admin.client.view.ToolbarContentTest;


/**
 * Tests deleting of studies.
 * 
 * @author daniel
 *
 */
public class DeleteStudyTest extends SeleniumTestCase {
	
	@Test
	public void shouldConfirmBeforeStudyDelete() throws Exception {
		
		login();
	
		waitForElement(StudyContentTest.LOCATOR_FIRST_STUDY, "Could not load study in time.");
		selenium.click(StudyContentTest.LOCATOR_FIRST_STUDY);
		clickItem(ToolbarContentTest.LOCATOR_DELETE_BUTTON);
		waitForConfirmation();
		Assert.assertEquals("Do you really want to delete the study {Sample Study} and all its forms  ?", selenium.getConfirmation());
	}
	
	
	@Test
	public void shouldConfirmBeforeFormDelete(){
		
		login();
		
		waitForElement(StudyContentTest.LOCATOR_FIRST_FORM, "Could not load form in time.");
		clickItem(StudyContentTest.LOCATOR_FIRST_FORM);
		clickItem(ToolbarContentTest.LOCATOR_DELETE_BUTTON);
		waitForConfirmation();
		
		System.out.println(selenium.getConfirmation());
	}
	
	
	@Test
	public void shouldConfirmBeforeFormVersionDelete(){
		
		login();
		
		waitForElement(StudyContentTest.LOCATOR_FIRST_FORM_VERSION, "Could not load form version in time.");
		clickItem(StudyContentTest.LOCATOR_FIRST_FORM_VERSION);
		clickItem(ToolbarContentTest.LOCATOR_DELETE_BUTTON);
		waitForConfirmation();
		
		System.out.println(selenium.getConfirmation());
	}
}
