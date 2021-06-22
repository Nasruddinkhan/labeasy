package com.labeasy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.labeasy.dto.CityDto;
import com.labeasy.dto.PinCodeDto;
import com.labeasy.services.MasterService;

@Controller
@RequestMapping("/master")
public class PinCodeController {
	
	private final MasterService masterService;
	
	public PinCodeController(MasterService masterService) {
		
		this.masterService = masterService;
	}

	@GetMapping("/show-pincode-page")
	public String showPinCodePage(Model model) {
	model.addAttribute("countries", masterService.findAllCounties());
	model.addAttribute("pincodes", masterService.findAllPinCode());
		return "pincode";
	}
	
	@PostMapping("/add-pincode")
	@ResponseBody
	public ResponseEntity<PinCodeDto> addCity(@RequestBody PinCodeDto pinCodeDto) {
		return new ResponseEntity<>(masterService.addPinCode(pinCodeDto), HttpStatus.CREATED);
	}

}
