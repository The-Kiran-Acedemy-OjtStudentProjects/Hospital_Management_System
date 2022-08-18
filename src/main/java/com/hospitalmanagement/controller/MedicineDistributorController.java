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

import com.hospitalmanagement.model.MedicineCompany;
import com.hospitalmanagement.model.MedicineDistributor;
import com.hospitalmanagement.resource.MedicineDistributorResource;

@Controller
public class MedicineDistributorController {
	
	private static Logger LOG = LogManager.getLogger(MedicineDistributorController.class);
	
	@Autowired
	private MedicineDistributorResource medicineDistributorResource;
	
	@GetMapping("/addmedicinedistributor")
	public String goToAdminRegisterPage() {
		LOG.info("Redirecting to Add Medicine Distributor Page.");
		return "addmedicinedistributor";
	}
	
	@PostMapping("/addmedicinedistributor")
	public ModelAndView registerAdmin(@ModelAttribute MedicineDistributor medicineDistributor, Model model) {
		ModelAndView mv = new ModelAndView();
		if(this.medicineDistributorResource.addDistributor(medicineDistributor)==true) {
			mv.addObject("status","Distributor "+medicineDistributor.getName()+" Successfully Added");
			mv.setViewName("index");
		}
		
		else {
			mv.addObject("status", "Failed to Add Distributor "+medicineDistributor.getName());
			mv.setViewName("addmedicinedistributor");
		}
		
		return mv;
	}
	
	@GetMapping("/searchdistributor")
	public String searchDistributor() {
		LOG.info("Redirecting to Search Distributor Page.");
		return "searchdistributor";
	}
	
	@GetMapping("/searchdistributorbyid")
	public ModelAndView searchDistributorById(@RequestParam int distributorId) {
		LOG.info("Searching distributor by id");
		MedicineDistributor medicineDistributor = medicineDistributorResource.getDistributorById(distributorId);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("searchdistributor");
		mv.addObject("medicineDistributor", medicineDistributor);
		return mv;
	}
	
	@GetMapping("/searchdistributorbyname")
	public ModelAndView searchDistributorByName(@RequestParam String distributorName) {
		LOG.info("Searching Distributor by distributor name");
		List<MedicineDistributor> medicineDistributors = medicineDistributorResource.getDistributorsByName(distributorName);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("searchmedicine");
		mv.addObject("medicineDistributors", medicineDistributors);
		return mv;
	}

}
