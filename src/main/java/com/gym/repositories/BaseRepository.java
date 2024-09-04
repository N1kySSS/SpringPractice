package com.gym.repositories;

public interface BaseRepository<T, KeyType> {
    void save(T entity);

    T findById(Class<T> entity, KeyType id);
}
