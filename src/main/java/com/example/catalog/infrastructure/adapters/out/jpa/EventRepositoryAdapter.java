package com.example.catalog.infrastructure.adapters.out.jpa;

import com.example.catalog.application.port.out.EventRepositoryPort;
import com.example.catalog.domain.model.Event;
import com.example.catalog.domain.vo.*;
import com.example.catalog.infrastructure.adapters.out.jpa.entity.EventEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class EventRepositoryAdapter implements EventRepositoryPort {

    private final JpaEventRepository repo;

    public EventRepositoryAdapter(JpaEventRepository repo){this.repo = repo;}



    @Override
    public void save(Event e) {
        var db = new EventEntity();
        db.setId(e.getEventId().value());
        db.setVenueId(e.getVenueId().value());
        db.setName(e.getName().value());
        db.setDescription(e.getDescription().value());
        db.setCapacity(e.getCapacity().value());
        db.setStartAt(e.getTimeSlot().start());
        db.setEndAt(e.getTimeSlot().end());
        db.setStatus(e.getStatus().name());
        db.setVisibility(e.getVisibility().name());
        db.setCategory(e.getCategory().name());
        repo.save(db);

    }

    @Override
    public Optional<Event> findById(UUID id) {
        return repo.findById(id).map( db ->
                Event.create(
                    new EventId(db.getId()),
                    new VenueId(db.getVenueId()),
                    new EventName(db.getName()),
                    new EventDescription(db.getDescription()),
                    new Capacity(db.getCapacity()),
                    new TimeSlot(db.getStartAt(), db.getEndAt())
                )

            );
    }

    @Override
    public boolean overlapsAtVenue(VenueId venueId, TimeSlot timeSlot) {
        return repo.existsOverlap(venueId.value(), timeSlot.start(), timeSlot.end());
    }
}
