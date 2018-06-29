package com.dummy;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class GridDemo {

	// HUB- java -jar selenium-server-standalone-3.12.0.jar -role hub
	// Node1:- java -jar selenium-server-standalone-3.12.jar -role webdriver -hub http://x.x.x.x:4444/grid/register/ -browser browserName=chrome
	// Node2:- java -jar selenium-server-standalone-3.12.jar -role webdriver -hub http://x.x.x.x:4444/grid/register/ -browser browserName=firefox

	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"), options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"), options);

		}

	}

}
