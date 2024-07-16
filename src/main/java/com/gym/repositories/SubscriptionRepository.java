package com.gym.repositories;

import com.gym.entities.Subscription;
import org.springframework.stereotype.Component;

@Component
public interface SubscriptionRepository {
    Subscription findSubscriptionByType(String type);
}
