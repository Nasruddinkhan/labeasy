package com.labeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labeasy.dto.B2BRegistrationDto;
import com.labeasy.services.B2BRegistrationService;

@Controller
@RequestMapping("/b2b")
public class B2BRegistrationController {

	private final B2BRegistrationService b2bRegService;
	
	@Autowired
	public B2BRegistrationController(final B2BRegistrationService b2bRegService) {
		super();
		this.b2bRegService = b2bRegService;
	}
	private void onLoads(ModelMap model, B2BRegistrationDto b2bRegDto) {
		model.addAttribute("b2breg", b2bRegDto);
	}
	
	private void onLoads(ModelMap model) {
		model.addAttribute("b2bregs", b2bRegService.findAllB2BRegistations());
	}
	
	@GetMapping("/show-lab-registration")
	public String showLabRegistration(ModelMap model) {
		onLoads(model, new B2BRegistrationDto());
		return "labregistration";
	}
	
	@PostMapping("/add-lab-registration")
	public String addLabRegistration(@ModelAttribute B2BRegistrationDto b2bRegDto) {
		System.out.println("B2BRegistrationService.addLabRegistration() [" + b2bRegDto + "]");
		B2BRegistrationDto dto = b2bRegService.addB2BRegistation(b2bRegDto);
		//eventPublisher.publishEvent(new OnUserRegistrationCompleteEvent(dto));
		return "redirect:view-b2b-registration";
	}
	
	@GetMapping("/show-dr-registration")
	public String showDrRegistration(ModelMap model) {
		onLoads(model, new B2BRegistrationDto());
		return "drregistration";
	}
	
	@PostMapping("/add-dr-registration")
	public String addDrRegistration(@ModelAttribute B2BRegistrationDto b2bRegDto) {
		System.out.println("B2BRegistrationService.addDrRegistration() [" + b2bRegDto + "]");
		B2BRegistrationDto dto = b2bRegService.addB2BRegistation(b2bRegDto);
		//eventPublisher.publishEvent(new OnUserRegistrationCompleteEvent(dto));
		return "redirect:view-b2b-registration";
	}
	
	@GetMapping("/show-franchise-registration")
	public String showFranchiseRegistration(ModelMap model) {
		onLoads(model, new B2BRegistrationDto());
		return "franchiseregistration";
	}
	
	@PostMapping("/add-franchise-registration")
	public String addFranchiseRegistration(@ModelAttribute B2BRegistrationDto b2bRegDto) {
		System.out.println("B2BRegistrationService.addFranchiseRegistration() [" + b2bRegDto + "]");
		B2BRegistrationDto dto = b2bRegService.addB2BRegistation(b2bRegDto);
		//eventPublisher.publishEvent(new OnUserRegistrationCompleteEvent(dto));
		return "redirect:view-b2b-registration";
	}
	
	@GetMapping("/view-b2b-registration")
	public String showB2BRegistration(ModelMap model) {
		onLoads(model);
		return "viewb2bregistrations";
	}
	
	@GetMapping("/edit-b2b-registration/{id}/{page}")
	public String editAppointment(@PathVariable Long id, @PathVariable String page, ModelMap model) {
	onLoads(model, b2bRegService.findByLabId(id));
		System.out.println("B2BRegistrationController.editAppointment id::"+id+"====page::"+page);
		if("DR".equals(page))
			return "drregistration";
		else if("FR".equals(page))
			return "franchiseregistration";
		else
			return "labregistration";
	}

}
