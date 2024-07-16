package com.gym.services.impl;

import com.gym.repositories.SubscriptionRepository;
import com.gym.repositories.TrainingSessionRepository;
import com.gym.repositories.VisitorRepository;
import com.gym.services.VisitorService;
import com.gym.services.dtos.SubscriptionDTO;
import com.gym.services.dtos.TrainingSessionDTO;
import com.gym.services.dtos.VisitorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VisitorServiceImplementation extends BaseServiceImplementation implements VisitorService {
    private final VisitorRepository visitorRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final TrainingSessionRepository trainingSessionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public VisitorServiceImplementation(VisitorRepository visitorRepository, SubscriptionRepository subscriptionRepository, TrainingSessionRepository trainingSessionRepository, ModelMapper modelMapper) {
        this.visitorRepository = visitorRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.trainingSessionRepository = trainingSessionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public void addNewVisitor(VisitorDTO visitorDTO) {

    }

    @Override
    @Transactional
    public void buySubscription(VisitorDTO visitorDTO, SubscriptionDTO subscriptionDTO) {

    }

    @Override
    @Transactional
    public void signUpForAWorkout(VisitorDTO visitorDTO, TrainingSessionDTO trainingSessionDTO) {

    }
}
