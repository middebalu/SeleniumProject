package com.myproejct.selenium.listeners;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.myproject.selenium.utils.Base;
import com.myproject.selenium.utils.ExtentReporterNG;

public class Listener extends Base implements ITestListener {

	// Object for extent test to use this capture the test results in methods

	ExtentTest test;
	// object for extent reports

	ExtentReports extent = ExtentReporterNG.getReportObject();

	// Creation thread local for extent test to avoid results overwrite during
	// parallel execution
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	Logger log;

	public void onTestStart(ITestResult result) {
		// Assign method name to extent test
		test = extent.createTest(result.getInstanceName() + " " + result.getMethod().getMethodName());

		// Adding extent test to thread local.
		extentTest.set(test);

		log = LogManager.getLogger(result.getInstanceName() + " " + result.getMethod().getMethodName());
		log.fatal("Tet started");
		log.fatal("test started");
	}

	public void onTestSuccess(ITestResult result) {

		// Get extent test from thread local and add log as test case passed
		extentTest.get().log(Status.PASS, "Test Passed");

		log.error("Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		log.error("Test Failed");
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}
		try {
			extentTest.get().addScreenCaptureFromPath(takeScreentShot(driver, testMethodName),
					result.getMethod().getMethodName());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
