package com.hospitalmanagement.service;

import java.util.List;
import com.hospitalmanagement.model.MedicineDistributor;

public interface MedicineDistributorService {
	MedicineDistributor addMedicineDistributor(MedicineDistributor medicineDistributor);
	void deleteMedicineDistributorById(Integer id);
	MedicineDistributor getMedicineDistributorById(Integer id);
	MedicineDistributor updateMedicineDistributor(MedicineDistributor medicineDistributor);
	List<MedicineDistributor> getAllDistributors();
	List<MedicineDistributor> getDistributorsByName(String distributorName);
	MedicineDistributor getDistributorByName(String distributorName);
	Long getCountByRegisteredDate(String registeredDate);
	List<MedicineDistributor> getTop5CompanyAddedByDate(String date);
}
