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

public class CalendarDemo {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void testCalendar() throws Exception {

		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.className("hasDatepicker")).click();

		List<WebElement> alllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement ele : alllDates) {
			String date = ele.getText();   // 1	//21
			if (date.equals("21")) {     // 1 !=21  21 21 T
				ele.click();
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
