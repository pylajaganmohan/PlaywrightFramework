package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.constants.AppConstants;

public class HomePageTest extends BaseTest {

	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}

	@Test
	public void homePageURLTest() {
		String actualURL = homePage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url").trim());
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "Macbook" }, { "iMac" }, { "samsung" } };
	}

	@Test(dataProvider = "getProductData")
	public void searchTest(String product) {
		String actualheader = homePage.doSearch(product);
		Assert.assertEquals(actualheader, "Search - " + product);
	}

}
