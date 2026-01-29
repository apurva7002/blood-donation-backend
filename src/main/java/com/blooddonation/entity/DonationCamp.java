package com.blooddonation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "camps")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonationCamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String location;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @Column(length = 2000)
    private String description;
}
