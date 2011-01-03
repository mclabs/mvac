package org.openxdata.server.admin.client.view;

import junit.framework.Assert;

import org.junit.Test;
import org.openxdata.server.admin.client.SeleniumTestCase;


/**
 * Tests the main view and ensures that it has the correct content.
 * 
 * @author daniel
 *
 */
public class MainViewContentTest  extends SeleniumTestCase {

	/** xpath locator for studes tab element. */
	public static final String LOCATOR_STUDIES_TAB = "//tr[2]/td[2]/div";
	
	/** xpath locator for users tab element. */
	public static final String LOCATOR_USERS_TAB = "//tr[3]/td/table/tbody/tr[2]/td[2]/div";
	
	/** xpath locator for roles tab element. */
	public static final String LOCATOR_ROLES_TAB = "//tr[5]/td/table/tbody/tr[2]/td[2]/div";
	
	/** xpath locator for tasks tab element. */
	public static final String LOCATOR_TASKS_TAB = "//tr[7]/td/table/tbody/tr[2]/td[2]/div";
	
	/** xpath locator for settings tab element. */
	public static final String LOCATOR_SETTINGS_TAB = "//tr[9]/td/table/tbody/tr[2]/td[2]/div";
	
	/** xpath locator for reports tab element. */
	public static final String LOCATOR_REPORTS_TAB = "//tr[11]/td/table/tbody/tr[2]/td[2]/div";
	
	/** xpath locator for studies design tab. */
	public static final String LOCATOR_STUDIES_DESIGN_TAB = "//td[3]/table/tbody/tr[2]/td[2]/div/div/div";
	
	/** xpath locator for studies properties tab. */
	public static final String LOCATOR_STUDIES_PROPERTIES_TAB = "//td[2]/div/div/div";
	
	/** xpath locator for studies properties tab. */
	public static final String LOCATOR_STUDIES_DATA_LIST_TAB = "//td[4]/table/tbody/tr[2]/td[2]/div/div/div";
	
	/** xpath locator for studies properties tab. */
	public static final String LOCATOR_STUDIES_DATA_TAB = "//td[5]/table/tbody/tr[2]/td[2]/div/div/div";
	
	/** xpath locator for users properties tab. */
	public static final String LOCATOR_USERS_PROPERTIES_TAB = "//td[2]/div/div/div";
	
	/** xpath locator for users user management tab. */
	public static final String LOCATOR_USERS_MANAGEMENT_TAB = "//td[3]/table/tbody/tr[2]/td[2]/div/div/div";
	
	/** xpath locator for roles properties tab. */
	public static final String LOCATOR_ROLES_PROPERTIES_TAB = "//td[2]/div/div/div";
	
	/** xpath locator for roles roles management tab. */
	public static final String LOCATOR_ROLES_ROLES_TAB = "//td[3]/table/tbody/tr[2]/td[2]/div/div/div";
	
	/** xpath locator for roles permissions management tab. */
	public static final String LOCATOR_ROLES_PERMISSION_TAB = "//td[4]/table/tbody/tr[2]/td[2]/div/div/div";
		
	/** xpath locator for tasks definition tab. */
	public static final String LOCATOR_TASKS_DEFINITION_TAB = "//td[2]/div/div/div";
	
	/** xpath locator for tasks schedule tab. */
	public static final String LOCATOR_TASKS_SCHEDULE_TAB = "//td[3]/table/tbody/tr[2]/td[2]/div/div/div";
	
	/** xpath locator for tasks parameters tab. */
	public static final String LOCATOR_TASKS_PARAMETERS_TAB = "//td[4]/table/tbody/tr[2]/td[2]/div/div/div";
	
	/** xpath locator for settings properties tab. */
	public static final String LOCATOR_SETTINGS_PROPERTIES_TAB = "//td[2]/div/div/div";
	
	public static final String LOCATOR_REPORTS_PROPERTIES_TAB = "//td[2]/div/div/div";
	public static final String LOCATOR_REPORTS_FIELDS_TAB = "//td[3]/table/tbody/tr[2]/td[2]/div/div/div";
	public static final String LOCATOR_REPORTS_OUTPUT_TAB = "//td[4]/table/tbody/tr[2]/td[2]/div/div/div";
	
	
	@Test
	public void shouldHaveExpectedWidgets() throws Exception {	
		
		login();
		
		//Main stack panel tabs.
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_STUDIES_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_USERS_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_ROLES_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_TASKS_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_SETTINGS_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_REPORTS_TAB));
		
		//study tabs
		selenium.click(LOCATOR_STUDIES_TAB);
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_STUDIES_PROPERTIES_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_STUDIES_DESIGN_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_STUDIES_DATA_LIST_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_STUDIES_DATA_TAB));
		
		//Roles tabs
		selenium.click(LOCATOR_ROLES_TAB);
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_ROLES_PROPERTIES_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_ROLES_ROLES_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_ROLES_PERMISSION_TAB));
		
		//User tabs
		selenium.click(LOCATOR_USERS_TAB);
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_USERS_PROPERTIES_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_USERS_MANAGEMENT_TAB));
		
		//Tasks tabs
		selenium.click(LOCATOR_TASKS_TAB);
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_TASKS_DEFINITION_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_TASKS_SCHEDULE_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_TASKS_PARAMETERS_TAB));
		
		//Settings tab
		selenium.click(LOCATOR_SETTINGS_TAB);
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_SETTINGS_PROPERTIES_TAB));
		
		//Reports tabs
		selenium.click(LOCATOR_REPORTS_TAB);
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_REPORTS_PROPERTIES_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_REPORTS_FIELDS_TAB));
		Assert.assertTrue(selenium.isElementPresent(LOCATOR_REPORTS_OUTPUT_TAB));
	}
}
