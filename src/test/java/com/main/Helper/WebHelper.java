package com.main.Helper;


import org.openqa.selenium.WebDriver;

import com.main.Utility.LoggerUtil;

public class WebHelper {

	private WebDriver driver;

	public WebHelper(WebDriver oWebDriver) {
		this.driver =oWebDriver;
	}

	public boolean verifyTextContainsInURL(String sSearchText) {
		boolean bCurrentURL =false;
		try {
			bCurrentURL = driver.getCurrentUrl().contains(sSearchText);
			LoggerUtil.info("Search Text exist in Current URL");
		} catch (Exception oException) {
			LoggerUtil.error("Exception occurred while getting current URL:" + oException.getMessage());
		}
		return bCurrentURL;
	}
}
