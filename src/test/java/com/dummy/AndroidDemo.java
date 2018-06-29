package com.dummy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDemo {

	public WebDriver driver;

	// adb shell
	// generic_x86:/ $ dumpsys window windows | grep -E 'mCurrentFocus|mFocusedApp'
	// set path = C:\Program Files\Java\jdk1.8.0_171\bin

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, new File("./src/test/resources/ApiDemos-debug.apk"));

		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".app.AlertDialogSamples");

		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	@Test
	public void testApp() {
		WebDriverWait wdw = new WebDriverWait(driver, 30);
		wdw.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("io.appium.android.apis:id/two_buttons")))
				.click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
