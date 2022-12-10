package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.dao.MedicineCompanyDao;
import com.hospitalmanagement.dao.MedicineDao;
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.model.MedicineCompany;

@Service("medicineCompanyService")
public class MedicineCompanyServiceImp implements MedicineCompanyService {

	@Autowired
	private MedicineCompanyDao medicineCompanyDao;

	@Override
	public MedicineCompany addMedicineCompany(MedicineCompany medicineCompany) {
		return medicineCompanyDao.save(medicineCompany);
	}

	@Override
	public void deleteMedicineCompanyById(Integer id) {
		medicineCompanyDao.deleteById(id);
	}

	@Override
	public MedicineCompany getMedicineCompanyById(Integer id) {
		Optional<MedicineCompany> optional = medicineCompanyDao.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public MedicineCompany updateMedicineCompany(MedicineCompany medicineCompany) {
		return medicineCompanyDao.save(medicineCompany);
	}

	@Override
	public List<MedicineCompany> getAllMedicineCompanys() {
		return medicineCompanyDao.findAll();
	}

	@Override
	public List<MedicineCompany> getCompanysByName(String companyName) {
		return medicineCompanyDao.findByNameContainingIgnoreCase(companyName);
	}

	@Override
	public MedicineCompany getCompanyByName(String companyName) {
		return medicineCompanyDao.findByName(companyName);
	}

	@Override
	public Long getCountByRegisteredDate(String registeredDate) {
		return medicineCompanyDao.countByRegisterdate(registeredDate);
	}

	@Override
	public List<MedicineCompany> getTop5CompanyAddedByDate(String registeredDate) {
		return medicineCompanyDao.findTop5ByIdDesc(registeredDate);
	}

}
