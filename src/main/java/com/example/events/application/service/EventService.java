package com.example.events.application.service;

import com.example.events.application.port.in.CreateEventCommand;
import com.example.events.application.port.in.CreateEventUseCase;
import com.example.events.application.port.in.GetEventUseCase;
import com.example.events.application.port.out.EventRepositoryPort;
import com.example.events.domain.model.Event;
import com.example.events.domain.vo.TimeSlot;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public final class EventService implements CreateEventUseCase, GetEventUseCase {

    private final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
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
        event = repo.save(event);
        return event.id();
    }


    @Override
    public Optional<Event> byId(UUID id) {
        return repo.findById(id);
    }


    private Instant converStringDateToInstant(String date) throws ParseException {
        return new SimpleDateFormat(DATE_FORMAT).parse(date).toInstant();
    }

}
