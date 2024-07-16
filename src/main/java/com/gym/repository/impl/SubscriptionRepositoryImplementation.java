package com.gym.repository.impl;

import com.gym.entity.Subscription;
import com.gym.repository.SubscriptionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
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
