package com.gym.controllers;

import com.gym.dtos.ContractDTO;
import com.gym.dtos.TrainerDTO;
import com.gym.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/addNewTrainer")
    public void addNewTrainer(@RequestBody TrainerDTO trainerDTO) {
        trainerService.addNewTrainer(trainerDTO);
    }

    @PostMapping("/createContract")
    public void createContract(@RequestParam Long trainerDTO, @RequestBody ContractDTO contractDTO) {
        trainerService.createContract(trainerDTO, contractDTO);
    }
}
