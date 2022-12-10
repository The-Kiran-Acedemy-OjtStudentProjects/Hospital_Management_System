package com.hospitalmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospitalmanagement.model.Appointment;
import com.hospitalmanagement.model.Medicine;
import com.hospitalmanagement.model.Patient;

@Repository("medicineDao")
public interface MedicineDao extends JpaRepository<Medicine, Integer> {
	
	List<Medicine> findByNameContainingIgnoreCase(String medicineName);
	Medicine findByName(String medicineName);
	List<Medicine> findByQuantityGreaterThan(int quantity);
	Long countByDateAdded(String dateAdded);
	@Query(value = "SELECT count(m) FROM Medicine m")
    public Long getTotalCount();
	@Query(value= "select * from Medicine where date_added=:date ORDER BY id DESC LIMIT 2", nativeQuery=true)
	public List<Medicine> findTop5ByIdDesc(@Param("date") String date);

}
