package com.gym.dtos;

import com.gym.entities.enums.SubscriptionType;

import java.time.LocalDate;

public class SubscriptionDTO {
    private Long id;
    private SubscriptionType type;
    private String periodInMonth;
    private LocalDate endDate;
    private double cost;
    private Long visitorId;
    private Long gymId;

    public SubscriptionDTO(Long id, SubscriptionType type, String periodInMonth, LocalDate endDate, double cost, Long visitorId, Long gymId) {
        this.id = id;
        this.type = type;
        this.periodInMonth = periodInMonth;
        this.endDate = endDate;
        this.cost = cost;
        this.visitorId = visitorId;
        this.gymId = gymId;
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

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
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
