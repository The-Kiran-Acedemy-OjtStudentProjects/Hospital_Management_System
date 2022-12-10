package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.dao.AdminDao;
import com.hospitalmanagement.hashing.MD5Hashing;
import com.hospitalmanagement.model.Admin;

@Service("adminService")
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin loginAdmin(String username, String password) {
		// you can encrypt here name also and others
		password = MD5Hashing.doHashing(password);
		return adminDao.loginAdmin(username, password);
	}

	@Override
	public boolean addAdmin(Admin admin) {
		String hashedPassword=MD5Hashing.doHashing(admin.getPassword());
		admin.setPassword(hashedPassword);
		return adminDao.addAdmin(admin);
	}

	@Override
	public void deleteAdminById(Integer id) {
		adminDao.deleteAdminById(id);
	}

	@Override
	public Admin getAdminById(Integer id) {
		Admin admin = adminDao.getAdminById(id);

		return admin;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

}
