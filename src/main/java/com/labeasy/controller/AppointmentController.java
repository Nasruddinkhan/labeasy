package com.labeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labeasy.dto.AppointmentDto;
import com.labeasy.dto.BillingAndInvoiceDto;
import com.labeasy.services.AppointmentService;
import com.labeasy.services.TestNamesService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	private final TestNamesService testNamesService;
	private final AppointmentService appointmentService;

	@Autowired
	public AppointmentController(final TestNamesService testNamesService, final AppointmentService appointmentService) {
		this.testNamesService = testNamesService;
		this.appointmentService = appointmentService;
	}

	private void addAppointmentOnLoadData(ModelMap model) {
		AppointmentDto appointmentDto = new AppointmentDto();
		appointmentDto.setAndInvoiceDto(new BillingAndInvoiceDto());
		model.addAttribute("appointment", appointmentDto);
		model.addAttribute("testNameList", testNamesService.findAllTestName());
	}

	@GetMapping("/view-appointment-page")
	public String viewAppointments(ModelMap model) {
		return "viewappointments";
	}

	@GetMapping("/show-appointment-page")
	public String showAppointment(ModelMap model) {
		addAppointmentOnLoadData(model);
		return "addappointment";
	}

	@PostMapping("/add-appointment")
	public String addAppointments(@ModelAttribute AppointmentDto appointmentDto) {
		 appointmentService.addAppointment(appointmentDto);
		return "redirect:view-appointment-page";
	}
}
