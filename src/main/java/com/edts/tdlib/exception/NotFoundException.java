package com.edts.tdlib.exception;

/**
 * {@link Exception} that will be thrown when validation fails.
 */
public class NotFoundException extends RuntimeException {
    /**
     * Constructor for {@link NotFoundException}.
     *
     * @param message message of the exception
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor for {@link NotFoundException}.
     *
     * @param message message of the exception
     * @param cause   the cause exception
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
