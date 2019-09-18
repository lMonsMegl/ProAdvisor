package com.proadvisor.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionMessage {
    
    private LocalDateTime dateTime;
    
    private HttpStatus status;
    
    private String message;
    
    private String details;
    
    public ExceptionMessage(final LocalDateTime dateTime, final HttpStatus status, final String message, final String details) {
        this.dateTime = dateTime;
        this.status = status;
        this.message = message;
        this.details = details;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    public HttpStatus getStatus() {
        return status;
    }
    
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getDetails() {
        return details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
}
