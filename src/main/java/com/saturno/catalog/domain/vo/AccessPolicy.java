package com.saturno.catalog.domain.vo;

public sealed interface AccessPolicy permits PublicAccess, PrivateAccess {}

