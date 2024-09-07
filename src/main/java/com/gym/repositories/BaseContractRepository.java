package com.gym.repositories;

import com.gym.entities.Contract;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BaseContractRepository extends BaseRepository<Contract> {
    @Query("SELECT c FROM Contract c WHERE c.trainer.id = :trainerId")
    Contract getContractByTrainerId(@Param(value = "trainerId") Long trainerId);
}
