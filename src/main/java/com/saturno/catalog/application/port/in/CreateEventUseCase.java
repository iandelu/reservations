package com.saturno.catalog.application.port.in;

import java.util.UUID;

public interface CreateEventUseCase {

    UUID create(CreateEventCommand cmd);
}
