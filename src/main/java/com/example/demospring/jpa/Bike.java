package com.example.demospring.jpa;

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
    private String name;

    public Bike() {
    }

    public Bike(Brand brand, String model, String name) {
        this.brand = brand;
        setModel(model);
        setName(name);
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setModel(String model) {
        this.model = model.toUpperCase();
    }
}
