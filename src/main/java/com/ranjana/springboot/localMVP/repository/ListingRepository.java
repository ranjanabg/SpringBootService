package com.ranjana.springboot.localMVP.repository;

import com.ranjana.springboot.localMVP.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListingRepository
        extends JpaRepository<Listing, Long> {

    @Query("""
       SELECT l FROM Listing l
       WHERE l.city = :city
         AND l.price BETWEEN :minPrice AND :maxPrice
         AND l.bedrooms >= :minBedrooms
    """)
    List<Listing> findMatches(
            String city,
            Integer minPrice,
            Integer maxPrice,
            Integer minBedrooms
    );
}
