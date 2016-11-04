package com.jcs.sbs.auth;

/**
 * JCSCredentialsProvider implementation that loads static JCS credentials.
 */
public class StaticCredentialsProvider implements JCSCredentialsProvider {

    private final JCSCredentials credentials;

    /**
     * Constructor for creating StaticCredentialsProvider object. It accepts
     * object of class implementing JCSCredentials interface
     * 
     * @param credentials
     *            An object of class that implements JCSCredentials interface.
     */
    public StaticCredentialsProvider(JCSCredentials credentials) {
        this.credentials = credentials;
    }

    public JCSCredentials getCredentials() {
        return credentials;
    }

    public void refresh() {
    }

}
