package com.ranjana.springboot.localMVP.service;

import com.ranjana.springboot.localMVP.domain.Listing;
import com.ranjana.springboot.localMVP.dto.ListingRequest;
import com.ranjana.springboot.localMVP.dto.ListingResponse;
import com.ranjana.springboot.localMVP.repository.ListingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingService {

    private final ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public ListingResponse saveListing(Listing listing) {
        Listing saved = listingRepository.save(listing);
        return mapToDto(saved);
    }

    public ListingResponse createListing(ListingRequest request) {
        Listing listing = new Listing();
        listing.setCity(request.getCity());
        listing.setPrice(request.getPrice());
        listing.setBedrooms(request.getBedrooms());

        Listing saved = listingRepository.save(listing);
        return mapToDto(saved);
    }

    public List<ListingResponse> getAllListings() {
        return listingRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private ListingResponse mapToDto(Listing listing) {
        return new ListingResponse(
                listing.getId(),
                listing.getCity(),
                listing.getPrice(),
                listing.getBedrooms()
        );
    }
}
