package com.gym.repositories.impl;

import com.gym.repositories.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseRepositoryImplementation<T, KeyType> implements BaseRepository<T, KeyType> {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }
}
