package com.gym.repositories.impl;

import com.gym.entities.Visitor;
import com.gym.repositories.BaseVisitorRepository;
import com.gym.repositories.VisitorRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class VisitorRepositoryImplementation extends DefaultRepository<BaseVisitorRepository> implements VisitorRepository {

    @Override
    public Visitor findByEmail(String email) {
        return defaultRepository.findByEmail(email);

    }

    @Override
    public Optional<Visitor> findById(Long id) {
        return defaultRepository.findById(id);
    }

    @Override
    public void update(Visitor visitor) {
        defaultRepository.save(visitor);
    }

    @Override
    public void add(Visitor visitor) {
        defaultRepository.save(visitor);
    }
}
