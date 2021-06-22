package com.labeasy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.labeasy.dto.CityDto;
import com.labeasy.services.MasterService;

@Controller
@RequestMapping("/master")
public class CityController {
	private final MasterService masterService;

	public CityController(MasterService masterService) {
		this.masterService = masterService;
	}

	@GetMapping("/show-city-page")
	public String showCityPage(Model model) {
		model.addAttribute("countries", masterService.findAllCounties());
		model.addAttribute("cities", masterService.findAllCities());
		return "city";
	}

	@PostMapping("/add-city")
	@ResponseBody
	public ResponseEntity<CityDto> addCity(@RequestBody CityDto cityDto) {
		return new ResponseEntity<>(masterService.addCity(cityDto), HttpStatus.CREATED);
	}

	@GetMapping("/show-city/{id}")
	public ResponseEntity<List<CityDto>> showCityByState(@PathVariable("id") Long id) {
		return new ResponseEntity<>(masterService.showCityByState(id), HttpStatus.OK);

	}
}
