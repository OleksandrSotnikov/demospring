package com.example.demospring.controllers;

import com.example.demospring.exceptions.DoesNotExistException;
import com.example.demospring.exceptions.NotFoundException;
import com.example.demospring.exceptions.UnprocessableEntityException;
import com.example.demospring.jpa.Bike;
import com.example.demospring.jpa.Brand;
import com.example.demospring.jpa.JpaBike;
import com.example.demospring.jpa.JpaBrand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {

    private final JpaBike jpaBike;
    private final JpaBrand jpaBrand;

    public BikeController(JpaBike jpaBike, JpaBrand jpaBrand) {
        this.jpaBike = jpaBike;
        this.jpaBrand = jpaBrand;
    }

    @GetMapping("/bikes")
    public List<Bike> bikes() {
        return jpaBike.findAll();
    }

    @GetMapping("/bikes/{id}")
    public Bike getById(@PathVariable Long id) {
        return jpaBike.findById(id).orElseThrow(() -> new NotFoundException("Bike Not Found", "Bike ID Not Found"));
    }

    @PostMapping("/bikes")
    public Bike create(@RequestBody Bike bike) {
        if (bike.getBrand() == null) {
            throw new UnprocessableEntityException("No Brand", "Brand was not sent");
        }

        if (bike.getBrand().getId() == null) {
            throw new UnprocessableEntityException("No Brand ID", "Brand ID was not sent");
        }

        Brand brand = jpaBrand
                .findById(bike.getBrand().getId())
                .orElseThrow(() -> new DoesNotExistException("Brand Does Not Exist", "Brand Does Not Exist"));

        bike.setBrand(brand);

        return jpaBike.save(bike);
    }


    //todo Name to uppercase, edit brand name in bike
    @PutMapping("/bikes/{id}")
    public Bike edit(@RequestBody Bike bike,
                     @PathVariable Long id){
        jpaBike.findById(id).orElseThrow(() -> new DoesNotExistException("Bad Request", "Incorrect bike's ID"));
        bike.setId(id);
        return jpaBike.save(bike);
    }

}
