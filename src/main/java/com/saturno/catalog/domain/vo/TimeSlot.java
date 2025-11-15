package com.saturno.catalog.domain.vo;

import java.time.Instant;

public record TimeSlot (Instant start, Instant end){

    public TimeSlot{
        if (start == null || end == null) throw new IllegalArgumentException("Start nor end can be null");
        if (start.isAfter(end)) throw new IllegalArgumentException("Start must be after the end");
    }

    public boolean overlap(TimeSlot other){
        return other.start.isAfter(this.start) || other.end.isBefore(this.end);
    }
}
