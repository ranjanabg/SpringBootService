package com.ranjana.springboot.localMVP.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Listing {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private Integer price;
    private Integer bedrooms;

    public Listing() {
        // JPA requires this
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

}
