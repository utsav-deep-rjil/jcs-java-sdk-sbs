package com.jcs.sbs.auth;

/**
 * Groups all the providers of ACCESS_KEY & SECRET_KEY
 *
 */
public class DefaultJCSCredentialsProviderChain extends JCSCredentialsProviderChain {

    public DefaultJCSCredentialsProviderChain() {
        super(new EnvironmentVariableCredentialsProvider(), new SystemPropertiesCredentialsProvider(),
                new ConfigPropertiesCredentialsProvider());
    }
}