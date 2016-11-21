package com.jcs.sbs.model;

import com.google.gson.Gson;

/**
 * This class is used internally for splitting protocol and host of a URL used
 * by the backend API.
 */
public class ProtocolAndHost {
    private String protocol;
    private String host;

    /**
     * Default constructor for ProtocolAndHost object.
     */
    public ProtocolAndHost() {
    }

    /**
     * Returns the protocol of the URL that is set.
     * 
     * @return The request protocol of the API to be called.
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Sets protocol of the URL if the URL is valid. Otherwise, sets empty
     * string in the protocol field in the object of this class.
     * 
     * @param protocol
     *            The request protocol of the API to be called.
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Returns the host of the URL if it is set.
     * 
     * @return Host or base URL of the API to be called.
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets host of the URL if the URL is valid. Otherwise, sets empty string in
     * the host field in the object of this class.
     * 
     * @param host
     *            Host or base URL of the API to be called.
     */
    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((host == null) ? 0 : host.hashCode());
        result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProtocolAndHost other = (ProtocolAndHost) obj;
        if (host == null) {
            if (other.host != null)
                return false;
        } else if (!host.equals(other.host))
            return false;
        if (protocol == null) {
            if (other.protocol != null)
                return false;
        } else if (!protocol.equals(other.protocol))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
