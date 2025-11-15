package com.saturno.catalog.application.port.in;

import java.time.Instant;

public record CreateEventCommand(
        String eventId,
        String venueId,
        String name,
        String description,
        int capacity,
        Instant startAt,
        Instant endAt
) {}