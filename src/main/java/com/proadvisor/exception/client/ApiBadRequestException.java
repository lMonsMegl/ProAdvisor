package com.proadvisor.exception.client;

import org.springframework.http.HttpStatus;

public final class ApiBadRequestException extends ClientException {
    
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
    
    private static final Integer CODE = 400;
    
    private static final String MESSAGE = "Bad request";
    
    public ApiBadRequestException(final String details) {
        super(STATUS, CODE, MESSAGE, details);
    }
}