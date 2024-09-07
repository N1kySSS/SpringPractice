package com.gym.repositories.impl;

import com.gym.entities.Subscription;
import com.gym.repositories.BaseSubscriptionRepository;
import com.gym.repositories.SubscriptionRepository;

public class SubscriptionRepositoryImplementation extends DefaultRepository<BaseSubscriptionRepository> implements SubscriptionRepository {

    @Override
    public void add(Subscription subscription) {
        defaultRepository.save(subscription);
    }
}
