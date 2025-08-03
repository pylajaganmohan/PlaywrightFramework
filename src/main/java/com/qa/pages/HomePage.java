package com.qa.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	// 1.String Locators
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String header = "div#content h1";
	private String myAccount = "//a[@title='My Account']";
	private String loginLink = "a:text('Login')";

	// 2. Constructor
	public HomePage(Page page) {
		this.page = page;
	}

	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("Page title is: " + title);
		return title;
	}

	public String getHomePageURL() {
		String url = page.url();
		System.out.println("Page title is: " + url);
		return url;
	}

	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		String hdr = page.textContent(header);
		System.out.println(hdr);
		return hdr;
	}

	public LoginPage navigateToLoginPage() {
		page.click(myAccount);
		page.click(loginLink);
		return new LoginPage(page);
	}
}
