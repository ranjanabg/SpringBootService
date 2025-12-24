package com.ranjana.springboot.localMVP.controller;

import com.ranjana.springboot.localMVP.domain.Subscription;
import com.ranjana.springboot.localMVP.dto.SubscriptionRequest;
import com.ranjana.springboot.localMVP.service.SubscriptionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Subscription> create(
            @Valid @RequestBody SubscriptionRequest request) {
        // service.create now uses getters from DTO
        Subscription saved = service.create(request);
        // Return 201 Created with saved subscription
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
