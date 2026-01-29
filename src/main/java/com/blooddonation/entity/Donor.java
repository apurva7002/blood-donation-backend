package com.blooddonation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // BASIC INFO
    private String name;
    private String bloodGroup;
    private Integer age;
    private String gender;

    // CONTACT INFO
    @Column(unique = true, nullable = false)
    private String phone;

    private String email;
    private String city;
    private String address;

    // DONATION INFO
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastDonationDate;

    // HEALTH INFO
    private Boolean hasHealthIssues;   // true / false
    private String healthDetails;      // description if any

    // EXTRA
    private String notes;
}
