package com.labeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master-test")
public class MasterTestController {


	@GetMapping("/show-test-group")
	public String showAppointments(ModelMap model) {
		return "testgroup";
	}
	
	@GetMapping("/show-test-name")
	public String addAppointments(ModelMap model) {
		return "testname";
	}
}
