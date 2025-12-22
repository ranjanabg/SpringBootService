package com.ranjana.springboot.localMVP.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Subscription {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer minBedrooms;

    public Subscription() {
        // JPA requirement
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setMinBedrooms(Integer minBedrooms) {
        this.minBedrooms = minBedrooms;
    }

    // getters (used later)
    public String getCity() {
        return city;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public Integer getMinBedrooms() {
        return minBedrooms;
    }
}
