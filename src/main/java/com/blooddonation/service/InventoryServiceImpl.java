package com.blooddonation.service;

import com.blooddonation.entity.BloodInventory;
import com.blooddonation.repository.BloodInventoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final BloodInventoryRepository repo;

    public InventoryServiceImpl(BloodInventoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public BloodInventory addOrUpdateInventory(String bloodGroup, int units) {
        Optional<BloodInventory> opt = repo.findByBloodGroupIgnoreCase(bloodGroup);
        BloodInventory inv = opt.orElse(BloodInventory.builder().bloodGroup(bloodGroup).units(0).build());
        inv.setUnits(units);
        inv.setLastUpdated(LocalDate.now());
        return repo.save(inv);
    }

    @Override
    public Optional<BloodInventory> getByBloodGroup(String bloodGroup) {
        return repo.findByBloodGroupIgnoreCase(bloodGroup);
    }

    @Override
    public List<BloodInventory> getAll() {
        return repo.findAll();
    }
}
