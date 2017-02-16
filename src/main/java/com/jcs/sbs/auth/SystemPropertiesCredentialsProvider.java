package com.jcs.sbs.auth;

import org.apache.commons.lang3.StringUtils;

/**
 * {@link com.jcs.sbs.auth.JCSCredentialsProvider JCSCredentialsProvider} implementation that loads JCS credentials from
 * Java system properties.
 */
public class SystemPropertiesCredentialsProvider implements JCSCredentialsProvider {
    
    
    /**
     * Default constructor for SystemPropertiesCredentialsProvider object.
     */
    public SystemPropertiesCredentialsProvider() {
    }

    /**
     * Implements getCredentials() method that reads ACCESS_KEY and SECRET_KEY
     * from system properties(if present) and returns BasicJCSCredentials
     * object.
     */
    @Override
    public JCSCredentials getCredentials() {
        String accessKey = System.getProperty("ACCESS_KEY");

        String secretKey = System.getProperty("SECRET_KEY");

        if (StringUtils.isBlank(accessKey) || StringUtils.isBlank(secretKey)) {
            throw new RuntimeException(String.format(
                    "Unable to load JCS credentials from Java system properties (%s and %s)", accessKey, secretKey));

        }

        return new BasicJCSCredentials(accessKey, secretKey);
    }

    @Override
    public void refresh() {
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     */
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}