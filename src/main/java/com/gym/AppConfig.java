package com.gym;

import com.gym.repositories.*;
import com.gym.repositories.impl.*;
import com.gym.services.GymService;
import com.gym.services.TrainerService;
import com.gym.services.VisitorService;
import com.gym.services.impl.GymServiceImplementation;
import com.gym.services.impl.TrainerServiceImplementation;
import com.gym.services.impl.VisitorServiceImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.gym.repositories")
@PropertySource(value = "application.properties")
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ContractRepository contractRepository() {
        return new ContractRepositoryImplementationImplementation();
    }

    @Bean
    public GymRepository gymRepository() {
        return new GymRepositoryImplementationImplementation();
    }

    @Bean
    public SubscriptionRepository subscriptionRepository() {
        return new SubscriptionRepositoryImplementationImplementation();
    }

    @Bean
    public TrainerRepository trainerRepository() {
        return new TrainerRepositoryImplementationImplementation();
    }

    @Bean
    public TrainingSessionRepository trainingSessionRepository() {
        return new TrainingSessionRepositoryImplementationImplementation();
    }

    @Bean
    public VisitorRepository visitorRepository() {
        return new VisitorRepositoryImplementationImplementation();
    }

    @Bean
    public GymService gymService() {
        return new GymServiceImplementation(gymRepository());
    }

    @Bean
    public TrainerService trainerService() {
        return new TrainerServiceImplementation(trainerRepository(), contractRepository(), gymRepository(), modelMapper());
    }

    @Bean
    public VisitorService visitorService() {
        return new VisitorServiceImplementation(visitorRepository(), subscriptionRepository(), trainingSessionRepository(), gymRepository(), trainerRepository(), modelMapper());
    }
}
