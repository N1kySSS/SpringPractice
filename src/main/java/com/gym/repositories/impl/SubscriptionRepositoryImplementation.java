package com.gym.repositories.impl;

import com.gym.entities.Subscription;
import com.gym.repositories.SubscriptionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class SubscriptionRepositoryImplementation extends BaseRepository<Subscription, Long> implements SubscriptionRepository {
    @Override
    public Subscription findSubscriptionByType(String type) {
        String jpql = "SELECT s FROM Subscription s WHERE s.type = :type";
        TypedQuery<Subscription> query = entityManager.createQuery(jpql, Subscription.class);
        query.setParameter("type", type);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new EntityNotFoundException("Subscription with such type does not exist");
        }
    }
}
