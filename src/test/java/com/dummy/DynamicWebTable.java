package com.dummy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicWebTable {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void testDynamic() throws Exception {

		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		// xpath - > //table//tbody//tr[1 to rows.size()]

		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

		for (int i = 1; i < rows.size(); i++) {
			System.out.println(driver.findElement(By.xpath("//table//tbody//tr[" + i + "]")).getText());
		}

	}

	@AfterMethod
	public void tearDown() throws IOException {
		driver.close();
	}

}
