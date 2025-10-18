package com.example.events.application.port.out;

import com.example.events.domain.model.Event;
import com.example.events.domain.vo.TimeSlot;
import com.example.events.domain.vo.VenueId;

import java.util.Optional;
import java.util.UUID;

public interface EventRepositoryPort {

    boolean overlapsAtVenue(VenueId venueId, TimeSlot timeSlot);
    Event save(Event event);
    Optional<Event> findById(UUID id);
}
