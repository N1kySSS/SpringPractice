package com.gym.repositories;

import com.gym.entities.Visitor;

public interface VisitorRepository {
    Visitor findByEmail(String email);

    Visitor findById(Long id);

    void save(Visitor visitor);

    void update(Visitor visitor);
}
