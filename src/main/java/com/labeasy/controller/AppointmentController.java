package com.labeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labeasy.dto.InquiryDto;
import com.labeasy.services.TestNamesService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	
	@Autowired
	TestNamesService testNamesService;
	
	private void onLoads(ModelMap model){
		model.addAttribute("appointment", "");
		model.addAttribute("testNameList", testNamesService.findAllTestName());
	}
	
	@GetMapping("/view-appointment-page")
	public String viewAppointments(ModelMap model) {
		
		return "viewappointments";
	}
	
	@GetMapping("/show-appointment-page")
	public String showAppointment(ModelMap model) {
		onLoads(model);
		return "addappointment";
	}
	
	@PostMapping("/add-appointment")
	public String addAppointments(@ModelAttribute InquiryDto inquiryDto) {
		System.out.println("InquiryController.saveInquiry() ["+inquiryDto+"]");
		/*
		 * inquiryService.addInquiry(inquiryDto); return "redirect:show-inquiry-page";
		 */
	return null;
	}
	
	
}
