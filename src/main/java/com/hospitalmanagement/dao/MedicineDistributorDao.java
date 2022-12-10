package com.hospitalmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospitalmanagement.model.MedicineCompany;
import com.hospitalmanagement.model.MedicineDistributor;

@Repository("medicineDistributorDao")
public interface MedicineDistributorDao extends JpaRepository<MedicineDistributor, Integer> {
	List<MedicineDistributor> findByNameContainingIgnoreCase(String distributorName);
	MedicineDistributor findByName(String distributorName);
	Long countByRegisterdate(String dateAdded);
	@Query(value= "select * from Medicine_Distributor where register_date=:date ORDER BY id DESC LIMIT 2", nativeQuery=true)
	public List<MedicineDistributor> findTop5ByIdDesc(@Param("date") String date);
}
