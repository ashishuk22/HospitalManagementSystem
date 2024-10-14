package com.Arc.hospital.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
    private LocalDateTime appointmentDate;
	private String status;
	
	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Doctor doctor;
}
