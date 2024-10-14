package com.Arc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Arc.hospital.entity.Doctor;

public interface Doctorrepo extends JpaRepository<Doctor, Long> {

}
