package com.main.Helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.main.BasePackage.WebDriverLoader;
import com.main.Utility.LoggerUtil;

public class WaitHelper {

	@SuppressWarnings("unused")
	private WebDriver driver;
	WebDriverWait oWebDriverWait;
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		oWebDriverWait = new WebDriverWait(driver, WebDriverLoader.largewWait);
	}

	public void WaitForElement(WebElement element) {
		LoggerUtil.info("waiting for element to visible..");		
		oWebDriverWait.until(ExpectedConditions.visibilityOf(element));
		LoggerUtil.info("element is visible..");
	}

	public void waitForPageLoad() {
		LoggerUtil.info("waiting for page to load..");
		oWebDriverWait.until(new Function<WebDriver, Boolean>() {
		public Boolean apply(WebDriver driver) {
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
		LoggerUtil.info("Page loaded Successfully");
	}	
}
