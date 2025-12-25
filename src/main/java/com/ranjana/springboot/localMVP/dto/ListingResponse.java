package com.ranjana.springboot.localMVP.dto;

public class ListingResponse {

    private final Long id;
    private final String city;
    private final Integer price;
    private final Integer bedrooms;

    public ListingResponse(Long id, String city, Integer price, Integer bedrooms) {
        this.id = id;
        this.city = city;
        this.price = price;
        this.bedrooms = bedrooms;
    }

    // Getters
    public Long getId() { return id; }
    public String getCity() { return city; }
    public Integer getPrice() { return price; }
    public Integer getBedrooms() { return bedrooms; }
}
