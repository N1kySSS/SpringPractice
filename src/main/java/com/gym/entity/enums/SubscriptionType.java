package com.gym.entity.enums;

public enum SubscriptionType {
    PREMIUM("Private"),
    BASIC("Basic"),
    GROUP("Group");

    private final String title;

    SubscriptionType(String title){
        this.title = title;
    }

    private String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return "SubscriptionType{" +
                "title='" + title + '\'' +
                '}';
    }
}
