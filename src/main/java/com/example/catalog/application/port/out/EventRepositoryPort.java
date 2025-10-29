package com.example.catalog.application.port.out;

import com.example.catalog.domain.model.Event;
import com.example.catalog.domain.vo.TimeSlot;
import com.example.catalog.domain.vo.VenueId;

import java.util.Optional;
import java.util.UUID;

public interface EventRepositoryPort {

    boolean overlapsAtVenue(VenueId venueId, TimeSlot timeSlot);
    void save(Event event);
    Optional<Event> findById(UUID id);
}
