package com.gym.services.impl;

import com.gym.dtos.ContractDTO;
import com.gym.dtos.TrainerDTO;
import com.gym.entities.Trainer;
import com.gym.repositories.ContractRepository;
import com.gym.repositories.TrainerRepository;
import com.gym.services.TrainerService;
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
        if (trainerRepository.findTrainerByPhoneNumber(trainerDTO.getPhoneNumber()) != null) {
            Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
        } else {
            throw new IllegalArgumentException("Trainer with this phone number already exists");
        }
    }

    @Override
    @Transactional
    public void createContract(TrainerDTO trainerDTO, ContractDTO contractDTO) {

    }
}
