package com.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.dao.AppointmentDao;
import com.hospitalmanagement.model.Appointment;

@Service("appointmentService")
public class AppointmentServiceImp implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public Appointment addAppointment(Appointment appointment) {
		return appointmentDao.save(appointment); 
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) {
        Optional<Appointment> optional = appointmentDao.findById(appointmentId);
		
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public List<Appointment> getAppointmentsByPatientsId(List<Integer> patientsId) {
		return appointmentDao.findByPatientsId(patientsId);
	}

	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(int doctorId, String appointmentDate) {
		return appointmentDao.findByDoctoridAndAppointmentdate(doctorId, appointmentDate);
	}

	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(int doctorId, String appointmentDate,
			String appointmentTime) {
		return appointmentDao.findByDoctoridAndAppointmentdateAndAppointmenttime(doctorId, appointmentDate, appointmentTime);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return appointmentDao.save(appointment);
	}

	@Override
	public List<Appointment> getAppointmentsByDate(String appointmentdate) {
		return appointmentDao.findByAppointmentdate(appointmentdate);
	}

	@Override
	public Long getCountByAppointmentDate(String appointmentDate) {
		return appointmentDao.countByAppointmentdate(appointmentDate);
	}

	@Override
	public double getSumOfPriceUsingBillingDate(String billingDate) {
		return appointmentDao.sumOfPrice(billingDate);
	}

	@Override
	public List<Appointment> findAppointmentsByBillingDate(String billingDate) {
		return appointmentDao.findByBillingDate(billingDate);
	}

	@Override
	public Long getAppointmentsTotalCount() {
		return appointmentDao.getTotalCount();
	}

	@Override
	public Long getCountByAppointmentTakenDate(String appointmentTakenDate) {
		return appointmentDao.countByAppointmenttakendate(appointmentTakenDate);
	}

	@Override
	public Long getCountByTreatmentStatusAndBillingDate(String treatmentStatus, String billingDate) {
		return appointmentDao.countByTreatmentstatusAndBillingDate(treatmentStatus, billingDate);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentDao.findAll();
	}

	@Override
	public List<Appointment> getTop5AppointmentsByDate(String date) {
		return appointmentDao.findTop5ByIdDesc(date);
	}
	
}
