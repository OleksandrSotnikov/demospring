package com.example.demospring.repositories;

import com.example.demospring.exceptions.DoesNotExistException;
import com.example.demospring.exceptions.NotFoundException;
import com.example.demospring.exceptions.UnprocessableEntityException;
import com.example.demospring.jpa.Bike;
import com.example.demospring.jpa.Brand;
import com.example.demospring.jpa.JpaBike;
import com.example.demospring.jpa.JpaBrand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class BikeRepository {

    private static final Logger LOG = LoggerFactory.getLogger(BikeRepository.class);

    private JpaBike jpaBike;
    private JpaBrand jpaBrand;

    public BikeRepository(JpaBike jpaBike, JpaBrand jpaBrand) {
        this.jpaBike = jpaBike;
        this.jpaBrand = jpaBrand;
    }

    // TODO: look into how to perform query on the database!!!
    public List<Bike> search(BikeQuery query) {
        Stream<Bike> stream = jpaBike.findAll().stream();

        if (query.getEngineCapacityFrom() != null) {
            stream = stream.filter(bike -> bike.getEngineCapacity() >= query.getEngineCapacityFrom());
        }

        if (query.getEngineCapacityTo() != null) {
            stream = stream.filter(bike -> bike.getEngineCapacity() <= query.getEngineCapacityTo());
        }

        if (query.getHpFrom() != null) {
            stream = stream.filter(bike -> bike.getHp() >= query.getHpFrom());
        }

        if (query.getHpTo() != null) {
            stream = stream.filter(bike -> bike.getHp() <= query.getHpTo());
        }

        return stream.collect(Collectors.toList());
    }

    public Bike getById(Long id) {
        LOG.info("search a bike by id {}", id);
        return jpaBike
                .findById(id)
                .orElseThrow(() -> {
                    LOG.info("bike with id {} not found", id);
                    return new NotFoundException("Bike Not Found", "Bike ID Not Found");
                });
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

