package com.hospitalmanagement.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalmanagement.hashing.MD5Hashing;
import com.hospitalmanagement.model.Receptionist;
import com.hospitalmanagement.service.ReceptionistService;

@Component("receptionistResource")
public class ReceptionistResource {
	
	@Autowired
	private ReceptionistService receptionistService;

	public boolean addReceptionist(Receptionist receptionist) {
		if(receptionist==null) {
			return false;
		}
		
		String hashedPassword=MD5Hashing.doHashing(receptionist.getPassword());
		receptionist.setPassword(hashedPassword);
	
		Receptionist r = receptionistService.addReceptionist(receptionist);
		
		if(r==null) {
			return false;
		}
		
		else {
			return true;
		}
	}

	public Receptionist loginReceptionist(String username, String password) {
		if(username==null || password==null) {
			return null;
		}
		
		password=MD5Hashing.doHashing(password);
		
		Receptionist receptionist = receptionistService.loginReceptionist(username, password);
		
		if(receptionist==null) {
			return null;
		}
		
		else {
			return receptionist;
		}
	}
	
	public void deleteReceptionistById(int receptionistId) {
	   receptionistService.deleteReceptionistById(receptionistId);
	}
	
	public Receptionist getReceptionistById(int receptionistId) {
		return receptionistService.getReceptionistById(receptionistId);
	}
	
	public Receptionist updateReceptionist(Receptionist receptionist) {
		return receptionistService.updateReceptionist(receptionist);
	}
	
	public Long getReceptionistTotalCount() {
		return receptionistService.getReceptionistTotalCount();
	}
	
	public List<Receptionist> getReceptionistsByFirstname(String firstName) {
		return receptionistService.getReceptionistsByFirstName(firstName);
	}
	
	public Long getReceptionistCountByRegisterDate(String registerDate) {
		return receptionistService.getReceptionistCountByRegisteredDate(registerDate);
	}

}
