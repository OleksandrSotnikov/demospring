package com.example.demospring.repositories;

import com.example.demospring.exceptions.NotFoundException;
import com.example.demospring.jpa.Brand;
import com.example.demospring.jpa.JpaBrand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandRepository {

    private final JpaBrand jpaBrand;

    public BrandRepository(JpaBrand jpaBrand) {
        this.jpaBrand = jpaBrand;
    }

    public List<Brand> findAll() {
        return jpaBrand.findAll();
    }

    public Brand getById(Long id) {
        return jpaBrand
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Brand Not Found", "Brand ID Not Found"));
    }


}