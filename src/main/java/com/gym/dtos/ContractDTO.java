package com.gym.dtos;

import java.time.LocalDate;

public class ContractDTO {
    private Long id;
    private Long trainerId;
    private String gymName;
    private double salary;
    private LocalDate contractEndDate;

    public ContractDTO(Long id, String gymName, Long trainerId, double salary, LocalDate contractEndDate) {
        this.id = id;
        this.gymName = gymName;
        this.trainerId = trainerId;
        this.salary = salary;
        this.contractEndDate = contractEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
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
