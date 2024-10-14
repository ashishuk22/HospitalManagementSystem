package com.Arc.hospital.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill {
      
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Patient patient;
	
	private double amount;
	private String status;
	
	private LocalDateTime paymentdate;
}
