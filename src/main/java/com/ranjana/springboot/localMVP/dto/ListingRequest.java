package com.ranjana.springboot.localMVP.dto;

public record ListingRequest(
        String city,
        Integer price,
        Integer bedrooms
) {}
