package com.dummy;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RobotDemo {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void testWindowAlert() throws Exception {

		driver.get("file:///C:/Users/ketan.sethi/Desktop/fileupload.html");

		driver.findElement(By.id("1")).click();

		Robot rb = new Robot();
		Thread.sleep(2000);

		// C:\ GROUPMOD
		// keyPress
		// keyRelease

		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_C);
		rb.keyPress(KeyEvent.VK_SEMICOLON);
		// C:

		rb.keyRelease(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_BACK_SLASH);
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		// C:\

		rb.keyPress(KeyEvent.VK_G);
		rb.keyRelease(KeyEvent.VK_G);

		rb.keyPress(KeyEvent.VK_R);
		rb.keyRelease(KeyEvent.VK_R);

		rb.keyPress(KeyEvent.VK_O);
		rb.keyRelease(KeyEvent.VK_O);

		rb.keyPress(KeyEvent.VK_U);
		rb.keyRelease(KeyEvent.VK_U);

		rb.keyPress(KeyEvent.VK_P);
		rb.keyRelease(KeyEvent.VK_P);

		rb.keyPress(KeyEvent.VK_M);
		rb.keyRelease(KeyEvent.VK_M);

		rb.keyPress(KeyEvent.VK_O);
		rb.keyRelease(KeyEvent.VK_O);

		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);

		// C:\GROUPMOD

		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
