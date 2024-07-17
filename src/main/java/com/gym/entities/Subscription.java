package com.gym.entities;

import com.gym.entities.enums.SubscriptionType;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "subscription")
public class Subscription extends IdEntity {

    private SubscriptionType type;

    private double cost;

    private LocalDate endDate;

    private Visitor visitor;

    private Gym gym;

    protected Subscription() {
    }

    public Subscription(SubscriptionType type, double cost, LocalDate endDate, Visitor visitor, Gym gym) {
        this.type = type;
        this.cost = cost;
        this.endDate = endDate;
        this.visitor = visitor;
        this.gym = gym;
    }

    @Column(name = "type", nullable = false)
    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }

    @Column(name = "cost", nullable = false)
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Column(name = "end_date", nullable = false)
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @OneToOne
    @JoinColumn(name = "visitor_id")
    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    @ManyToOne
    @JoinColumn(name = "gym_id", nullable = false)
    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}
