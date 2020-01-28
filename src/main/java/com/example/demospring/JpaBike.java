package com.example.demospring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBike extends JpaRepository<Bike, Long> {

}
