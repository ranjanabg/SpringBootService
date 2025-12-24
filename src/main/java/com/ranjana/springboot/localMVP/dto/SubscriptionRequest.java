package com.ranjana.springboot.localMVP.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SubscriptionRequest {

    @NotBlank(message = "City is required")
    private String city;

    @NotNull(message = "Minimum price is required")
    @Min(value = 0, message = "minPrice must be >= 0")
    private Integer minPrice;

    @NotNull(message = "Maximum price is required")
    @Min(value = 0, message = "maxPrice must be >= 0")
    private Integer maxPrice;

    @NotNull(message = "Minimum bedrooms is required")
    @Min(value = 0, message = "minBedrooms must be >= 0")
    private Integer minBedrooms;

    // Default constructor
    public SubscriptionRequest() {}

    // Getters & setters
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public Integer getMinPrice() { return minPrice; }
    public void setMinPrice(Integer minPrice) { this.minPrice = minPrice; }

    public Integer getMaxPrice() { return maxPrice; }
    public void setMaxPrice(Integer maxPrice) { this.maxPrice = maxPrice; }

    public Integer getMinBedrooms() { return minBedrooms; }
    public void setMinBedrooms(Integer minBedrooms) { this.minBedrooms = minBedrooms; }
}
