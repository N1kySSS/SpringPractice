package com.gym.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "trainer")
public class Trainer extends IdEntity {

    private String firstName;

    private String lastName;

    private String specialization;

    private String phoneNumber;

    private String workplace;

    private int experience;

    private Set<TrainingSession> trainingSessions;

    private Set<Contract> contracts;

    protected Trainer() {
    }

    public Trainer(String firstName, String lastName, String specialization, String phoneNumber, String workplace, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.workplace = workplace;
        this.experience = experience;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "specialization", nullable = false)
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "workplace", nullable = false)
    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Column(name = "experience", nullable = false)
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @OneToMany(mappedBy = "trainer", targetEntity = TrainingSession.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }

    public void setTrainingSessions(Set<TrainingSession> trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

    @OneToMany(mappedBy = "trainer", targetEntity = Contract.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
