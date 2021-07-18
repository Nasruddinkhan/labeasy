package com.labeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.labeasy.services.impl.AuditAwareImpl;

@Controller
class HomeController {
    @GetMapping(value ={"/","/dasboard"})
    public String index(Model model) {
    	 model.addAttribute("message",AuditAwareImpl.getLoggedUser().getEmailId());
         return "welcome";
    }
   
}