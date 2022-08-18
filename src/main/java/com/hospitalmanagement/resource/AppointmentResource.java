package com.hospitalmanagement.resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospitalmanagement.model.Appointment;
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.service.AppointmentService;
import com.hospitalmanagement.service.PatientService;

@Component("appointmentResource")
public class AppointmentResource {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private MedicineResource medicineResource;

	public Appointment addAppointment(Appointment appointment) {
		Appointment a = appointmentService.addAppointment(appointment);
		return a;			
	}
	
	public Appointment getAppointmentById(int appointmentid) {
		return appointmentService.getAppointmentById(appointmentid);
	}
	
	public List<Appointment> getAppointmentsByPatientName(String patientName) {
		List<Patient> patientsId = patientService.getPatientsIdByPatientName(patientName);
		List<Integer> patientIds = new ArrayList<>();
		for(Patient patient : patientsId) {
			patientIds.add(patient.getId());
		}
		return appointmentService.getAppointmentsByPatientsId(patientIds);
	}
	
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(int doctorId, String appointmentDate) {
		return appointmentService.getAppointmentsByDoctorIdAndAppointmentDate(doctorId, appointmentDate);
	}
	
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDateAndTime(int doctorId, String appointmentDate, String appointmentTime) {
		return appointmentService.getAppointmentsByDoctorIdAndAppointmentDate(doctorId, appointmentDate);
	}
	
	public Appointment updateAppointment(Appointment appointment) {
		return appointmentService.updateAppointment(appointment);
	}
	
	public List<Appointment> getAppointmentsByDate(String appointmentdate){
		return appointmentService.getAppointmentsByDate(appointmentdate);
	}

	 
    public Long getAppointmentCountByDate(String appointmentDate) {
    	return appointmentService.getCountByAppointmentDate(appointmentDate);
    }
    
    public double getSumOfPriceFromAppointmentByBillingDate(String billingDate) {
    	return appointmentService.getSumOfPriceUsingBillingDate(billingDate);
    }
    
    public List<Appointment> getAppointmentsByBillingDate(String billingDate) {
    	return appointmentService.findAppointmentsByBillingDate(billingDate);
    }
    
    public Double getTotalEarningToday() {
    	
    	Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
        String todayDate= formatter.format(date);  
        double treatmentEarning = getSumOfPriceFromAppointmentByBillingDate(todayDate); 
        double medicinesEarning = 0;
        
        List<Appointment> appointments = getAppointmentsByBillingDate(todayDate);
        
        for(Appointment appointment : appointments) {
        	double medPrice = Double.parseDouble(medicineResource.getMedicinesPrice(appointment.getMedicines()));
        	medicinesEarning = medPrice + medicinesEarning;
        }
        double earning = treatmentEarning + medicinesEarning;
  
        if(earning == 0) {
        	return 0.0;
        }
        else {
        	return earning;
        }
    }
    
    public Long getTotalAppointmentsCount() {
    	return appointmentService.getAppointmentsTotalCount();
    }
    
    public Long getAppointmentCountByAppointmentTakenDate(String appointmentTakenDate) {
    	return appointmentService.getCountByAppointmentTakenDate(appointmentTakenDate);
    }
    
    public Long getAppointmentCountByTreatmentStatusAndBillingDate(String treatmentStatus, String billingDate) {
    	return appointmentService.getCountByTreatmentStatusAndBillingDate(treatmentStatus, billingDate);
    }
    
    public List<Appointment> getAllAppointments(){
    	return appointmentService.getAllAppointments();
    }
    
    public double getTotalTodaysAppointmentTreatmentPrice() {
    	Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
        String todayDate= formatter.format(date);  
    	List<Appointment> appointments = appointmentService.getAppointmentsByDate(todayDate);
    	
    	double totalTreatmentPrice=0;
    	
    	for(Appointment a : appointments) {
    		totalTreatmentPrice = a.getTreatmentprice()+totalTreatmentPrice;
    	}
    	
    	return totalTreatmentPrice;
    }
    
    public double getTotalAppointmentTreatmentPrice() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
    	
    	double totalTreatmentPrice=0;
    	
    	for(Appointment a : appointments) {
    		totalTreatmentPrice = a.getTreatmentprice()+totalTreatmentPrice;
    	}
    	
    	return totalTreatmentPrice;
    }
    
    public double getTotalEarningTillNow() {
    	return medicineResource.getMedicinesTotalEarnings() + getTotalAppointmentTreatmentPrice();
    }
    
    public List<Appointment> getTop5AppointmentsByDate(String date){
    	return appointmentService.getTop5AppointmentsByDate(date);
    }
	
}
