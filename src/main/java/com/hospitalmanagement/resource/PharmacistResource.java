package com.hospitalmanagement.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalmanagement.hashing.MD5Hashing;
import com.hospitalmanagement.model.Pharmacist;
import com.hospitalmanagement.service.PharmacistService;

@Component("pharmacistResource")
public class PharmacistResource {
	
	@Autowired
	private PharmacistService pharmacistService;

	public boolean addPharmacist(Pharmacist pharmacist) {
		if(pharmacist==null) {
			return false;
		}
		
		String hashedPassword=MD5Hashing.doHashing(pharmacist.getPassword());
		pharmacist.setPassword(hashedPassword);
	
		Pharmacist p = pharmacistService.addPharmacist(pharmacist);
		
		if(p==null) {
			return false;
		}
		
		else {
			return true;
		}
	}

	public Pharmacist loginPharmacist(String username, String password) {
		if(username==null || password==null) {
			return null;
		}
		
		password=MD5Hashing.doHashing(password);
		
		Pharmacist pharmacist = pharmacistService.loginPharmacist(username, password);
		
		if(pharmacist==null) {
			return null;
		}
		
		else {
			return pharmacist;
		}
	}
	
	public void deletePharmacistById(int pharmacistId) {
		pharmacistService.deletePharmacistById(pharmacistId);
    }
		
    public Pharmacist getPharmacistById(int pharmacistId) {
		return pharmacistService.getPharmacistById(pharmacistId);
	}
		
	public Pharmacist updatePharmacist(Pharmacist pharmacist) {
		return pharmacistService.updatePharmacist(pharmacist);
	}
	
	public Long getPharmacistTotalCount() {
		return pharmacistService.getPharmacistsTotalCount();
	}
	
	public List<Pharmacist> getPharmacistsByName(String name){
		return pharmacistService.getPharmacistsByFirstName(name);
	}
	
	public Long getPharmacistCountByRegisteredDate(String regitserDate) {
		return pharmacistService.getPharmacistCountByDate(regitserDate);
	}

}
