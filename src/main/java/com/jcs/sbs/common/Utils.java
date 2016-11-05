package com.jcs.sbs.common;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jcs.sbs.model.ProtocolAndHost;

/**
 * Class containing some utility methods that are used internally.
 *
 */
public class Utils {

	/**
	 * This method finds protocol and host for given url.
	 * 
	 * @param url The url from which protocol and host are to be found
	 * @return ProtocolAndHost object.
	 */
	public static ProtocolAndHost getProtocolAndHost(String url){
		ProtocolAndHost protocolAndHost = new ProtocolAndHost();
		Pattern r = Pattern.compile(Constants.PROTOCOL_AND_HOST_REGEX);
		Matcher url_parts = r.matcher(url);
		if(!url_parts.find()){
			protocolAndHost.setProtocol("");
			protocolAndHost.setHost("");
		}
		else{
			protocolAndHost.setProtocol(url_parts.group(1));
			protocolAndHost.setHost(url_parts.group(2));
		}
		return protocolAndHost;
	}
	
	
}
