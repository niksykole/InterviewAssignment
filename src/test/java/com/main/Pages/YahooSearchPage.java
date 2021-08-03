package com.main.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooSearchPage{	

	public WebDriver driver;
	
	@FindBy(xpath = "//input[@id='ybar-sbq']")
	public WebElement searchBar;

	@FindBy(xpath = "//div[@id='web']//a")
	public
	List<WebElement> searchResult;
	
	@FindBy(xpath = "//div[@id='main']")
	public WebElement resultframe;
	
}
