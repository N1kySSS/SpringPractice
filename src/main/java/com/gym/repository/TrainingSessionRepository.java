package com.gym.repository;

import com.gym.entity.TrainingSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingSessionRepository {
    List<TrainingSession> getAllTrainingSessionByVisitorId(Long Id);
}
