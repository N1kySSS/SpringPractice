package com.gym.repositories.impl;

import com.gym.entities.Contract;
import com.gym.repositories.BaseContractRepository;
import com.gym.repositories.ContractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepositoryImplementation extends DefaultRepository<BaseContractRepository> implements ContractRepository {

    @Override
    public Contract getContractByTrainerId(Long trainerId) {
        return defaultRepository.getContractByTrainerId(trainerId);
    }

    @Override
    public void add(Contract contract) {
        defaultRepository.save(contract);
    }
}
