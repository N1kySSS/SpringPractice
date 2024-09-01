package com.gym.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalTime;

@Entity
@Table(name = "training_session")
public class TrainingSession extends IdEntity {

    private Visitor visitor;

    private Trainer trainer;

    private LocalTime trainingTime;

    private Date trainingDate;

    public TrainingSession(Visitor visitor, Trainer trainer, LocalTime trainingTime, Date trainingDate) {
        this.visitor = visitor;
        this.trainer = trainer;
        this.trainingTime = trainingTime;
        this.trainingDate = trainingDate;
    }

    protected TrainingSession() {
    }

    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Column(name = "training_time", nullable = false)
    public LocalTime getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(LocalTime trainingTime) {
        this.trainingTime = trainingTime;
    }

    @Column(name = "training_date", nullable = false)
    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }
}
