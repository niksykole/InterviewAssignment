package com.main.Actions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.main.Utility.LoggerUtil;
import com.main.Helper.WaitHelper;
import com.main.Helper.WebHelper;
import com.main.BasePackage.BaseClass;
import com.main.BasePackage.WebDriverLoader;
import com.main.Pages.GoogleSearchPage;
import com.main.Pages.YahooSearchPage;

public class GoogleSearchActions extends BaseClass{

	public GoogleSearchPage oGoogleSearch = null;
	public YahooSearchPage oYahooSearchPage=null;
	WaitHelper oWaitHelper;
	public WebDriver driver;
	public WebHelper oWebHelper;
	public GoogleSearchActions(WebDriver driver){
		super(driver);
		this.driver=driver;
		this.oGoogleSearch= new GoogleSearchPage();
		this.oYahooSearchPage= new YahooSearchPage();
		PageFactory.initElements(driver, oGoogleSearch);
		PageFactory.initElements(driver, oYahooSearchPage);
		oWaitHelper = new WaitHelper(driver);
		oWebHelper=new WebHelper(driver);
	}

	public void waitForGoogleSearchResult() {
		try {
			LoggerUtil.info("waiting for search results..");			
			if(oWebHelper.verifyTextContainsInURL("google.com")) {
				Boolean oWebElement = (new WebDriverWait(driver, WebDriverLoader.largewWait))
						.until(ExpectedConditions.elementToBeSelected(oGoogleSearch.resultframe));
			}else if (oWebHelper.verifyTextContainsInURL("yahoo.com")) {
				Boolean oWebElement = (new WebDriverWait(driver, WebDriverLoader.largewWait))
						.until(ExpectedConditions.elementToBeSelected(oYahooSearchPage.resultframe));
			}
			
			LoggerUtil.info("Search results found..");
		} catch (Exception oException) {
			LoggerUtil.error("Exception occurred while getting current URL:" + oException.getMessage());
		}
	}
	

	public void enterTextToSearchBar(String searchBarText) {
		try {
			if(oWebHelper.verifyTextContainsInURL("google.com")) {
				oWaitHelper.WaitForElement(oGoogleSearch.searchBar);
				oGoogleSearch.searchBar.sendKeys(searchBarText);
				LoggerUtil.info("Successfully Enter the Search Text i.e ["+searchBarText+"]");
				oGoogleSearch.searchBar.submit();
			}else if (oWebHelper.verifyTextContainsInURL("yahoo.com")) {
				oWaitHelper.WaitForElement(oYahooSearchPage.searchBar);
				oYahooSearchPage.searchBar.sendKeys(searchBarText);
				LoggerUtil.info("Successfully Enter the Search Text i.e ["+searchBarText+"]");
				oYahooSearchPage.searchBar.submit();
			}
		} catch (Exception oException) {
			LoggerUtil.error("Exception occurred while getting current URL:" + oException.getMessage());
		}
	}
 
	public boolean VerifyLink(int iLinkNumber, String Link) {
		List<WebElement> findElements = null;
		boolean bResult = false;
		try {
			if(oWebHelper.verifyTextContainsInURL("google.com")) {
			 findElements = oGoogleSearch.searchResult;
			}else if (oWebHelper.verifyTextContainsInURL("yahoo.com")) {
				findElements = oYahooSearchPage.searchResult;
			}			
			WebElement oWebElement=findElements.get(iLinkNumber-1);
			System.out.println("----------Link"+oWebElement.getAttribute("href"));
				if(oWebElement.getAttribute("href").equals(Link)) {
					bResult=true;
				}	
		} catch (Exception oException) {
			LoggerUtil.error("Exception occurred while getting current URL:" + oException.getMessage());
		}
		return bResult;
	}
	public boolean VerifyLinks(String Link) {
		boolean bResult = false;
		List<WebElement> findElements = null;
		try {
			if(oWebHelper.verifyTextContainsInURL("google.com")) {
			 findElements = oGoogleSearch.searchResult;
			}else if (oWebHelper.verifyTextContainsInURL("yahoo.com")) {
				findElements = oYahooSearchPage.searchResult;
			}
			for (WebElement webElement : findElements) {
				LoggerUtil.info("Search Result Link :" + webElement.getAttribute("href"));
				if ((webElement.getAttribute("href").equalsIgnoreCase(Link)))					
				{
					bResult = true;
					LoggerUtil.info("Successfully found expected result link :" + webElement.getAttribute("href"));					
					break;
				}				
			}
			if(!bResult) {
				LoggerUtil.error("Expected link ["+ Link +" ] is not found in serach result");
			}
		} catch (Exception oException) {
			LoggerUtil.error("Exception occurred while getting current URL:" + oException.getMessage());
		}
		return bResult;
	}
}
