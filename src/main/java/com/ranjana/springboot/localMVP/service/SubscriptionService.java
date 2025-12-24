package com.ranjana.springboot.localMVP.service;

import com.ranjana.springboot.localMVP.domain.Subscription;
import com.ranjana.springboot.localMVP.dto.SubscriptionRequest;
import com.ranjana.springboot.localMVP.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private final SubscriptionRepository repository;

    public SubscriptionService(SubscriptionRepository repository) {
        this.repository = repository;
    }

    public Subscription create(SubscriptionRequest request) {
        Subscription s = new Subscription();
        s.setCity(request.getCity());
        s.setMinPrice(request.getMinPrice());
        s.setMaxPrice(request.getMaxPrice());
        s.setMinBedrooms(request.getMinBedrooms());

        return repository.save(s);
    }

    public Subscription get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
    }
}
