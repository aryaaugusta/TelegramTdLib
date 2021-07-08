package com.edts.tdlib.exception;

/**
 * {@link Exception} that will be thrown when validation fails.
 */
public class BadRequestException extends RuntimeException {
    /**
     * Constructor for {@link BadRequestException}.
     *
     * @param message message of the exception
     */
    public BadRequestException(String message) {
        super(message);
    }

    /**
     * Constructor for {@link BadRequestException}.
     *
     * @param message message of the exception
     * @param cause   the cause exception
     */
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
