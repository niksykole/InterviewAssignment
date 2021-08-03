package com.main.BasePackage;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public WebDriver driver;
	WebDriverWait oWebDriverWait;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
		oWebDriverWait = new WebDriverWait(driver,WebDriverLoader.SmallWait);
	}
	public static String getPathToSroreScreenshot(WebDriver driver, String ssName) throws IOException {
		String sSimpleDate = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot tsTakesScreenshot = (TakesScreenshot)driver;
		File fileSource = tsTakesScreenshot.getScreenshotAs(OutputType.FILE);
		String sDestinationPath = System.getProperty("user.dir")+"\\test-output\\FailuerScreenShot\\"+ssName+"_"+sSimpleDate+".png";
		File fileDestinationPath = new File(sDestinationPath);
		FileUtils.copyFile(fileSource,fileDestinationPath);
		return sDestinationPath;
	}

	


}
