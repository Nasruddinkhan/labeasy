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

import com.labeasy.dto.UserRoleDto;
import com.labeasy.services.UserRoleService;

@Controller
@RequestMapping("/role-master")
public class RoleMasterController {
	
	
	public final UserRoleService userRoleService;
	@Autowired
	public RoleMasterController(final UserRoleService userRoleService) {
		super();
		this.userRoleService = userRoleService;
	}
	
	
	private void onLoads(ModelMap model) {
		model.addAttribute("userRoleList", userRoleService.findAllRoles());
	}

	@GetMapping("/show-user-role")
	public String showTestGroup(ModelMap model) {
		onLoads(model);
		return "addrole";
	}
	
	@PostMapping("/add-user-role")
	@ResponseBody
	public ResponseEntity<UserRoleDto> addTestGroup(@RequestBody UserRoleDto userRoleDto, ModelMap model) {
		System.out.println("RoleMasterController.addTestGroup() [" + userRoleDto + "]");
		return new ResponseEntity<>(userRoleService.addUserRole(userRoleDto), HttpStatus.CREATED);
	}}
