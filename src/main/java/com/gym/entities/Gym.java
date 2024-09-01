package com.gym.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "gym")
public class Gym extends IdEntity {

    private String name;

    private String contactNumber;

    private String location;

    private String workingHours;

    private Set<Subscription> subscriptions;

    private Set<Contract> contracts;

    public Gym(String name, String contactNumber, String location, String workingHours) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.location = location;
        this.workingHours = workingHours;
    }

    protected Gym() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "contact_number", nullable = false)
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Column(name = "location", nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "working_hours", nullable = false)
    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    @OneToMany(mappedBy = "gym", targetEntity = Subscription.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @OneToMany(mappedBy = "gym", targetEntity = Contract.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
