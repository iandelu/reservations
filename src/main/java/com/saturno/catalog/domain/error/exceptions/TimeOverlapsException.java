package com.saturno.catalog.domain.error.exceptions;

public class TimeOverlapsException extends RuntimeException{

    public TimeOverlapsException(String message) {
        super(message);
    }
}
