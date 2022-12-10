package com.hospitalmanagement.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalmanagement.hashing.MD5Hashing;
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.model.MedicineDistributor;
import com.hospitalmanagement.service.DoctorService;

@Component("doctorResource")
public class DoctorResource {
	
	@Autowired
	private DoctorService doctorService;

	public Doctor loginDoctor(String username, String password) {
		if(username==null || password==null) {
			return null;
		}
		
		password=MD5Hashing.doHashing(password);
		
		Doctor doctor = doctorService.loginDoctor(username, password);
		
		if(doctor==null) {
			return null;
		}
		
		else {
			return doctor;
		}
	}

	/*
	 * public boolean addDoctor(Doctor doctor) { if(doctor==null) { return false; }
	 * 
	 * String hashedPassword=MD5Hashing.doHashing(doctor.getPassword());
	 * doctor.setPassword(hashedPassword);
	 * 
	 * Doctor d = doctorService.addDoctor(doctor);
	 * 
	 * if(d==null) { return false; }
	 * 
	 * else { return true; } }
	 */
	
	public List<Doctor> getAllDoctor(){
		return doctorService.getAllDoctors();
	}
	
	public Doctor getDoctorById(int doctorId) {
		return doctorService.getDoctorById(doctorId);
	}
	
	 public void deleteDoctorById(int doctorId) {
		 doctorService.deleteDoctorById(doctorId);
	}
		
	public Doctor updateDoctor(Doctor doctor) {
		return doctorService.updateDoctor(doctor);
	}
	
	public Long getDoctorsTotalCount() {
		return doctorService.getDoctorsTotalCounts();
	}
	
	public List<Doctor> getDoctorsByName(String doctorName) {
		return doctorService.getDoctorsByName(doctorName);
	}
	
	public Long getDoctorCountByRegisteredDate(String registeeredDate) {
		return doctorService.getDoctorsCountByDate(registeeredDate);
	}

}
