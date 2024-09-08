package com.gym.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class DefaultRepository<T> {

    @Autowired
    protected T defaultRepository;
}
