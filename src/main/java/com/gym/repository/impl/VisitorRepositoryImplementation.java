package com.gym.repository.impl;

import com.gym.entity.Visitor;
import com.gym.repository.VisitorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorRepositoryImplementation extends BaseRepository<Visitor, Long> implements VisitorRepository {
    @Override
    public Visitor findByEmail(String email) {
        String jpql = "SELECT v FROM Visitor v WHERE v.email = :email";
        TypedQuery<Visitor> query = entityManager.createQuery(jpql, Visitor.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new EntityNotFoundException("Visitor with such email does not exist");
        }
    }
}
