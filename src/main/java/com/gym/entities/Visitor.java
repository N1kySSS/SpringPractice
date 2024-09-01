package com.gym.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "visitor")
public class Visitor extends IdEntity {

    private String firstName;

    private String lastName;

    private String email;

    private Subscription subscription;

    private Set<TrainingSession> trainingSessions = new HashSet<>();

    public Visitor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    protected Visitor() {
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

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToOne(mappedBy = "visitor", cascade = CascadeType.ALL)
    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @OneToMany(mappedBy = "visitor", targetEntity = TrainingSession.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }

    public void setTrainingSessions(Set<TrainingSession> trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

    public void addTrainingSession(TrainingSession session) {
        trainingSessions.add(session);
        session.setVisitor(this);
    }

    public void removeTrainingSession(TrainingSession session) {
        trainingSessions.remove(session);
        session.setVisitor(null);
    }
}
