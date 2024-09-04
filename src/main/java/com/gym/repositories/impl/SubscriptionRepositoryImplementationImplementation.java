package com.gym.repositories.impl;

import com.gym.entities.Subscription;
import com.gym.repositories.SubscriptionRepository;
import jakarta.persistence.TypedQuery;

public class SubscriptionRepositoryImplementationImplementation extends BaseRepositoryImplementation<Subscription, Long> implements SubscriptionRepository {
    @Override
    public Subscription findSubscriptionByType(String type) {
        String jpql = "SELECT s FROM Subscription s WHERE s.type = :type";
        TypedQuery<Subscription> query = entityManager.createQuery(jpql, Subscription.class);
        query.setParameter("type", type);
        return query.getSingleResult();
    }
}
