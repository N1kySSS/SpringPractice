package com.gym.services.impl;

import com.gym.dtos.GymDTO;
import com.gym.entities.Gym;
import com.gym.repositories.GymRepository;
import com.gym.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GymServiceImplementation extends BaseServiceImplementation implements GymService {
    private final GymRepository gymRepository;

    @Autowired
    public GymServiceImplementation(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    @Override
    @Transactional
    public String getLocationOfTheGym(GymDTO gymDTO) {
        Gym gym = gymRepository.findGymByName(gymDTO.getName());
        if (gym != null) {
            return gym.getLocation();
        } else {
            throw new IllegalArgumentException("Gym with this name does not exist");
        }
    }

    @Override
    @Transactional
    public String getWorkingHoursOfTheGym(GymDTO gymDTO) {
        Gym gym = gymRepository.findGymByName(gymDTO.getName());
        if (gym != null) {
            return gym.getWorkingHours();
        } else {
            throw new IllegalArgumentException("Gym with this name does not exist");
        }
    }
}
