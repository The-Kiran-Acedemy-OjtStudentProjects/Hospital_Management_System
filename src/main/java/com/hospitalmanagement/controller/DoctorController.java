package com.hospitalmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.resource.AppointmentResource;
import com.hospitalmanagement.resource.DoctorResource;
import com.hospitalmanagement.resource.MedicineCompanyResource;
import com.hospitalmanagement.resource.MedicineDistributorResource;
import com.hospitalmanagement.resource.MedicineResource;
import com.hospitalmanagement.resource.PatientResource;
import com.hospitalmanagement.resource.PharmacistResource;
import com.hospitalmanagement.resource.ReceptionistResource;
import com.hospitalmanagement.service.DoctorService;

@Controller
public class DoctorController {
	
	private static Logger LOG = LogManager.getLogger(DoctorController.class);
	
	@Autowired
	private DoctorService doctorService;
	
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
	
	@GetMapping("/doctorlogin")
	public String goToDoctorLoginPage() {
		LOG.info("Redirecting to Doctor Login Page.");
		return "doctorlogin";
	}
	
	@PostMapping("/doctorlogin")
	public ModelAndView loginAdmin(HttpServletRequest request, @RequestParam String username, @RequestParam String password ) {
		ModelAndView mv = new ModelAndView();
		Doctor doctor = this.doctorService.loginDoctor(username, password);
		if(doctor != null) {
			HttpSession session = request.getSession();
			session.setAttribute("active-user",doctor);
			session.setAttribute("user-login","doctor");
			mv.addObject("doctorResource",doctorResource);
			mv.addObject("patientResource",patientResource);
			mv.addObject("appointmentResource",appointmentResource);
			mv.addObject("status", username+" Successfully Logged in as DOCTOR");
			mv.setViewName("index");
		}
		
		else {
			mv.addObject("status"," Failed to Login as DOCTOR");
			mv.setViewName("doctorlogin");
		}
		
		return mv;
	}
	
	@GetMapping("/doctorregister")
	public ModelAndView goToDoctorRegisterPage() {
		LOG.info("Redirecting to Doctor Register Page.");
		return new ModelAndView("doctorregister").addObject("doctorResource", doctorResource);
	}
	
	@PostMapping("/doctorregister")
	public ModelAndView registerAdmin(@ModelAttribute Doctor doctor, Model model) {
		ModelAndView mv = new ModelAndView();
		if(this.doctorService.addDoctor(doctor)==true) {
			mv.addObject("status", doctor.getFirstname()+" Successfully Registered as DOCTOR");
			mv.setViewName("doctorlogin");
		}
		
		else {
			mv.addObject("status", doctor.getFirstname()+" Failed to Registered as DOCTOR");
			mv.setViewName("doctorregister");
		}
		
		return mv;
	}
	
	@GetMapping("/mypatient")
	public ModelAndView goToMyPatientPage() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("doctorResource",doctorResource);
		mv.addObject("patientResource",patientResource);
		mv.addObject("appointmentResource",appointmentResource);
		mv.setViewName("mypatient");
		LOG.info("Redirecting to My patient Page.");
		return mv;
	}
	
	@GetMapping("/searchdoctorbyId")
	public ModelAndView searchDoctorByid(@RequestParam int doctorId) {
		LOG.info("Searching medicine by id");
		Doctor doctor = doctorResource.getDoctorById(doctorId);
		List<Doctor> doctors = new ArrayList<Doctor>();
		doctors.add(doctor);
		ModelAndView mv =new ModelAndView();
		mv.addObject("view", AdminView.DOCTOR.value());
		mv.setViewName("admindashboard");
		mv.addObject("doctors", doctors);
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
	
	@GetMapping("/searchdoctorbyName")
	public ModelAndView searchdoctorByname(@RequestParam String doctorName) {
		LOG.info("Searching Medicine by medicine name");
		List<Doctor> doctors = doctorResource.getDoctorsByName(doctorName);
		ModelAndView mv =new ModelAndView();
        mv.addObject("view", AdminView.DOCTOR.value());
		mv.setViewName("admindashboard");
		mv.addObject("doctors", doctors);
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
