package com.gym.services.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImplementation {
    @PersistenceContext
    protected EntityManager entityManager;
}