package com.gym.repository.impl;

import com.gym.entity.Gym;
import com.gym.repository.GymRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class GymRepositoryImplementation extends BaseRepository<Gym, Long> implements GymRepository {
    @Override
    public Gym findGymByName(String name) {
        String jpql = "SELECT g FROM Gym g WHERE g.name = :name";
        TypedQuery<Gym> query = entityManager.createQuery(jpql, Gym.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new EntityNotFoundException("Gym with such name does not exist");
        }
    }
}
