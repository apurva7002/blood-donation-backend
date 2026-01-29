package com.blooddonation.service;

import com.blooddonation.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment schedule(Appointment appointment);
    Optional<Appointment> getById(Long id);
    List<Appointment> getAll();
    void cancel(Long id);
    List<Appointment> findByDonorId(Long donorId);
}
