package com.ranjana.springboot.localMVP.controller;

import com.ranjana.springboot.localMVP.dto.ListingRequest;
import com.ranjana.springboot.localMVP.dto.ListingResponse;
import com.ranjana.springboot.localMVP.service.ListingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {

    private final ListingService service;

    public ListingController(ListingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ListingResponse> createListing(
            @Valid @RequestBody ListingRequest request) {
        ListingResponse saved = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<ListingResponse>> getAllListings() {
        return ResponseEntity.ok(service.getAll());
    }
}