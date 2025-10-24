package com.example.events.application.port.in;

import com.example.events.domain.vo.TimeSlot;

import com.example.events.domain.vo.*;
public record CreateEventCommand(
        EventId eventId,
        VenueId venueId,
        EventName name,
        EventDescription description,
        Capacity capacity,
        TimeSlot timeSlot
) {}