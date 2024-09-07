package com.gym.services.impl;

import com.gym.dtos.ContractDTO;
import com.gym.dtos.TrainerDTO;
import com.gym.entities.Contract;
import com.gym.entities.Gym;
import com.gym.entities.Trainer;
import com.gym.repositories.ContractRepository;
import com.gym.repositories.GymRepository;
import com.gym.repositories.TrainerRepository;
import com.gym.services.TrainerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TrainerServiceImplementation implements TrainerService {
    private final TrainerRepository trainerRepository;
    private final ContractRepository contractRepository;
    private final GymRepository gymRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TrainerServiceImplementation(TrainerRepository trainerRepository, ContractRepository contractRepository, GymRepository gymRepository, ModelMapper modelMapper) {
        this.trainerRepository = trainerRepository;
        this.contractRepository = contractRepository;
        this.gymRepository = gymRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void addNewTrainer(TrainerDTO trainerDTO) {
        if (trainerRepository.findTrainerByPhoneNumber(trainerDTO.getPhoneNumber()) != null) {
            throw new IllegalArgumentException("Trainer with this phone number already exists");
        }

        Trainer trainer = modelMapper.map(trainerDTO, Trainer.class);
        trainerRepository.add(trainer);
    }

    @Override
    @Transactional
    public void createContract(ContractDTO contractDTO) {
        Optional<Trainer> trainerOptional = trainerRepository.findById(contractDTO.getTrainerId());
        if (trainerOptional.isEmpty()) {
            throw new IllegalArgumentException("Trainer with this id does not exist");
        }

        Trainer trainer = trainerOptional.get();

        Gym gym = gymRepository.findGymByName(contractDTO.getGymName());
        if (gym == null) {
            throw new IllegalArgumentException("Gym with this name does not exist");
        }

        if (contractRepository.getContractByTrainerId(contractDTO.getTrainerId()) != null &&
                contractRepository.getContractByTrainerId(contractDTO.getTrainerId()).getGym().getName().equals(contractDTO.getGymName()) &&
                contractRepository.getContractByTrainerId(contractDTO.getTrainerId()).getContractEndDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Trainer already has contract in this gym");
        }

        Contract contract = modelMapper.map(contractDTO, Contract.class);
        contract.setGym(gym);
        contract.setContractEndDate(LocalDate.now().plusMonths(12));
        contractRepository.add(contract);

        Set<Contract> contracts = trainer.getContracts();
        if (contracts == null) {
            contracts = new HashSet<>();
        }
        contracts.add(contract);
        trainer.setContracts(contracts);
        trainerRepository.update(trainer);
    }
}
