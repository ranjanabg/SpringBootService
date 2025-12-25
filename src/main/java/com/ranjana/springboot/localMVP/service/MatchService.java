package com.ranjana.springboot.localMVP.service;

import com.ranjana.springboot.localMVP.domain.Listing;
import com.ranjana.springboot.localMVP.domain.Subscription;
import com.ranjana.springboot.localMVP.dto.ListingResponse;
import com.ranjana.springboot.localMVP.repository.ListingRepository;
import com.ranjana.springboot.localMVP.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final SubscriptionRepository subscriptionRepository;
    private final ListingRepository listingRepository;

    public MatchService(SubscriptionRepository subscriptionRepository,
                        ListingRepository listingRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.listingRepository = listingRepository;
    }

    public List<ListingResponse> findMatches(Long subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        return listingRepository.findAll().stream()
                .filter(listing -> listing.getCity().equals(subscription.getCity()))
                .filter(listing -> listing.getPrice() >= subscription.getMinPrice()
                        && listing.getPrice() <= subscription.getMaxPrice())
                .filter(listing -> listing.getBedrooms() >= subscription.getMinBedrooms())
                .map(listing -> new ListingResponse(
                        listing.getId(),
                        listing.getCity(),
                        listing.getPrice(),
                        listing.getBedrooms()
                ))
                .collect(Collectors.toList());
    }
}
