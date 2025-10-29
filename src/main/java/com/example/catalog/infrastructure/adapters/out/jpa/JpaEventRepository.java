package com.example.catalog.infrastructure.adapters.out.jpa;

import com.example.catalog.infrastructure.adapters.out.jpa.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.UUID;

interface JpaEventRepository extends JpaRepository<EventEntity, UUID> {

    @Query("""
      SELECT CASE WHEN COUNT(e)>0 THEN true ELSE false END
      FROM EventEntity e
      WHERE e.venueId = :venueId
        AND e.startAt < :newEnd
        AND e.endAt   > :newStart
    """)
    boolean existsOverlap(UUID venueId, Instant newStart, Instant newEnd);
}
