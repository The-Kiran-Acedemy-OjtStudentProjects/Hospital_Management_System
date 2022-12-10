package com.hospitalmanagement.service;

import java.util.List;

import com.hospitalmanagement.model.Admin;

public interface AdminService {
	boolean addAdmin(Admin admin);
	Admin loginAdmin(String username, String password);
	void deleteAdminById(Integer id);
	Admin getAdminById(Integer id);
	List<Admin> getAllAdmin();
	Admin updateAdmin(Admin admin);
}
