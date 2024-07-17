package com.gym.services;

import com.gym.dtos.GymDTO;

public interface GymService {
    String getLocationOfTheGym(String gymName);
    String getWorkingHoursOfTheGym(String gymName);
}
