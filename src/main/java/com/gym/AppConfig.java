package com.gym;

import com.gym.repository.*;
import com.gym.repository.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "application.properties")
public class AppConfig {
    @Bean
    public ContractRepository contractRepository() {
        return new ContractRepositoryImplementation();
    }

    @Bean
    public GymRepository gymRepository() {
        return new GymRepositoryImplementation();
    }

    @Bean
    public SubscriptionRepository subscriptionRepository() {
        return new SubscriptionRepositoryImplementation();
    }

    @Bean
    public TrainerRepository trainerRepository() {
        return new TrainerRepositoryImplementation();
    }

    @Bean
    public TrainingSessionRepository trainingSessionRepository() {
        return new TrainingSessionRepositoryImplementation();
    }

    @Bean
    public VisitorRepository visitorRepository() {
        return new VisitorRepositoryImplementation();
    }

    //TODO(Добавить сервисы и их имплементации)
}
