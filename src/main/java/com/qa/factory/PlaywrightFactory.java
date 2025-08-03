package com.qa.factory;

import java.io.FileInputStream;
import java.nio.file.Paths;
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

	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}

	public static Browser getBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getContext() {
		return tlContext.get();
	}

	public static Page getPage() {
		return tlPage.get();
	}

	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		tlPlaywright.set(Playwright.create());

		switch (browserName.toLowerCase()) {
		case "chromium":
			// browser = playwright.chromium().launch(new
			// BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "firefox":
			// browser = playwright.firefox().launch(new
			// BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "safari":
			// browser = playwright.webkit().launch(new
			// BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "chrome":
			// browser = playwright.webkit().launch(new
			// BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			tlBrowser.set(getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;
		case "edge":
			// browser = playwright.webkit().launch(new
			// BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
			tlBrowser.set(getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false)));
			break;
		default:
			// browser = playwright.chromium().launch(new
			// BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;
		}

		tlContext.set(getBrowser().newContext());
		tlPage.set(getContext().newPage());
		getPage().navigate(prop.getProperty("url").trim());
		return getPage();

//		context = browser.newContext();
//		page = context.newPage();
//		page.navigate(prop.getProperty("url").trim());
//		return page;
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
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		return path;
	}
}
