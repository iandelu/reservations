package com.example.events.application.service;

import com.example.events.application.port.in.CreateEventCommand;
import com.example.events.application.port.in.CreateEventUseCase;
import com.example.events.application.port.in.GetEventUseCase;
import com.example.events.application.port.out.EventRepositoryPort;
import com.example.events.domain.model.Event;
import com.example.events.domain.model.EventStatus;
import com.example.events.domain.vo.*;

import java.util.Optional;
import java.util.UUID;

public final class EventService implements CreateEventUseCase, GetEventUseCase {

    private final EventRepositoryPort repo;

    public EventService(EventRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public UUID create(CreateEventCommand cmd) {
        var timeSlot = new TimeSlot(cmd.start(), cmd.end());
        var venueId = new VenueId(cmd.venueId());
        if (repo.overlapsAtVenue(venueId, timeSlot)) throw new IllegalStateException("Time Overlap with other event for the same venue");
        var event = new Event(new EventId(UUID.randomUUID()),
                new EventName(cmd.name()), new Capacity(cmd.capacity()), timeSlot, venueId, EventStatus.DRAFT);
        repo.save(event);
        return event.id();
    }

    @Override
    public Optional<Event> byId(UUID id) {
        return repo.findById(id);
    }
}
