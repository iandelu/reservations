package com.example.events.application.port.in;

import java.time.Instant;
import java.util.UUID;

public record CreateEventCommand(
        String name, UUID venueId, Instant start, Instant end, int capacity) {}
