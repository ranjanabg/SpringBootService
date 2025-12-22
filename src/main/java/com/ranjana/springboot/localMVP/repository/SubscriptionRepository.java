package com.ranjana.springboot.localMVP.repository;

import com.ranjana.springboot.localMVP.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository
        extends JpaRepository<Subscription, Long> {
}
