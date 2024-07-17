package com.gym.dtos;

import com.gym.entities.Trainer;

import java.time.LocalDate;

public class ContractDTO {
    private Long id;
    private Trainer trainer;
    private String gymName;
    private double salary;
    private LocalDate contractEndDate;

    public ContractDTO(Long id, String gymName, Trainer trainer, double salary, LocalDate contractEndDate) {
        this.id = id;
        this.gymName = gymName;
        this.trainer = trainer;
        this.salary = salary;
        this.contractEndDate = contractEndDate;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }
}
