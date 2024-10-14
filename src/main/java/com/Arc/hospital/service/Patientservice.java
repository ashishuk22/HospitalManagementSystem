package com.Arc.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arc.hospital.entity.Patient;
import com.Arc.hospital.entity.User;
import com.Arc.hospital.repository.Patientrepo;

@Service
public class Patientservice {
   
	@Autowired
	private Patientrepo prepo;
	
	public List<Patient> getAllPatients(){
		return prepo.findAll();
	}
	
	public Patient getPatientById(long id) {
		return prepo.findById(id).orElse(null);
	}
	
	public Patient createPatient(Patient patient) {
		return prepo.save(patient);
	}
	
	public Patient updatePatient(long id, Patient patient) {
		Patient existingPatient = getPatientById(id);
		if(existingPatient != null) {
			existingPatient.setName(patient.getName());
			existingPatient.setAge(patient.getAge());
			existingPatient.setAddress(patient.getAddress());
			existingPatient.setMedicalhistory(patient.getMedicalhistory());
			return prepo.save(existingPatient);
		}
		
		return null;
	}
	
	public void deletePatient(long id) {
		prepo.deleteById(id);
	}
	
}
