package com.example.catalog.application.service;

import com.example.catalog.application.port.in.CreateEventCommand;
import com.example.catalog.application.port.in.CreateEventUseCase;
import com.example.catalog.application.port.in.GetEventUseCase;
import com.example.catalog.application.port.out.EventRepositoryPort;
import com.example.catalog.domain.model.Event;
import com.example.catalog.domain.vo.TimeSlot;
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
        TimeSlot slot = cmd.timeSlot();

        if (repo.overlapsAtVenue(cmd.venueId(), slot)) {
            throw new IllegalStateException("Time overlap at venue");
        }
        Event event = Event.create(
                cmd.eventId(),
                cmd.venueId(),
                cmd.name(),
                cmd.description(),
                cmd.capacity(),
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
