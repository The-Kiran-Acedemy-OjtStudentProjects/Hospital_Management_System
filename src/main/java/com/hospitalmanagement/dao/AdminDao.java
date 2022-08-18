package com.hospitalmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospitalmanagement.model.Admin;


public interface AdminDao {
	boolean addAdmin(Admin admin);
	Admin loginAdmin(String username, String password);
	void deleteAdminById(Integer id);
	Admin getAdminById(Integer id);
	List<Admin> getAllAdmin();
	Admin updateAdmin(Admin admin);

}
