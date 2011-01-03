package org.openxdata.server.admin.client;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openxdata.server.admin.client.view.LoginViewContentTest;
import org.openxdata.server.admin.client.view.MainViewContentTest;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Wait;


/**
 * Base class for selenium test cases.
 * 
 * @author daniel
 *
 */
public abstract class SeleniumTestCase {

	protected static DefaultSelenium selenium;


	@BeforeClass
	public static void init() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, TestConstants.BROWSER,TestConstants.BASE_URL);
		selenium.start();
	}


	@AfterClass  
	public static void shutDown() {  
		selenium.stop();  
	}  
	
	
	protected void login(){
		selenium.open(TestConstants.URL_SUFFIX);
		
		selenium.type(LoginViewContentTest.LOCATOR_USER_NAME_TEXT, "guyzb");
		selenium.type(LoginViewContentTest.LOCATOR_PASSWORD_TEXT, "daniel123");
		selenium.click(LoginViewContentTest.LOCATOR_LOGIN_BUTTON);
		
		waitForElement(MainViewContentTest.LOCATOR_STUDIES_TAB, "timed out before loading the studies tab");
		
		selenium.windowMaximize();
		selenium.windowFocus();
		
		Assert.assertEquals("OpenXData Server Admin", selenium.getTitle());
	}
	
	
	protected void waitForElement(final String waitingElement, String timeoutMessage) {  
		new Wait() {  
			public boolean until() {  
				return selenium.isElementPresent(waitingElement);  
			}  
		}.wait(timeoutMessage);  
	}  
	
	
	protected void waitForConfirmation() {  
		new Wait() {  
			public boolean until() {  
				return selenium.isConfirmationPresent();  
			}  
		}.wait("Timed out waiting for confirmation");  
	} 
	
	
	protected void waitForAlert() {  
		new Wait() {  
			public boolean until() {  
				return selenium.isAlertPresent();  
			}  
		}.wait("Timed out waiting for alert");  
	}  
	
	
	protected void clickItem(String locator){
		selenium.mouseOver(locator);
		selenium.mouseDown(locator);
		selenium.mouseUp(locator);
	}
}
