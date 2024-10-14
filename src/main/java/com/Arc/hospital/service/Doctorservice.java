package com.Arc.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arc.hospital.entity.Doctor;
import com.Arc.hospital.entity.Patient;
import com.Arc.hospital.repository.Doctorrepo;

@Service
public class Doctorservice {
	
   @Autowired
   private Doctorrepo drepo;
   
   public List<Doctor> getAllDoctors(){
		return drepo.findAll();
	}
	
	public Doctor getDoctorById(long id) {
		return drepo.findById(id).orElse(null);
	}
	
	public Doctor createDoctor(Doctor doctor) {
		return drepo.save(doctor);
	}
	
	public Doctor updateDoctor(long id, Doctor doctor) {
		Doctor existingDoctor = getDoctorById(id);
		if(existingDoctor != null) {
			existingDoctor.setName(doctor.getName());
			existingDoctor.setSpeciality(doctor.getSpeciality());
			existingDoctor.setAvaliability(doctor.getAvaliability());
			return drepo.save(existingDoctor);
		}
		
		return null;
	}
	
	public void deleteDoctor(long id) {
		drepo.deleteById(id);
	}
}
