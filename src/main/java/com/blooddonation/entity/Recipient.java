package com.blooddonation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "recipients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String bloodGroup;

    @NotBlank
    private String contactNumber;

    private String hospital;

    @Column(length = 1000)
    private String requirementDetails;
}
