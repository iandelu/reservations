package com.example.catalog.application.port.in;

import com.example.catalog.domain.vo.EventId;

public record GetEventQuery(EventId eventId) { }
