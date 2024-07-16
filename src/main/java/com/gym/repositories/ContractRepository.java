package com.gym.repositories;

import com.gym.entities.Contract;
import org.springframework.stereotype.Component;

@Component
public interface ContractRepository {
    Contract findContractByTrainerId(Long Id);
}
