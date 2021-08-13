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
	
	private final TestNamesService testNamesService;
	private final TestGroupService testGroupService;
	
	@Autowired
	public TestNamesController(TestNamesService testNamesService, TestGroupService testGroupService) {
		super();
		this.testNamesService = testNamesService;
		this.testGroupService = testGroupService;
	}

	private void onLoads(ModelMap model) {
		model.addAttribute("testNameList", testNamesService.findAllTestName());
		model.addAttribute("testGroupList", testGroupService.findAllTestGroup());
		model.addAttribute("menuopen", "menu-open");

		
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
	
	@GetMapping("/show-add-test-package")
	public String showTestPackage(ModelMap model) {
		onLoads(model);
		return "testpackage";
	}
	
	@GetMapping("/show-view-test-packages")
	public String viewTestPackages(ModelMap model) {
		return "viewtestpackages";
	}
	
}
