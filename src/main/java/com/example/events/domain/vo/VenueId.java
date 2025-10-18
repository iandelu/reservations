package com.example.events.domain.vo;

import java.util.UUID;

public record VenueId(UUID value) {
    public VenueId {
        if (value == null) throw new IllegalArgumentException("VenueId null");
    }
}