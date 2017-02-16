package com.jcs.sbs.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Contains static method for reading properties from properties files present
 * in classpath resource folder.
 */
public class PropertiesReader {

    private static final Log log = LogFactory.getLog(PropertiesReader.class);

    final private static Properties properties = new Properties();
    final private static InputStream input = PropertiesReader.class.getClassLoader()
            .getResourceAsStream(Constants.PROPERTIES_FILE_NAME);

    /**
     * Reads properties from config.properties file placed under
     * resources folder and returns value for given key.
     * 
     * @param key
     *            The key to search in config.properties file
     * @return The value (if any) corresponding to given key
     */
    public static String getProperty(String key) {
        try {
            properties.load(input);
            return properties.getProperty(key);
        } catch (IOException e) {
            log.warn(String.format("Unable to read value of %s from %s file", key, Constants.PROPERTIES_FILE_NAME), e);
            return null;
        }
    }
}
