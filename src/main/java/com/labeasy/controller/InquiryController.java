package com.labeasy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	private void onLoads(ModelMap model) {
		model.addAttribute("inquires", inquiryService.findAllInquires());
	}

	@GetMapping("/show-inquiry-page")
	public String showInquiryPages(ModelMap model) {
		onLoads(model);
		return "inquiry";

	}

	@PostMapping("/save-inquiry")
	@ResponseBody
	public ResponseEntity<InquiryDto> saveInquiry(@RequestBody InquiryDto inquiryDto) {
		System.out.println("InquiryController.saveInquiry() [" + inquiryDto + "]");
		return new ResponseEntity<>(inquiryService.addInquiry(inquiryDto), HttpStatus.CREATED);
	}
}
