package com.labeasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.labeasy.dto.StateDto;
import com.labeasy.services.MasterService;

@Controller
@RequestMapping("/master")
public class StateController {
	private final MasterService masterService;

	@Autowired
	public StateController(MasterService masterService) {
		this.masterService = masterService;

	}

	@GetMapping("/show-state-page")
	public String showStatePage(Model model) {
		model.addAttribute("state", masterService.findAllStates());
		model.addAttribute("countries", masterService.findAllCounties());

		return "state";
	}

	@PostMapping("/add-state")
	@ResponseBody
	public ResponseEntity<StateDto> addState(@RequestBody StateDto stateDto) {
		return new ResponseEntity<>(masterService.addState(stateDto), HttpStatus.CREATED);
	}

	@GetMapping("/show-state/{id}")
	@ResponseBody
	public ResponseEntity<List<StateDto>> showStateByCountry(@PathVariable("id") Long id) {
		return new ResponseEntity<>(masterService.showStateByCountry(id), HttpStatus.OK);
	}
}
