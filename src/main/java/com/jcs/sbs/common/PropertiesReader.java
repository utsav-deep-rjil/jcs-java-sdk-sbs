package com.jcs.sbs.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	
	final private static Properties properties = new Properties();
	final private static InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream("config.properties");

	/**
	 * This method reads properties from config.properties file placed under resources folder and returns value for given key.
	 * 
	 * @param key The key to be searched in config.properties file
	 * @return The value (if any) corresponding to given key
	 */
	public static String getProperty(String key){
		try {
			properties.load(input);
			return properties.getProperty(key);
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
	}
}
