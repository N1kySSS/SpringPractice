package com.gym.repositories.impl;

import com.gym.entities.Visitor;
import com.gym.repositories.VisitorRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class VisitorRepositoryImplementation extends BaseRepository<Visitor, Long> implements VisitorRepository {
    @Override
    public Visitor findByEmail(String email) {
        String jpql = "SELECT v FROM Visitor v WHERE v.email = :email";
        TypedQuery<Visitor> query = entityManager.createQuery(jpql, Visitor.class);
        query.setParameter("email", email);
        List<Visitor> resultList = query.getResultList();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.getFirst();
        }
    }

    @Override
    @Transactional
    public Visitor findById(Long id) {
        return super.findById(Visitor.class, id);
    }

    @Override
    @Transactional
    public void update(Visitor visitor) {
        entityManager.merge(visitor);
    }
}
