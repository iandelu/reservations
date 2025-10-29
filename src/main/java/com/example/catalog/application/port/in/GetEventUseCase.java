package com.example.catalog.application.port.in;

import com.example.catalog.domain.model.Event;

import java.util.Optional;
import java.util.UUID;

public interface GetEventUseCase {
    Optional<Event> byId(UUID id);
}
