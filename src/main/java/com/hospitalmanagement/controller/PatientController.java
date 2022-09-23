package com.hospitalmanagement.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.resource.AppointmentResource;
import com.hospitalmanagement.resource.DoctorResource;
import com.hospitalmanagement.resource.MedicineCompanyResource;
import com.hospitalmanagement.resource.MedicineDistributorResource;
import com.hospitalmanagement.resource.MedicineResource;
import com.hospitalmanagement.resource.PatientResource;
import com.hospitalmanagement.resource.PharmacistResource;
import com.hospitalmanagement.resource.ReceptionistResource;

@Controller
public class PatientController {
	
	private static Logger LOG = LogManager.getLogger(PatientController.class);
	
	@Autowired
	private MedicineResource medicineResource;
	
	@Autowired
	private MedicineDistributorResource medicineDistributorResource;
	
	@Autowired
	private MedicineCompanyResource medicineCompanyResource;
	
	@Autowired
	private AppointmentResource appointmentResource;
	
	@Autowired
	private DoctorResource doctorResource;
	
	@Autowired
	private PatientResource patientResource;
	
	@Autowired
	private ReceptionistResource receptionistResource;
	
	@Autowired
	private PharmacistResource pharmacistResource;
	
	@GetMapping("/patientregister")
	public String goToPatientRegisterPage() {
		LOG.info("Redirecting to Patient Register Page");
		return "patientregister";
	}
	
	@PostMapping("/patientregister")
	public ModelAndView registerPatient(@ModelAttribute Patient patient, Model model) {
		ModelAndView mv = new ModelAndView();
		if(this.patientResource.addPatient(patient)==true) {
			mv.addObject("status", patient.getFirstname()+" Successfully Registered as Patient.");
			mv.setViewName("index");
		}
		
		else {
			mv.addObject("status", patient.getFirstname()+" Failed to Registered as Patient.");
			mv.setViewName("patientregister");
		}
		
		return mv;
	}
	
	@GetMapping("/getpatient")
	public ModelAndView getPatientById(@RequestParam int patientid) {
		ModelAndView mv = new ModelAndView();
		LOG.info("Fetching patient detail by his id");
		Patient patient = patientResource.getPatientById(patientid);
		mv.setViewName("appointment");
		mv.addObject("patient", patient);
		mv.addObject("doctorResource", doctorResource);
		return mv;
	}
	
	
	@GetMapping("/viewmypatient")
	public String viewMyPatients() {
		return "viewmypatient";
	}
	
	@GetMapping("/searchpatientbyId")
	public ModelAndView searchPatientByid(@RequestParam int patientId) {
		LOG.info("Searching medicine by id");
		Patient patient = patientResource.getPatientById(patientId);
		List<Patient> patients = new ArrayList<Patient>();
		patients.add(patient);
		ModelAndView mv =new ModelAndView();
		mv.addObject("view", AdminView.PATIENT.value());
		mv.setViewName("admindashboard");
		mv.addObject("patients", patients);
		mv.addObject("appointmentResource", appointmentResource);
		mv.addObject("medicineResource", medicineResource);
		mv.addObject("companyResource", medicineCompanyResource);
		mv.addObject("distributorResource", medicineDistributorResource);
        mv.addObject("patientResource",patientResource );
        mv.addObject("doctorResource", doctorResource);
        mv.addObject("receptionistResource",receptionistResource);
        mv.addObject("pharmacistResource",pharmacistResource);
		return mv;
	}
	
	@GetMapping("/searchpatientbyName")
	public ModelAndView searchpharmacistByname(@RequestParam String patientName) {
		LOG.info("Searching Medicine by medicine name");
		List<Patient> patients = patientResource.getPatientsByName(patientName);
		ModelAndView mv =new ModelAndView();
        mv.addObject("view", AdminView.PATIENT.value());
		mv.setViewName("admindashboard");
		mv.addObject("patients", patients);
		mv.addObject("appointmentResource", appointmentResource);
		mv.addObject("medicineResource", medicineResource);
		mv.addObject("companyResource", medicineCompanyResource);
		mv.addObject("distributorResource", medicineDistributorResource);
        mv.addObject("patientResource",patientResource );
        mv.addObject("doctorResource", doctorResource);
        mv.addObject("receptionistResource",receptionistResource);
        mv.addObject("pharmacistResource",pharmacistResource);
		return mv;
	}
	@GetMapping("/searchAllpatient")
	public ModelAndView searchAllpatient() {
		LOG.info("Searching Medicine by medicine name");
		List<Patient> patients = patientResource.getAllPatient();
		ModelAndView mv =new ModelAndView();
        mv.addObject("view", AdminView.PATIENT.value());
		mv.setViewName("admindashboard");
		mv.addObject("patients", patients);
		mv.addObject("appointmentResource", appointmentResource);
		mv.addObject("medicineResource", medicineResource);
		mv.addObject("companyResource", medicineCompanyResource);
		mv.addObject("distributorResource", medicineDistributorResource);
        mv.addObject("patientResource",patientResource );
        mv.addObject("doctorResource", doctorResource);
        mv.addObject("receptionistResource",receptionistResource);
        mv.addObject("pharmacistResource",pharmacistResource);
		return mv;
	}
}
