package com.TB.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.TB.spring.DAO.UserDaoImpl;
import com.TB.spring.Entities.User;

@Controller
@SessionAttributes("userName")
public class UserController {
	
	@RequestMapping(value = "/UserLogin", method = RequestMethod.POST)
	public String userLogin(@Validated User u,Model model,UserDaoImpl ud) {
		User us = ud.loginUser(u);
		if (us != null) {
			model.addAttribute("userName",us.getUserName());
			return "redirect:/filiere";
		}
		model.addAttribute("Message","Authentication failed!! Try again.");
		return "Login";
	}
	
//	Redirects 
	
//	redirect to filiere
	@RequestMapping(value = "/goToFiliere", method = RequestMethod.GET)
	public String goToFilHome() {
		return "redirect:/filiere";
	}
//	redirect to eleves
	@RequestMapping(value = "/goToEtudiant", method = RequestMethod.GET)
	public String goToEtHome() {
		return "redirect:/etudiant";
	}
	
	
	@RequestMapping(value = "/UserSignUp", method = RequestMethod.POST)
	public String userSignUp(@Validated User u,Model model,UserDaoImpl ud) {
		ud.save(u);
		return "Login";
	}
	@RequestMapping(value = "/goSignUp", method = RequestMethod.GET)
	public String goToSignUp() {
		return "SignUp";
	}
	@RequestMapping(value = "/goSignIn", method = RequestMethod.GET)
	public String goToSignIn() {
		return "Login";
	}
}
