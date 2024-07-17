package com.gym.services;

import com.gym.dtos.*;

public interface VisitorService {
    void addNewVisitor(VisitorDTO visitorDTO);
    void buySubscription(VisitorDTO visitorDTO, SubscriptionDTO subscriptionDTO);
    void signUpForAWorkout(VisitorDTO visitorDTO, TrainingSessionDTO trainingSessionDTO);//
}
