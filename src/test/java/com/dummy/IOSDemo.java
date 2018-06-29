package com.dummy;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDemo {
	private IOSDriver<WebElement> driver;

	@BeforeSuite
	public void setUp() throws Exception {

		// https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
		// curl -u ketansethi7861:3a1acfcb-d583-4843-ae27-0de1e2dc1207 -X POST -H "Content-Type: application/octet-stream" https://saucelabs.com/rest/v1/storage/ketansethi7861/TestApp.app.zip?overwrite=true --data-binary @C:/Users/ketan.sethi/Downloads/TestApp.app.zip


		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("appiumVersion", "1.8.1");
		caps.setCapability("deviceName","iPhone X Simulator");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("platformVersion","11.3");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("browserName", "");
		caps.setCapability("app","sauce-storage:TestApp.app.zip");

		URL sauceUrl = new URL(
				"http://ketansethi7861:3a1acfcb-d583-4843-ae27-0de1e2dc1207@ondemand.saucelabs.com:80/wd/hub");

		driver = new IOSDriver<WebElement>(sauceUrl, caps);

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testFindElementsByAccessibilityID() {
		// This finds elements by "accessibility id", which in the case of IOS is the
		// "name" attribute of the element
		List<WebElement> computeSumButtons = driver.findElementsByAccessibilityId("ComputeSumButton");
		Assert.assertEquals(computeSumButtons.size(), 1);
		computeSumButtons.get(0).click();
	}

	@Test
	public void testFindElementsByClassName() {
		// Find element by name
		List<WebElement> windowElements = driver.findElementsByClassName("XCUIElementTypeWindow");
		Assert.assertTrue(windowElements.size() > 1);
	};

	@Test
	public void testFindElementsByNSPredicateString() {
		// This is an IOS-specific selector strategy. See
		// https://developer.apple.com/library/content/documentation/Cocoa/Conceptual/Predicates/Articles/pSyntax.html
		// for reference
		List<WebElement> allVisibleElements = driver.findElementsByIosNsPredicate("visible = true");
		Assert.assertTrue(allVisibleElements.size() > 1);
	};

	@Test
	public void testFindElementsByClassChain() {
		// This is also an IOS-specific selector strategy. Similar to XPath. This is
		// recommended over XPath.
		List<WebElement> windowElements = driver.findElementsByIosClassChain("XCUIElementTypeWindow[1]/*[2]");
		Assert.assertEquals(windowElements.size(), 1);
	};

	@Test
	public void testFindElementsByXPath() {
		// Can find source xml by calling "driver.source()"
		// Note that XPath is not recommended due to major performance issues
		List<WebElement> buttons = driver.findElementsByXPath("//XCUIElementTypeWindow//XCUIElementTypeButton");
		Assert.assertTrue(buttons.size() > 1);
	};
}
