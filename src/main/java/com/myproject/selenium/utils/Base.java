package com.myproject.selenium.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	static WebDriver driver;

	public static WebDriver intiliazeDriver(String url, String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\servers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", ".\\resources\\servers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.contentEquals("edge")) {
			System.setProperty("webdriver.edge.driver", ".\\resources\\servers\\msedgedriver.exe");
			driver = new EdgeDriver();

		} else {
			System.out.println(browser + "  Browser option is invalid");
		}

		driver.get(url);
		return driver;

	}

	public static String takeScreentShot(WebDriver driver, String testCaseName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		try {
			FileUtils.copyFile(source, new File(destinationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationFile;

	}
}
