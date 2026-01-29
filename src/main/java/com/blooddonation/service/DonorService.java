package com.blooddonation.service;

import com.blooddonation.entity.Donor;

import java.util.List;
import java.util.Optional;

public interface DonorService {

    Donor registerDonor(Donor donor);

    Optional<Donor> loginByPhone(String phone);

    List<Donor> getAllDonors();

    Donor updateDonor(Long id, Donor donor);

    void deleteDonor(Long id);
}
