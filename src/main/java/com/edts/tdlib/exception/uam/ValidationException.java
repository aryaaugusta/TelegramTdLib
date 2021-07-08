package com.edts.tdlib.exception.uam;

/**
 * {@link Exception} that will be thrown when validation fails.
 */
public class ValidationException extends RuntimeException {
    /**
     * Constructor for ValidationException.
     *
     * @param message  message of the exception
     */
    public ValidationException(String message) {
        super(message);
    }
}
