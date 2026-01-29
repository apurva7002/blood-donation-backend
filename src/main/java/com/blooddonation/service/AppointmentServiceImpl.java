package com.blooddonation.service;

import com.blooddonation.entity.Appointment;
import com.blooddonation.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repo;

    public AppointmentServiceImpl(AppointmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Appointment schedule(Appointment appointment) {
        if (appointment.getStatus() == null) appointment.setStatus("SCHEDULED");
        return repo.save(appointment);
    }

    @Override
    public Optional<Appointment> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Appointment> getAll() {
        return repo.findAll();
    }

    @Override
    public void cancel(Long id) {
        repo.findById(id).ifPresent(a -> {
            a.setStatus("CANCELLED");
            repo.save(a);
        });
    }

    @Override
    public List<Appointment> findByDonorId(Long donorId) {
        return repo.findByDonorId(donorId);
    }
}
