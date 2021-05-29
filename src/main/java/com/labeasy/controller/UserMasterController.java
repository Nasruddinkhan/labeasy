package com.labeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labeasy.dto.AddressDto;
import com.labeasy.dto.UserDto;
import com.labeasy.services.UserRoleService;
import com.labeasy.services.UserService;

@Controller
@RequestMapping("/user-master")
public class UserMasterController {
	
	private final UserService userService;
	public final UserRoleService userRoleService;
	
	@Autowired
	public UserMasterController(final UserService userService, final UserRoleService userRoleService) {
		super();
		this.userService = userService;
		this.userRoleService = userRoleService;
	}
	
	private void onLoads(ModelMap model) {
		UserDto userDto = new UserDto();
		userDto.setAddress(new AddressDto());
		model.addAttribute("user", userDto);
		model.addAttribute("userRoleList", userRoleService.findAllRoles());
	}

	@GetMapping("/show-add-user-page")
	public String showUserPage(ModelMap model) {
		onLoads(model);
		return "adduser";
	}
	
	@GetMapping("/add-new-user")
	public String addNewUser(ModelMap model) {
		//onLoads(model);
		return "adduser";
	}
	
	@PostMapping("/add-new-user")
	public String addNewUser(@ModelAttribute UserDto userDto) {
		System.out.println("UserMasterController.addNewUser() ["+userDto+"]");
		 userService.addUser(userDto);
		return "redirect:view-users";
	}
	
	
	@GetMapping("/view-users")
	public String viewUsers(ModelMap model) {
		onLoads(model);
		return "viewusers";
	}}
