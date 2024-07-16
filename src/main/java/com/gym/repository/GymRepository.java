package com.gym.repository;

import com.gym.entity.Gym;
import org.springframework.stereotype.Component;

@Component
public interface GymRepository {
    Gym findGymByName(String name);

    void save(Gym gym);
}
