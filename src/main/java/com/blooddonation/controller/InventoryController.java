package com.blooddonation.controller;

import com.blooddonation.entity.BloodInventory;
import com.blooddonation.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping("/update")
    public ResponseEntity<BloodInventory> update(@RequestParam String bloodGroup, @RequestParam int units) {
        return ResponseEntity.ok(service.addOrUpdateInventory(bloodGroup, units));
    }

    @GetMapping
    public ResponseEntity<List<BloodInventory>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{bloodGroup}")
    public ResponseEntity<BloodInventory> getByGroup(@PathVariable String bloodGroup) {
        return service.getByBloodGroup(bloodGroup).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
