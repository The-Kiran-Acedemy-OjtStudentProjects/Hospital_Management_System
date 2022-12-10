package com.hospitalmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospitalmanagement.dao.DoctorDao;
import com.hospitalmanagement.hashing.MD5Hashing;
import com.hospitalmanagement.model.Doctor;

@Service("doctorService")
public class DoctorServiceImp implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	@Override
	public boolean addDoctor(Doctor doctor) {
		String hashedPassword = MD5Hashing.doHashing(doctor.getPassword());
		doctor.setPassword(hashedPassword);
		boolean b = doctorDao.addDoctor(doctor);
		return b;
	}

	@Override
	public boolean deleteDoctorById(Integer id) {
		boolean b = doctorDao.deleteDoctorById(id);
		return b;

	}

	@Override
	public Doctor getDoctorById(Integer id) {
		Doctor doctor = doctorDao.getDoctorById(id);
		return doctor;
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		Doctor doctr = doctorDao.updateDoctor(doctor);
		return doctr;
	}

	@Override
	public Doctor loginDoctor(String username, String password) {
		password=MD5Hashing.doHashing(password);
		Doctor doctor = doctorDao.loginDoctor(username, password);
		return doctor;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> list = doctorDao.getAllDoctors();
		return list;
	}

	@Override
	public Long getDoctorsTotalCounts() {
		Long counts = doctorDao.getDoctorsTotalCounts();
		return counts;
	}

	@Override
	public Long getDoctorsCountByDate(String registereddate) {
		Long counts = doctorDao.getDoctorsCountByDate(registereddate);
		return counts;
	}

	@Override
	public List<Doctor> getDoctorsByName(String doctorName) {
		List<Doctor> list = doctorDao.getDoctorsByName(doctorName);
		return list;
	}

}
