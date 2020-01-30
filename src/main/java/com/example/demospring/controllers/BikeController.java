package com.example.demospring.controllers;

import com.example.demospring.exceptions.NotFoundException;
import com.example.demospring.jpa.Bike;
import com.example.demospring.jpa.JpaBike;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BikeController {

    private final JpaBike jpaBike;

    public BikeController(JpaBike jpaBike) {
        this.jpaBike = jpaBike;

    }

    @GetMapping("/bikes")
    public List<Bike> bikes() {
        return jpaBike.findAll();
    }

    @GetMapping("/bikes/{id}")
    public Bike getById(@PathVariable Long id) {
        return jpaBike.findById(id).orElseThrow(() -> new NotFoundException("Bike Not Found", "Bike ID Not Found"));
    }
}
