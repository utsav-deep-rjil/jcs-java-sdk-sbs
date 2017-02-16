package com.jcs.sbs.auth;

/**
 * Groups all the providers of ACCESS_KEY & SECRET_KEY
 */
public class DefaultJCSCredentialsProviderChain extends JCSCredentialsProviderChain {

    /**
     * Default constructor for DefaultJCSCredentialsProviderChain object. It
     * internally calls the constructors of classes that implements
     * {@link com.jcs.sbs.auth.JCSCredentialsProvider JCSCredentialsProvider}
     * interface.
     */
    public DefaultJCSCredentialsProviderChain() {
        super(new EnvironmentVariableCredentialsProvider(), new SystemPropertiesCredentialsProvider(),
                new ConfigPropertiesCredentialsProvider());
    }
}