package com.enviro.assessment.grad001.sikhoqangule.exception;

/**
 * Custom exception class for handling resource not found scenarios.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
