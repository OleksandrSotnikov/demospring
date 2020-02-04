package com.example.demospring.repositories;

import com.example.demospring.exceptions.DoesNotExistException;
import com.example.demospring.exceptions.ImpossibleToDeleteException;
import com.example.demospring.exceptions.NotFoundException;
import com.example.demospring.jpa.Brand;
import com.example.demospring.jpa.JpaBike;
import com.example.demospring.jpa.JpaBrand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandRepository {

    private final JpaBrand jpaBrand;
    private final JpaBike jpaBike;

    public BrandRepository(JpaBrand jpaBrand, JpaBike jpaBike) {
        this.jpaBrand = jpaBrand;
        this.jpaBike = jpaBike;
    }

    public List<Brand> findAll() {
        return jpaBrand.findAll();
    }

    public Brand getById(Long id) {
        return jpaBrand
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Brand Not Found", "Brand ID Not Found"));
    }

    public Brand create(Brand brand) {
        return jpaBrand.save(brand);
    }

    public Brand edit(Long id, Brand brand) {
        jpaBrand.findById(id).orElseThrow(() -> new DoesNotExistException("Bad Request", "Incorrect brand's ID"));
        brand.setId(id);
        return jpaBrand.save(brand);
    }

    public void delete(Long id) {
        jpaBrand.findById(id).orElseThrow(() -> new DoesNotExistException("Bad Request", "Incorrect brand's ID'"));

        if (jpaBike.existsByBrandId(id)) {
            throw new ImpossibleToDeleteException("Impossible to delete", "Some bikes belong to this brand");
        }

        jpaBrand.deleteById(id);
    }
}
