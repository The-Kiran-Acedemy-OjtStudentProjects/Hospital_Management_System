package com.hospitalmanagement.resource;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalmanagement.model.Medicine;
import com.hospitalmanagement.model.MedicineCompany;
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.service.MedicineCompanyService;

@Component("medicineCompanyResource")
public class MedicineCompanyResource {

	@Autowired
	private MedicineCompanyService medicineCompanyService;
	
	private static Logger LOG = LogManager.getLogger(MedicineCompanyService.class);

	public boolean addCompany(MedicineCompany medicineCompany) {
		if(medicineCompany==null) {
			return false;
		}
		
		MedicineCompany md = medicineCompanyService.addMedicineCompany(medicineCompany);
		
		if(md==null) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
    public List<MedicineCompany> getAllCompanys() {
		return medicineCompanyService.getAllMedicineCompanys();		
	}
    
    public MedicineCompany getCompanyById(Integer companyId) {
		return medicineCompanyService.getMedicineCompanyById(companyId);	
	}
    
    public void deleteCompanyById(int companyId) {
    	medicineCompanyService.deleteMedicineCompanyById(companyId);
	}
	
	public MedicineCompany updateCompany(MedicineCompany medicineCompany) {
		return medicineCompanyService.updateMedicineCompany(medicineCompany);
	}
	
	public List<MedicineCompany> getCompanysByName(String companyName) {
		return medicineCompanyService.getCompanysByName(companyName);
	}
	
	public boolean isCompanyAlreadyAvailable(String companyName) {
		MedicineCompany medicineCompany = medicineCompanyService.getCompanyByName(companyName);
        if(medicineCompany == null)
        	return false;
        return true;
        
 	}

	public Long getCompanyCountUsingRegisteredDate(String registeredDate) {
		return medicineCompanyService.getCountByRegisteredDate(registeredDate);
	}
	
	public List<MedicineCompany> getTop5CompanysByDateAdded(String date){
		return medicineCompanyService.getTop5CompanyAddedByDate(date);
	}
	
}
