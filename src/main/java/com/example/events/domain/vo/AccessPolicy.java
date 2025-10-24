package com.example.events.domain.vo;

public sealed interface AccessPolicy permits PublicAccess, PrivateAccess {}

