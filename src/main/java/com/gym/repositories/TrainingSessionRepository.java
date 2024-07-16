package com.gym.repositories;

import com.gym.entities.TrainingSession;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Component
public interface TrainingSessionRepository {
    List<TrainingSession> getAllTrainingSessionByVisitorId(Long Id);

    List<TrainingSession> getTrainingSessionsByTimeAndDate(LocalTime trainingTime, Date trainingDate);

    void save(TrainingSession trainingSession);
}
