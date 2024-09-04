package com.gym.repositories;

import com.gym.entities.Trainer;
import com.gym.entities.enums.TrainerSpecialization;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface TrainerRepository {
    List<Trainer> findTrainersByCriteria(int experience, TrainerSpecialization specialization);

    Trainer findAvailableTrainer(Long trainerId, LocalTime trainingTime, Date trainingDate);

    Trainer findTrainerByPhoneNumber(String phoneNumber);

    Trainer findById(Long id);

    void update(Trainer trainer);

    void save(Trainer trainer);
}
