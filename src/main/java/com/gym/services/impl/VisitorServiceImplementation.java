package com.gym.services.impl;

import com.gym.dtos.SubscriptionDTO;
import com.gym.dtos.TrainingSessionDTO;
import com.gym.dtos.VisitorDTO;
import com.gym.entities.*;
import com.gym.entities.enums.SubscriptionType;
import com.gym.repositories.*;
import com.gym.services.VisitorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

@Service
public class VisitorServiceImplementation implements VisitorService {
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
    public void addNewVisitor(VisitorDTO visitorDTO) {
        if (visitorRepository.findByEmail(visitorDTO.getEmail()) != null) {
            throw new IllegalArgumentException("Visitor with this email already exists, change email");
        }

        Visitor visitor = modelMapper.map(visitorDTO, Visitor.class);
        visitorRepository.save(visitor);
    }

    @Override
    public void buySubscription(Long visitorId, String gymName, SubscriptionDTO subscriptionDTO) {
        float premiumPrice3Month = 0.9f;
        float premiumPrice6Month = 0.8f;
        float premiumPrice12Month = 0.7f;
        float groupPrice3Month = 0.95f;
        float groupPrice6Month = 0.9f;
        float groupPrice12Month = 0.85f;
        float cost = 0;

        if (visitorRepository.findById(visitorId) == null) {
            throw new IllegalArgumentException("Visitor with this id does not exist");
        }

        if (visitorRepository.findById(visitorId).getSubscription() != null) {
            throw new IllegalArgumentException("Visitor already has subscription");
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

        if (gymRepository.findGymByName(gymName) == null) {
            throw new IllegalArgumentException("Gym with this name does not exist");
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = currentDate.plusMonths(Long.parseLong(subscriptionDTO.getPeriodInMonth()));
        subscriptionDTO.setEndDate(endDate);
        subscriptionDTO.setCost(cost);
        subscriptionDTO.setVisitorId(visitorId);
        subscriptionDTO.setGymId(gymRepository.findGymByName(gymName).getId());
        Subscription subscription = modelMapper.map(subscriptionDTO, Subscription.class);
        subscriptionRepository.save(subscription);

        Visitor visitor = visitorRepository.findById(subscriptionDTO.getVisitorId());
        visitor.setSubscription(subscription);
        visitorRepository.update(visitor);
    }

    @Override
    public void signUpForAWorkout(TrainingSessionDTO trainingSessionDTO) {
        if (trainerRepository.findTrainersByCriteria(trainingSessionDTO.getExperience(), trainingSessionDTO.getSpecialization()).getFirst() == null) {
            throw new IllegalArgumentException("Trainer with this specialization and this experience does not exist");
        } else {
            Trainer trainer = trainerRepository.findTrainersByCriteria(trainingSessionDTO.getExperience(), trainingSessionDTO.getSpecialization()).getFirst();
            if (trainerRepository.findAvailableTrainer(trainer.getId(), trainingSessionDTO.getTrainingTime(), trainingSessionDTO.getTrainingDate()) == null) {
                throw new IllegalArgumentException("Trainer is busy at this time");
            }

            String visitorsGym = visitorRepository.findById(trainingSessionDTO.getVisitorId()).getSubscription().getGym().getName();
            if (findGym(visitorsGym, trainingSessionDTO)) {
                trainingSessionDTO.setTrainerId(trainer.getId());
                TrainingSession trainingSession = new TrainingSession(visitorRepository.findById(trainingSessionDTO.getVisitorId()),
                        trainerRepository.findById(trainingSessionDTO.getTrainerId()),
                        trainingSessionDTO.getTrainingTime(),
                        trainingSessionDTO.getTrainingDate());
                trainingSessionRepository.save(trainingSession);

                visitorRepository.findById(trainingSessionDTO.getVisitorId()).addTrainingSession(trainingSession);
                Visitor visitor = visitorRepository.findById(trainingSession.getVisitor().getId());
                visitorRepository.update(visitor);

                trainer.addTrainingSession(trainingSession);
                trainerRepository.update(trainer);
            } else {
                throw new IllegalArgumentException("Trainer does not work in your gym");
            }

        }
    }

    public Boolean findGym(String visitorsGym, TrainingSessionDTO trainingSessionDTO) {
        Set<Contract> contracts = trainerRepository.findById(trainingSessionDTO.getTrainerId()).getContracts();
        for (Contract contract : contracts) {
            if (contract.getGym().getName().equals(visitorsGym)) {
                return true;
            }
        }
        return false;
    }
}
