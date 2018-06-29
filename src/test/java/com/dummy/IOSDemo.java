package com.dummy;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDemo {
	private IOSDriver<WebElement> driver;

	@BeforeSuite
	public void setUp() throws Exception {

		// https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
		// curl -u ketansethi7861:3a1acfcb-d583-4843-ae27-0de1e2dc1207 -X POST -H
		// "Content-Type: application/octet-stream"
		// https://saucelabs.com/rest/v1/storage/ketansethi7861/TestApp.app.zip?overwrite=true
		// --data-binary @C:/Users/ketan.sethi/Downloads/TestApp.app.zip

		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("appiumVersion", "1.8.1");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X Simulator");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("platformVersion", "11.3");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability("browserName", "");
		caps.setCapability("app", "sauce-storage:TestApp.app.zip");

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
	public void testSendKeysToInput() {

		WebDriverWait wdw = new WebDriverWait(driver, 30);
		wdw.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("TextField1")))
				.sendKeys("10000");

		wdw.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("TextField2")))
				.sendKeys("20000");

		wdw.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Compute Sum"))).click();

		wdw.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("show alert"))).click();

	}

}
