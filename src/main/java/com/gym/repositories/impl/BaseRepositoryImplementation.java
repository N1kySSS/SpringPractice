package com.gym.repositories.impl;

import com.gym.repositories.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class BaseRepositoryImplementation<T, KeyType> implements BaseRepository<T, KeyType> {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public T findById(Class<T> entity, KeyType id) {
        String jpql = "SELECT e FROM " + entity.getSimpleName() +
                " e WHERE e.id = :id";
        TypedQuery<T> query = entityManager.createQuery(jpql, entity)
                .setParameter("id", id);

        List<T> results = query.getResultList();
        if (results.isEmpty()) {
            throw new EntityNotFoundException(entity.getSimpleName() + " with id " + id + " not found");
        } else {
            return results.get(0);
        }
    }
}
