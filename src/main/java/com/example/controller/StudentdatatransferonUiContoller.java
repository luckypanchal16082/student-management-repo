package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentdatatransferonUiContoller {
	
	@GetMapping("/studentdata")
	public String showstudentdatapage(Model model) {
		model.addAttribute("studentname" , "lucky");
		return "studentdata";
	}
	
}