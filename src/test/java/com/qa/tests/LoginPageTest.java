package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageNavigationTest() {
		loginPage = homePage.navigateToLoginPage();
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLogin());
	}

	@Test(priority = 3)
	public void invalidUserNameTest() {
		loginPage.doLogin(prop.getProperty("invalidUser"), prop.getProperty("password"));
		Assert.assertTrue(loginPage.isWaringDisplayed());
		
		String actualWarning = loginPage.getWarningMessage();
		Assert.assertTrue(actualWarning.equalsIgnoreCase(AppConstants.INVALID_LOGIN_WARNING) || actualWarning.equalsIgnoreCase(AppConstants.EXCEEDED_ATTEMPTS_WARNING));
	}

	@Test(priority = 4)
	public void invalidPasswordTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("invalidPwd"));
		Assert.assertTrue(loginPage.isWaringDisplayed());
		
		String actualWarning = loginPage.getWarningMessage();
		Assert.assertTrue(actualWarning.equalsIgnoreCase(AppConstants.INVALID_LOGIN_WARNING) || actualWarning.equalsIgnoreCase(AppConstants.EXCEEDED_ATTEMPTS_WARNING));
	}

	@Test(priority = 5)
	public void invalidUserAndPwdTest() {
		loginPage.doLogin(prop.getProperty("invalidUser"), prop.getProperty("invalidPwd"));
		Assert.assertTrue(loginPage.isWaringDisplayed());

		String actualWarning = loginPage.getWarningMessage();
		Assert.assertTrue(actualWarning.equalsIgnoreCase(AppConstants.INVALID_LOGIN_WARNING) || actualWarning.equalsIgnoreCase(AppConstants.EXCEEDED_ATTEMPTS_WARNING));
	}

	@Test(priority = 6)
	public void appLoginTest() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accountPage.getTitle(), AppConstants.MYACCOUNT_PAGE_TITLE);
	}

}
