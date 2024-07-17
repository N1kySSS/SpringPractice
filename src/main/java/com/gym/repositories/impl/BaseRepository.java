package com.gym.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.metamodel.EntityType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    public EntityType findById(EntityPrimaryKeyType id) {
        Optional<EntityType> optionalEntity = genericRepository.findById(id);
        return optionalEntity.orElse(null);
    }
}
