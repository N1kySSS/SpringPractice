package com.gym.repositories;

import com.gym.entities.TrainingSession;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingSessionRepository {

    void add(TrainingSession trainingSession);
}
