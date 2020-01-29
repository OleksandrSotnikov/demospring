package com.example.demospring.brand;

import com.example.demospring.CountryEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer year;
    private CountryEnum country;

    public Brand() {
    }

    public Brand(String name, Integer year, CountryEnum country) {
        this.name = name;
        this.year = year;
        this.country = country;
    }
}
