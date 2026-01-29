package com.blooddonation.controller;

import com.blooddonation.entity.Appointment;
import com.blooddonation.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Appointment> schedule(@RequestBody Appointment appointment) {
        Appointment scheduled = service.schedule(appointment);
        return ResponseEntity.ok(scheduled);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancel(@PathVariable Long id) {
        service.cancel(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/donor/{donorId}")
    public ResponseEntity<List<Appointment>> getByDonor(@PathVariable Long donorId) {
        return ResponseEntity.ok(service.findByDonorId(donorId));
    }
}
