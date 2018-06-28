package com.dummy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutiITDemo {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void testWindowAlert() {
		
		driver.get("file:///C:/Users/ketan.sethi/Desktop/fileupload.html");
		driver.findElement(By.id("1")).click();
		try {
			Runtime.getRuntime().exec("C:/Users/ketan.sethi/Desktop/upload.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() throws IOException {
		driver.close();
	}

}
