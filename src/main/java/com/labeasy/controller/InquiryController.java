package com.labeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labeasy.dto.InquiryDto;
import com.labeasy.services.InquiryService;


@Controller
@RequestMapping("/inquiry")
public class InquiryController {
	public final InquiryService inquiryService;

	public InquiryController(final InquiryService inquiryService) {
		super();
		this.inquiryService = inquiryService;
	}

	private void onLoads(ModelMap model){
		model.addAttribute("inquiry", new InquiryDto());
	}
	
	@GetMapping("/show-inquiry-page")
	public String showInquiryPages(ModelMap model) {
		onLoads(model);
		return "inquiry";
		
	}
	
	@PostMapping("/save-inquiry")
	public String saveInquiry(@ModelAttribute InquiryDto inquiryDto) {
		System.out.println("InquiryController.saveInquiry() ["+inquiryDto+"]");
		inquiryService.addInquiry(inquiryDto);
		return "redirect:show-inquiry-page";
	}
}
