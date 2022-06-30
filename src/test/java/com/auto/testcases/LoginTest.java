package com.auto.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.auto.pages.BaseClass;
import com.auto.pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void LoginTestMethod()
	{
		
		LoginPage loginp = PageFactory.initElements(driver, LoginPage.class);
		
		//loginp.SignInMethod("narkhede.meenal86@gmail.com", "Medhaj@2011");
		
		loginp.SignInMethod(excel.getStringData("Sheet1", 1,0),excel.getStringData("Sheet1", 1, 1));
		
		
		boolean flag= loginp.loginNameDisplay();
		assertEquals(flag, true);
		
		System.out.println("Login assertion successful");
	}
}
