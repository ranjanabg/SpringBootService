package com.ranjana.springboot.localMVP.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ListingRequest {

    @NotBlank(message = "City is required")
    private String city;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be greater than 0")
    private Integer price;

    @NotNull(message = "Bedrooms is required")
    @Min(value = 0, message = "Bedrooms must be >= 0")
    private Integer bedrooms;

    // Default constructor (required for Spring)
    public ListingRequest() {}

    // Getters & setters
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public Integer getBedrooms() { return bedrooms; }
    public void setBedrooms(Integer bedrooms) { this.bedrooms = bedrooms; }
}
