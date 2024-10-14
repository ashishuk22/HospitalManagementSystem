package com.Arc.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arc.hospital.entity.Appointment;
import com.Arc.hospital.repository.Appointmentrepo;

@Service
public class Appointmentservice {
     
	@Autowired
	private Appointmentrepo arepo;
	
	public List<Appointment> getAllAppointments(){
		return arepo.findAll();
	}
	
	public Appointment getAppointmentById(long id) {
		return arepo.findById(id).orElse(null);
	}
	
	public Appointment createAppointment(Appointment appointment) {
		return arepo.save(appointment);
	}
	
	public Appointment updateAppointment(long id, Appointment appointment){
		Appointment existingAppointment = getAppointmentById(id);
		if(existingAppointment != null) {
		  existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
		  existingAppointment.setStatus(appointment.getStatus());
		  existingAppointment.setPatient(appointment.getPatient());
		  existingAppointment.setDoctor(appointment.getDoctor());
		  return arepo.save(existingAppointment);
		}
	return null;
	}
	
	public void deleteAppointment(long id) {
		arepo.deleteById(id);
	}
}
