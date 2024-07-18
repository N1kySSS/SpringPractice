package com.gym.dtos;

import com.gym.entities.Subscription;
import com.gym.entities.TrainingSession;

import java.util.Set;

public class VisitorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Subscription subscription;
    private Set<TrainingSession> trainingSessions;

    protected VisitorDTO() {
    }

    public VisitorDTO(Long id, String firstName, String lastName, String email, Subscription subscription, Set<TrainingSession> trainingSessions) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subscription = subscription;
        this.trainingSessions = trainingSessions;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Set<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }

    public void setTrainingSessions(Set<TrainingSession> trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
