package com.ranjana.springboot.localMVP.dto;

public record MatchResponse(
        Long listingId,
        String city,
        Integer price,
        Integer bedrooms
) {}
