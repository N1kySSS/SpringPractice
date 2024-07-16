package com.gym.services.dtos;

import com.gym.entities.Contract;

import java.util.Set;

public class TrainerDTO {
    private Long id;
    private String specialization;
    private int experience;
    private Set<Contract> contracts;

    public TrainerDTO(Long id, String specialization, int experience, Set<Contract> contracts) {
        this.id = id;
        this.specialization = specialization;
        this.experience = experience;
        this.contracts = contracts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
