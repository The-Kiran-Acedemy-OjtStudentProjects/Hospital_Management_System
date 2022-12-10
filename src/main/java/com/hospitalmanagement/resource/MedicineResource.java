package com.hospitalmanagement.resource;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalmanagement.constants.DatabaseConstants.WantMedicinesFromHospital;
import com.hospitalmanagement.model.Appointment;
import com.hospitalmanagement.model.Medicine;
import com.hospitalmanagement.service.MedicineService;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("medicineResource")
public class MedicineResource {

	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private AppointmentResource appointmentResource;

	public boolean addMedicine(Medicine medicine) {
		
		if(medicine==null) {
			return false;
		}
		
		Medicine m = medicineService.addMedicine(medicine);
		
		if(m==null) {
			return false;
		}
		
		else {
			return true;
		}
			
	}
	
	public Medicine getMedicineById(int medicineId) {
		return medicineService.getMedicineById(medicineId);
	}
	
	public List<Medicine> getAllMedicines(){
		return medicineService.getAllMedicine();
	}
	
	public void deleteMedicineById(int medicineId) {
		medicineService.deleteMedicineById(medicineId);
	}
	
	public Medicine updateMedicine(Medicine medicine) {
		return medicineService.updateMedicine(medicine);
	}
	
	public List<Medicine> getExpiredMedicines(){
		
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
		String todaysDate = formatter.format(date);
        
		List<Medicine> expiredMedicines = new ArrayList<>();
		
		for(Medicine medicine :  medicineService.getAllMedicine()) {
			String expiry = medicine.getExpirydate();
			int expiryYear = Integer.parseInt(expiry.substring(6, 10));
			int currentYear = Integer.parseInt(todaysDate.substring(6, 10));
			int expiryMonth = Integer.parseInt(expiry.substring(3, 5));
			int currentMonth = Integer.parseInt(todaysDate.substring(3, 5));
			int expiryDate = Integer.parseInt(expiry.substring(0, 2));
			int currentDate = Integer.parseInt(todaysDate.substring(0, 2));	    
		
			if(expiryYear - currentYear < 1 ) {
				if(expiryMonth - currentMonth < 1 ) {
					if(expiryDate - currentDate < 1) {
						expiredMedicines.add(medicine);
					}
				}				
			}
			
		}
		
		return expiredMedicines;
			
	}
	
	public List<Medicine> getMedicinesByName(String medicineName) {
		return medicineService.getMedicinesByName(medicineName);
	}
	
	public boolean isMedicineAlreadyAvailable(String medicineName) {
		Medicine medicine = medicineService.getMedicineByName(medicineName);
        if(medicine == null)
        	return false;
        return true;
        
 	}
	
	public String getMedicinesPrice(List<Medicine> medicines) {
		
		double totalPrice=0;
		
		for(Medicine m : medicines) {
			totalPrice = totalPrice + m.getPrice();
	    }
	    return String.valueOf(totalPrice);
   }
	
   public double getTotalPrice(String medicinesPrice, String treatmentPrice) {
	   return Double.parseDouble(medicinesPrice) + Double.parseDouble(treatmentPrice);
   }

   public Medicine updateQuantity(int medicineId) {
	   
	   Medicine medicine = medicineService.getMedicineById(medicineId);
	   
	   if(medicine.getQuantity()-1 >= 0) {
		   medicine.setQuantity(medicine.getQuantity()-1);
	   }
	 
	   return medicineService.updateMedicine(medicine);
	
   }
   
   public List<Medicine> getAllAvailableMedicines(){
	   return medicineService.getMedicinesWithQuantityMoreThanZero(0);
   }
   
   public Long getMedicineCountByDateAdded(String dateAdded) {
	   return medicineService.getCountOfMedicineByDateAdded(dateAdded);
   }

   public Long getMedicinesTotalCount() {
	   return medicineService.getMedicinesTotalCount();
   }
   
   public double getMedicinesTodayEarning() {
	   Date date = new Date();  
       SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
       String todayDate= formatter.format(date);  
	   List<Appointment> appointments = appointmentResource.getAppointmentsByDate(todayDate);
	   
	   double totalMedicinePrice = 0;
	   
	   for(Appointment a : appointments) {
		   
		   if(a.getWantMedicine()!= null && a.getWantMedicine().equals(WantMedicinesFromHospital.YES.value())) {
		     List<Medicine> medicines = a.getMedicines();
		   
		     for(Medicine m : medicines ) {
			   double price = m.getPrice();
			   totalMedicinePrice = totalMedicinePrice + price;
		     }
		   }
	   }
	   
	   return totalMedicinePrice;
	   
   }
   
   public double getMedicinesTotalEarnings() {
	  
	   List<Appointment> appointments = appointmentResource.getAllAppointments();
	   
	   double totalMedicinePrice = 0;
	   
	   for(Appointment a : appointments) {
		   
		   if(a.getWantMedicine().equals(WantMedicinesFromHospital.YES.value())) {
		     List<Medicine> medicines = a.getMedicines();
		   
		     for(Medicine m : medicines ) {
			   double price = m.getPrice();
			   totalMedicinePrice = totalMedicinePrice + price;
		     }
		   }
	   }
	   
	   return totalMedicinePrice;
	   
   }
   
   public List<Medicine> getTop5MedicinesByDate(String date){
	   return medicineService.getTop5MedicineAddedByDate(date);
   }
   
}

