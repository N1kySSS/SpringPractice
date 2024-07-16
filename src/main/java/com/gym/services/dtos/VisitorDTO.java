package com.gym.services.dtos;

import com.gym.entities.Subscription;
import com.gym.entities.TrainingSession;

import java.sql.Date;
import java.util.Set;

public class VisitorDTO {
    private Long id;
    private String email;
    private Subscription subscription;
    private Set<TrainingSession> trainingSessions;
    private Date subscriptionEndDate;

    public VisitorDTO(Long id, String email, Date subscriptionEndDate, Subscription subscription, Set<TrainingSession> trainingSessions) {
        this.id = id;
        this.email = email;
        this.subscriptionEndDate = subscriptionEndDate;
        this.subscription = subscription;
        this.trainingSessions = trainingSessions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(Date subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }
}
