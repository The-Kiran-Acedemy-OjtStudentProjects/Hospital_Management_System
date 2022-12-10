package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.dao.MedicineDao;
import com.hospitalmanagement.model.Medicine;
import com.hospitalmanagement.model.MedicineDistributor;

@Service("medicineService")
public class MedicineServiceImp implements MedicineService  {

	@Autowired
	private MedicineDao medicineDao;
	
	@Override
	public Medicine addMedicine(Medicine medicine) {
		return medicineDao.save(medicine);
	}

	@Override
	public void deleteMedicineById(Integer id) {
		medicineDao.deleteById(id);
	}

	@Override
	public Medicine getMedicineById(Integer id) {
		Optional<Medicine> optional = medicineDao.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		return medicineDao.save(medicine);
	}

	@Override
	public List<Medicine> getAllMedicine() {
		return medicineDao.findAll();
	}

	@Override
	public List<Medicine> getMedicinesByName(String medicineName) {
		return medicineDao.findByNameContainingIgnoreCase(medicineName);
	}

	@Override
	public Medicine getMedicineByName(String medicineName) {
		return medicineDao.findByName(medicineName);
	}

	@Override
	public List<Medicine> getMedicinesWithQuantityMoreThanZero(int quanatity) {
		return medicineDao.findByQuantityGreaterThan(quanatity);
	}

	@Override
	public Long getCountOfMedicineByDateAdded(String dateAdded) {
		return medicineDao.countByDateAdded(dateAdded);
	}

	@Override
	public Long getMedicinesTotalCount() {
        return medicineDao.getTotalCount();
	}

	@Override
	public List<Medicine> getTop5MedicineAddedByDate(String date) {
		return medicineDao.findTop5ByIdDesc(date);
	}
	
}
