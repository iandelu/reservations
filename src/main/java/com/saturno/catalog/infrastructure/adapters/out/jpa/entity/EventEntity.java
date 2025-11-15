package com.saturno.catalog.infrastructure.adapters.out.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity @Table(name = "events")
@Data @NoArgsConstructor
public class EventEntity {
    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID venueId;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 10000)
    private String description;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private Instant startAt;

    @Column(nullable = false)
    private Instant endAt;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String visibility;

    @Column(nullable = false)
    private String category;
    
    private String password;
}
