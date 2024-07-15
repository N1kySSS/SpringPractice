package com.gym.repository;

import com.gym.entity.Visitor;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository {
    Visitor findByEmail(String email);
}
