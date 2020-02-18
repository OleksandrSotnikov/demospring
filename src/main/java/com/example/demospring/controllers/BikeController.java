package com.example.demospring.controllers;

import com.example.demospring.jpa.Bike;
import com.example.demospring.repositories.BikeQuery;
import com.example.demospring.repositories.BikeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {
    private static final Logger LOG = LoggerFactory.getLogger(BikeController.class);

    private final BikeRepository bikeRepo;

    public BikeController(BikeRepository bikeRepo) {
        this.bikeRepo = bikeRepo;
    }

    @GetMapping("/bikes")
    public List<Bike> bikes(BikeQuery query) {
        return bikeRepo.search(query);
    }

    @GetMapping("/bikes/{id}")
    public Bike getById(@PathVariable Long id) {
        Bike bike = bikeRepo.getById(id);
        LOG.info("getting bike by {}: {}", id, bike);
        return bike;
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
}

