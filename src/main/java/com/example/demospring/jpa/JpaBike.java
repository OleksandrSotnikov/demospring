package com.example.demospring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaBike extends JpaRepository<Bike, Long> {

    boolean existsByBrandId(Long id);
    List<Bike> findAllByBrandId(Long id);
}
