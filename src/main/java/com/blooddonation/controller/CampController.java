package com.blooddonation.controller;

import com.blooddonation.entity.DonationCamp;
import com.blooddonation.service.CampService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camps")
public class CampController {

    private final CampService service;

    public CampController(CampService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DonationCamp> create(@RequestBody DonationCamp camp) {
        return ResponseEntity.ok(service.createCamp(camp));
    }

    @GetMapping
    public ResponseEntity<List<DonationCamp>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationCamp> get(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonationCamp> update(@PathVariable Long id, @RequestBody DonationCamp camp) {
        try {
            return ResponseEntity.ok(service.updateCamp(id, camp));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteCamp(id);
        return ResponseEntity.ok().build();
    }
}
