package com.gym.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract extends IdEntity {

    private Date contractDate;

    private double salary;

    private Set<Gym> gyms;

    private Trainer trainer;

    protected Contract() {
    }

    public Contract(Date contractDate, double salary, Set<Gym> gyms, Trainer trainer) {
        this.contractDate = contractDate;
        this.salary = salary;
        this.gyms = gyms;
        this.trainer = trainer;
    }

    @Column(name = "contract_date", nullable = false)
    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Column(name = "salary", nullable = false)
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @ManyToMany
    @JoinTable(name = "contract_gym",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "gym_id"))
    public Set<Gym> getGyms() {
        return gyms;
    }

    public void setGyms(Set<Gym> gyms) {
        this.gyms = gyms;
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
