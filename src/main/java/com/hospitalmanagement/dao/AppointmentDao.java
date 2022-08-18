package com.hospitalmanagement.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospitalmanagement.model.Appointment;

@Repository("appointmentDao")
public interface AppointmentDao extends JpaRepository<Appointment , Integer> {
	
	
	
	@Query( "select a from Appointment a where a.patientid in :ids" )
	List<Appointment> findByPatientsId(@Param("ids") List<Integer> patientIds);
	List<Appointment> findByDoctoridAndAppointmentdate(int doctorid , String appointmentdate);
	List<Appointment> findByDoctoridAndAppointmentdateAndAppointmenttime(int doctorid , String appointmentdate, String appointmenttime);
	List<Appointment> findByAppointmentdate(String apointmentDate);
	Long countByAppointmentdate(String apointmentDate);
	Long countByTreatmentstatusAndBillingDate(String treatmentStatus, String billingDate);
	Long countByAppointmenttakendate(String apointmentTakenDate);
	@Query(value = "SELECT sum(a.treatmentprice) FROM Appointment a where a.billingDate =:date")
    public Double sumOfPrice(@Param("date") String billingDate);
	@Query(value="select a from Appointment a where a.billingDate =:date" )
	List<Appointment> findByBillingDate(@Param("date") String billingDate);
	@Query(value = "SELECT count(a) FROM Appointment a")
    public Long getTotalCount();
	@Query(value= "select * from Appointment where appointment_date=:date ORDER BY id DESC LIMIT 5", nativeQuery=true)
	public List<Appointment> findTop5ByIdDesc(@Param("date") String appointmentDate);
    
	
}
