package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.dao.PharmacistDao;
import com.hospitalmanagement.hashing.MD5Hashing;
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.model.Pharmacist;

@Service("pharmacistService")
public class PharmacistServiceImp implements PharmacistService {

	@Autowired
	private PharmacistDao pharmacistDao;

	@Override
	public Pharmacist addPharmacist(Pharmacist pharmacist) {
		String hashedPassword = MD5Hashing.doHashing(pharmacist.getPassword());
		pharmacist.setPassword(hashedPassword);
		return pharmacistDao.addPharmacist(pharmacist);
	}

	@Override
	public void deletePharmacistById(Integer id) {
		pharmacistDao.deletePharmacistById(id);

	}

	@Override
	public Pharmacist getPharmacistById(Integer id) {

		return pharmacistDao.getPharmacistById(id);
	}

	@Override
	public Pharmacist updatePharmacist(Pharmacist Pharmacist) {

		return pharmacistDao.updatePharmacist(Pharmacist);
	}

	@Override
	public Pharmacist loginPharmacist(String username, String password) {
		password = MD5Hashing.doHashing(password);
		return pharmacistDao.loginPharmacist(username, password);
	}

	@Override
	public Long getPharmacistsTotalCount() {

		return pharmacistDao.getPharmacistsTotalCount();
	}

	@Override
	public List<Pharmacist> getPharmacistsByFirstName(String firstName) {

		return pharmacistDao.getPharmacistsByFirstName(firstName);
	}

	@Override
	public Long getPharmacistCountByDate(String date) {

		return pharmacistDao.getPharmacistCountByDate(date);
	}

}
