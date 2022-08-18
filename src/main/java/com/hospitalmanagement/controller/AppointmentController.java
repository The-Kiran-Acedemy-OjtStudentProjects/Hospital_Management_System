package com.hospitalmanagement.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hospitalmanagement.constants.DatabaseConstants.AdminView;
import com.hospitalmanagement.constants.DatabaseConstants.BillMade;
import com.hospitalmanagement.constants.DatabaseConstants.TreatmentStatus;
import com.hospitalmanagement.constants.DatabaseConstants.WantMedicinesFromHospital;
import com.hospitalmanagement.model.Appointment;
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.model.Medicine;
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.resource.AdminResource;
import com.hospitalmanagement.resource.AppointmentResource;
import com.hospitalmanagement.resource.DoctorResource;
import com.hospitalmanagement.resource.MedicineCompanyResource;
import com.hospitalmanagement.resource.MedicineDistributorResource;
import com.hospitalmanagement.resource.MedicineResource;
import com.hospitalmanagement.resource.PatientResource;
import com.hospitalmanagement.resource.PharmacistResource;
import com.hospitalmanagement.resource.ReceptionistResource;
import com.hospitalmanagement.utility.BillExporter;
import com.lowagie.text.DocumentException;

@Controller
public class AppointmentController {
	
	private static Logger LOG = LogManager.getLogger(AppointmentController.class);
	
	@Autowired
	private AdminResource adminResource;
	
	@Autowired
	private AppointmentResource appointmentResource;
	
	@Autowired
	private MedicineResource medicineResource;
	
	@Autowired
	private MedicineCompanyResource companyResource;
	
	@Autowired
	private MedicineDistributorResource distributorResource;
	
	@Autowired
	private DoctorResource doctorResource;
	
	@Autowired
	private PatientResource patientResource;
	
	@Autowired
	private ReceptionistResource receptionistResource;
	
	@Autowired
	private PharmacistResource pharmacistResource;
	
	public static List<Medicine> medicines = new ArrayList<>();

	@GetMapping("/appointment")
	public ModelAndView goToAppointmentPage() {
		LOG.info("Redirecting to Appointment Page.");
		return new ModelAndView("appointment").addObject("doctorResource", doctorResource);
	}
	
	@PostMapping("/addappointment")
	public ModelAndView  addAppointment(@ModelAttribute Appointment appointment, Model model) {
		appointment.setTreatmentstatus(TreatmentStatus.PENDING.value());
		appointment.setBillMade(BillMade.NO.value());
		
		ModelAndView mv = new ModelAndView();
		Doctor doctor = doctorResource.getDoctorById(appointment.getDoctorid());    
		Patient patient = patientResource.getPatientById(appointment.getPatientid());
		Appointment a=this.appointmentResource.addAppointment(appointment);
			mv.addObject("status", "Doctor "+doctor.getFirstname()+" appointed for patient "+patient.getFirstname()+" Appointment No. is "+a.getId());
			mv.setViewName("adminregister");
		
		return mv;
	}
	
	@GetMapping("/searchappointment")
	public String searchAppointment() {
		LOG.info("Redirecting to Search Appointment Page.");
		return "searchappointment";
	}
	
	@GetMapping("/searchappointmentbyid")
	public ModelAndView searchAppointmentById(@RequestParam int appointmentid) {
		LOG.info("Searching appointment by id");
		List<Appointment> appointments = new ArrayList<>();
		Appointment appointment = appointmentResource.getAppointmentById(appointmentid);
		appointments.add(appointment);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("searchappointment");
		mv.addObject("patientResource", patientResource);
		mv.addObject("doctorResource", doctorResource);
		mv.addObject("appointments", appointments);
		return mv;
	}
	
	@GetMapping("/searchappointmentbypatientname")
	public ModelAndView searchAppointmentByPatientName(@RequestParam String patientname) {
		LOG.info("Searching appointment by patient name");
		List<Appointment> appointments = appointmentResource.getAppointmentsByPatientName(patientname);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("searchappointment");
		mv.addObject("patientResource", patientResource);
		mv.addObject("doctorResource", doctorResource);
		mv.addObject("appointments", appointments);
		return mv;
	}
	
	@GetMapping("/searchappointmentbydate")
	public ModelAndView searchAppointmentByDate(@RequestParam String appointmentdate) {
		LOG.info("Searching appointment by date");
		List<Appointment> appointments = appointmentResource.getAppointmentsByDate(appointmentdate);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("searchappointment");
		mv.addObject("patientResource", patientResource);
		mv.addObject("doctorResource", doctorResource);
		mv.addObject("appointments", appointments);
		return mv;
	}
	
	@GetMapping("/searchappointmentbyId")
	public ModelAndView searchAppointmentByid(@RequestParam int appointmentid) {
		LOG.info("Searching appointment by id");
		List<Appointment> appointments = new ArrayList<>();
		Appointment appointment = appointmentResource.getAppointmentById(appointmentid);
		appointments.add(appointment);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("admindashboard");
        mv.addObject("view", AdminView.APPOINTMENT.value());
		mv.addObject("appointmentResource", appointmentResource);
		mv.addObject("medicineResource", medicineResource);
		mv.addObject("companyResource", companyResource);
		mv.addObject("distributorResource", distributorResource);
        mv.addObject("patientResource",patientResource );
        mv.addObject("doctorResource", doctorResource);
        mv.addObject("receptionistResource",receptionistResource);
        mv.addObject("pharmacistResource",pharmacistResource);
		mv.addObject("appointments", appointments);
		return mv;
	}
	
	@GetMapping("/searchappointmentbypatientName")
	public ModelAndView searchAppointmentByPatientname(@RequestParam String patientname) {
		LOG.info("Searching appointment by patient name");
		List<Appointment> appointments = appointmentResource.getAppointmentsByPatientName(patientname);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("admindashboard");
		mv.addObject("view", AdminView.APPOINTMENT.value());
		mv.addObject("appointmentResource", appointmentResource);
		mv.addObject("medicineResource", medicineResource);
		mv.addObject("companyResource", companyResource);
		mv.addObject("distributorResource", distributorResource);
        mv.addObject("patientResource",patientResource );
        mv.addObject("doctorResource", doctorResource);
        mv.addObject("receptionistResource",receptionistResource);
        mv.addObject("pharmacistResource",pharmacistResource);
		mv.addObject("appointments", appointments);
		return mv;
	}
	
	@GetMapping("/searchappointmentbyDate")
	public ModelAndView searchAppointmentBydate(@RequestParam String appointmentdate) {
		LOG.info("Searching appointment by date");
		List<Appointment> appointments = appointmentResource.getAppointmentsByDate(appointmentdate);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("admindashboard");
		mv.addObject("view", AdminView.APPOINTMENT.value());
		mv.addObject("appointmentResource", appointmentResource);
		mv.addObject("medicineResource", medicineResource);
		mv.addObject("companyResource", companyResource);
		mv.addObject("distributorResource", distributorResource);
        mv.addObject("patientResource",patientResource );
        mv.addObject("doctorResource", doctorResource);
        mv.addObject("receptionistResource",receptionistResource);
        mv.addObject("pharmacistResource",pharmacistResource);
		mv.addObject("appointments", appointments);
		return mv;
	}
	
	@GetMapping("/searchappointmentbydateandtime")
	public ModelAndView getAppointmentsByDateAndTime(HttpServletRequest request,@RequestParam String date, @RequestParam String time) {
		ModelAndView mv=new ModelAndView();
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("active-user");
		List<Appointment> appointments = appointmentResource.getAppointmentsByDoctorIdAndAppointmentDateAndTime(doctor.getId(), date, time);
		mv.addObject("doctorResource",doctorResource);
		mv.addObject("patientResource",patientResource);
		mv.addObject("appointmentResource",appointmentResource);
		mv.addObject("appointments",appointments);
		mv.setViewName("mypatient");
		LOG.info("Redirecting to My patient Page.");
		return mv;
	}
	
	@GetMapping("/viewappoinment")
	public ModelAndView viewAppointment(@RequestParam int appointmentId) {
		ModelAndView mv=new ModelAndView();
		Appointment appointment = appointmentResource.getAppointmentById(appointmentId);
		mv.addObject("doctorResource",doctorResource);
		mv.addObject("patientResource",patientResource);
		mv.addObject("medicineResource",medicineResource);
		mv.addObject("appointment",appointment);
		mv.setViewName("viewappointment");
		LOG.info("Redirecting to View Appointment Page");
		return mv;
	}
	
	@PostMapping("/assignMedicinesToPatient")
	public ModelAndView assignMedicinesToPatient(@RequestParam int medicineId, @RequestParam int appointmentId) {
		ModelAndView mv=new ModelAndView();
		
		Appointment appointment = appointmentResource.getAppointmentById(appointmentId);
	    medicines.add(medicineResource.getMedicineById(medicineId));
	   
		mv.addObject("doctorResource",doctorResource);
		mv.addObject("patientResource",patientResource);
		mv.addObject("medicineResource",medicineResource);
		mv.addObject("appointment",appointment);
		mv.addObject("medicines",medicines );
		mv.setViewName("viewappointment");
		LOG.info("Redirecting to View Appointment Page");
		return mv;
	}
	
	@GetMapping("/assignMedicinesToPatientDB")
	public ModelAndView assignMedicinesToPatientDB(@RequestParam int appointmentId) {
		ModelAndView mv=new ModelAndView();
		List<Medicine> meds = new ArrayList<>();
		
		for(Medicine medicine : medicines) {
			medicine = medicineResource.updateQuantity(medicine.getId());
			meds.add(medicine);
		}
		
		Appointment appointment = appointmentResource.getAppointmentById(appointmentId);
		appointment.setMedicines(meds);
		appointmentResource.updateAppointment(appointment);
		mv.addObject("doctorResource",doctorResource);
		mv.addObject("patientResource",patientResource);
		mv.addObject("medicineResource",medicineResource);
		mv.addObject("appointment",appointment);
		mv.addObject("message","Selected Medicines assigned to patient.");
		mv.setViewName("viewappointment");
		medicines = null;
		LOG.info("Redirecting to View Appointment Page");
		return mv;
	}
	
	@GetMapping("/updateappointment")
	public ModelAndView updatePatientAppointment(@RequestParam int appointmentId, @RequestParam String treatmentStatus,@RequestParam int treatmentprice) {
		ModelAndView mv=new ModelAndView();
		
		Appointment appointment = appointmentResource.getAppointmentById(appointmentId);
		appointment.setTreatmentstatus(treatmentStatus);
		appointment.setTreatmentprice(treatmentprice);
		
		appointmentResource.updateAppointment(appointment);
		mv.addObject("doctorResource",doctorResource);
		mv.addObject("patientResource",patientResource);
		mv.addObject("medicineResource",medicineResource);
		mv.addObject("appointment",appointment);
		mv.addObject("message","Appointment updated.");
		mv.setViewName("viewappointment");
		LOG.info("Redirecting to View Appointment Page");
		return mv;
	}
	
	@GetMapping("/makebill")
	public ModelAndView makeBill(@RequestParam int appointmentId) {
		ModelAndView mv=new ModelAndView();
		Appointment appointment = appointmentResource.getAppointmentById(appointmentId);
		mv.addObject("doctorResource",doctorResource);
		mv.addObject("patientResource",patientResource);
		mv.addObject("medicineResource",medicineResource);
		mv.addObject("appointment",appointment);
		mv.setViewName("makebill");
		LOG.info("Redirecting to View Appointment Page");
		return mv;
	}
	
	@GetMapping("/bill")
	public ModelAndView showBill(@RequestParam int appointmentId, @RequestParam String iswantmedicine) {
		 Date date = new Date();  
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
         String strDate= formatter.format(date);  
		ModelAndView mv=new ModelAndView();
		Appointment appointment = appointmentResource.getAppointmentById(appointmentId);
		appointment.setWantMedicine(iswantmedicine);
		appointment.setBillMade(BillMade.YES.value());
		if(appointment.getBillingDate()==null) {
			appointment.setBillingDate(strDate);
		}
		appointmentResource.updateAppointment(appointment);
		mv.addObject("doctorResource",doctorResource);
		mv.addObject("patientResource",patientResource);
		mv.addObject("medicineResource",medicineResource);
		mv.addObject("medicineCompany", companyResource);
		mv.addObject("appointment",appointment);
		mv.setViewName("bill");
		LOG.info("Redirecting to View Appointment Page");
		return mv;
	}
	
	@GetMapping("/downloadBill")
	public void downloadBill(@RequestParam int appointmentId, HttpServletResponse response) throws DocumentException, IOException {

		ModelAndView mv=new ModelAndView();
		Appointment appointment = appointmentResource.getAppointmentById(appointmentId);
		
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+patientResource.getPatientById(appointment.getPatientid()).getFirstname()+"_Bill.pdf";
        response.setHeader(headerKey, headerValue);
		
        BillExporter exporter = new BillExporter(doctorResource, patientResource, companyResource, medicineResource ,appointment);
        exporter.export(response);
	}
	
}
