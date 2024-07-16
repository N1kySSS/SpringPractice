package com.gym.dtos;

public class GymDTO {
    private String name;
    private String workingHours;
    private String location;

    public GymDTO(String name, String workingHours, String location) {
        this.name = name;
        this.workingHours = workingHours;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
