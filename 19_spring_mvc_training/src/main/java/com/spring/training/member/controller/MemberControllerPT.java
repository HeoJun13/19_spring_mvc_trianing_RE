package com.spring.training.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/memberPractice")
public class MemberControllerPT {
	
	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView(" ");
	}
	
	@PostMapping("/register")
	public @ResponseBody 
	

}
