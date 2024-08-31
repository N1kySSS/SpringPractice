package com.gym.controllers;

import com.gym.dtos.ContractDTO;
import com.gym.dtos.TrainerDTO;
import com.gym.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerController {
    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/trainers/addNewTrainer")
    public void addNewTrainer(@RequestBody TrainerDTO trainerDTO) {
        trainerService.addNewTrainer(trainerDTO);
    }

    @PostMapping("/trainers/createContract")
    public void createContract(@RequestBody ContractDTO contractDTO) {
        trainerService.createContract(contractDTO);
    }
}
