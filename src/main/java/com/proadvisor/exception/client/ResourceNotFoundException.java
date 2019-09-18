package com.proadvisor.exception.client;

import org.springframework.http.HttpStatus;

public final class ResourceNotFoundException extends ClientException {
    
    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;
    
    private static final Integer CODE = 404;
    
    private static final String MESSAGE = "Resource not found";
    
    public ResourceNotFoundException(final String details) {
        super(STATUS, CODE, MESSAGE, details);
    }
}
