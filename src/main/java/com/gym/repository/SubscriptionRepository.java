package com.gym.repository;

import com.gym.entity.Subscription;
import org.springframework.stereotype.Component;

@Component
public interface SubscriptionRepository {
    Subscription findSubscriptionByType(String type);
}
