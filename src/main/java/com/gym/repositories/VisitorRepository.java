package com.gym.repositories;

import com.gym.entities.Visitor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitorRepository {

    Visitor findByEmail(String email);

    Optional<Visitor> findById(Long id);

    void add(Visitor visitor);

    void update(Visitor visitor);
}
