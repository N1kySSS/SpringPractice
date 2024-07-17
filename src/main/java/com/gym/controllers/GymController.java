package com.gym.controllers;

import com.gym.dtos.GymDTO;
import com.gym.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gyms")
public class GymController {
    private final GymService gymService;

    @Autowired
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping("/location")
    public String getLocationOfTheGym(@RequestParam String gymName) {
        return gymService.getLocationOfTheGym(gymName);
    }

    @GetMapping("/workingHours")
    public String getWorkingHoursOfTheGym(@RequestParam String gymName) {
        return gymService.getWorkingHoursOfTheGym(gymName);
    }
}
