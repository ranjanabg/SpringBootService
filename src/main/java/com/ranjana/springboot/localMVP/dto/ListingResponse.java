package com.ranjana.springboot.localMVP.dto;

public record ListingResponse(
        Long id,
        String city,
        Integer price,
        Integer bedrooms
) {}
