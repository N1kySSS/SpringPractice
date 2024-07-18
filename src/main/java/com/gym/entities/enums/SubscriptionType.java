package com.gym.entities.enums;

public enum SubscriptionType {
    PREMIUM("Premium", 25000),
    BASIC("Basic", 15000),
    GROUP("Group", 19900);

    private final String title;
    private final int costMonth;

    SubscriptionType(String title, int costMonth) {
        this.title = title;
        this.costMonth = costMonth;
    }

    private String getTitle() {
        return title;
    }

    public int getCostMonth() {
        return costMonth;
    }

    @Override
    public String toString() {
        return "SubscriptionType{" +
                "title='" + title + '\'' +
                ", costMonth=" + costMonth +
                '}';
    }
}
