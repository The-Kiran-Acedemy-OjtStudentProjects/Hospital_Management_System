package com.hospitalmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospitalmanagement.model.Medicine;
import com.hospitalmanagement.model.MedicineCompany;

@Repository("medicineCompanyDao")
public interface MedicineCompanyDao extends JpaRepository<MedicineCompany, Integer> {
	
	List<MedicineCompany> findByNameContainingIgnoreCase(String companyName);
	MedicineCompany findByName(String companyName);
	Long countByRegisterdate(String dateAdded);
	@Query(value= "select * from Medicine_Company where register_date=:date ORDER BY id DESC LIMIT 2", nativeQuery=true)
	public List<MedicineCompany> findTop5ByIdDesc(@Param("date") String date);
}
