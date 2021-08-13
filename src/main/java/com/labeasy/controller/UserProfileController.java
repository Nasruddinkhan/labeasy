package com.labeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labeasy.dto.UserDto;
import com.labeasy.services.impl.AuditAwareImpl;

@Controller
@RequestMapping("/user-profile")
public class UserProfileController {

	
	private void onLoads(ModelMap model, UserDto userDto) {
		model.addAttribute("user", userDto);
	}
	
	@GetMapping("/view-profile-details")
	public String viewProfileDetails(ModelMap model) {
		onLoads(model, AuditAwareImpl.getLoggedUser());
		return "viewprofile";
	}
	
	@GetMapping("/show-change-password")
	public String showChangePassword(ModelMap model) {
		onLoads(model, new UserDto());
		return "changepassword";
	}
	
	@PostMapping("/change-password")
	public String changePassword(@ModelAttribute UserDto userDto, ModelMap model) {
		System.out.println("UserProfileController.changePassword() ["+userDto.getPassword()+ "==="+userDto.getRePassword()+"]");
		UserDto loggedUserDto = AuditAwareImpl.getLoggedUser();
		loggedUserDto.setPassword(userDto.getPassword());
		
		// need to update here password
		
		onLoads(model, new UserDto());
		return "changepassword";
	}
}
