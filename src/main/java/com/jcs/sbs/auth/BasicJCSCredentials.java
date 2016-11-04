package com.jcs.sbs.auth;

import org.apache.commons.lang3.StringUtils;

/**
 * Basic implementation of the JCSCredentials interface that allows callers to
 * pass in the access key and secret key in the constructor. Initiates access
 * key and secret key.
 */
public class BasicJCSCredentials implements JCSCredentials {
    private String accessKey;
    private String secretKey;

    /**
     * Constructs a new BasicJCSCredentials object, with the specified access key and secret key.
     * 
     * @param accessKey
     *            JCS Access Key of the account
     * @param secretKey
     *            JCS Secret Key of the account
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
     * Returns the JCS access key for this credentials object.
     */
    @Override
    public String getJCSAccessKey() {
        return this.accessKey;
    }

    /**
     * Returns the JCS secret key for this credentials object.
     */
    @Override
    public String getJCSSecretKey() {
        return this.secretKey;
    }

}
