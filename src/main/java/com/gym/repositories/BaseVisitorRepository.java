package com.gym.repositories;

import com.gym.entities.Visitor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseVisitorRepository extends BaseRepository<Visitor> {
    @Query("SELECT v FROM Visitor v WHERE v.email = :email")
    Visitor findByEmail(@Param(value = "email") String email);
}
