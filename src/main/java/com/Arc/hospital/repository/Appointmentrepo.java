package com.Arc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Arc.hospital.entity.Appointment;

public interface Appointmentrepo extends JpaRepository<Appointment, Long> {

}
