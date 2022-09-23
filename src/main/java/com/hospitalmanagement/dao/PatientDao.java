package com.hospitalmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospitalmanagement.model.Medicine;
import com.hospitalmanagement.model.Patient;

@Repository("patientDao")
public interface PatientDao extends JpaRepository<Patient, Integer> {
	List<Patient> findByFirstnameContainingIgnoreCase(String patientName);
	@Query(value = "SELECT count(p) FROM Patient p")
    public Long getTotalCount();
	Long countByRegisterdate(String registeredDate);
	@Query(value= "select * from Patient where register_date=:date ORDER BY id DESC LIMIT 6", nativeQuery=true)
	public List<Patient> findTop5ByIdDesc(@Param("date") String date);

	@Query(value= "SELECT * FROM Patient ", nativeQuery=true)
	List<Patient> getAllPatient();
}
