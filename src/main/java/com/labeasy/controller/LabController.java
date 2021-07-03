package com.labeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labeasy.dto.LabDto;
import com.labeasy.services.LabService;

@Controller
@RequestMapping("/lab-master")
public class LabController {

	private final LabService labService;
	
	@Autowired
	public LabController(final LabService labService) {
		super();
		this.labService = labService;
	}
	private void onLoads(ModelMap model, LabDto labDto) {
		model.addAttribute("lab", labDto);
	}
	@GetMapping("/show-lab-page")
	public String showCityPage(Model model) {
		
		return "addlab";
	}
	
	@GetMapping("/add-new-lab")
	public String addNewLab(ModelMap model) {
		onLoads(model, new LabDto());
		return "addlab";
	}

}
