package com.example.demospring;

import org.springframework.web.bind.annotation.GetMapping;
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


}
