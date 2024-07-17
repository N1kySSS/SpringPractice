package com.gym.repositories.impl;

import com.gym.entities.Contract;
import com.gym.repositories.ContractRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepositoryImplementation extends BaseRepository<Contract, Long> implements ContractRepository {
    @Override
    public Contract findContractByTrainerId(Long trainerId) {
        String jpql = "SELECT c FROM Contract c WHERE c.trainer.id = :trainerId";
        TypedQuery<Contract> query = entityManager.createQuery(jpql, Contract.class);
        query.setParameter("trainerId", trainerId);
        return query.getSingleResult();
    }
}
