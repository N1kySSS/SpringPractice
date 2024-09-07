package com.gym.dtos;

import com.gym.entities.enums.TrainerSpecialization;

import java.util.Set;

public class TrainerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private TrainerSpecialization specialization;
    private String phoneNumber;
    private int experience;
    private Set<TrainingSessionDTO> trainingSessions;
    private Set<ContractDTO> contracts;

    public TrainerDTO(Long id, String firstName, String lastName, TrainerSpecialization specialization, String phoneNumber, int experience, Set<TrainingSessionDTO> trainingSessions, Set<ContractDTO> contracts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
        this.trainingSessions = trainingSessions;
        this.contracts = contracts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<TrainingSessionDTO> getTrainingSessions() {
        return trainingSessions;
    }

    public void setTrainingSessions(Set<TrainingSessionDTO> trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainerSpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(TrainerSpecialization specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Set<ContractDTO> getContracts() {
        return contracts;
    }

    public void setContracts(Set<ContractDTO> contracts) {
        this.contracts = contracts;
    }
}
