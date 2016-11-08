package com.jcs.sbs.auth;

/**
 * Interface that provides access to the JCS credentials (Access key and Secret
 * key) used for accessing JCS services.
 */
public interface JCSCredentials {

    /**
     * It returns JCS Access Key, which is set by any of the
     * JCSCredentialsProviders:
     * <ul>
     * <li>ConfigPropertiesCredentialsProvider,</li>
     * <li>EnvironmentVariableCredentialsProvider and</li>
     * <li>SystemPropertiesCredentialsProvider</li>
     * </ul>
     * 
     * @return JCS Access Key
     */
    public String getJCSAccessKey();

    /**
     * It returns JCS Secret Key, which is set by any of the
     * JCSCredentialsProviders:
     * <ul>
     * <li>ConfigPropertiesCredentialsProvider,</li>
     * <li>EnvironmentVariableCredentialsProvider and</li>
     * <li>SystemPropertiesCredentialsProvider</li>
     * </ul>
     * 
     * @return JCS Secret Key
     */
    public String getJCSSecretKey();

}
