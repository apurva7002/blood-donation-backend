package com.blooddonation.controller;

import com.blooddonation.entity.Recipient;
import com.blooddonation.repository.RecipientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipients")
public class RecipientController {

    private final RecipientRepository repo;

    public RecipientController(RecipientRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Recipient> create(@RequestBody Recipient recipient) {
        return ResponseEntity.ok(repo.save(recipient));
    }

    @GetMapping
    public ResponseEntity<List<Recipient>> all() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipient> get(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
