package com.ranjana.springboot.localMVP.service;

import com.ranjana.springboot.localMVP.domain.Listing;
import com.ranjana.springboot.localMVP.domain.Subscription;

public class ListingMatcher {

    public boolean matches(Subscription subscription, Listing listing) {

        if (!subscription.getCity().equals(listing.getCity())) {
            return false;
        }

        if (listing.getPrice() < subscription.getMinPrice()
                || listing.getPrice() > subscription.getMaxPrice()) {
            return false;
        }

        if (listing.getBedrooms() < subscription.getMinBedrooms()) {
            return false;
        }

        return true;
    }
}
