package com.gym.repositories;

import com.gym.entities.Trainer;
import com.gym.entities.Visitor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Component
public interface TrainerRepository {
    List<Trainer> findTrainersBySpecialization(String specialization);

    List<Trainer> findTrainersByCriteria(int experience, String specialization);

    Trainer findAvailableTrainer(Long trainerId, LocalTime trainingTime, Date trainingDate);

    Trainer findTrainerByPhoneNumber(String phoneNumber);

    Trainer findById(Long id);

    void update(Trainer trainer);

    void save(Trainer trainer);
}
