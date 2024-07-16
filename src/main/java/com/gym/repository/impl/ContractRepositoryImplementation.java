package com.gym.repository.impl;

import com.gym.entity.Contract;
import com.gym.repository.ContractRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepositoryImplementation extends BaseRepository<Contract, Long> implements ContractRepository {

    @Override
    public Contract findContractByTrainerId(Long trainerId) {
        String jpql = "SELECT c FROM Contract c WHERE c.trainer.id = :trainerId";
        TypedQuery<Contract> query = entityManager.createQuery(jpql, Contract.class);
        query.setParameter("trainerId", trainerId);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new EntityNotFoundException("Trainer with such trainerId does not have contract");
        }
    }
}
