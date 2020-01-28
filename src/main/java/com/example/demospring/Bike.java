package com.example.demospring;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Brand brand;

    private String model;

    public Bike() {
    }

    public Bike(Brand brand, String model) {
        this.brand = brand;
        this.model = model;
    }
}
