package com.jcs.sbs.auth;

import com.jcs.sbs.exceptions.PropertyNotFoundException;
/**
 * Interface for providing JCS credentials.
 */
public interface JCSCredentialsProvider {

    /**
     * Returns {@link com.jcs.sbs.auth.JCSCredentials JCSCredentials} which the
     * caller can use to authorize a JCS request. Each implementation of
     * JCSCredentialsProvider can chose its own strategy for loading
     * credentials. For example, an implementation might load credentials from
     * an existing key management system, or load new credentials when
     * credentials are rotated.
     *
     * @return {@link com.jcs.sbs.auth.JCSCredentials JCSCredentials} which the
     *         caller can use to authorize a JCS request.
     * @throws PropertyNotFoundException
     */
    public JCSCredentials getCredentials() throws PropertyNotFoundException;

    /**
     * Forces this credentials provider to refresh its credentials. For many
     * implementations of credentials provider, this method may simply be a
     * no-op, such as any credentials provider implementation that vends
     * static/non-changing credentials. For other implementations that vend
     * different credentials through out their lifetime, this method should
     * force the credentials provider to refresh its credentials.
     */
    public void refresh();

}