package com.dummy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EbayTest {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver.manage().window().maximize();
		driver.get("https://www.ebay.in/");

	}

	@Test
	public void testEbay() {
		WebElement tbx = driver.findElement(By.xpath("//div[@id='gh-ac-box2']//input"));
		tbx.sendKeys("Amazon Fire TV Stick");
		driver.findElement(By.cssSelector("#gh-btn")).click();

	}

	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}
