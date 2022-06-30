package com.auto.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.auto.utility.BrowserFactory;
import com.auto.utility.ConfigDataProvider;
import com.auto.utility.ExcelDataProvider;
import com.auto.utility.Helper;

public class BaseClass {
	public WebDriver driver; 
	public ExcelDataProvider excel;
    public ConfigDataProvider configD;
    //public ExtentReports reports;
   // public ExtentTest logger;
	
	@BeforeSuite
	public void setData() {
		excel = new ExcelDataProvider();
		configD = new ConfigDataProvider();
//		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/linkdinReports.html"));
//		reports = new ExtentReports();
//		reports.attachReporter(extent);
	}
	
	@BeforeTest
	
	public void Start() {
		
		driver = BrowserFactory.StartApp(driver,configD.getBrowser(),configD.getStagingURL());
	}
	
	@AfterTest
	public void closeAppMethod() {
		
		BrowserFactory.closeApp(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		{
		Helper.captureScreenShots(driver);
		}
	}
}
