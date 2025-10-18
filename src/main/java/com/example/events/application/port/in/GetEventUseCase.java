package com.example.events.application.port.in;

import com.example.events.domain.model.Event;

import java.util.Optional;
import java.util.UUID;

public interface GetEventUseCase {
    Optional<Event> byId(UUID id);
}
