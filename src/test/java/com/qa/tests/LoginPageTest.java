package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	public void loginPageNavigationTest() {
		loginPage = homePage.navigateToLoginPage();
		String actualTitle = loginPage.getLooginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLogin());
	}
	
	@Test(priority=3)
	public void appLoginTest() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}
	
}
