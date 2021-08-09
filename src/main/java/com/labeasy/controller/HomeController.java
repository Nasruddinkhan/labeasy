package com.labeasy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.labeasy.services.DashboardService;
import com.labeasy.services.impl.AuditAwareImpl;

@Controller
class HomeController {
 
	private final DashboardService dashBoardService;
	
	@Autowired
	public HomeController(DashboardService dashBoardService) {
		super();
		this.dashBoardService = dashBoardService;
	}

	@GetMapping(value = { "/", "/dasboard" })
	public String index(Model model, HttpSession session) {
		model.addAttribute("message", "welcome " + AuditAwareImpl.getLoggedUser().getEmailId());
	    session.setAttribute("menu", dashBoardService.findAllMenus()); 

		return "welcome";
	}

}