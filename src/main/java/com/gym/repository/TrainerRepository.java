package com.gym.repository;

import com.gym.entity.Trainer;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository {
    Trainer findBySpecialization(String specialization);
}
