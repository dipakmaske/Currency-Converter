package com.ccw.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ccw.pojos.Currency;
import com.ccw.pojos.User;
import com.ccw.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	public UserController() {
		System.out.println("in ctr" + getClass().getName());
	}

	@RequestMapping("/login")
	public String showLoginForm() {
		return "/user/login";
	}

	@RequestMapping("/register")
	public String showRegister(User u) {
		return "/user/register";
	}

	@PostMapping("/login")
	public String validateCustomer(@RequestParam String em, @RequestParam String pass, Model map,
			RedirectAttributes flashMap, HttpSession session, Currency c) {
		System.out.println(" in validate user methos with email : " + em + " and pass " + pass);
		User u = userService.validateUser(em, pass);
		if (u == null) {
			return "/user/login";
		}
		LocalDate dt = LocalDate.now();
		session.setAttribute("user", u);
		session.setAttribute("userName", u.getName());
		session.setAttribute("date", dt);
		return "redirect:/currency";

	}

	@PostMapping("/register")
	public String processRegisterForm(User u, HttpSession session) {
		System.out.println(" in processing form method");
		System.out.println(" received user : " + u);
		System.out.println(userService.addUser(u));

		return "redirect:/user/login";
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession hs) {
		hs.invalidate();
		return "redirect:/";
	}
}
