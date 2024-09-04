package com.gym.repositories.impl;

import com.gym.entities.TrainingSession;
import com.gym.repositories.TrainingSessionRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public class TrainingSessionRepositoryImplementationImplementation extends BaseRepositoryImplementation<TrainingSession, Long> implements TrainingSessionRepository {

    @Override
    public List<TrainingSession> getAllTrainingSessionByVisitorId(Long Id) {
        String jpql = "SELECT ts FROM TrainingSession ts WHERE ts.visitor.id = :visitorId";
        TypedQuery<TrainingSession> query = entityManager.createQuery(jpql, TrainingSession.class);
        query.setParameter("visitorId", Id);
        return query.getResultList();
    }

    @Override
    public List<TrainingSession> getTrainingSessionsByTimeAndDate(LocalTime trainingTime, Date trainingDate) {
        String jpql = "SELECT ts FROM TrainingSession ts WHERE ts.trainingTime = :trainingTime " +
                "AND ts.trainingDate = :trainingDate";
        ;
        TypedQuery<TrainingSession> query = entityManager.createQuery(jpql, TrainingSession.class);
        query.setParameter("trainingTime", trainingTime);
        query.setParameter("trainingDate", trainingDate);
        return query.getResultList();
    }
}
