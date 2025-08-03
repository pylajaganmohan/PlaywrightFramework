package com.qa.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.factory.PlaywrightFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class BaseTest {
	PlaywrightFactory factory;
	Page page;
	
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		PlaywrightFactory factory = new PlaywrightFactory();
		prop = factory.init_prop();
		page = factory.initBrowser(prop);
		homePage = new HomePage(page);

	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
