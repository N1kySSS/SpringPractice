package com.gym.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;

public abstract class DefaultRepository<T extends Repository<?, ?>> {

    @Autowired
    protected T defaultRepository;
}
