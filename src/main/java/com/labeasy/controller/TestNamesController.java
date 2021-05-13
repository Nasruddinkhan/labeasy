package com.labeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.labeasy.dto.TestNamesDto;
import com.labeasy.services.TestGroupService;
import com.labeasy.services.TestNamesService;

@Controller
@RequestMapping("/master-test")
public class TestNamesController {
	
	@Autowired
	TestNamesService testNamesService;
	


	/*
	 * public TestNamesController(final TestNamesService testNamesService) {
	 * super(); this.testNamesService = testNamesService; }
	 */
	
	
	@Autowired
	TestGroupService testGroupService;
	
	private void onLoads(ModelMap model) {
		model.addAttribute("testNameList", testNamesService.findAllTestName());
		model.addAttribute("testGroupList", testGroupService.findAllTestGroup());
	}
	
	@GetMapping("/show-test-name")
	public String addAppointments(ModelMap model) {
		onLoads(model);
		return "testname";
	}
	
	@PostMapping("/add-test-name")
	@ResponseBody
	public ResponseEntity<TestNamesDto> addTestName(@RequestBody TestNamesDto testNamesDto, ModelMap model) {
		System.out.println("TestNamesController.addTestName() [" + testNamesDto + "]");
		return new ResponseEntity<>(testNamesService.addTestName(testNamesDto), HttpStatus.CREATED);
	}
}
