package com.gym.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "subscription")
public class Subscription extends IdEntity {

    private String type;

    private double cost;

    private Date creationDate;

    private Visitor visitor;

    private Set<Gym> gyms;

    protected Subscription() {
    }

    public Subscription(String type, double cost, Date creationDate, Visitor visitor, Set<Gym> gyms) {
        this.type = type;
        this.cost = cost;
        this.creationDate = creationDate;
        this.visitor = visitor;
        this.gyms = gyms;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "cost", nullable = false)
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Column(name = "creation_date", nullable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @OneToOne
    @JoinColumn(name = "visitor_id")
    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    @ManyToMany
    @JoinTable(name = "subscription",
            joinColumns = @JoinColumn(name = "subscription_id"),
            inverseJoinColumns = @JoinColumn(name = "gym_id"))
    public Set<Gym> getGyms() {
        return gyms;
    }

    public void setGyms(Set<Gym> gyms) {
        this.gyms = gyms;
    }
}
