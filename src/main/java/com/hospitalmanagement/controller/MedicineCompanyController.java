package com.hospitalmanagement.controller;

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

import com.hospitalmanagement.model.Medicine;
import com.hospitalmanagement.model.MedicineCompany;
import com.hospitalmanagement.resource.MedicineCompanyResource;

@Controller
public class MedicineCompanyController {
	
   private static Logger LOG = LogManager.getLogger(MedicineCompanyController.class);
	
	@Autowired
	private MedicineCompanyResource medicineCompanyResource;
	
	@GetMapping("/addmedicinecompany")
	public String goToAdminRegisterPage() {
		LOG.info("Redirecting to Add Medicine Distributor Page.");
		return "addmedicinecompany";
	}
	
	@PostMapping("/addmedicinecompany")
	public ModelAndView registerAdmin(@ModelAttribute MedicineCompany medicineCompany, Model model) {
		ModelAndView mv = new ModelAndView();
		if(this.medicineCompanyResource.addCompany(medicineCompany)==true) {
			mv.addObject("status","Company "+medicineCompany.getName()+" Successfully Added");
			mv.setViewName("index");
		}
		
		else {
			mv.addObject("status", "Failed to Add Company "+medicineCompany.getName());
			mv.setViewName("addmedicinecompany");
		}
		
		return mv;
	}
	
	@GetMapping("/searchcompany")
	public String searchCompany() {
		LOG.info("Redirecting to Search Company Page.");
		return "searchcompany";
	}
	
	@GetMapping("/searchcompanybyid")
	public ModelAndView searchCompanyById(@RequestParam int companyId) {
		LOG.info("Searching company by id");
		MedicineCompany medicineCompany = medicineCompanyResource.getCompanyById(companyId);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("searchcompany");
		mv.addObject("medicineCompany", medicineCompany);
		return mv;
	}
	
	@GetMapping("/searchcompanybyname")
	public ModelAndView searchCompanyByName(@RequestParam String companyName) {
		LOG.info("Searching Company by company name");
		List<MedicineCompany> medicineCompanys = medicineCompanyResource.getCompanysByName(companyName);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("searchmedicine");
		mv.addObject("medicineCompanys", medicineCompanys);
		return mv;
	}


}
