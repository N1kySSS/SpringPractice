package com.gym.controllers;

import com.gym.dtos.SubscriptionDTO;
import com.gym.dtos.TrainingSessionDTO;
import com.gym.dtos.VisitorDTO;
import com.gym.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visitors")
public class VisitorController {
    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping("/addVisitor")
    public void addNewVisitor(@RequestBody VisitorDTO visitorDTO){
        visitorService.addNewVisitor(visitorDTO);
    }

    @PostMapping("/buySubscription")
    public void buySubscription(@RequestParam Long visitorId, @RequestParam String gymName, @RequestBody SubscriptionDTO subscriptionDTO) {
        visitorService.buySubscription(visitorId, gymName, subscriptionDTO);
    }

    @PostMapping("/signUpForAWorkout")
    public void signUpForAWorkout(@RequestBody TrainingSessionDTO trainingSessionDTO) {
        visitorService.signUpForAWorkout(trainingSessionDTO);
    }
}
