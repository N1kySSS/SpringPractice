package com.gym.repository;

import com.gym.entity.Contract;
import org.springframework.stereotype.Component;

@Component
public interface ContractRepository {
    Contract findByTrainerId(Long Id);
}
