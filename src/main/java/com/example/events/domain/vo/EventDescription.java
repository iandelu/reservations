package com.example.events.domain.vo;

public record EventDescription(String value) {
    static final int MAX_SIZE = 10000;
    public EventDescription{
        if (value.length() > MAX_SIZE) throw new IllegalArgumentException("Description should be shorter than :" + MAX_SIZE);
    }
}
