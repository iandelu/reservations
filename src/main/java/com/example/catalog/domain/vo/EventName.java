package com.example.catalog.domain.vo;

public record EventName(String value) {
    public EventName {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("EventName value cannot be null or blank");
        if (value.length() > 140) throw new IllegalArgumentException("Name cannot be longer than 140 chars");
    }
}
