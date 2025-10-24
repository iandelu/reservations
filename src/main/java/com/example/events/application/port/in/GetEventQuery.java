package com.example.events.application.port.in;

import com.example.events.domain.vo.EventId;

public record GetEventQuery(EventId eventId) { }
