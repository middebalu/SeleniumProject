package Proejct.Selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HelloProgram extends Base {
	WebDriver driver;
	@Test
	public void fireFoxDriver() {
		
		driver= Base.intiliazeDriver("https://www.spicejet.com/","firefox");
		System.out.println(driver.getTitle());	
		driver.close();
	}
	
	@Test
	public void chromeDriver() {
		
		driver= Base.intiliazeDriver("https://www.spicejet.com/","chrome");
		System.out.println(driver.getTitle());	
		driver.close();
	}
	
	@Test
	public void edgeDriver() {
		
		driver= Base.intiliazeDriver("https://www.spicejet.com/","edge");
		System.out.println(driver.getTitle());	
		driver.close();
	}
	

}
