package com.example.catalog.application.service;

import com.example.catalog.application.port.in.CreateEventCommand;
import com.example.catalog.application.port.in.CreateEventUseCase;
import com.example.catalog.application.port.in.GetEventUseCase;
import com.example.catalog.application.port.out.EventRepositoryPort;
import com.example.catalog.domain.model.Event;
import com.example.catalog.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public final class EventService implements CreateEventUseCase, GetEventUseCase {
    private final EventRepositoryPort repo;

    public EventService(EventRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public UUID create(CreateEventCommand cmd) {
        TimeSlot slot = new TimeSlot(cmd.startAt(), cmd.endAt());
        VenueId venueId = new VenueId(UUID.fromString(cmd.venueId()));

        if (repo.overlapsAtVenue(venueId, slot)) {
            throw new IllegalStateException("Time overlap at venue");
        }

        Event event = Event.newEvent(
                new EventId(UUID.fromString(cmd.eventId())),
                venueId,
                new EventName(cmd.name()),
                new EventDescription(cmd.name()),
                new Capacity(cmd.capacity()),
                slot
        );

        repo.save(event);
        return event.id();
    }


    @Override
    public Optional<Event> byId(UUID id) {
        return repo.findById(id);
    }

}
