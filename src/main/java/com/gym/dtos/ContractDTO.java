package com.gym.dtos;

import com.gym.entities.Trainer;

public class ContractDTO {
    private Long id;
    private Trainer trainer;
    private String gymName;

    public ContractDTO(Long id, String gymName, Trainer trainer) {
        this.id = id;
        this.gymName = gymName;
        this.trainer = trainer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }
}
