package com.dummy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

	}

	@Test
	public void testAmazon() {
		WebElement tbx = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		tbx.sendKeys("Amazon Fire TV Stick");
		driver.findElement(By.className("nav-input")).click();
		Assert.assertEquals("Amazon Fire TV Stick with Voice Remote | Streaming Media Player",
				driver.findElement(By.xpath("//a[contains(@title,'Amazon Fire TV Stick')]")).getText());

	}

	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}
