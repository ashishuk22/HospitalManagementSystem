package com.Arc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Arc.hospital.entity.Patient;

public interface Patientrepo extends JpaRepository<Patient, Long> {

}
