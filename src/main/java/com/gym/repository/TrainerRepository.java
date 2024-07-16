package com.gym.repository;

import com.gym.entity.Trainer;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Component
public interface TrainerRepository {
    List<Trainer> findTrainersBySpecialization(String specialization);

    List<Trainer> findTrainersByCriteria(int experience, String specialization);

    Trainer findAvailableTrainer(Long trainerId, LocalTime trainingTime, Date trainingDate);

    void save(Trainer trainer);
}
