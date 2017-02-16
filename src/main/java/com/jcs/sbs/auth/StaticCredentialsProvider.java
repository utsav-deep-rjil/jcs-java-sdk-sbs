package com.jcs.sbs.auth;

/**
 * {@link com.jcs.sbs.auth.JCSCredentialsProvider JCSCredentialsProvider}
 * implementation that loads static JCS credentials.
 */
public class StaticCredentialsProvider implements JCSCredentialsProvider {

    private final JCSCredentials credentials;

    /**
     * Constructor for creating StaticCredentialsProvider object. It accepts
     * object of class implementing {@link com.jcs.sbs.auth.JCSCredentials JCSCredentials} interface.
     * 
     * @param credentials
     *            An object of class that implements {@link com.jcs.sbs.auth.JCSCredentials JCSCredentials} interface.
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
