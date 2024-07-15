package com.gym.repository;

import com.gym.entity.Subscription;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository {
    Subscription findSubscriptionByType(String type);
}
