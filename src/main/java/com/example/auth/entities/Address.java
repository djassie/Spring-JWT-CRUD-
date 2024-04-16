package com.example.auth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="entity_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String HouseNo;
    private String StreetAddress;

    @Column(nullable = false)
    private String zipCode;
    private String State;
    private String Country;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Address() {
    }

    public Address(String houseNo, String streetAddress, String zipCode, String state, String country, User user) {
        HouseNo = houseNo;
        StreetAddress = streetAddress;
        this.zipCode = zipCode;
        State = state;
        Country = country;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getHouseNo() {
        return HouseNo;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return State;
    }

    public String getCountry() {
        return Country;
    }

    public User getUser() {
        return user;
    }

    public void setHouseNo(String houseNo) {
        HouseNo = houseNo;
    }

    public void setStreetAddress(String streetAddress) {
        StreetAddress = streetAddress;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setState(String state) {
        State = state;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
