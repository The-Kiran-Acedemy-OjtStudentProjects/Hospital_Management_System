package com.hospitalmanagement.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.model.Medicine;

public interface DoctorDao  {
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
