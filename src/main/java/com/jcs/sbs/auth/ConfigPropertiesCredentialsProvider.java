package com.jcs.sbs.auth;

import com.jcs.sbs.common.PropertiesReader;
import com.jcs.sbs.common.Utils;

public class ConfigPropertiesCredentialsProvider implements JCSCredentialsProvider {
	/**
	 * Implements getCredentials() method that reads ACCESS_KEY and SECRET_KEY from config.properties(if properties are set) and returns BasicJCSCredentials object.
	 */
	@Override
	public JCSCredentials getCredentials() {

        String accessKey = PropertiesReader.getProperty("ACCESS_KEY").trim();

        String secretKey = PropertiesReader.getProperty("SECRET_KEY").trim();

        if (Utils.isNullOrEmpty(accessKey) || Utils.isNullOrEmpty(secretKey)) {

            throw new RuntimeException(
                    "Unable to load JCS credentials from config.properties file ("
            + accessKey + " and "+ secretKey + ")");
        }

        return new BasicJCSCredentials(accessKey, secretKey);
	}

	@Override
	public void refresh() {}

	@Override
    public String toString() {
        return getClass().getSimpleName();
    }
	
}
