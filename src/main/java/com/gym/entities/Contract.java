package com.gym.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "contract")
public class Contract extends IdEntity {

    private LocalDate contractEndDate;

    private double salary;

    private Gym gym;

    private Trainer trainer;

    protected Contract() {
    }

    public Contract(LocalDate contractEndDate, double salary, Gym gym, Trainer trainer) {
        this.contractEndDate = contractEndDate;
        this.salary = salary;
        this.gym = gym;
        this.trainer = trainer;
    }

    @Column(name = "end_date", nullable = false)
    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    @Column(name = "salary", nullable = false)
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @ManyToOne
    @JoinColumn(name = "gym_name", nullable = false)
    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
