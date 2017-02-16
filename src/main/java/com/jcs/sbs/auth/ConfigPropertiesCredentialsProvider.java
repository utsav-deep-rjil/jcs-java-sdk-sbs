package com.jcs.sbs.auth;

import org.apache.commons.lang3.StringUtils;

import com.jcs.sbs.common.Constants;
import com.jcs.sbs.common.PropertiesReader;

/**
 * {@link com.jcs.sbs.auth.JCSCredentialsProvider JCSCredentialsProvider} implementation that loads JCS credentials from config
 * properties file present in classpath resource folder.
 */
public class ConfigPropertiesCredentialsProvider implements JCSCredentialsProvider {
    
    
    /**
     * Default constructor for ConfigPropertiesCredentialsProvider object.
     */
    public ConfigPropertiesCredentialsProvider() {
        super();
    }

    /**
     * Implements getCredentials() method that reads ACCESS_KEY and SECRET_KEY
     * from properties file (if properties are set) and returns
     * BasicJCSCredentials object which the caller can use to authorize a JCS
     * request.
     */
    @Override
    public JCSCredentials getCredentials() {

        String accessKey = PropertiesReader.getProperty("ACCESS_KEY");
        String secretKey = PropertiesReader.getProperty("SECRET_KEY");

        if (StringUtils.isBlank(accessKey) || StringUtils.isBlank(secretKey)) {
            throw new RuntimeException(String.format("Unable to load JCS credentials from %s file (%s and %s)",
                    Constants.PROPERTIES_FILE_NAME, accessKey, secretKey));
        }

        return new BasicJCSCredentials(accessKey, secretKey);
    }

    @Override
    public void refresh() {
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     */
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
