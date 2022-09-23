package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.dao.PatientDao;
import com.hospitalmanagement.model.Patient;

@Service("patientService")
public class PatientServiceImp implements PatientService {
	
	@Autowired
	private PatientDao patientDao;

	@Override
	public Patient addPatient(Patient patient) {
		return patientDao.save(patient);
	}

	@Override
	public void deletePatientById(Integer id) {
		patientDao.deleteById(id);
	}

	@Override
	public Patient getPatientById(Integer id) {
		Optional<Patient> optional = patientDao.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return patientDao.save(patient);
	}

	@Override
	public List<Patient> getPatientsIdByPatientName(String patientname) {
		return patientDao.findByFirstnameContainingIgnoreCase(patientname);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientDao.findAll();
	}

	@Override
	public Long getPatientsCount() {
		return patientDao.getTotalCount();
	}

	@Override
	public Long getPatientsCountByDate(String registerDate) {
		return patientDao.countByRegisterdate(registerDate);
	}

	@Override
	public List<Patient> getTop5PatientAddedByDate(String date) {
		return patientDao.findTop5ByIdDesc(date);
	}

}
