package com.gym.repositories.impl;

import com.gym.entities.Trainer;
import com.gym.entities.enums.TrainerSpecialization;
import com.gym.repositories.TrainerRepository;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public class TrainerRepositoryImplementationImplementation extends BaseRepositoryImplementation<Trainer, Long> implements TrainerRepository {

    @Override
    public List<Trainer> findTrainersByCriteria(int experience, TrainerSpecialization specialization) {
        String jpql = "SELECT t FROM Trainer t WHERE t.experience >= :experience AND t.specialization = :specialization";
        TypedQuery<Trainer> query = entityManager.createQuery(jpql, Trainer.class);
        query.setParameter("specialization", specialization);
        query.setParameter("experience", experience);
        return query.getResultList();
    }

    @Override
    public Trainer findAvailableTrainer(Long trainerId, LocalTime trainingTime, Date trainingDate) {
        String jpql = "SELECT t " +
                "FROM Trainer t " +
                "LEFT JOIN t.trainingSessions ts " +
                "WHERE t.id = :trainerId " +
                "AND (ts IS NULL OR (ts.trainingTime != :trainingTime AND ts.trainingDate != :trainingDate))";
        TypedQuery<Trainer> query = entityManager.createQuery(jpql, Trainer.class);
        query.setParameter("trainerId", trainerId);
        query.setParameter("trainingTime", trainingTime);
        query.setParameter("trainingDate", trainingDate);
        List<Trainer> resultList = query.getResultList();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.getFirst();
        }
    }

    @Override
    public Trainer findTrainerByPhoneNumber(String phoneNumber) {
        String jpql = "SELECT t FROM Trainer t WHERE t.phoneNumber = :phoneNumber";
        TypedQuery<Trainer> query = entityManager.createQuery(jpql, Trainer.class);
        query.setParameter("phoneNumber", phoneNumber);
        List<Trainer> resultList = query.getResultList();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.getFirst();
        }
    }

    @Override
    @Transactional
    public Trainer findById(Long id) {
        return super.findById(Trainer.class, id);
    }

    @Override
    @Transactional
    public void update(Trainer trainer) {
        entityManager.merge(trainer);
    }
}
