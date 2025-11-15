package com.saturno.catalog.domain.vo;

import java.util.UUID;

public record TierId(UUID value) {
    public TierId {
        if (value == null) throw new IllegalArgumentException("TierId null");
    }
}