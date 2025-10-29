package com.example.catalog.application.port.in;

import com.example.catalog.domain.vo.TimeSlot;

import com.example.catalog.domain.vo.*;

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