package com.example.demospring.configs;

import com.example.demospring.jpa.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedDatabase {

    @Bean
    public CommandLineRunner seed(JpaBike bikeRepo, JpaBrand brandRepo) {
        return (args) -> {

            Brand honda = new Brand("Honda", 1946, CountryEnum.JAP);
            Brand suzuki = new Brand("Suzuki", 1909, CountryEnum.JAP);
            Brand kawasaki = new Brand("Kawasaki", 1896, CountryEnum.JAP);

            brandRepo.save(honda);
            brandRepo.save(suzuki);
            brandRepo.save(kawasaki);

            bikeRepo.save(new Bike(honda, "CBR1100XX", "Super Blackbird"));
            bikeRepo.save(new Bike(suzuki, "DL650", "V-Strom"));
            bikeRepo.save(new Bike(kawasaki, "H2R", "Ninja"));
        };
    }
}
