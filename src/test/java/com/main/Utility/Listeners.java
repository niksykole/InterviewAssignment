package com.main.Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.main.BasePackage.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	ExtentTest test;
	WebDriver driver = null;
	ExtentReports extent = ExtentReporter.initializeReporter();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("TestCase Started!! "+arg0.getName());
		test=extent.createTest(arg0.getName(), "**Report for Search Test**");
		extentTest.set(test);
		extentTest.get().log(Status.INFO,"Test execution Started");
	}

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("TestCase Finished!! "+arg0.getName());
		extentTest.get().log(Status.INFO,"Test execution Completed");
		extent.flush();
	}



	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("TestCase Failed!! "+arg0.getName());
		extentTest.get().log(Status.FAIL,"Test Case Fail");

		try {
			driver = (WebDriver)arg0.getTestClass().getRealClass().getDeclaredField("driver").get(arg0.getInstance());
		}catch(Exception e){

		}
		try {
			extentTest.get().addScreenCaptureFromPath(BaseClass.getPathToSroreScreenshot(driver,arg0.getMethod().getMethodName()),arg0.getMethod().getMethodName());
		}catch(IOException e) {

		}
	}

	
	@Override
	public void onTestSkipped(ITestResult arg0) {
	
	}

	;
	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("TestCase Success!! "+arg0.getName());
		extentTest.get().log(Status.PASS,"Test cases");

	}

	
	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("TestCase Started!! "+arg0.getMethod().getMethodName());
		extentTest.get().log(Status.INFO,"Test Case Start");
	}

}
