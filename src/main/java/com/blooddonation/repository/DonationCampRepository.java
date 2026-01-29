package com.blooddonation.repository;

import com.blooddonation.entity.DonationCamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, Long> {
}
