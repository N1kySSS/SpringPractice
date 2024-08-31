package com.gym.controllers;

import com.gym.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymController {
    private final GymService gymService;

    @Autowired
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping("/gyms/location")
    public String getLocationOfTheGym(@RequestParam String gymName) {
        return gymService.getLocationOfTheGym(gymName);
    }

    @GetMapping("/gyms/workingHours")
    public String getWorkingHoursOfTheGym(@RequestParam String gymName) {
        return gymService.getWorkingHoursOfTheGym(gymName);
    }
}
