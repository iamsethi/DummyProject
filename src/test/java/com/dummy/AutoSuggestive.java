package com.dummy;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoSuggestive {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void testAutoSuggestive() throws Exception {

		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.id("hp-widget__sfrom")).sendKeys("DEL");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> l = driver.findElements(By.xpath("//span[@class='autoCompleteItem__label']"));

		for (WebElement w : l) {

			if (w.getText().contains("Kolkata")) {
				w.click();
				break;
			}
		}

		Thread.sleep(10000);

	}

	@AfterMethod
	public void tearDown() throws IOException {
		driver.close();
	}

}
