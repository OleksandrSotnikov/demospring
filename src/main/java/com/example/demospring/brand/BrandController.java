package com.example.demospring.brand;

import com.example.demospring.Exception.DoesNotExistException;
import com.example.demospring.Exception.ImpossibleToDeleteException;
import com.example.demospring.Exception.NotFoundException;
import com.example.demospring.bike.JpaBike;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    private final JpaBrand jpaBrand;
    private final JpaBike jpaBike;

    public BrandController(JpaBrand jpaBrand, JpaBike jpaBike) {
        this.jpaBrand = jpaBrand;
        this.jpaBike = jpaBike;
    }

    @GetMapping("/brands")
    public List<Brand> brands() {
        return jpaBrand.findAll();
    }

    @GetMapping("/brands/{id}")
    public Brand getById(@PathVariable Long id) {
        return jpaBrand.findById(id).orElseThrow(() -> new NotFoundException("Brand Not Found", "Bike ID Not Found"));
    }

    @PostMapping("/brands")
    public Brand create(@RequestBody Brand brand) {
        return jpaBrand.save(brand);
    }

    @PutMapping("/brands/{id}")
    public Brand edit(@RequestBody Brand brand,
                      @PathVariable Long id) {
        jpaBrand.findById(id).orElseThrow(() -> new DoesNotExistException("Bad Request", "Incorrect brand's ID"));
        brand.setId(id);
        return jpaBrand.save(brand);
    }

    @DeleteMapping("/brands/{id}")
    public ResponseEntity<Object> delete(@RequestBody Brand brand,
                                         @PathVariable Long id) {
        jpaBrand.findById(id).orElseThrow(() -> new DoesNotExistException("Bad Request", "Incorrect brand's ID'"));

        if (jpaBike.existsByBrandId(id)) {
            throw new ImpossibleToDeleteException("Impossible to delete", "Some bikes belong to this brand");
        }

        return ResponseEntity.noContent().build();
    }
}
