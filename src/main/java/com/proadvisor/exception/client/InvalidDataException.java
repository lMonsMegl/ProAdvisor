package com.proadvisor.exception.client;

import org.springframework.http.HttpStatus;

public final class InvalidDataException extends ClientException {
    
    private static final HttpStatus STATUS = HttpStatus.UNPROCESSABLE_ENTITY;
    
    private static final Integer CODE = 422;
    
    private static final String MESSAGE = "Unprocessable entity";
    
    public InvalidDataException(final String details) {
        super(STATUS, CODE, MESSAGE, details);
    }
}
