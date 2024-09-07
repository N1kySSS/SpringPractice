package com.gym.repositories;

import com.gym.entities.Gym;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository {

    Gym findGymByName(String name);
}
