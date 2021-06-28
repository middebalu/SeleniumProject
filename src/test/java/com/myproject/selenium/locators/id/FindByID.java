package com.myproject.selenium.locators.id;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.myproject.selenium.utils.Base;


public class FindByID extends Base {

	WebDriver driver;

	@FindBy(how = How.ID, using = "ctl00_mainContent_rbtnl_Trip_0")
	private WebElement oneWay;

	@FindBy(id = "ctl00_mainContent_rbtnl_Trip_1")
	private WebElement roundTrip;

	@FindBy(id = "MultiCityModelAlert")
	private WebElement alert;

	 public static Logger log =LogManager.getLogger(FindByID.class.getName());
	@Test
	public void findByID() {
		SoftAssert softAssert = new SoftAssert();
		
		roundTrip.click();
		softAssert.assertTrue(roundTrip.isSelected(), "expected radio button not selected");
		
		oneWay.click();
		softAssert.assertTrue(oneWay.isSelected(), "expected radio button not selected");
		log.info("afterclick info inside method");
		log.error("afterclick error inside method");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_2")).click();
		alert.click();
		softAssert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_2")).isSelected(),
				"expected radio button not selected");
		
		softAssert.assertAll();
	}

	@AfterMethod
	public void afterMehodSteps() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMehodSteps() {
		driver = Base.intiliazeDriver("https://www.spicejet.com/", "chrome");
		// instantiate the driver object in page factory
		PageFactory.initElements(driver, this);
	}
}
