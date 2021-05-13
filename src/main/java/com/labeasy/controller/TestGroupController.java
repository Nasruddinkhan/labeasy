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

import com.labeasy.dto.TestGroupDto;
import com.labeasy.dto.TestNamesDto;
import com.labeasy.services.TestGroupService;

@Controller
@RequestMapping("/master-test")
public class TestGroupController {
	
	public final TestGroupService testMasterService;

	public TestGroupController(final TestGroupService testMasterService) {
		super();
		this.testMasterService = testMasterService;
	}
	
	private void onLoads(ModelMap model) {
		model.addAttribute("testGroupList", testMasterService.findAllTestGroup());
	}

	@GetMapping("/show-test-group")
	public String showTestGroup(ModelMap model) {
		onLoads(model);
		return "testgroup";
	}
	
	@PostMapping("/add-test-group")
	@ResponseBody
	public ResponseEntity<TestGroupDto> addTestGroup(@RequestBody TestGroupDto testGroupDto, ModelMap model) {
		System.out.println("MasterTestController.addTestGroup() [" + testGroupDto + "]");
		return new ResponseEntity<>(testMasterService.addTestGroup(testGroupDto), HttpStatus.CREATED);
	}
	
}
