package com.saturno.catalog.infrastructure.adapters.out.jpa;

import com.saturno.catalog.domain.repo.EventRepositoryPort;
import com.saturno.catalog.domain.model.Event;
import com.saturno.catalog.domain.vo.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class EventRepositoryAdapter implements EventRepositoryPort {
    private final JpaEventRepository repo;

    public EventRepositoryAdapter(JpaEventRepository repo){this.repo = repo;}

    @Override
    public void save(Event e) {
        var db = EventMapper.toEntityFrom(e);
        repo.save(db);

    }

    @Override
    public Optional<Event> findById(UUID id) {
        return repo.findById(id).map(EventMapper::toModelFrom);
    }

    @Override
    public boolean overlapsAtVenue(VenueId venueId, TimeSlot timeSlot) {
        return repo.existsOverlap(venueId.value(), timeSlot.start(), timeSlot.end());
    }
}
