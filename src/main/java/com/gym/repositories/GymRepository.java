package com.gym.repositories;

import com.gym.entities.Gym;
import org.springframework.stereotype.Component;

@Component
public interface GymRepository {
    Gym findGymByName(String name);

    void save(Gym gym);
}
