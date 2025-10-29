package com.example.catalog.application.port.in;

import com.example.catalog.domain.vo.TimeSlot;

import com.example.catalog.domain.vo.*;
public record CreateEventCommand(
        EventId eventId,
        VenueId venueId,
        EventName name,
        EventDescription description,
        Capacity capacity,
        TimeSlot timeSlot
) {}