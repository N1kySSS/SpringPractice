package com.gym.repositories;

public interface BaseRepository<T, KeyType> {
    void save(T entity);
}
