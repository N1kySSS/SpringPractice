package com.gym.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class BaseRepository<EntityType, EntityPrimaryKeyType> {
    private JpaRepository<EntityType, EntityPrimaryKeyType> genericRepository;

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<EntityType> entityTypeClass;

    @Transactional
    public void save(EntityType entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public EntityType findById(Class<EntityType> entityTypeClass, Long id) {
        String jpql = "SELECT e FROM " + entityTypeClass.getSimpleName() +
                " e WHERE e.id = :id";
        TypedQuery<EntityType> query = entityManager.createQuery(jpql, entityTypeClass)
                .setParameter("id", id);

        List<EntityType> results = query.getResultList();
        if (results.isEmpty()) {
            throw new EntityNotFoundException(entityTypeClass.getSimpleName() + " with id " + id + " not found");
        } else {
            return results.get(0);
        }
    }
}
