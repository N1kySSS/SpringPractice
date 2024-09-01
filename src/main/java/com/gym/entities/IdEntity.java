package com.gym.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class IdEntity {
    private Long id;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
