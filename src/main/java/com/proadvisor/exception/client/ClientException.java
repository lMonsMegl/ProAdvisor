package com.proadvisor.exception.client;

import com.proadvisor.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public abstract class ClientException extends ApplicationException {
    
    public ClientException(HttpStatus status, Integer code, String message, String details) {
        super(status, code, message, details);
    }
    
    public ClientException(HttpStatus status, Integer code, String message, Throwable cause) {
        super(status, code, message, cause);
    }
    
    public ClientException(HttpStatus status, Integer code, String message, String details, Throwable cause) {
        super(status, code, message, details, cause);
    }
}
