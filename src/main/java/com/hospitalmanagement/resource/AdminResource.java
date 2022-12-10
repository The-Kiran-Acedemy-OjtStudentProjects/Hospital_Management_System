package com.hospitalmanagement.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalmanagement.hashing.MD5Hashing;
import com.hospitalmanagement.model.Admin;
import com.hospitalmanagement.service.AdminService;

@Component("adminResource")
public class AdminResource {
	
	@Autowired
	private AdminService adminService;

	
	
   
    public List<Admin> getAllAdmin(){
    	return adminService.getAllAdmin();
    }
    
    public Admin getAdminById(int adminId) {
    	return adminService.getAdminById(adminId);
    }
    
    public void deleteAdminById(int adminId) {
    	adminService.deleteAdminById(adminId);
    }
	
    public Admin updateAdminById(Admin admin) {
    	return adminService.updateAdmin(admin);
    }
   
}
