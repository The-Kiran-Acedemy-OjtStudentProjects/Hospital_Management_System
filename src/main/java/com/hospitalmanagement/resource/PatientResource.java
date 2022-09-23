package com.hospitalmanagement.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.service.PatientService;

@Component("patientResource")
public class PatientResource {
	
	@Autowired
	private PatientService patientService;

	public boolean addPatient(Patient patient) {
		if(patient==null) {
			return false;
		}
	
		Patient p = patientService.addPatient(patient);
		
		if(p==null) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
	public Patient getPatientById(int patientid) {
		return patientService.getPatientById(patientid);
	}
	
	public void deletePatientById(int patientId) {
	    patientService.deletePatientById(patientId);
	}
	
	public Patient updatePatient(Patient patient) {
		return patientService.updatePatient(patient);
	}
	
	public List<Patient> getAllPatient(){
		return patientService.getAllPatients();
	}
	
	public List<Patient> getPatientsByName(String patientName) {
		return patientService.getPatientsIdByPatientName(patientName);
	}
	
	public Long getPatientsTotalCount() {
		return patientService.getPatientsCount();
	}
	
	public Long getPatientsByRegisteredDate(String registerDate) {
		return patientService.getPatientsCountByDate(registerDate);
	}
	
	public List<Patient> getTop5PatientBydate(String date){
		return patientService.getTop5PatientAddedByDate(date);
	}

}
