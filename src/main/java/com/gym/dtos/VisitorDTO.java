package com.gym.dtos;

import java.util.Set;

public class VisitorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long subscriptionId;
    private Set<TrainingSessionDTO> trainingSessions;

    protected VisitorDTO() {
    }

    public VisitorDTO(Long id, String firstName, String lastName, String email, Long subscriptionId, Set<TrainingSessionDTO> trainingSessions) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subscriptionId = subscriptionId;
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

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
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
}
