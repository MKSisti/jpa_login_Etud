package com.TB.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class HomeController {

	// serve home page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model) {
		return "Login";
	}
	
	@GetMapping(value = "/goHome")
	public RedirectView goHome() {
		return new RedirectView("/",true);
	}
	
	
}
