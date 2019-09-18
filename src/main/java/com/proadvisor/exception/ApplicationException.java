package com.proadvisor.exception;

import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

public abstract class ApplicationException extends Exception {
    
    private HttpStatus status;
    
    private final Integer code;
    
    private final String details;
    
    public ApplicationException(final HttpStatus status, final Integer code, final String message, final String details) {
        this(status, code, message, details, null);
    }
    
    public ApplicationException(final HttpStatus status, final Integer code, final String message, final Throwable cause) {
        this(status, code, message, null, cause);
    }
    
    public ApplicationException(final HttpStatus status, final Integer code, final String message, final String details, final Throwable cause) {
        super(message, cause);
        
        this.status = status;
        this.code = code;
        this.details = details;
    }
    
    public HttpStatus getStatus() {
        return status;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public String getDetails() {
        return details;
    }
    
    @Override
    public String toString() {
        if (details != null) {
            return MessageFormat.format("Error {0,number,#000000}. {1}: {2} -> {3}", code, getMessage(), details, status);
        } else if (getCause() != null) {
            return MessageFormat.format("Error {0,number,#000000}. {1}\n{2} -> {3}", code, getMessage(), getCause(), status);
        }
        return MessageFormat.format("Error {0,number,#000000}. {1} -> {2}", code, getMessage(), status);
    }
}

