package com.hospitalmanagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity


public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Column(name="PatientId")
	private int patientid;
	@Column(name="DoctorId")
	private int doctorid;
	@Column(name="AppointmentTakenDate")
	private String appointmenttakendate;
	@Column(name="AppointmentTakenTime")
	private String appointmenttakentime;
	@Column(name="AppointmentDate")
	private String appointmentdate;
	@Column(name="AppointmentTime")
	private String appointmenttime;
	@Column(name="ProblemDescription")
	private String problemdescription;
	@Column(name="TreatmentStatus")
	private String treatmentstatus;
	@ManyToMany
	@Column(name="MedicineAssigned")
	private List<Medicine> medicines;
    @Column(name="TreatmentPrice")
	private double treatmentprice;
    @Column(name="BillMade")
    private String billMade;
    @Column(name="BillingDate")
    private String billingDate;
    @Column(name="WantMedicine")
    private String wantMedicine;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public String getAppointmenttakendate() {
		return appointmenttakendate;
	}
	public void setAppointmenttakendate(String appointmenttakendate) {
		this.appointmenttakendate = appointmenttakendate;
	}
	public String getAppointmenttakentime() {
		return appointmenttakentime;
	}
	public void setAppointmenttakentime(String appointmenttakentime) {
		this.appointmenttakentime = appointmenttakentime;
	}
	public String getAppointmentdate() {
		return appointmentdate;
	}
	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public String getAppointmenttime() {
		return appointmenttime;
	}
	public void setAppointmenttime(String appointmenttime) {
		this.appointmenttime = appointmenttime;
	}
	public String getProblemdescription() {
		return problemdescription;
	}
	public void setProblemdescription(String problemdescription) {
		this.problemdescription = problemdescription;
	}
	public String getTreatmentstatus() {
		return treatmentstatus;
	}
	public void setTreatmentstatus(String treatmentstatus) {
		this.treatmentstatus = treatmentstatus;
	}
	public List<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	public double getTreatmentprice() {
		return treatmentprice;
	}
	public void setTreatmentprice(double treatmentprice) {
		this.treatmentprice = treatmentprice;
	}
	public String getBillMade() {
		return billMade;
	}
	public void setBillMade(String billMade) {
		this.billMade = billMade;
	}
	public String getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}
	public String getWantMedicine() {
		return wantMedicine;
	}
	public void setWantMedicine(String wantMedicine) {
		this.wantMedicine = wantMedicine;
	}
    
    

}
