package com.gym.dtos;

import com.gym.entities.Gym;
import com.gym.entities.Visitor;
import com.gym.entities.enums.SubscriptionType;

import java.sql.Date;
import java.time.LocalDate;

public class SubscriptionDTO {
    private Long id;
    private SubscriptionType type;
    private String periodInMonth;
    private LocalDate endDate;
    private double cost;
    private Visitor visitor;
    private Gym gym;

    public SubscriptionDTO(Long id, SubscriptionType type, String periodInMonth, LocalDate endDate, double cost, Visitor visitor, Gym gym) {
        this.id = id;
        this.type = type;
        this.periodInMonth = periodInMonth;
        this.endDate = endDate;
        this.cost = cost;
        this.visitor = visitor;
        this.gym = gym;
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public String getPeriodInMonth() {
        return periodInMonth;
    }

    public void setPeriodInMonth(String periodInMonth) {
        this.periodInMonth = periodInMonth;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
