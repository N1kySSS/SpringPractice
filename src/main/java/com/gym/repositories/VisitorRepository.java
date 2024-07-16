package com.gym.repositories;

import com.gym.entities.Visitor;
import org.springframework.stereotype.Component;

@Component
public interface VisitorRepository {
    Visitor findByEmail(String email);

    void save(Visitor visitor);
}
