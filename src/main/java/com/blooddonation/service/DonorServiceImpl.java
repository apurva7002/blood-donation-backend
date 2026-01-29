package com.blooddonation.service;

import com.blooddonation.entity.Donor;
import com.blooddonation.repository.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;

    public DonorServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public Donor registerDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public Optional<Donor> loginByPhone(String phone) {
        return donorRepository.findByPhone(phone);
    }

    @Override
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @Override
    public Donor updateDonor(Long id, Donor updatedDonor) {
        Donor donor = donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found"));

        donor.setName(updatedDonor.getName());
        donor.setBloodGroup(updatedDonor.getBloodGroup());
        donor.setAge(updatedDonor.getAge());
        donor.setGender(updatedDonor.getGender());
        donor.setEmail(updatedDonor.getEmail());
        donor.setCity(updatedDonor.getCity());
        donor.setLastDonationDate(updatedDonor.getLastDonationDate());
        donor.setNotes(updatedDonor.getNotes());

        return donorRepository.save(donor);
    }

    @Override
    public void deleteDonor(Long id) {
        if (!donorRepository.existsById(id)) {
            throw new RuntimeException("Donor not found");
        }
        donorRepository.deleteById(id);
    }
}
