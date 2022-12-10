package com.hospitalmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hospitalmanagement.model.Pharmacist;
import com.hospitalmanagement.model.Receptionist;

@Repository("pharmacistDao")
public interface PharmacistDao {
	Pharmacist addPharmacist(Pharmacist Pharmacist);
	void deletePharmacistById(Integer id);
	Pharmacist getPharmacistById(Integer id);
	Pharmacist updatePharmacist(Pharmacist Pharmacist);
	Pharmacist loginPharmacist(String username, String password);
	Long getPharmacistsTotalCount();
	List<Pharmacist> getPharmacistsByFirstName(String firstName);
	Long getPharmacistCountByDate(String date);
}
