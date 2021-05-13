package com.labeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-master")
public class UserMasterController {
	

	
	private void onLoads(ModelMap model) {
		model.addAttribute("user", "");
	}

	@GetMapping("/add-new-user")
	public String addNewUser(ModelMap model) {
		onLoads(model);
		return "adduser";
	}
	
	@GetMapping("/view-users")
	public String viewUsers(ModelMap model) {
		onLoads(model);
		return "viewusers";
	}

}
