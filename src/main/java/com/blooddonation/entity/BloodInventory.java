package com.blooddonation.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "blood_inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bloodGroup;

    @Column(nullable = false)
    private int units;

    @Column(name = "last_updated")
    private LocalDate lastUpdated;
}
