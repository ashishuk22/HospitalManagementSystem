package com.Arc.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Arc.hospital.entity.Patient;
import com.Arc.hospital.service.Patientservice;

@RestController
@RequestMapping("/patient")
public class PatientController {
     
	@Autowired
	private Patientservice pservice;
	
	@GetMapping
	public List<Patient> getAllPatients(){
		return pservice.getAllPatients();
	}
	
	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable long id) {
		return pservice.getPatientById(id);
	}
	
	@PostMapping
	public Patient createPatient(@RequestBody Patient patient) {
		return pservice.createPatient(patient);
	}
	
	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable long id, @RequestBody Patient patient) {
		return pservice.updatePatient(id, patient);
	}
	
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable long id) {
		pservice.deletePatient(id);
	}
	
}
