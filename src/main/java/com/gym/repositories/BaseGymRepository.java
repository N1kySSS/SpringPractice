package com.gym.repositories;

import com.gym.entities.Gym;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BaseGymRepository extends BaseRepository<Gym> {
    @Query("SELECT g FROM Gym g WHERE g.name = :name")
    Gym findGymByName(@Param(value = "name") String name);
}
