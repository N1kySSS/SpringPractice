package com.gym.repositories.impl;

import com.gym.entities.Gym;
import com.gym.entities.Visitor;
import com.gym.repositories.GymRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GymRepositoryImplementation extends BaseRepository<Gym, Long> implements GymRepository {
    @Override
    public Gym findGymByName(String name) {
        String jpql = "SELECT g FROM Gym g WHERE g.name = :name";
        TypedQuery<Gym> query = entityManager.createQuery(jpql, Gym.class);
        query.setParameter("name", name);
        List<Gym> resultList = query.getResultList();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.getFirst();
        }
    }
}
