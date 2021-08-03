package com.main.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage{	

	public WebDriver driver;
	
	@FindBy(xpath = "//input[@title='Search']")
	public WebElement searchBar;

	@FindBy(xpath = "//*[@id='rso']//a")
	public
	List<WebElement> searchResult;
	
	@FindBy(xpath = "//div[@id='result-stats']")
	public WebElement resultframe;
	
}
