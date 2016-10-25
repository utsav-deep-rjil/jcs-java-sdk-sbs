package com.jcs.sbs.auth;

import com.jcs.sbs.common.Utils;

/**
 * Class to read credentials from system properties.
 */
public class SystemPropertiesCredentialsProvider implements JCSCredentialsProvider {
	/**
	 * Implements getCredentials() method that reads ACCESS_KEY and SECRET_KEY from system properties(if present) and returns BasicJCSCredentials object.
	 */
    @Override
    public JCSCredentials getCredentials() {
        String accessKey = System.getProperty("ACCESS_KEY").trim();

        String secretKey = System.getProperty("SECRET_KEY").trim();

        if (Utils.isNullOrEmpty(accessKey) || Utils.isNullOrEmpty(secretKey)) {

            throw new RuntimeException(
                    "Unable to load JCS credentials from Java system properties ("
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