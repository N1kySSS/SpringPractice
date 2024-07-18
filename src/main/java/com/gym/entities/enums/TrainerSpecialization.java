package com.gym.entities.enums;

public enum TrainerSpecialization {
    FOOTBALL("FootballTrainer", 0),
    BASKETBALL("BasketballTrainer", 1),
    FITNESS("FitnessTrainer", 2),
    POWERLIFTING("PowerliftingTrainer", 3),
    BODYBUILDING("BodybuildingTrainer", 4);

    private final String title;
    private final int id;

    TrainerSpecialization(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TrainerSpecialization{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }

}
