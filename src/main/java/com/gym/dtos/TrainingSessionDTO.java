package com.gym.dtos;

import com.gym.entities.enums.TrainerSpecialization;

import java.sql.Date;
import java.time.LocalTime;

public class TrainingSessionDTO {
    private Long visitorId;
    private Long trainerId;
    private LocalTime trainingTime;
    private Date trainingDate;
    private TrainerSpecialization specialization;
    private int experience;

    public TrainingSessionDTO(Long visitorId, Long trainerId, LocalTime trainingTime, Date trainingDate, TrainerSpecialization specialization, int experience) {
        this.visitorId = visitorId;
        this.trainerId = trainerId;
        this.trainingTime = trainingTime;
        this.trainingDate = trainingDate;
        this.specialization = specialization;
        this.experience = experience;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
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
}
