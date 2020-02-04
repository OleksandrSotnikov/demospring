package com.example.demospring.controllers;

import com.example.demospring.jpa.Brand;
import com.example.demospring.repositories.BrandQuery;
import com.example.demospring.repositories.BrandRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    private final BrandRepository brandRepo;

    public BrandController(BrandRepository brandRepo) {
        this.brandRepo = brandRepo;
    }

    @GetMapping("/brands")
    public List<Brand> brands() {
        return brandRepo.findAll();
    }

    @GetMapping("/brands/{id}")
    public Brand getById(@PathVariable Long id) {
        return brandRepo.getById(id, new BrandQuery(true));
    }

    @PostMapping("/brands")
    public Brand create(@RequestBody Brand brand) {
        return brandRepo.create(brand);
    }

    @PutMapping("/brands/{id}")
    public Brand edit(@PathVariable Long id, @RequestBody Brand brand) {
        return brandRepo.edit(id, brand);
    }

    @DeleteMapping("/brands/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        brandRepo.delete(id);
        return ResponseEntity.noContent().build();
    }
}
