package com.gym.services.impl;

import com.gym.entities.Gym;
import com.gym.repositories.GymRepository;
import com.gym.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymServiceImplementation extends BaseServiceImplementation implements GymService {
    private final GymRepository gymRepository;

    @Autowired
    public GymServiceImplementation(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    @Override
    public String getLocationOfTheGym(String gymName) {
        Gym gym = gymRepository.findGymByName(gymName);
        if (gym != null) {
            return gym.getLocation();
        } else {
            throw new IllegalArgumentException("Gym with this name does not exist");
        }
    }

    @Override
    public String getWorkingHoursOfTheGym(String gymName) {
        Gym gym = gymRepository.findGymByName(gymName);
        if (gym != null) {
            return gym.getWorkingHours();
        } else {
            throw new IllegalArgumentException("Gym with this name does not exist");

        }
    }
}
