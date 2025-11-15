package com.saturno.catalog.infrastructure.adapters.out.jpa;

import com.saturno.catalog.domain.model.Event;
import com.saturno.catalog.domain.model.EventCategory;
import com.saturno.catalog.domain.model.EventStatus;
import com.saturno.catalog.domain.model.EventVisibility;
import com.saturno.catalog.domain.vo.*;
import com.saturno.catalog.infrastructure.adapters.out.jpa.entity.EventEntity;

public class EventMapper {

    public static Event toModelFrom(EventEntity entity){

        TimeSlot slot = new TimeSlot(entity.getStartAt(), entity.getEndAt());
        AccessPolicy accessPolicy = new PublicAccess();
        if (entity.getPassword() != null) accessPolicy = new PrivateAccess(entity.getPassword());

        return Event.recreateExisting(
                new EventId(entity.getId()),
                new VenueId(entity.getVenueId()),
                new EventName(entity.getName()),
                new EventDescription(entity.getDescription()),
                new Capacity(entity.getCapacity()),
                slot,
                EventStatus.valueOf(entity.getStatus()),
                EventVisibility.valueOf(entity.getVisibility()),
                EventCategory.valueOf(entity.getCategory()),
                accessPolicy
        );
    }

    public static EventEntity toEntityFrom(Event event){
        var entity = new EventEntity();
        entity.setId(event.getEventId().value());
        entity.setVenueId(event.getVenueId().value());
        entity.setName(event.getName().value());
        entity.setDescription(event.getDescription().value());
        entity.setCapacity(event.getCapacity().value());
        entity.setStartAt(event.getTimeSlot().start());
        entity.setEndAt(event.getTimeSlot().end());
        entity.setStatus(event.getStatus().name());
        entity.setVisibility(event.getVisibility().name());
        entity.setCategory(event.getCategory().name());

        if (event.getAccessPolicy() instanceof PrivateAccess privateAccess) {
            entity.setPassword(privateAccess.passwordHash());
        } else {
            entity.setPassword(null);
        }

        return  entity;
    }
}
