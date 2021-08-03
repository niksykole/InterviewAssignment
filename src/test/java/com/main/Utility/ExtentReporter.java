package com.main.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports extent;
	public static ExtentReports initializeReporter() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/Testindex.html");
		reporter.config().setDocumentTitle("Customized-Report");
		reporter.config().setReportName("SearchReport");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Company Name", "HCL");
		extent.setSystemInfo("Project Name", "Test Assignment");
		extent.setSystemInfo("Tester Name", "Nikhil");
		return extent;
	}




}
