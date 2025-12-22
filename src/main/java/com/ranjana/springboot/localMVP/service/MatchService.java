package com.ranjana.springboot.localMVP.service;

import com.ranjana.springboot.localMVP.domain.Subscription;
import com.ranjana.springboot.localMVP.dto.MatchResponse;
import com.ranjana.springboot.localMVP.repository.ListingRepository;
import com.ranjana.springboot.localMVP.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final SubscriptionRepository subscriptionRepo;
    private final ListingRepository listingRepo;

    public MatchService(SubscriptionRepository s, ListingRepository l) {
        this.subscriptionRepo = s;
        this.listingRepo = l;
    }

    public List<MatchResponse> findMatches(Long subscriptionId) {
        Subscription s = subscriptionRepo.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        return listingRepo.findMatches(
                        s.getCity(),
                        s.getMinPrice(),
                        s.getMaxPrice(),
                        s.getMinBedrooms()
                ).stream()
                .map(l -> new MatchResponse(
                        l.getId(),
                        l.getCity(),
                        l.getPrice(),
                        l.getBedrooms()
                ))
                .toList();
    }
}
