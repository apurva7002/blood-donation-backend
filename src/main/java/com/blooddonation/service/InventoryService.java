package com.blooddonation.service;

import com.blooddonation.entity.BloodInventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    BloodInventory addOrUpdateInventory(String bloodGroup, int units);
    Optional<BloodInventory> getByBloodGroup(String bloodGroup);
    List<BloodInventory> getAll();
}
