package com.example.demospring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedDatabase {

    @Bean
    public CommandLineRunner seed(JpaBike bikeRepo, JpaBrand brandRepo) {
        return (args) -> {

            Brand honda = new Brand("Honda", 1954, CountryEnum.JAP);
            Brand suzuki = new Brand("Suzuki", 1960, CountryEnum.JAP);
            Brand kawasaki = new Brand("Kawasaki", 1972, CountryEnum.JAP);

            brandRepo.save(honda);
            brandRepo.save(suzuki);
            brandRepo.save(kawasaki);

            bikeRepo.save(new Bike(honda, "CBR1100XX"));
            bikeRepo.save(new Bike(suzuki, "DL650"));
            bikeRepo.save(new Bike(kawasaki, "H2R"));
        };
    }
}
