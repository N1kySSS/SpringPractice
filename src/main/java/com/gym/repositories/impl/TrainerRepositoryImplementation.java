package com.gym.repositories.impl;

import com.gym.entities.Trainer;
import com.gym.repositories.TrainerRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public class TrainerRepositoryImplementation extends BaseRepository<Trainer, Long> implements TrainerRepository {
    @Override
    public List<Trainer> findTrainersBySpecialization(String specialization) {
        String jpql = "SELECT t FROM Trainer t WHERE t.specialization = :specialization";
        TypedQuery<Trainer> query = entityManager.createQuery(jpql, Trainer.class);
        query.setParameter("specialization", specialization);
        return query.getResultList();
    }

    @Override
    public List<Trainer> findTrainersByCriteria(int experience, String specialization) {
        String jpql = "SELECT t FROM Trainer t WHERE t.experience >= :experience AND t.specialization = :specialization";
        TypedQuery<Trainer> query = entityManager.createQuery(jpql, Trainer.class);
        query.setParameter("specialization", specialization);
        query.setParameter("experience", experience);
        return query.getResultList();
    }

    @Override
    public Trainer findAvailableTrainer(Long trainerId, LocalTime trainingTime, Date trainingDate) {
        String jpql = "SELECT t FROM Trainer t JOIN t.trainingSessions ts WHERE t.id = :trainerId " +
                "AND ts.trainingTime != :trainingTime " +
                "AND ts.trainingDate != :trainingDate";
        TypedQuery<Trainer> query = entityManager.createQuery(jpql, Trainer.class);
        query.setParameter("trainerId", trainerId);
        query.setParameter("trainingTime", trainingTime);
        query.setParameter("trainingDate", trainingDate);
        return query.getSingleResult();
    }

    @Override
    public Trainer findTrainerByPhoneNumber(String phoneNumber) {
        String jpql = "SELECT t FROM Trainer t WHERE t.phoneNumber = :phoneNumber";
        TypedQuery<Trainer> query = entityManager.createQuery(jpql, Trainer.class);
        query.setParameter("phoneNumber", phoneNumber);
        return query.getSingleResult();
    }


}
