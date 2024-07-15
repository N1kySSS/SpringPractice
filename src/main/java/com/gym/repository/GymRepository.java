package com.gym.repository;

import com.gym.entity.Gym;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository {
    Gym findByName(String name);
}
