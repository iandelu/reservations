package com.example.catalog.domain.vo;

import java.util.UUID;

public record EventId(UUID value) {
    public EventId {
        if (value == null) {
            throw new IllegalArgumentException("EventId value cannot be null");
        }
    }
}
