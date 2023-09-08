package com.spring.training.member.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/MemberPT")
public class MemberControllerPT {
	
	
	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("/MemberPT/register");
	}
	
}
	