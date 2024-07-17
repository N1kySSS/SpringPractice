package com.gym.repositories;

import com.gym.entities.Visitor;
import org.springframework.stereotype.Component;

@Component
public interface VisitorRepository {
    Visitor findByEmail(String email);

    Visitor findById(Long id);

    void save(Visitor visitor);

    void update(Visitor visitor);
}
