package com.gym.services;

import com.gym.services.dtos.ContractDTO;
import com.gym.services.dtos.TrainerDTO;

public interface TrainerService {
    void addNewTrainer(TrainerDTO trainerDTO);
    void createContract(TrainerDTO trainerDTO, ContractDTO contractDTO);
}
