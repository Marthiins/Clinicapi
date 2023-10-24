package com.sergio.clinicapi.clinicaapi.entity;

import jakarta.persistence.Column;

import java.io.Serializable;

public class Address implements Serializable {

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "city", nullable = false)
    private String city;

    public Address(String country, String state, String city) {
        this.country = country;
        this.state = state;
        this.city = city;
    }
}
