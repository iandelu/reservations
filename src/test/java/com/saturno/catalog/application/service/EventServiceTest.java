package com.saturno.catalog.application.service;

import com.saturno.catalog.application.port.in.CreateEventCommand;
import com.saturno.catalog.domain.error.exceptions.TimeOverlapsException;
import com.saturno.catalog.domain.repo.EventRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
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

        var cmd = new CreateEventCommand(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                "Concert",
                "Music concert",
                100,
                Instant.now().plusSeconds(3600),
                Instant.now().plusSeconds(7200)
        );


        UUID id = service.create(cmd);
        assert(id != null);
        assert (id.toString().equals(cmd.eventId()));
        verify(repo, times(1)).save(any());

    }

    @Test
    void shouldThrowWhenTimeOverlaps(){
        when(repo.overlapsAtVenue(any(), any())).thenReturn(true);

        var cmd = new CreateEventCommand(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                "Concert",
                "Music concert",
                100,
                Instant.now().plusSeconds(3600),
                Instant.now().plusSeconds(7200)
        );

        assertThrows(TimeOverlapsException.class, () -> service.create(cmd));
        verify(repo, never()).save(any());
    }




}