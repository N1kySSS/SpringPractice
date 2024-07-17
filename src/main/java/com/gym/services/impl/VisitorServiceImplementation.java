package com.gym.services.impl;

import com.gym.dtos.SubscriptionDTO;
import com.gym.dtos.TrainingSessionDTO;
import com.gym.dtos.VisitorDTO;
import com.gym.entities.Subscription;
import com.gym.entities.Trainer;
import com.gym.entities.TrainingSession;
import com.gym.entities.Visitor;
import com.gym.entities.enums.SubscriptionType;
import com.gym.repositories.*;
import com.gym.services.VisitorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Service
public class VisitorServiceImplementation extends BaseServiceImplementation implements VisitorService {
    private final VisitorRepository visitorRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final TrainingSessionRepository trainingSessionRepository;
    private final GymRepository gymRepository;
    private final TrainerRepository trainerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public VisitorServiceImplementation(VisitorRepository visitorRepository, SubscriptionRepository subscriptionRepository, TrainingSessionRepository trainingSessionRepository, GymRepository gymRepository, TrainerRepository trainerRepository, ModelMapper modelMapper) {
        this.visitorRepository = visitorRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.trainingSessionRepository = trainingSessionRepository;
        this.gymRepository = gymRepository;
        this.trainerRepository = trainerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public void addNewVisitor(VisitorDTO visitorDTO) {
        if (visitorRepository.findByEmail(visitorDTO.getEmail()) != null) {
            throw new IllegalArgumentException("Visitor with this email already exists, change email");
            //TODO(спросить про enum)
        }

        Visitor visitor = modelMapper.map(visitorDTO, Visitor.class);
        visitorRepository.save(visitor);
    }

    @Override
    public void buySubscription(VisitorDTO visitorDTO, SubscriptionDTO subscriptionDTO) {
        float premiumPrice3Month = 0.9f;
        float premiumPrice6Month = 0.8f;
        float premiumPrice12Month = 0.7f;
        float groupPrice3Month = 0.95f;
        float groupPrice6Month = 0.9f;
        float groupPrice12Month = 0.85f;
        float cost = 0;

        if (visitorRepository.findById(visitorDTO.getId()) == null) {
            throw new IllegalArgumentException("Visitor with this id does not exist");
        }

        switch (subscriptionDTO.getType()) {
            case PREMIUM -> {
                int periodInMonth = Integer.parseInt(subscriptionDTO.getPeriodInMonth());
                if (periodInMonth >= 3 && periodInMonth < 6) {
                    cost = SubscriptionType.PREMIUM.getCostMonth() * premiumPrice3Month;
                } else if (periodInMonth >= 6 && periodInMonth < 12) {
                    cost = SubscriptionType.PREMIUM.getCostMonth() * premiumPrice6Month;
                } else if (periodInMonth >= 12) {
                    cost = SubscriptionType.PREMIUM.getCostMonth() * premiumPrice12Month;
                } else {
                    cost = SubscriptionType.PREMIUM.getCostMonth();
                }
            }
            case GROUP -> {
                int periodInMonth = Integer.parseInt(subscriptionDTO.getPeriodInMonth());
                if (periodInMonth >= 3 && periodInMonth < 6) {
                    cost = SubscriptionType.GROUP.getCostMonth() * groupPrice3Month;
                } else if (periodInMonth >= 6 && periodInMonth < 12) {
                    cost = SubscriptionType.GROUP.getCostMonth() * groupPrice6Month;
                } else if (periodInMonth >= 12) {
                    cost = SubscriptionType.GROUP.getCostMonth() * groupPrice12Month;
                } else {
                    cost = SubscriptionType.GROUP.getCostMonth();
                }
            }
            case BASIC -> {
                cost = SubscriptionType.BASIC.getCostMonth();
            }
            default -> throw new IllegalArgumentException("There is no subscription with this type");
        }

        if (gymRepository.findGymByName(subscriptionDTO.getGym().getName()) == null) {
            throw new IllegalArgumentException("Gym with this name does not exist");
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = currentDate.plusMonths(Long.parseLong(subscriptionDTO.getPeriodInMonth()));
        subscriptionDTO.setEndDate(endDate);
        subscriptionDTO.setCost(cost);
        Subscription subscription = modelMapper.map(subscriptionDTO, Subscription.class);
        subscriptionRepository.save(subscription);

        Visitor visitor = visitorRepository.findById(subscriptionDTO.getVisitor().getId());
        visitor.setSubscription(subscription);
        visitorRepository.update(visitor);
    }

    @Override
    public void signUpForAWorkout(VisitorDTO visitorDTO, TrainingSessionDTO trainingSessionDTO) {
        if (trainerRepository.findTrainersByCriteria(trainingSessionDTO.getExperience(), trainingSessionDTO.getSpecialization()).getFirst() == null) {
            throw new IllegalArgumentException("Trainer with this specialization and this experience does not exist");
        } else {
            Trainer trainer = trainerRepository.findTrainersByCriteria(trainingSessionDTO.getExperience(), trainingSessionDTO.getSpecialization()).getFirst();
            if (trainerRepository.findAvailableTrainer(trainer.getId(), trainingSessionDTO.getTrainingTime(), trainingSessionDTO.getTrainingDate()) == null) {
                throw new IllegalArgumentException("Trainer is busy at this time");
            }

            trainingSessionDTO.setTrainer(trainer);
            TrainingSession trainingSession = modelMapper.map(trainingSessionDTO, TrainingSession.class);
            trainingSessionRepository.save(trainingSession);
        }

        if (trainerRepository.findTrainersBySpecialization(trainingSessionDTO.getSpecialization()).getFirst() == null) {
            throw new IllegalArgumentException("Trainer with this specialization does not exist");
        } else {
            Trainer trainer = trainerRepository.findTrainersByCriteria(trainingSessionDTO.getExperience(), trainingSessionDTO.getSpecialization()).getFirst();
            if (trainerRepository.findAvailableTrainer(trainer.getId(), trainingSessionDTO.getTrainingTime(), trainingSessionDTO.getTrainingDate()) == null) {
                throw new IllegalArgumentException("Trainer is busy at this time");
            }

            trainingSessionDTO.setTrainer(trainer);
            TrainingSession trainingSession = modelMapper.map(trainingSessionDTO, TrainingSession.class);
            trainingSessionRepository.save(trainingSession);

            Set<TrainingSession> trainingSessions = Set.of(trainingSession);

            Visitor visitor = visitorRepository.findById(trainingSession.getVisitor().getId());
            visitor.setTrainingSessions(trainingSessions);
            visitorRepository.update(visitor);

            trainer.setTrainingSessions(trainingSessions);
            trainerRepository.update(trainer);
        }
    }
}
