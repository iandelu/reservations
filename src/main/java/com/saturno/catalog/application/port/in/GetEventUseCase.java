package com.saturno.catalog.application.port.in;

import com.saturno.catalog.domain.model.Event;

import java.util.Optional;
import java.util.UUID;

public interface GetEventUseCase {
    Optional<Event> byId(UUID id);
}
