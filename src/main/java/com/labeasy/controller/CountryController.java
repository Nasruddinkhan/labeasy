package com.labeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.labeasy.dto.CountryDto;
import com.labeasy.services.MasterService;

@Controller
@RequestMapping("/master")
public class CountryController {

	private final MasterService masterService;
	@Autowired
	public CountryController(final MasterService masterService) {
		super();
		this.masterService = masterService;
	}


	@GetMapping("/show-country-page")
	public String showCountryPage(Model model) {
		model.addAttribute("countries", masterService.findAllCounties());
		return "country";
	}
	
	
	@PostMapping("/add-country")
	@ResponseBody
	public ResponseEntity<CountryDto> addCountry(@RequestBody CountryDto countryDto) {
		return new ResponseEntity<>(masterService.addCountry(countryDto), HttpStatus.CREATED);
	}
}
