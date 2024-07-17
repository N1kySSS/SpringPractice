package com.gym.dtos;

import com.gym.entities.Trainer;
import com.gym.entities.Visitor;

import java.sql.Date;
import java.time.LocalTime;

public class TrainingSessionDTO {
    private Visitor visitor;
    private Trainer trainer;
    private LocalTime trainingTime;
    private Date trainingDate;
    private String specialization;
    private int experience;

    public TrainingSessionDTO(Visitor visitor, Trainer trainer, LocalTime trainingTime, Date trainingDate, String specialization, int experience) {
        this.visitor = visitor;
        this.trainer = trainer;
        this.trainingTime = trainingTime;
        this.trainingDate = trainingDate;
        this.specialization = specialization;
        this.experience = experience;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public LocalTime getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(LocalTime trainingTime) {
        this.trainingTime = trainingTime;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
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
}
