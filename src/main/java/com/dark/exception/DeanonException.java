package com.dark.exception;

/**
 * Date: 2020-10-11
 */
public class DeanonException extends RuntimeException {

    public DeanonException(String message) {
        super(message);
    }

    public DeanonException(Throwable cause) {
        super(cause);
    }
}
