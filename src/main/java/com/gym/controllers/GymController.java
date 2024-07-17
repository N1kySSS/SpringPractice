package com.gym.controllers;

import com.gym.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gyms")
public class GymController {
    private final GymService gymService;

    @Autowired
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }
}
