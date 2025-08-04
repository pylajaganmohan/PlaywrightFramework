package com.qa.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;

	private String email = "input#input-email";
	private String password = "input#input-password";
	private String loginBtn = "input.btn.btn-primary";
	private String forgotPassword = "//div[@class='form-group']/a[contains(text(),'Forgotten Password')]";
	private String warning = "//div[@class='alert alert-danger alert-dismissible']";

	public LoginPage(Page page) {
		this.page = page;
	}

	// Page actions
	public String getLoginPageTitle() {
		return page.title();
	}

	public boolean isForgotPwdLogin() {
		return page.isVisible(forgotPassword);
	}

	public MyAccountPage doLogin(String uname, String pwd) {
		page.fill(email, uname);
		page.fill(password, pwd);
		page.click(loginBtn);

		return new MyAccountPage(page);

	}

	public String getWarningMessage() {
		return page.textContent(warning);
	}

	public boolean isWaringDisplayed() {
		return page.isVisible(warning);
	}

}
