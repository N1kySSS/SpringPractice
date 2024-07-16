package com.gym.services.impl;

import com.gym.repositories.ContractRepository;
import com.gym.repositories.TrainerRepository;
import com.gym.services.TrainerService;
import com.gym.services.dtos.ContractDTO;
import com.gym.services.dtos.TrainerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrainerServiceImplementation extends BaseServiceImplementation implements TrainerService {
    private final TrainerRepository trainerRepository;
    private final ContractRepository contractRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TrainerServiceImplementation(TrainerRepository trainerRepository, ContractRepository contractRepository, ModelMapper modelMapper) {
        this.trainerRepository = trainerRepository;
        this.contractRepository = contractRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void addNewTrainer(TrainerDTO trainerDTO) {

    }

    @Override
    @Transactional
    public void createContract(TrainerDTO trainerDTO, ContractDTO contractDTO) {

    }
}
