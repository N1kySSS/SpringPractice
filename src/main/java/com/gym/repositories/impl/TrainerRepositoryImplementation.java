package com.gym.repositories.impl;

import com.gym.entities.Trainer;
import com.gym.entities.enums.TrainerSpecialization;
import com.gym.repositories.BaseTrainerRepository;
import com.gym.repositories.TrainerRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class TrainerRepositoryImplementation extends DefaultRepository<BaseTrainerRepository> implements TrainerRepository {

    @Override
    public List<Trainer> findTrainersByCriteria(int experience, TrainerSpecialization specialization) {
        return defaultRepository.findTrainersByCriteria(experience, specialization);
    }

    @Override
    public Trainer findAvailableTrainer(Long trainerId, LocalTime trainingTime, Date trainingDate) {
        return defaultRepository.findAvailableTrainer(trainerId, trainingTime, trainingDate);
    }

    @Override
    public Trainer findTrainerByPhoneNumber(String phoneNumber) {
        return defaultRepository.findTrainerByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<Trainer> findById(Long id) {
        return defaultRepository.findById(id);
    }

    @Override
    public void update(Trainer trainer) {
        defaultRepository.save(trainer);
    }

    @Override
    public void add(Trainer trainer) {
        defaultRepository.save(trainer);
    }
}
