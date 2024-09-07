package com.gym.repositories;

import com.gym.entities.Trainer;
import com.gym.entities.enums.TrainerSpecialization;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrainerRepository {

    List<Trainer> findTrainersByCriteria(int experience, TrainerSpecialization specialization);

    Trainer findAvailableTrainer(Long trainerId, LocalTime trainingTime, Date trainingDate);

    Trainer findTrainerByPhoneNumber(String phoneNumber);

    Optional<Trainer> findById(Long id);

    void update(Trainer trainer);

    void add(Trainer trainer);
}
