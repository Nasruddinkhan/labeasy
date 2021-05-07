package com.labeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@GetMapping("/show-appointment-page")
	public String showAppointments(ModelMap model) {
		return "appointment";
	}
	
	@GetMapping("/add-apointment")
	public String addAppointments(ModelMap model) {
		return "add_appointment";
	}
	
}
