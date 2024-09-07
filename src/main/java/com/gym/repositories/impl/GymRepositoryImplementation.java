package com.gym.repositories.impl;

import com.gym.entities.Gym;
import com.gym.repositories.BaseGymRepository;
import com.gym.repositories.GymRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GymRepositoryImplementation extends DefaultRepository<BaseGymRepository> implements GymRepository {

    @Override
    public Gym findGymByName(String name) {
        return defaultRepository.findGymByName(name);
    }
}
