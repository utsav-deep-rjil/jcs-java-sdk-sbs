package com.jcs.sbs.auth;

/**
 * Interface that provides access to Access and Secret keys
 *
 */
public interface JCSCredentials {

    /**
     * 
     * @return JCS Access Key
     */
    public String getJCSAccessKey();

    /**
     * 
     * @return JCS Secret Key
     */
    public String getJCSSecretKey();

}
