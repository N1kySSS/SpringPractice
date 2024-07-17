package com.gym.services;

import com.gym.dtos.*;

public interface VisitorService {
    void addNewVisitor(VisitorDTO visitorDTO);
    void buySubscription(Long visitorId, String gymName, SubscriptionDTO subscriptionDTO);
    void signUpForAWorkout(TrainingSessionDTO trainingSessionDTO);//
}
