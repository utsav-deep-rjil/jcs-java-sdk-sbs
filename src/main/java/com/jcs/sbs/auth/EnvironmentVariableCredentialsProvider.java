package com.jcs.sbs.auth;

import org.apache.commons.lang3.StringUtils;

/**
 * JCSCredentialsProvider implementation that loads JCS credentials from environment variables.
 */
public class EnvironmentVariableCredentialsProvider implements JCSCredentialsProvider {
    
    
    /**
     * Default constructor for EnvironmentVariableCredentialsProvider object.
     */
    public EnvironmentVariableCredentialsProvider() {
        super();
    }

    /**
     * Implements getCredentials() method that reads ACCESS_KEY and SECRET_KEY
     * from environment variables(if present) and returns BasicJCSCredentials
     * object.
     */
    @Override
    public JCSCredentials getCredentials() {
        String accessKey = System.getenv("ACCESS_KEY");
        String secretKey = System.getenv("SECRET_KEY");

        if (StringUtils.isBlank(accessKey) || StringUtils.isBlank(secretKey)) {
            throw new RuntimeException(String.format(
                    "Unable to load JCS credentials from environment variables (%s and %s)", accessKey, secretKey));
        }

        return new BasicJCSCredentials(accessKey, secretKey);
    }

    @Override
    public void refresh() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}