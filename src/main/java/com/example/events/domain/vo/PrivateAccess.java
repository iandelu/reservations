package com.example.events.domain.vo;

public record PrivateAccess(String passwordHash) implements AccessPolicy {
    public PrivateAccess {
        if (passwordHash == null || passwordHash.isBlank()) throw new IllegalArgumentException("Missing hash");
    }
}
