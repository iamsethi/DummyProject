package com.dummy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Debug {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void testDynamic() throws Exception {

		driver.get("https://www.Facebook.com");
		String actual = driver.findElement(By.xpath("//span[text()='Create an account']")).getText();
		System.out.println(actual);
		String expected = "Create an account ";

		if (actual.equals(expected)) {
			System.out.println("Actual is equal to Expected TC - Pass");

		} else
			System.out.println("Actual is not equal to Expected TC - Fail");

	}

	@AfterMethod
	public void tearDown() throws IOException {
		driver.close();
	}

}