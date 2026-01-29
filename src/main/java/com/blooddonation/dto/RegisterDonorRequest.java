package com.blooddonation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDonorRequest {
    private String name;
    private String email;
    private String contactNumber; // coming from React
    private String bloodGroup;
    private String city;
}
