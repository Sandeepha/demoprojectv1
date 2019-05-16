package com.demoproject.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoproject.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("User name entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickSubmit();
		logger.info("Submit button is clicked");
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test is passed");
		} else {
			
			
			logger.info("Login test is failed");
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
		}

	}
}
