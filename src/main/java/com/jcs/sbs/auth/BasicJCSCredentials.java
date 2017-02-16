package com.jcs.sbs.auth;

import org.apache.commons.lang3.StringUtils;

/**
 * Basic implementation of the {@link com.jcs.sbs.auth.JCSCredentials JCSCredentials} interface that allows callers to
 * pass in the access and secret keys in the constructor. Initializes the access
 * and secret keys.
 */
public class BasicJCSCredentials implements JCSCredentials {
    private String accessKey;
    private String secretKey;

    /**
     * Constructs a new BasicJCSCredentials object, with the specified access and secret keys.
     * 
     * @param accessKey
     *            JCS Access Key
     * @param secretKey
     *            JCS Secret Key
     */
    public BasicJCSCredentials(String accessKey, String secretKey) {
        if (StringUtils.isBlank(accessKey)) {
            throw new IllegalArgumentException("Access key cannot be null or empty.");
        }
        if (StringUtils.isBlank(secretKey)) {
            throw new IllegalArgumentException("Secret key cannot be null or empty.");
        }
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    /**
     * Returns the JCS access key for the credentials object.
     */
    @Override
    public String getJCSAccessKey() {
        return this.accessKey;
    }

    /**
     * Returns the JCS secret key for the credentials object.
     */
    @Override
    public String getJCSSecretKey() {
        return this.secretKey;
    }

}
