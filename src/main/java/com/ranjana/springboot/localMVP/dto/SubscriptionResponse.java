package com.ranjana.springboot.localMVP.dto;

public class SubscriptionResponse {

    private final Long id;
    private final String city;
    private final Integer minPrice;
    private final Integer maxPrice;
    private final Integer minBedrooms;

    public SubscriptionResponse(Long id, String city, Integer minPrice, Integer maxPrice, Integer minBedrooms) {
        this.id = id;
        this.city = city;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minBedrooms = minBedrooms;
    }

    // Getters
    public Long getId() { return id; }
    public String getCity() { return city; }
    public Integer getMinPrice() { return minPrice; }
    public Integer getMaxPrice() { return maxPrice; }
    public Integer getMinBedrooms() { return minBedrooms; }
}
