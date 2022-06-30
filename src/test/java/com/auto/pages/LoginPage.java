package com.auto.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
WebDriver driver;

	public LoginPage(WebDriver pdriver) {
	this.driver= pdriver;
	}
	
	@FindBy(xpath = "//input[@id='username']") 
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='btn__primary--large from__button--floating']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//div[@class='t-16 t-black t-bold']")
	WebElement loginName;
	
	public void SignInMethod(String uname, String pwd) {
		
		username.sendKeys(uname);	
		password.sendKeys(pwd);
		
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn__primary--large from__button--floating']")));
		       
		signInBtn.click();
}
	
	public boolean loginNameDisplay() {
		try {
			loginName.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
