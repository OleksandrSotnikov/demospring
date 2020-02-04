package com.example.demospring.controllers;

import com.example.demospring.exceptions.DoesNotExistException;
import com.example.demospring.exceptions.ImpossibleToDeleteException;
import com.example.demospring.jpa.Brand;
import com.example.demospring.jpa.JpaBike;
import com.example.demospring.jpa.JpaBrand;
import com.example.demospring.repositories.BrandRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    private final JpaBrand jpaBrand;
    private final JpaBike jpaBike;
    private final BrandRepository brandRepo;

    public BrandController(JpaBrand jpaBrand, JpaBike jpaBike, BrandRepository brandRepo) {
        this.jpaBrand = jpaBrand;
        this.jpaBike = jpaBike;
        this.brandRepo = brandRepo;
    }

    @GetMapping("/brands")
    public List<Brand> brands() {
        return brandRepo.findAll();
    }

    @GetMapping("/brands/{id}")
    public Brand getById(@PathVariable Long id) {
        return brandRepo.getById(id);
    }

    @PostMapping("/brands")
    public Brand create(@RequestBody Brand brand) {
        return brandRepo.create(brand);
    }

    @PutMapping("/brands/{id}")
    public Brand edit(@RequestBody Brand brand,
                      @PathVariable Long id) {
        return brandRepo.edit(id, brand);
    }

    @DeleteMapping("/brands/{id}")
    public ResponseEntity<Object> delete(@RequestBody Brand brand,
                                         @PathVariable Long id) {
        jpaBrand.findById(id).orElseThrow(() -> new DoesNotExistException("Bad Request", "Incorrect brand's ID'"));

        if (jpaBike.existsByBrandId(id)) {
            throw new ImpossibleToDeleteException("Impossible to delete", "Some bikes belong to this brand");
        }

        jpaBrand.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
