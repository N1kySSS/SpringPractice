package com.gym.services.impl;

import com.gym.repositories.GymRepository;
import com.gym.services.GymService;
import com.gym.dtos.GymDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GymServiceImplementation extends BaseServiceImplementation implements GymService {
    private final GymRepository gymRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GymServiceImplementation(GymRepository gymRepository, ModelMapper modelMapper) {
        this.gymRepository = gymRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public String getLocationOfTheGym(GymDTO gymDTO) {
        return "";
    }

    @Override
    @Transactional
    public String getWorkingHoursOfTheGym(GymDTO gymDTO) {
        return "";
    }
}
