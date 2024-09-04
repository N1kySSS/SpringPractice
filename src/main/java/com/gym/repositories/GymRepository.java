package com.gym.repositories;

import com.gym.entities.Gym;

public interface GymRepository {
    Gym findGymByName(String name);

    void save(Gym gym);
}
