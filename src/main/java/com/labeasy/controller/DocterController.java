package com.labeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labeasy.dto.DoctorDto;
import com.labeasy.services.DoctorService;

@Controller
@RequestMapping("/doctor-master")
public class DocterController {
	private final DoctorService doctorService;

	@Autowired
	public DocterController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}

	@GetMapping("/add-doctor")
	public String addNewDoctor(ModelMap model) {
		onLoads(model, new DoctorDto());
		return "adddoctor";

	}

	private void onLoads(ModelMap model, DoctorDto doctorDto) {
		model.addAttribute("doctor", doctorDto);

	}

	@PostMapping("/add-doctor")
	public String addNewDoctor(@ModelAttribute DoctorDto doctorDto) {
		doctorService.addNewDoctor(doctorDto);
		return "redirect:view-doctors";
	}

	@GetMapping("/view-doctors")
	public String viewUsers(ModelMap model) {
		System.out.println("DocterController.viewUsers()");
		model.addAttribute("doctorList", doctorService.findAllDoctors());
		return "viewdoctors";
	}

	@GetMapping("/edit-doctor/{id}")
	public String editDoctor(@PathVariable("id") Long id, ModelMap model) {
		System.out.println(id);
		model.addAttribute("doctor", doctorService.findById(id));
		return "adddoctor";

	}

}
