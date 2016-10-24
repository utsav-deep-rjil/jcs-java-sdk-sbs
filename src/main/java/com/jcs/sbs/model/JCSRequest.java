package com.jcs.sbs.model;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.annotation.NotThreadSafe;

import com.jcs.sbs.auth.JCSCredentialsProvider;


@NotThreadSafe
public abstract class JCSRequest {
	
	private JCSCredentialsProvider credentialsProvider;
	private Map<String, String> customRequestHeaders;
	
	/**
	 * @param credentialsProvider
	 */
	public void setRequestCredentialsProvider(JCSCredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
    }

    /**
     * @return
     */
    public JCSCredentialsProvider getRequestCredentialsProvider() {
        return credentialsProvider;
    }
    
    /**
     * @return
     */
    public Map<String, String> getCustomRequestHeaders() {
        if (customRequestHeaders == null) {
            return new HashMap<String, String>();
        }
        return customRequestHeaders;
    }
    
    /**
     * @param name
     * @param value
     * @return
     */
    public String putCustomRequestHeader(String name, String value) {
        if (customRequestHeaders == null) {
            customRequestHeaders = new HashMap<String, String>();
        }
        return customRequestHeaders.put(name, value);
    }

}
