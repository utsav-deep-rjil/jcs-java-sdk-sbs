package com.jcs.sbs.exceptions;

/**
 * This exception is thrown when a particular property is not found. 
 *
 */
public class PropertyNotFoundException extends Exception {

    private static final long serialVersionUID = 4160231393580268199L;

    public PropertyNotFoundException() {
    }

    public PropertyNotFoundException(String message) {
        super(message);
    }

    public PropertyNotFoundException(Throwable cause) {
        super(cause);
    }

    public PropertyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
