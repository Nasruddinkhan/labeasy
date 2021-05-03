package com.labeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {
    @GetMapping(value ={"/","/dasboard"})
    public String index(Model model) {
    	 model.addAttribute("message", "You are logged in as XYZ");
         return "welcome";
    }
   
}