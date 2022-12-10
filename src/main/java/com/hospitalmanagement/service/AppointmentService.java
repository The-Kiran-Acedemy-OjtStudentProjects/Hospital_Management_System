package com.hospitalmanagement.service;

import java.util.List;
import com.hospitalmanagement.model.Appointment;

public interface AppointmentService {
	
	Appointment addAppointment(Appointment appointment);
	Appointment updateAppointment(Appointment appointment);
	Appointment getAppointmentById(int appointmentId);
	List<Appointment> getAppointmentsByPatientsId(List<Integer> patientsId);
	List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(int doctorId, String appointmentDate);
	List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(int doctorId, String appointmentDate, String appointmentTime);
	List<Appointment> getAppointmentsByDate(String date);
	Long getCountByAppointmentDate(String appointmentDate);
	double getSumOfPriceUsingBillingDate(String billingDate);
	List<Appointment> findAppointmentsByBillingDate(String billingDate);
	Long getAppointmentsTotalCount();
	Long getCountByAppointmentTakenDate(String appointmentTakenDate);
	Long getCountByTreatmentStatusAndBillingDate(String treatmentStatus, String billingDate);
	List<Appointment> getAllAppointments();
	List<Appointment> getTop5AppointmentsByDate(String date);
}
