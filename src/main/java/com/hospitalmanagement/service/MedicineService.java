package com.hospitalmanagement.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.hospitalmanagement.model.Medicine;

public interface MedicineService {
	Medicine addMedicine(Medicine medicine);
	void deleteMedicineById(Integer id);
	Medicine getMedicineById(Integer id);
	Medicine updateMedicine(Medicine medicine);
	List<Medicine> getAllMedicine();
	List<Medicine> getMedicinesByName(String medicineName);
	Medicine getMedicineByName(String medicineName);
	List<Medicine> getMedicinesWithQuantityMoreThanZero(int quanatity);
	Long getCountOfMedicineByDateAdded(String dateAdded);
    Long getMedicinesTotalCount();
    List<Medicine> getTop5MedicineAddedByDate(String date);
}
