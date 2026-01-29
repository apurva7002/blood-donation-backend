package com.blooddonation.controller;

import com.blooddonation.entity.Donor;
import com.blooddonation.service.DonorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donors")
@CrossOrigin(origins = "http://localhost:3000")
public class DonorController {

    private final DonorService donorService;

    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Donor donor) {
        return ResponseEntity.ok(donorService.registerDonor(donor));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String phone = body.get("phone");

        return donorService.loginByPhone(phone)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).body("Invalid phone"));
    }

    @GetMapping
    public List<Donor> getAll() {
        return donorService.getAllDonors();
    }

    // ✅ ADD THIS (THIS IS THE FIX)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return ResponseEntity.ok("Donor deleted successfully");
    }
}
