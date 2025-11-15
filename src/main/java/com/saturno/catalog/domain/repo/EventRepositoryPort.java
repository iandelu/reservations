package com.saturno.catalog.domain.repo;

import com.saturno.catalog.domain.model.Event;
import com.saturno.catalog.domain.vo.TimeSlot;
import com.saturno.catalog.domain.vo.VenueId;

import java.util.Optional;
import java.util.UUID;

public interface EventRepositoryPort {

    boolean overlapsAtVenue(VenueId venueId, TimeSlot timeSlot);
    void save(Event event);
    Optional<Event> findById(UUID id);
}
