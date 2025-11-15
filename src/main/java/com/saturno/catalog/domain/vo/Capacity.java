package com.saturno.catalog.domain.vo;

public record Capacity(Integer value){
    public Capacity{
        if (value <= 0 ) throw new  IllegalArgumentException("Capacity must be over 0");
    }

}
