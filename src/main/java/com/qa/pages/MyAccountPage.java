package com.qa.pages;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MyAccountPage {

	private Page page;

	private String logoutLink = "//div[@class='list-group']/a[text()='Logout']";
	private String sideBarLinks = "div.list-group a";

	public MyAccountPage(Page page) {
		this.page = page;
	}

	public boolean isLoginBtnVisible() {
		return page.isVisible(logoutLink);
	}

	public String getTitle() {
		return page.title();
	}

	public boolean isOptionAvailabe(String option) {
		Locator options = page.locator(sideBarLinks);
		List<String> optionTexts = options.allInnerTexts();
		return optionTexts.stream().anyMatch(e -> e.toLowerCase().equalsIgnoreCase(option));

	}
}
