package com.hospitalmanagement.service;

import java.util.List;
import com.hospitalmanagement.model.Patient;

public interface PatientService {
	Patient addPatient(Patient patient);
	void deletePatientById(Integer id);
	Patient getPatientById(Integer id);
	Patient updatePatient(Patient patient);
	
	List<Patient> getPatientsIdByPatientName(String patientname);
	Long getPatientsCount();
	Long getPatientsCountByDate(String registerDate);
	List<Patient> getTop5PatientAddedByDate(String date);	

	List<Patient> getAllPatient();
}
