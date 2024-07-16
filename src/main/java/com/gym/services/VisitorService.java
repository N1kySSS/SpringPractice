package com.gym.services;

import com.gym.dtos.SubscriptionDTO;
import com.gym.dtos.TrainingSessionDTO;
import com.gym.dtos.VisitorDTO;

public interface VisitorService {
    void addNewVisitor(VisitorDTO visitorDTO);
    void buySubscription(VisitorDTO visitorDTO, SubscriptionDTO subscriptionDTO);
    void signUpForAWorkout(VisitorDTO visitorDTO, TrainingSessionDTO trainingSessionDTO);//
}
