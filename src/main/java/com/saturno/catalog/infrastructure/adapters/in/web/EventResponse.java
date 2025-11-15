package com.saturno.catalog.infrastructure.adapters.in.web;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.UUID;

@Schema(name = "EventResponse")
public record EventResponse(
        UUID id,
        String venueId,
        String name,
        String description,
        int capacity,
        Instant startAt,
        Instant endAt,
        String status,
        String visibility,
        String category
) {}