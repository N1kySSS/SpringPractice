package com.gym.repositories.impl;

import com.gym.entities.TrainingSession;
import com.gym.repositories.TrainingSessionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public class TrainingSessionRepositoryImplementation extends BaseRepository<TrainingSession, Long> implements TrainingSessionRepository {

    @Override
    public List<TrainingSession> getAllTrainingSessionByVisitorId(Long Id) {
        String jpql = "SELECT ts FROM TrainingSession ts WHERE ts.visitor.id = :visitorId";
        TypedQuery<TrainingSession> query = entityManager.createQuery(jpql, TrainingSession.class);
        query.setParameter("visitorId", Id);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            throw new EntityNotFoundException("TrainingSession with such id does not exist");
        }
    }

    @Override
    public List<TrainingSession> getTrainingSessionsByTimeAndDate(LocalTime trainingTime, Date trainingDate) {
        String jpql = "SELECT ts FROM TrainingSession ts WHERE ts.trainingTime = :trainingTime " +
                "AND ts.trainingDate = :trainingDate";;
        TypedQuery<TrainingSession> query = entityManager.createQuery(jpql, TrainingSession.class);
        query.setParameter("trainingTime", trainingTime);
        query.setParameter("trainingDate", trainingDate);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            throw new EntityNotFoundException("There is no training sessions in such time and date");
        }
    }
}
