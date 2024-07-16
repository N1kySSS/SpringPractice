package com.gym.entities.enums;

public enum TrainerSpecialization {
    FOOTBALL("FootballTrainer"),
    BASKETBALL("BasketballTrainer"),
    FITNESS("FitnessTrainer"),
    POWERLIFTING("PowerliftingTrainer"),
    BODYBUILDING("BodybuildingTrainer");

    private final String title;

    TrainerSpecialization(String title){
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
