package com.example.catalog.infrastructure.adapters.in.web;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record CreateEventRequest(

        @NotNull @Schema(example = "9a8c0d7c-6c9f-4b2e-9f2f-1e0d3d2b1a00") String eventId,
        @NotNull @Schema(example = "9a8c0d7c-6c9f-4b2e-9f2f-1e0d3d2b1a00") String venueId,
        @NotBlank @Schema(example = "Saturno: Urban Night") String name,
        @NotBlank @Schema(example = "Saturno is an event when ... end") String description,
        @NotBlank @Schema(example = "2025-12-12T21:00:00Z") Instant startAt,
        @NotBlank @Schema(example = "2025-12-13T03:00:00Z") Instant endAt,
        @Min(1)   @Schema(example = "300") int capacity
        ) {
}
