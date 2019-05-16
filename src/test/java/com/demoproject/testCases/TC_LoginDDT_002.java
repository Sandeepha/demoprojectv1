package com.demoproject.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoproject.pageObjects.LoginPage;
import com.demoproject.utilities.ExcelUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "loginData")
	public void loginDDT(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickSubmit();
		logger.info("submit button clicked");
		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			//driver.getPageSource().contains("");
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}

		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			LoginPage.lnkLogout.click();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			

		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "src/test/java/com/demoproject/testData/LoginData.xlsx";
		int rownum = ExcelUtils.getRowCount(path, "Sheet1");
		int colcount = ExcelUtils.getCellCount(path, "Sheet1", 1);

		String loginData[][] = new String[rownum][colcount];
		for (int i = 0; i < rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;

	}
}
