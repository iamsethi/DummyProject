package com.dummy;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Log4jDemo {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Log4jDemo.class);

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Window Maximized");

	}

	@Test
	public void test() {
		log.debug("Now hitting Amazon server");
		driver.get("https://www.amazon.in/");
		log.info("Landed on amazon home page");

		try {
			log.debug("Now hitting Amazon server");
			log.error("Some error message");
			log.fatal("Some fatal message");
		} catch (Exception e) {

		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
