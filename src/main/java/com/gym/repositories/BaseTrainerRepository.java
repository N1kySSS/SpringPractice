package com.gym.repositories;

import com.gym.entities.Trainer;
import com.gym.entities.enums.TrainerSpecialization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface BaseTrainerRepository extends BaseRepository<Trainer> {
    @Query("SELECT t FROM Trainer t WHERE t.experience >= :experience AND t.specialization = :specialization")
    List<Trainer> findTrainersByCriteria(
            @Param(value = "experience") int experience,
            @Param(value = "specialization") TrainerSpecialization specialization);

    @Query("SELECT t FROM Trainer t WHERE t.id = :trainerId AND t.id NOT IN (" +
            "SELECT ts.trainer.id FROM TrainingSession ts WHERE ts.trainingTime = :trainingTime AND ts.trainingDate = :trainingDate)")
    Trainer findAvailableTrainer(
            @Param(value = "trainerId") Long trainerId,
            @Param(value = "trainingTime") LocalTime trainingTime,
            @Param(value = "trainingDate") Date trainingDate);

    @Query("SELECT t FROM Trainer t WHERE t.phoneNumber = :phoneNumber")
    Trainer findTrainerByPhoneNumber(@Param(value = "phoneNumber") String phoneNumber);
}
