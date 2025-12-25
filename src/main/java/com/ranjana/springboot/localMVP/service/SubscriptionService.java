package com.ranjana.springboot.localMVP.service;

import com.ranjana.springboot.localMVP.domain.Subscription;
import com.ranjana.springboot.localMVP.dto.SubscriptionRequest;
import com.ranjana.springboot.localMVP.dto.SubscriptionResponse;
import com.ranjana.springboot.localMVP.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    private final SubscriptionRepository repository;

    public SubscriptionService(SubscriptionRepository repository) {
        this.repository = repository;
    }

    public SubscriptionResponse create(SubscriptionRequest request) {
        Subscription s = new Subscription();
        s.setCity(request.getCity());
        s.setMinPrice(request.getMinPrice());
        s.setMaxPrice(request.getMaxPrice());
        s.setMinBedrooms(request.getMinBedrooms());

        Subscription saved = repository.save(s);
        return mapToDto(saved);
    }

    public List<SubscriptionResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private SubscriptionResponse mapToDto(Subscription s) {
        return new SubscriptionResponse(
                s.getId(),
                s.getCity(),
                s.getMinPrice(),
                s.getMaxPrice(),
                s.getMinBedrooms()
        );
    }
}
