package com.jcs.sbs.auth;

public class StaticCredentialsProvider implements JCSCredentialsProvider {

    private final JCSCredentials credentials;

    public StaticCredentialsProvider(JCSCredentials credentials) {
        this.credentials = credentials;
    }

    public JCSCredentials getCredentials() {
        return credentials;
    }

    public void refresh() {}

}
