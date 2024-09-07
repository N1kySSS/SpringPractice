package com.gym.repositories;

import com.gym.entities.Contract;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository {

    Contract getContractByTrainerId(Long trainerId);

    void add(Contract contract);
}
