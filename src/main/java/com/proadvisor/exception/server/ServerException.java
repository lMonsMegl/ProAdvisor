package com.proadvisor.exception.server;

import com.proadvisor.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class ServerException extends ApplicationException {
    
    public ServerException(HttpStatus status, Integer code, String message, String details) {
        super(status, code, message, details);
    }
    
    public ServerException(HttpStatus status, Integer code, String message, Throwable cause) {
        super(status, code, message, cause);
    }
    
    public ServerException(HttpStatus status, Integer code, String message, String details, Throwable cause) {
        super(status, code, message, details, cause);
    }
}
