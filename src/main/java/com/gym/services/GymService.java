package com.gym.services;

import com.gym.services.dtos.GymDTO;

public interface GymService {
    String getLocationOfTheGym(GymDTO gymDTO);
    String getWorkingHoursOfTheGym(GymDTO gymDTO);
}
