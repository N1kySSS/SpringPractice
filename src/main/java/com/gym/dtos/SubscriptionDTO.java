package com.gym.dtos;

import com.gym.entities.Gym;
import com.gym.entities.Visitor;

import java.sql.Date;
import java.util.Set;

public class SubscriptionDTO {
    private String type;
    private double cost;
    private Date endDate;
    private Visitor visitor;
    private Set<Gym> gyms;

    public SubscriptionDTO(String type, double cost, Date endDate, Visitor visitor, Set<Gym> gyms) {
        this.type = type;
        this.cost = cost;
        this.endDate = endDate;
        this.visitor = visitor;
        this.gyms = gyms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Set<Gym> getGyms() {
        return gyms;
    }

    public void setGyms(Set<Gym> gyms) {
        this.gyms = gyms;
    }
}
