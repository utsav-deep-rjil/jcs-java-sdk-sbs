package com.jcs.sbs.common;

/**
 * Contains some constants (final variables) that are used internally
 * in the SDK
 */
public class Constants {

    
    private Constants() {}
    
    /**
     * Regex used internally for separating Protocol and Host from the given URL
     */
    public final static String PROTOCOL_AND_HOST_REGEX = "(http[s]?)://((?:[a-zA-Z]|[0-9]|[$-_@.&+]|[!*(),]|(?:%[0-9a-fA-F][0-9a-fA-F]))+)";
    
    /**
     * Name of config properties file that is located in src/java/resources folder (i.e., classpath resources folder) 
     */
    public final static String PROPERTIES_FILE_NAME = "config.properties";

}
