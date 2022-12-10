package com.hospitalmanagement.service;

import java.util.List;

import com.hospitalmanagement.model.Doctor;

public interface DoctorService {
	boolean addDoctor(Doctor doctor);
	boolean deleteDoctorById(Integer id);
	Doctor getDoctorById(Integer id);
	Doctor updateDoctor(Doctor doctor);
	Doctor loginDoctor(String username, String password);
	List<Doctor> getAllDoctors();
	Long getDoctorsTotalCounts();
	Long getDoctorsCountByDate(String registereddate);
	List<Doctor> getDoctorsByName(String doctorName);
	
}
