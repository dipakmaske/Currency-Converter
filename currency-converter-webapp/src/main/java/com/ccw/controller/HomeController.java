package com.ccw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("in ctor" + getClass().getName());
	}

	@RequestMapping("/")
	public String showHomePage() {
		return "/index";
	}

}
