package com.ranjana.springboot.localMVP.controller;

import com.ranjana.springboot.localMVP.dto.SubscriptionRequest;
import com.ranjana.springboot.localMVP.service.SubscriptionService;
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
    public ResponseEntity<?> create(@RequestBody SubscriptionRequest request) {
        return ResponseEntity.ok(service.create(request));
    }
}
