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
            Brand bmw = new Brand("BMW",1916, CountryEnum.GER);
            Brand ducati = new Brand("Ducati", 1926, CountryEnum.ITA);

            brandRepo.save(honda);
            brandRepo.save(suzuki);
            brandRepo.save(kawasaki);
            brandRepo.save(bmw);
            brandRepo.save(ducati);

            bikeRepo.save(new Bike(honda, "CBR1100XX", "Super Blackbird", 1100, 153));
            bikeRepo.save(new Bike(suzuki, "DL650", "V-Strom", 650, 66));
            bikeRepo.save(new Bike(suzuki, "DL1000", "V-Strom", 996, 98));
            bikeRepo.save(new Bike(kawasaki, "H2R", "Ninja", 998, 310));
            bikeRepo.save(new Bike(kawasaki, "KLZ 1000", "Versys", 1043, 118));
            bikeRepo.save(new Bike(kawasaki, "KLE 650", "Versys", 649, 64));
            bikeRepo.save(new Bike(bmw, "R1200GS", "GS", 1170, 123));
            bikeRepo.save(new Bike(bmw, "F650GS", "GS", 652, 48));
            bikeRepo.save(new Bike(bmw, "F800GS", "GS", 798, 85));
            bikeRepo.save(new Bike(ducati, "Multistrada 1200", "Multistrada", 1100, 150));
            bikeRepo.save(new Bike(suzuki, "GSX1300R", "Hayabusa", 1299, 197));
        };
    }
}
