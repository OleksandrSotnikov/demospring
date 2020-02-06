package com.example.demospring.controllers;

import com.example.demospring.jpa.Bike;
import com.example.demospring.repositories.BikeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {

    private final BikeRepository bikeRepo;

    public BikeController(BikeRepository bikeRepo) {
        this.bikeRepo = bikeRepo;
    }

    @GetMapping("/bikes")
    public List<Bike> bikes() {
        return bikeRepo.findAll();
    }

    @GetMapping("/bikes/{id}")
    public Bike getById(@PathVariable Long id) {
        return bikeRepo.getById(id);
    }

    @PostMapping("/bikes")
    public Bike create(@RequestBody Bike bike) {
        return bikeRepo.create(bike);
    }

    @PutMapping("/bikes/{id}")
    public Bike edit(@RequestBody Bike bike,
                     @PathVariable Long id) {
        return bikeRepo.edit(bike, id);
    }


    @DeleteMapping("/bikes/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        bikeRepo.delete(id);
        return ResponseEntity.noContent().build();
    }

    //todo: mute null objects (JSON), Query, many parameters
}
