package com.gym.repository;

import com.gym.entity.Visitor;
import org.springframework.stereotype.Component;

@Component
public interface VisitorRepository {
    Visitor findByEmail(String email);

    void save(Visitor visitor);
}
