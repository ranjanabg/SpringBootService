package com.ranjana.springboot.localMVP.controller;

import com.ranjana.springboot.localMVP.domain.Listing;
import com.ranjana.springboot.localMVP.dto.ListingRequest;
import com.ranjana.springboot.localMVP.repository.ListingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listings")
public class ListingController {

    private final ListingRepository repository;

    public ListingController(ListingRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ListingRequest request) {
        Listing l = new Listing();
        l.setCity(request.city());
        l.setPrice(request.price());
        l.setBedrooms(request.bedrooms());
        return ResponseEntity.ok(repository.save(l));
    }
}
