package com.example.BookShelf.exception.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

final public class ExceptionData {
    final private String message;
    final private HttpStatus code;
    final private LocalDateTime timestamp;

    public ExceptionData(String message, HttpStatus code)
    {
        this.message = message;
        this.code = code;
        this.timestamp = LocalDateTime.now();
    }
    public String getMessage()
    {
        return message;
    }
    public HttpStatus getCode()
    {
        return code;
    }
    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }
}
