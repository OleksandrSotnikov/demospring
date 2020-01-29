package com.example.demospring.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBrand extends JpaRepository<Brand, Long> {

}
