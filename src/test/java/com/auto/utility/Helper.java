package com.auto.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
//screenshots,alerts,frames,windows,synch issue,javascript executer
	
	public static void captureScreenShots(WebDriver driver) {
		
		File fl = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
try {
			FileHandler.copy(fl, new File("./Screenshots/"+getCurrentDate() +".png"));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("unable to capture screenshots" +e.getMessage());
		}
	} 

public static String getCurrentDate() {
	DateFormat custformat = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
	Date currentDate = new Date();
	return custformat.format(currentDate);
}
}
