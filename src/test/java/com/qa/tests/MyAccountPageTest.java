package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.constants.AppConstants;

public class MyAccountPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginTest() {
		loginPage = homePage.navigateToLoginPage();
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountPage.getTitle(), AppConstants.MYACCOUNT_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void isMyAccountOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("My Account"));
	}

	@Test(priority = 3)
	public void isEditAccountOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Edit Account"));
	}

	@Test(priority = 4)
	public void isPasswordOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Password"));
	}

	@Test(priority = 5)
	public void isAddressBookOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Address Book"));
	}

	@Test(priority = 6)
	public void isWishListOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Wish List"));
	}

	@Test(priority = 7)
	public void isOrderHistoryOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Order History"));
	}

	@Test(priority = 8)
	public void isDownloadsOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Downloads"));
	}

	@Test(priority = 9)
	public void isRecurringPaymentsOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Recurring payments"));
	}

	@Test(priority = 10)
	public void isRewardPointsOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Reward Points"));
	}

	@Test(priority = 11)
	public void isReturnsOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Returns"));
	}

	@Test(priority = 12)
	public void isTransactionsOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Transactions"));
	}

	@Test(priority = 13)
	public void isNewsletterAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Newsletter"));
	}

	@Test(priority = 14)
	public void isLogoutOptionAvailable() {
		Assert.assertTrue(accountPage.isOptionAvailabe("Logout"));
	}

}
