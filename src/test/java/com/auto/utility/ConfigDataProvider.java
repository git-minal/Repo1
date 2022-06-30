package com.auto.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	
	public ConfigDataProvider() { 
	File srcc = new File("C:\\Users\\ADMIN\\eclipse-workspace\\PractApp\\Config\\Config.properties");
	
	try {
		FileInputStream fisc = new FileInputStream(srcc);
		
		prop = new Properties();
		
		prop.load(fisc);
	} catch (Exception e) {
		
		System.out.println("Propeties file not found" +e.getMessage());
	}
	
	 }
	
	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	
	public String getStagingURL() {
		return prop.getProperty("qaUrl");
	}
}
