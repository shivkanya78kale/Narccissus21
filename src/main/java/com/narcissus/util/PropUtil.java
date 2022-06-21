package com.narcissus.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {

	/**
	 * This method returns value of specified locator from or.properties file
	 * @param locator
	 * @return
	 * @throws IOException 
	 * @throws IOException
	 */
	public static String getLocator(String locator) throws IOException {
		
		String dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(dir+"/src/test/resources/OR.properties"); 
	
	
	Properties prop = new Properties();
	prop.load(fis);
	return prop.getProperty(locator);
	
		
	
	
	}
	
	
	
	
}
