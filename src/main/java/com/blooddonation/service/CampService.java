package com.blooddonation.service;

import com.blooddonation.entity.DonationCamp;

import java.util.List;
import java.util.Optional;

public interface CampService {
    DonationCamp createCamp(DonationCamp camp);
    Optional<DonationCamp> getById(Long id);
    List<DonationCamp> getAll();
    DonationCamp updateCamp(Long id, DonationCamp camp);
    void deleteCamp(Long id);
}
