package com.saturno.catalog.application.port.in;

import com.saturno.catalog.domain.vo.EventId;

public record GetEventQuery(EventId eventId) { }
