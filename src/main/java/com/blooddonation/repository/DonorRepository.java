package com.blooddonation.repository;

import com.blooddonation.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    Optional<Donor> findByPhone(String phone);
}
