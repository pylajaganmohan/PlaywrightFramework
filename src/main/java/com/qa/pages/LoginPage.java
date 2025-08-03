package com.qa.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;

	private String email = "input#input-email";
	private String password = "input#input-password";
	private String loginBtn = "input.btn.btn-primary";
	private String forgotPassword = "//div[@class='form-group']/a[contains(text(),'Forgotten Password')]";
	private String logout = "//div[@class='list-group']/a[text()='Logout']";

	public LoginPage(Page page) {
		this.page = page;
	}

	// Page actions
	public String getLooginPageTitle() {
		return page.title();
	}

	public boolean isForgotPwdLogin() {
		return page.isVisible(forgotPassword);
	}

	public boolean doLogin(String uname, String pwd) {
		page.fill(email, uname);
		page.fill(password, pwd);
		page.click(loginBtn);
		
		return page.isVisible(logout);

	}

}
