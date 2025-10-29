package com.example.catalog.application.service;

import com.example.catalog.application.port.in.CreateEventCommand;
import com.example.catalog.application.port.out.EventRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    private EventRepositoryPort repo;

    @InjectMocks
    private EventService service;

    @Test
    void shouldCreateAnEventWithDataIsCorrect(){
        when(repo.overlapsAtVenue(any(), any())).thenReturn(false);

        var cmd = new CreateEventCommand("name", UUID.fromString("1f9d07bb-5d2a-43a8-860a-6b93348af1ea"),
                Instant.now(), Instant.now().plusSeconds(6000), 300);
        service.create(cmd);
        verify(repo, times(1)).save(any());

    }

    @Test
    void shouldFailWhenTimeSlotIsOverlap(){
        when(repo.overlapsAtVenue(any(), any())).thenReturn(true);

        var cmd = new CreateEventCommand("name", UUID.fromString("1f9d07bb-5d2a-43a8-860a-6b93348af1ea"),
                Instant.now(), Instant.now().plusSeconds(6000), 300);
        assertThrows( IllegalStateException.class, () ->  service.create(cmd));


    }



}