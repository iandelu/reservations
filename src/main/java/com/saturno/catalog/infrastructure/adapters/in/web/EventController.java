package com.saturno.catalog.infrastructure.adapters.in.web;

import com.saturno.catalog.application.port.in.CreateEventCommand;
import com.saturno.catalog.application.port.in.CreateEventUseCase;
import com.saturno.catalog.application.port.in.GetEventUseCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/event")
public class EventController {
    private final CreateEventUseCase createEventUseCase;
    private final GetEventUseCase getEventUseCase;

    public EventController(CreateEventUseCase createEventUseCase, GetEventUseCase getEventUseCase) {
        this.createEventUseCase = createEventUseCase;
        this.getEventUseCase = getEventUseCase;
    }

    @Operation(summary = "Create a new event")
    @PostMapping
    public ResponseEntity<UUID> create(@Valid @RequestBody CreateEventRequest dto){
        CreateEventCommand cmd = new CreateEventCommand(
            dto.eventId(),
            dto.venueId(),
            dto.name(),
            dto.description(),
            dto.capacity(),
            dto.startAt(),
            dto.endAt()
        );

        return ResponseEntity.ok().body(createEventUseCase.create(cmd));
    }
}
