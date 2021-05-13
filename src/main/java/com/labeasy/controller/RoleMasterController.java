package com.labeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role-master")
public class RoleMasterController {
	
	private void onLoads(ModelMap model) {
		//model.addAttribute("testGroupList", testMasterService.findAllTestGroup());
	}

	@GetMapping("/add-new-role")
	public String showTestGroup(ModelMap model) {
		onLoads(model);
		return "addrole";
	}
	
	/*@PostMapping("/add-test-group")
	@ResponseBody
	public ResponseEntity<TestGroupDto> addTestGroup(@RequestBody TestGroupDto testGroupDto, ModelMap model) {
		System.out.println("MasterTestController.addTestGroup() [" + testGroupDto + "]");
		return new ResponseEntity<>(testMasterService.addTestGroup(testGroupDto), HttpStatus.CREATED);
	}
	*/
}
