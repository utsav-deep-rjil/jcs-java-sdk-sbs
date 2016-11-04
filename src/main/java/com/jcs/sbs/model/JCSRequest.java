package com.jcs.sbs.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.annotation.NotThreadSafe;

import com.jcs.sbs.auth.JCSCredentialsProvider;

/**
 * This class is the parent class of all the Request model classes and contains
 * the common properties: credentialsProvider and customRequestHeaders.
 */
@NotThreadSafe
public abstract class JCSRequest {

    private JCSCredentialsProvider credentialsProvider;
    private Map<String, String> customRequestHeaders;

    /**
     * Default constructor for JCSRequest object.
     */
    public JCSRequest() {
    }

    /**
     * Sets the provider class for the credentials.
     * 
     * @param credentialsProvider
     *            An object of class that implements the interface
     *            JCSCredentialsProvider.
     */
    public void setRequestCredentialsProvider(JCSCredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
    }

    /**
     * Can be used to know the request credentials provider that is currently
     * set.
     * 
     * @return An object of class that implements the interface
     *         JCSCredentialsProvider.
     */
    public JCSCredentialsProvider getRequestCredentialsProvider() {
        return credentialsProvider;
    }

    /**
     * @return The map of custom headers (if any) that are set for the request
     */
    public Map<String, String> getCustomRequestHeaders() {
        if (customRequestHeaders == null) {
            return new HashMap<String, String>();
        }
        return customRequestHeaders;
    }

    /**
     * Adds a new custom header in 'customRequestHeaders' map.
     * 
     * @param name
     *            The header name that is to be set.
     * @param value
     *            The value of the corresponding header.
     * @return the previous value associated with the <tt>header</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>header</tt>. (A
     *         <tt>null</tt> return can also indicate that the map previously
     *         associated <tt>null</tt> with <tt>header</tt>.)
     */
    public String putCustomRequestHeader(String name, String value) {
        if (customRequestHeaders == null) {
            customRequestHeaders = new HashMap<String, String>();
        }
        return customRequestHeaders.put(name, value);
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     */
    @Override
    public String toString() {
        return "JCSRequest [credentialsProvider=" + credentialsProvider + ", customRequestHeaders="
                + customRequestHeaders + "]";
    }

}
