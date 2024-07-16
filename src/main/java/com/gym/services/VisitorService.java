package com.gym.services;

import com.gym.services.dtos.SubscriptionDTO;
import com.gym.services.dtos.TrainingSessionDTO;
import com.gym.services.dtos.VisitorDTO;

public interface VisitorService {
    void addNewVisitor(VisitorDTO visitorDTO);
    void buySubscription(VisitorDTO visitorDTO, SubscriptionDTO subscriptionDTO);
    void signUpForAWorkout(VisitorDTO visitorDTO, TrainingSessionDTO trainingSessionDTO);//
}
