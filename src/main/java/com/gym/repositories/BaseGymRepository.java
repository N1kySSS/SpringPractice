package com.gym.repositories;

import com.gym.entities.Gym;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseGymRepository {
    @Query("SELECT g FROM Gym g WHERE g.name = :name")
    Gym findGymByName(@Param(value = "name") String name);
}
