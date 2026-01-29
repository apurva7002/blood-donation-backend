package com.blooddonation.service;

import com.blooddonation.entity.DonationCamp;
import com.blooddonation.repository.DonationCampRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampServiceImpl implements CampService {

    private final DonationCampRepository repo;

    public CampServiceImpl(DonationCampRepository repo) {
        this.repo = repo;
    }

    @Override
    public DonationCamp createCamp(DonationCamp camp) {
        return repo.save(camp);
    }

    @Override
    public Optional<DonationCamp> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<DonationCamp> getAll() {
        return repo.findAll();
    }

    @Override
    public DonationCamp updateCamp(Long id, DonationCamp camp) {
        return repo.findById(id).map(existing -> {
            existing.setName(camp.getName());
            existing.setLocation(camp.getLocation());
            existing.setStartDateTime(camp.getStartDateTime());
            existing.setEndDateTime(camp.getEndDateTime());
            existing.setDescription(camp.getDescription());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Camp not found " + id));
    }

    @Override
    public void deleteCamp(Long id) {
        repo.deleteById(id);
    }
}
