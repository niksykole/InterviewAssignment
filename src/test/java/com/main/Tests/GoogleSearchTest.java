package com.main.Tests;

import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.main.Actions.GoogleSearchActions;
import com.main.BasePackage.WebDriverLoader;
import com.main.Helper.ExcelHelper;
import com.main.Helper.WaitHelper;
import com.main.Helper.WebHelper;

public class GoogleSearchTest {
	public WebDriver driver;
	WaitHelper oWaitHelper;
	WebHelper oWebHelper;
	GoogleSearchActions oGoogleSearchActions;
	@BeforeClass(groups= {"smoke"})
	public void beforeClass() {
		try {
			ExcelHelper.getExcelData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	@BeforeMethod
	public void setup() throws IOException {
		WebDriverLoader tester = new WebDriverLoader();
		driver=tester.getDriver();
		oWaitHelper = new WaitHelper(driver);
		oWebHelper =new WebHelper(driver);
		oGoogleSearchActions= new GoogleSearchActions(driver);
	}

	@DataProvider(name="data-provider")
	public Object[][] dataProvider(){
		Object[][] oDataArray = new Object[ExcelHelper.listExcelData.size()][1];
		int i=0;
		for (Map<String,String> m : ExcelHelper.listExcelData) {
			oDataArray[i][0]=m;
			i++;}
		return oDataArray;

	}

	@Test(dataProvider="data-provider")
	public void googleSearch(Map<String,String> map) {		
		driver.get(map.get("SearchEngineURL"));	
		oWaitHelper.waitForPageLoad();
		oGoogleSearchActions.enterTextToSearchBar(map.get("ContentToSearch"));
		oGoogleSearchActions.waitForGoogleSearchResult();		
		boolean bCurrentURL= oWebHelper.verifyTextContainsInURL(map.get("ContentToSearch"));
		Assert.assertEquals(bCurrentURL,true);	
		//boolean bVerifyURL= oGoogleSearchActions.VerifyLink(Integer.parseInt(map.get("LinkNumber")),map.get("VerifyLink"));
		//Assert.assertEquals(bCurrentURL,true);			
		boolean bResult=oGoogleSearchActions.VerifyLinks(map.get("VerifyLink"));
		Assert.assertEquals(bResult,true);		
	}	


	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

