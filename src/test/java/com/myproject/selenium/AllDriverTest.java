package com.myproject.selenium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myproject.selenium.utils.Base;

public class AllDriverTest extends Base {
	public WebDriver driver;
	@Test
	public void fireFoxDriver() {
		
		driver= Base.intiliazeDriver("https://www.spicejet.com/","firefox");
		System.out.println(driver.getTitle());	
		AssertJUnit.fail();
	
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
