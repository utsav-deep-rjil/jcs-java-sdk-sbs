package com.jcs.sbs.model;

/**
 * This class is used internally for setting protocol and host in the API
 * request.
 */
public class ProtocolAndHost {
    private String protocol;
    private String host;

    /**
     * @return The request protocol of the API to be called.
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * @param protocol
     *            The request protocol of the API to be called.
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * @return Host or base URL of the API to be called.
     */
    public String getHost() {
        return host;
    }

    /**
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
        return "ProtocolAndHost [protocol=" + protocol + ", host=" + host + "]";
    }

}
