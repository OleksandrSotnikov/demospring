package com.example.demospring.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer year;
    private CountryEnum country;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Bike> bikes;

    public Brand() {
    }

    public Brand(String name, Integer year, CountryEnum country) {
        this.name = name;
        this.year = year;
        this.country = country;
    }
}
