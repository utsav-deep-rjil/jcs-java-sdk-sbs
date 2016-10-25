package com.jcs.sbs.common;

import java.util.regex.*;

import com.jcs.sbs.model.ProtocolAndHost;

/**
 * Class containing some utility methods that are used internally.
 *
 */
public class Utils {

    /**
     * This method finds protocol and host for given url.
     * 
     * @param url
     *            The url from which protocol and host are to be found
     * @return ProtocolAndHost object.
     */
    public static ProtocolAndHost getProtocolAndHost(String url) {
        ProtocolAndHost protocolAndHost = new ProtocolAndHost();
        Pattern r = Pattern.compile("(http[s]?)://((?:[a-zA-Z]|[0-9]|[$-_@.&+]|[!*(),]|(?:%[0-9a-fA-F][0-9a-fA-F]))+)");
        Matcher url_parts = r.matcher(url);
        if (!url_parts.find()) {
            protocolAndHost.setProtocol("");
            protocolAndHost.setHost("");
        } else {
            protocolAndHost.setProtocol(url_parts.group(1));
            protocolAndHost.setHost(url_parts.group(2));
        }
        return protocolAndHost;
    }

    /**
     * This method checks if the given string value is null or empty.
     * 
     * @param value
     *            The string value that is to be tested
     * @return Boolean value. True if string is null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(String value) {
        if (value == null) {
            return true;
        }
        return value.isEmpty();
    }
}
