package com.vtiger.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consist of reusable method related to property file
 * 
 * @author Yogesh Pahadiya
 */

public class PropertyFileUtilities {
	Properties p;
	String path = "C:\\Users\\Yogesh Pahadiya\\eclipse-workspace\\VtigerFramework\\src\\test\\resource\\config.properties";

	/**
	 * this method will read data from propertyyfile for the key provided by caller
	 * and return the value to caller
	 * 
	 * @throws IOException
	 */

//	public String readDataFromPropertyFile(String key) throws IOException {
//		p = new Properties();
//		FileInputStream fis = new FileInputStream(path);
//		p.load(fis);
//		String value = p.getProperty(key);
//		return value;
//
//	}

	public PropertyFileUtilities() {
		try {
			p = new Properties();
			FileInputStream fis = new FileInputStream(path);
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getBaseUrl() {
		String value = p.getProperty("baseUrl");
		if (value != null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
	}

	public String getBrowser() {
		String value = p.getProperty("browser");
		if (value != null)
			return value;
		else
			throw new RuntimeException("browser not specified in config file.");
	}

	public String getUserName() {
		String value = p.getProperty("username");
		if (value != null)
			return value;
		else
			throw new RuntimeException("username not specified in config file.");
	}

	public String getPassword() {
		String password = p.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
	}
}
