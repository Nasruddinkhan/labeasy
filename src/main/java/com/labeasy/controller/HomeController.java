package com.labeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class HomeController {
    @GetMapping(value ={"/","/dasboard"})
    public String index(Model model) {
    	 model.addAttribute("message", "You are logged in as XYZ");
         return "welcome";
    }
    
	private void onLoads(ModelMap model) {
		model.addAttribute("user", "");
		model.addAttribute("viewprofile", "");
	}
    
	
	@GetMapping("/viewprofile")
	public String viewProfile(ModelMap model) {
		onLoads(model);
		return "viewprofile";
	}
	
	@GetMapping("/changepassword")
	public String changePassword(ModelMap model) {
		onLoads(model);
		return "changepassword";
	}
    
   
}