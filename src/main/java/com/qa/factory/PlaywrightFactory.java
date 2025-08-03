package com.qa.factory;

import java.io.FileInputStream;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;

	Properties prop;

	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		playwright = Playwright.create();

		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = playwright.webkit()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		case "edge":
			browser = playwright.webkit()
					.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
			break;
		default:
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		}

		context = browser.newContext();
		page = context.newPage();
		page.navigate(prop.getProperty("url").trim());
		return page;
	}

	public Properties init_prop() {
		try {
			FileInputStream fi = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}
