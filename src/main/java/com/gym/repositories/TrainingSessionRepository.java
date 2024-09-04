package com.gym.repositories;

import com.gym.entities.TrainingSession;
import org.springframework.stereotype.Component;

@Component
public interface TrainingSessionRepository {
    void save(TrainingSession trainingSession);
}
