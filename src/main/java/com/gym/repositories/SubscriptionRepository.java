package com.gym.repositories;

import com.gym.entities.Subscription;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository {

    void add(Subscription subscription);
}
