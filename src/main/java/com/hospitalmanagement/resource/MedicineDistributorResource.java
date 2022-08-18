package com.hospitalmanagement.resource;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalmanagement.model.MedicineCompany;
import com.hospitalmanagement.model.MedicineDistributor;
import com.hospitalmanagement.service.MedicineDistributorService;

@Component("medicineDistributorResource")
public class MedicineDistributorResource {
	
	@Autowired
	private MedicineDistributorService medicineDistributorService;
	
	private static Logger LOG = LogManager.getLogger(MedicineDistributorResource.class);

	public boolean addDistributor(MedicineDistributor medicineDistributor) {
		if(medicineDistributor==null) {
			return false;
		}
		
		MedicineDistributor md = medicineDistributorService.addMedicineDistributor(medicineDistributor);
		
		if(md==null) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
    public List<MedicineDistributor> getAllDistributors() {
		return medicineDistributorService.getAllDistributors();		
	}
    
    public MedicineDistributor getDistributorById(Integer distributorId) {	
		return medicineDistributorService.getMedicineDistributorById(distributorId);		
	}
    
    public void deleteDistributorById(int distributorId) {
    	medicineDistributorService.deleteMedicineDistributorById(distributorId);
	}
	
	public MedicineDistributor updateCompany(MedicineDistributor medicineDistributor) {
		return medicineDistributorService.updateMedicineDistributor(medicineDistributor);
	}

	public List<MedicineDistributor> getDistributorsByName(String distributorName) {
		return medicineDistributorService.getDistributorsByName(distributorName);
	}
	
	public boolean isDistributorAlreadyAvailable(String distributorName) {
		MedicineDistributor medicineDistributor = medicineDistributorService.getDistributorByName(distributorName);
        if(medicineDistributor == null)
        	return false;
        return true;
        
 	}
	
	public Long getDistributorCountUsingRegisteredDate(String registeredDate) {
		return medicineDistributorService.getCountByRegisteredDate(registeredDate);
	}
	
	public List<MedicineDistributor> getTop5DistributorAddedByDate(String date){
		return medicineDistributorService.getTop5CompanyAddedByDate(date);
	}


}
