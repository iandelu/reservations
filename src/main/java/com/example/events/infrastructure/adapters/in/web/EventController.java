package com.example.events.infrastructure.adapters.in.web;

import com.example.events.application.port.in.CreateEventCommand;
import com.example.events.application.port.in.CreateEventUseCase;
import com.example.events.application.port.in.GetEventUseCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
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
    public ResponseEntity<EventResponse> create(@Valid @RequestBody CreateEventRequest dto){


    }
}
