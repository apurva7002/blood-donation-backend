package com.blooddonation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Who is donating? simple relation
    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;

    // optional: link to camp
    @ManyToOne
    @JoinColumn(name = "camp_id")
    private DonationCamp camp;

    @NotNull
    private LocalDateTime appointmentDateTime;

    private String status; // SCHEDULED / COMPLETED / CANCELLED
    private String notes;
}
