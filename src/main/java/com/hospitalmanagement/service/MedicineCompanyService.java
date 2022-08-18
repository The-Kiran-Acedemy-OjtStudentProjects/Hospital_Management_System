package com.hospitalmanagement.service;

import java.util.List;

import com.hospitalmanagement.model.MedicineCompany;

public interface MedicineCompanyService {
	MedicineCompany addMedicineCompany(MedicineCompany medicineCompany);
	void deleteMedicineCompanyById(Integer id);
	MedicineCompany getMedicineCompanyById(Integer id);
	MedicineCompany updateMedicineCompany(MedicineCompany medicineCompany);
	List<MedicineCompany> getAllMedicineCompanys();
	List<MedicineCompany> getCompanysByName(String companyName);
	MedicineCompany getCompanyByName(String companyName);
	Long getCountByRegisteredDate(String registeredDate);
	List<MedicineCompany> getTop5CompanyAddedByDate(String registeredDate);
 }
