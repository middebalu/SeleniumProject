package com.myproject.selenium.locators.name;

import org.testng.annotations.Test;
import java.util.List;
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

public class FindByName extends Base {

	WebDriver driver;

	@FindBy(how = How.NAME, using = "ctl00$mainContent$rbtnl_Trip")
	private List<WebElement> tripSelector;

	@FindBy(name = "ctl00$mainContent$rbtnl_Trip")
	private WebElement tripSelectorSingle;

	@FindBy(id = "MultiCityModelAlert")
	private WebElement alert;

	@Test
	public void findByName() {
		SoftAssert softAssert = new SoftAssert();
		// it selects first radio button oneWay as all radio buttons have same name
		tripSelectorSingle.click();
		softAssert.assertTrue(tripSelectorSingle.isSelected(), "expected radio button not selected");
		for (WebElement e : tripSelector) {
			System.out.println(e.getAttribute("value"));
			e.click();
			softAssert.assertTrue(e.isSelected(), "expected radio button not selected");
		}
		//alert.click(); // to accept multicity alert
		driver.findElement(By.name("ctl00$mainContent$rbtnl_Trip")).click();
		
		softAssert.assertTrue(driver.findElement(By.name("ctl00$mainContent$rbtnl_Trip")).isSelected(),
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
