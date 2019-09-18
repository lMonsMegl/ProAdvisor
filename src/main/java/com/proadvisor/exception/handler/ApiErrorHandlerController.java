package com.proadvisor.exception.handler;

import com.proadvisor.exception.ExceptionMessage;
import com.proadvisor.exception.client.ClientException;
import com.proadvisor.exception.server.ServerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiErrorHandlerController extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(ClientException.class)
    public ResponseEntity<Object> onClientError(final ClientException ex) {
        final ExceptionMessage message = new ExceptionMessage(
                LocalDateTime.now(),
                ex.getStatus(),
                ex.getMessage(),
                ex.getDetails()
        );
        
        return new ResponseEntity<>(message, new HttpHeaders(), message.getStatus());
    }
    
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<Object> onServerError(final ServerException ex) {
        final ExceptionMessage message = new ExceptionMessage(
                LocalDateTime.now(),
                ex.getStatus(),
                ex.getMessage(),
                ex.getDetails()
        );
        
        return new ResponseEntity<>(message, new HttpHeaders(), message.getStatus());
    }
    
    @ExceptionHandler({Throwable.class})
    public ResponseEntity<Object> onUnexpectedError(final Exception ex) {
        final ExceptionMessage message = new ExceptionMessage(
                LocalDateTime.now(),
                HttpStatus.EXPECTATION_FAILED,
                ex.getMessage(),
                "Something went wrong!"
        );
        
        return new ResponseEntity<>(message, new HttpHeaders(), message.getStatus());
    }
}
