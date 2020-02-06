package com.example.demospring.repositories;

import com.example.demospring.exceptions.DoesNotExistException;
import com.example.demospring.exceptions.NotFoundException;
import com.example.demospring.exceptions.UnprocessableEntityException;
import com.example.demospring.jpa.Bike;
import com.example.demospring.jpa.Brand;
import com.example.demospring.jpa.JpaBike;
import com.example.demospring.jpa.JpaBrand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BikeRepository {

    private JpaBike jpaBike;
    private JpaBrand jpaBrand;

    public BikeRepository(JpaBike jpaBike, JpaBrand jpaBrand) {
        this.jpaBike = jpaBike;
        this.jpaBrand = jpaBrand;
    }

    public List<Bike> findAll() {
        return jpaBike.findAll();
    }

    public Bike getById(Long id) {
        return jpaBike.findById(id).orElseThrow(() -> new NotFoundException("Bike Not Found", "Bike ID Not Found"));
    }

    public Bike create(Bike bike) {
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

    public Bike edit(Bike bike, Long id) {
        jpaBike.findById(id).orElseThrow(() -> new DoesNotExistException("Bad Request", "Incorrect bike's ID"));
        bike.setId(id);
        return jpaBike.save(bike);
    }

    public void delete(Long id) {
        jpaBike.findById(id).orElseThrow(() -> new DoesNotExistException("Bad Request", "Incorrect brand's ID'"));

        jpaBike.deleteById(id);
    }
}

