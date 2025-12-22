package com.ranjana.springboot.localMVP.dto;

public record SubscriptionRequest(
        String city,
        Integer minPrice,
        Integer maxPrice,
        Integer minBedrooms
) {}
