package com.gym.repositories.impl;

import com.gym.entities.TrainingSession;
import com.gym.repositories.BaseTrainingSessionRepository;
import com.gym.repositories.TrainingSessionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TrainingSessionRepositoryImplementation extends DefaultRepository<BaseTrainingSessionRepository> implements TrainingSessionRepository {

    @Override
    public void add(TrainingSession trainingSession) {
        defaultRepository.save(trainingSession);
    }
}
