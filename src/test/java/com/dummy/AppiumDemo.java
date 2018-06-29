package com.dummy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDemo {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, new File("./src/test/resources/WordPress.apk"));

		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"org.wordpress.android.ui.WPLaunchActivity");

		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	@Test
	public void testApp() {

		driver.findElement(By.xpath("//android.widget.Button[@text='LOG IN']")).click();
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("ketansethi786@gmail.com");
		driver.findElement(By.id("org.wordpress.android:id/primary_button")).click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
