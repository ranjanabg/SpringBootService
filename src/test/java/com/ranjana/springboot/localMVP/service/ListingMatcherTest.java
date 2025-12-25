package com.ranjana.springboot.localMVP.service;
import org.springframework.boot.test.context.SpringBootTest;

import com.ranjana.springboot.localMVP.domain.Listing;
import com.ranjana.springboot.localMVP.domain.Subscription;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListingMatcherTest {

    @Test
    void shouldMatchWhenAllConditionsAreSatisfied() {
        // GIVEN (input data)
        Listing listing = new Listing();
        listing.setCity("NY");
        listing.setPrice(2000);
        listing.setBedrooms(2);

        Subscription subscription = new Subscription();
        subscription.setCity("NY");
        subscription.setMinPrice(1500);
        subscription.setMaxPrice(2500);
        subscription.setMinBedrooms(1);

        ListingMatcher matcher = new ListingMatcher();

        // WHEN (action)
        boolean result = matcher.matches(subscription, listing);

        // THEN (assertion)
        assertTrue(result);
    }

    @Test
    void shouldNotMatchWhenCityDoesNotMatch() {
        // GIVEN
        Listing listing = new Listing();
        listing.setCity("NY");
        listing.setPrice(2000);
        listing.setBedrooms(2);

        Subscription subscription = new Subscription();
        subscription.setCity("SF"); // <-- only difference
        subscription.setMinPrice(1500);
        subscription.setMaxPrice(2500);
        subscription.setMinBedrooms(1);

        ListingMatcher matcher = new ListingMatcher();

        // WHEN
        boolean result = matcher.matches(subscription, listing);

        // THEN
        assertFalse(result);
    }

    @Test
    void shouldNotMatchWhenPriceIsOutOfRange() {
        // GIVEN
        Listing listing = new Listing();
        listing.setCity("NY");
        listing.setPrice(4000); // too expensive
        listing.setBedrooms(2);

        Subscription subscription = new Subscription();
        subscription.setCity("NY");
        subscription.setMinPrice(1500);
        subscription.setMaxPrice(2500);
        subscription.setMinBedrooms(1);

        ListingMatcher matcher = new ListingMatcher();

        // WHEN
        boolean result = matcher.matches(subscription, listing);

        // THEN
        assertFalse(result);
    }
}
