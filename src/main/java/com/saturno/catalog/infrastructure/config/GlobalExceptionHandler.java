package com.saturno.catalog.infrastructure.config;

import com.saturno.catalog.domain.error.exceptions.TimeOverlapsException;
import com.saturno.catalog.infrastructure.adapters.in.web.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(TimeOverlapsException ex){
        ErrorResponse errorDetails = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }
}
