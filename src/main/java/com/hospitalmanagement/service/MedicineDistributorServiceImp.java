package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.dao.MedicineDistributorDao;
import com.hospitalmanagement.model.MedicineCompany;
import com.hospitalmanagement.model.MedicineDistributor;

@Service("medicineDistributorService")
public class MedicineDistributorServiceImp implements MedicineDistributorService {

	@Autowired
	private MedicineDistributorDao medicineDistributorDao;
	
	@Override
	public MedicineDistributor addMedicineDistributor(MedicineDistributor medicineDistributor) {
		return medicineDistributorDao.save(medicineDistributor);
	}

	@Override
	public void deleteMedicineDistributorById(Integer id) {
		medicineDistributorDao.deleteById(id);
	}

	@Override
	public MedicineDistributor getMedicineDistributorById(Integer id) {
		Optional<MedicineDistributor> optional = medicineDistributorDao.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public MedicineDistributor updateMedicineDistributor(MedicineDistributor medicineDistributor) {
		return medicineDistributorDao.save(medicineDistributor);
	}

	@Override
	public List<MedicineDistributor> getAllDistributors() {
		return medicineDistributorDao.findAll();
	}

	@Override
	public List<MedicineDistributor> getDistributorsByName(String distributorName) {
		return medicineDistributorDao.findByNameContainingIgnoreCase(distributorName);
	}

	@Override
	public MedicineDistributor getDistributorByName(String distributorName) {
		return medicineDistributorDao.findByName(distributorName);
	}

	@Override
	public Long getCountByRegisteredDate(String registeredDate) {
		return medicineDistributorDao.countByRegisterdate(registeredDate);
	}

	@Override
	public List<MedicineDistributor> getTop5CompanyAddedByDate(String date) {
		return medicineDistributorDao.findTop5ByIdDesc(date);
	}

}
