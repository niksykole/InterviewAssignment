package com.main.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverLoader {

	public static Properties property;
	public static WebDriver driver;
	public static String browserName;
	public static Long largewWait;
	public static Long SmallWait;
	public static String operatingSystemName;


	public WebDriver getDriver() throws IOException {
		FileInputStream fp = new FileInputStream("src/test/java/com/main/Config/Config.properties");
		property = new Properties();
		property.load(fp);
		operatingSystemName=property.getProperty("OperatingSystemName");
		browserName = property.getProperty("BrowserName");
		largewWait = Long.parseLong(property.getProperty("LargeWait"));
		SmallWait = Long.parseLong(property.getProperty("SmallWait"));
		
		System.out.println("browserName :"+browserName);
		System.out.println("operatingSystemName :"+operatingSystemName);
		System.out.println("largewWait :"+largewWait);
		System.out.println("SmallWait :"+SmallWait);
		switch(operatingSystemName){
			case "MAC":
				if(browserName.equals("CHROME")) {
					System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/MAC/chromedriver");
					driver = new ChromeDriver();
				}		
				else if(browserName.equals("FIREFOX")) {
					System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/MAC/geckodriver");
					driver = new FirefoxDriver();
				}
				break;
			case "WINDOWS":
				if(browserName.equals("CHROME")) {
					System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/Windows/chromedriver.exe");
					driver = new ChromeDriver();
				}		
				else if(browserName.equals("FIREFOX")) {
					System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/Windows/geckodriver.exe");
					driver = new FirefoxDriver();
				}
				break;	
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(SmallWait, TimeUnit.SECONDS);
		return driver;
	}	

}
