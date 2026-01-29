package com.blooddonation.config;

import com.blooddonation.entity.Donor;
import com.blooddonation.repository.DonorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public org.springframework.boot.CommandLineRunner initDonors(DonorRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(Donor.builder()
                        .name("Rahul Singh")
                        .email("rahul@gmail.com")
                        .phone("9999999999")
                        .bloodGroup("A+")
                        .city("Mumbai")
                        .build());

                System.out.println("✅ Sample donor inserted");
            } else {
                System.out.println("ℹ️ Donors already exist");
            }
        };
    }
}
