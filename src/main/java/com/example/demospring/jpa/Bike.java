package com.example.demospring.jpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Brand brand;

    private String model;
    private String name;
    private int engineCapacity;
    private int hp;

    private String wikiLink;

    public Bike() {
    }

    public Bike(Brand brand, String model, String name, int engineCapacity, int hp) {
        this.brand = brand;
        setModel(model);
        setName(name);
        this.engineCapacity = engineCapacity;
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setModel(String model) {
        this.model = model.toUpperCase();
    }
}
