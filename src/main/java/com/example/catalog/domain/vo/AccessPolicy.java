package com.example.catalog.domain.vo;

public sealed interface AccessPolicy permits PublicAccess, PrivateAccess {}

