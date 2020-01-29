package com.example.demospring.bike;

import com.example.demospring.brand.Brand;
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

    public Bike(Brand brand, String model,String name) {
        this.brand = brand;
        this.model = model;
        this.name = name;
    }
}
