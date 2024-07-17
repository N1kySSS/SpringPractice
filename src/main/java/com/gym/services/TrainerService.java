package com.gym.services;

import com.gym.dtos.ContractDTO;
import com.gym.dtos.GymDTO;
import com.gym.dtos.TrainerDTO;

public interface TrainerService {
    void addNewTrainer(TrainerDTO trainerDTO);
    void createContract(TrainerDTO trainerDTO, ContractDTO contractDTO, GymDTO gymDTO);
}
