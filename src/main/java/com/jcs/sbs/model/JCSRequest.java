package com.jcs.sbs.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.annotation.NotThreadSafe;

import com.google.gson.Gson;
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
     * Returns a map of custom headers (if any) that are set for the request.
     * 
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
     * 
     * @return String representation of the object.
     */
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    /**
     * Returns hashCode value for object of this class.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customRequestHeaders == null) ? 0 : customRequestHeaders.hashCode());
        return result;
    }

    /**
     * Returns true if another object is same as object of this class, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JCSRequest other = (JCSRequest) obj;
        if (customRequestHeaders == null) {
            if (other.customRequestHeaders != null)
                return false;
        } else if (!customRequestHeaders.equals(other.customRequestHeaders))
            return false;
        return true;
    }
    
    

}
