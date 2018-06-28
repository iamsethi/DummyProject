package com.dummy;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetCoordinatesDemo {

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
	public void test() throws IOException {

		driver.get("https://www.google.com/");
		WebElement ele = driver.findElement(By.id("hplogo"));

		// Get entire page
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);

		Point point = ele.getLocation();

		// width and height
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy

		File screensShotLocation = new File("C:\\Users\\ketan.sethi\\Desktop\\GoogleLogo_screenshot.png");
		FileUtils.copyFile(screenshot, screensShotLocation);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
