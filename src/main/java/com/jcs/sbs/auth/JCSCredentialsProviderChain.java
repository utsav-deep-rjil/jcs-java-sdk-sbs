package com.jcs.sbs.auth;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jcs.sbs.exceptions.PropertyNotFoundException;

/**
 * {@link com.jcs.sbs.auth.JCSCredentialsProvider JCSCredentialsProvider}
 * implementation that read credentials from available credentials providers.
 * The credential provider classes are:
 * <ul>
 * <li>{@link com.jcs.sbs.auth.ConfigPropertiesCredentialsProvider
 * ConfigPropertiesCredentialsProvider},</li>
 * <li>{@link com.jcs.sbs.auth.EnvironmentVariableCredentialsProvider
 * EnvironmentVariableCredentialsProvider} and</li>
 * <li>{@link com.jcs.sbs.auth.SystemPropertiesCredentialsProvider
 * SystemPropertiesCredentialsProvider}</li>
 * </ul>
 * 
 */
public class JCSCredentialsProviderChain implements JCSCredentialsProvider {

    private static final Log log = LogFactory.getLog(JCSCredentialsProviderChain.class);

    private final List<JCSCredentialsProvider> credentialsProviders = new LinkedList<JCSCredentialsProvider>();

    private boolean reuseLastProvider = true;
    private JCSCredentialsProvider lastUsedProvider;

    /**
     * Default constructor for creating JCSCredentialsProviderChain object.
     */
    public JCSCredentialsProviderChain() {
        super();
    }

    /**
     * Constructor for creating JCSCredentialsProviderChain object that accepts
     * list of credential provider classes.
     * 
     * @param credentialsProviders
     *            List of classes that extends
     *            {@link com.jcs.sbs.auth.JCSCredentialsProvider
     *            JCSCredentialsProvider} interface. The credential provider
     *            classes are:
     *            <ul>
     *            <li>{@link com.jcs.sbs.auth.ConfigPropertiesCredentialsProvider
     *            ConfigPropertiesCredentialsProvider},</li>
     *            <li>{@link com.jcs.sbs.auth.EnvironmentVariableCredentialsProvider
     *            EnvironmentVariableCredentialsProvider} and</li>
     *            <li>{@link com.jcs.sbs.auth.SystemPropertiesCredentialsProvider
     *            SystemPropertiesCredentialsProvider}</li>
     *            </ul>
     */
    public JCSCredentialsProviderChain(List<? extends JCSCredentialsProvider> credentialsProviders) {
        if (credentialsProviders == null || credentialsProviders.size() == 0) {
            throw new IllegalArgumentException("No credential providers specified");
        }
        this.credentialsProviders.addAll(credentialsProviders);
    }

    /**
     * 
     * @param credentialsProviders
     *            Comma separated list of available credentials providers as
     *            arguments. The credential provider classes are:
     *            <ul>
     *            <li>{@link com.jcs.sbs.auth.ConfigPropertiesCredentialsProvider
     *            ConfigPropertiesCredentialsProvider},</li>
     *            <li>{@link com.jcs.sbs.auth.EnvironmentVariableCredentialsProvider
     *            EnvironmentVariableCredentialsProvider} and</li>
     *            <li>{@link com.jcs.sbs.auth.SystemPropertiesCredentialsProvider
     *            SystemPropertiesCredentialsProvider}</li>
     *            </ul>
     */
    public JCSCredentialsProviderChain(JCSCredentialsProvider... credentialsProviders) {
        if (credentialsProviders == null || credentialsProviders.length == 0) {
            throw new IllegalArgumentException("No credential providers specified");
        }

        for (JCSCredentialsProvider provider : credentialsProviders) {
            this.credentialsProviders.add(provider);
        }
    }

    /**
     * Returns a boolean value that tells if last provider will be reused or
     * not.
     * 
     * @return A boolean value 'reuseLastProvider'. If it is true then the last
     *         credentials provider will be used.
     */
    public boolean getReuseLastProvider() {
        return reuseLastProvider;
    }

    /**
     * Sets the given boolean value <b>reuseLastProvider</b>, that tells if the
     * last provider is used or not.
     * 
     * @param reuseLastProvider
     *            A boolean value to set or unset value of reuseLastProvider
     */
    public void setReuseLastProvider(boolean reuseLastProvider) {
        this.reuseLastProvider = reuseLastProvider;
    }

    @Override
    public JCSCredentials getCredentials() throws PropertyNotFoundException {
        if (reuseLastProvider && lastUsedProvider != null) {
            return lastUsedProvider.getCredentials();
        }

        Exception exception = new Exception();
        for (JCSCredentialsProvider provider : credentialsProviders) {
            try {
                JCSCredentials credentials = provider.getCredentials();

                if (!StringUtils.isBlank(credentials.getJCSAccessKey())
                        && !StringUtils.isBlank(credentials.getJCSSecretKey())) {

                    lastUsedProvider = provider;
                    log.info("Using credentials from " + provider.toString());
                    return credentials;
                }
            } catch (Exception e) {
                // Ignore any exceptions and move onto the next provider
                exception.addSuppressed(e);
                log.warn(String.format("%s: %s", provider.toString(), e.getMessage()));
            }
        }

        throw new PropertyNotFoundException("Unable to load JCS credentials from any provider in the chain", exception);
    }

    @Override
    public void refresh() {
        for (JCSCredentialsProvider provider : credentialsProviders) {
            provider.refresh();
        }
    }

}
