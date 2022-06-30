package com.auto.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver StartApp(WebDriver driver,String browser,String url) {
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\PractApp\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		
		else if(browser.equals("Firefox")) { 
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\PractApp\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\PractApp\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("Invalid Support of Browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void closeApp(WebDriver driver) {
		
		driver.close();
	}
}
