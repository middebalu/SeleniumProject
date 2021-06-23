package Proejct.Selenium;

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

}
