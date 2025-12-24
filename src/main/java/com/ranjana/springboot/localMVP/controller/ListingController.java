package com.ranjana.springboot.localMVP.controller;

import com.ranjana.springboot.localMVP.domain.Listing;
import com.ranjana.springboot.localMVP.dto.ListingResponse;
import com.ranjana.springboot.localMVP.service.ListingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {

    private final ListingService listingService;

    // Constructor injection (Spring will inject ListingService)
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    // POST /listings → create a new listing
    @PostMapping
    public ResponseEntity<ListingResponse> createListing(@Valid @RequestBody Listing listing) {
        ListingResponse savedListing = listingService.saveListing(listing);
        return ResponseEntity.status(201).body(savedListing);
    }

    // GET /listings → fetch all listings
    @GetMapping
    public ResponseEntity<List<ListingResponse>> getAllListings() {
        List<ListingResponse> listings = listingService.getAllListings();
        return ResponseEntity.ok(listings);
    }
}